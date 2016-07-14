package com.cloudera.hive.serde;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde.serdeConstants;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.io.Writable;
import org.junit.Test;


public class TestDeserializeJSON {

    private static final Writable EXAMPLE = new Writable() {
        @Override
        public void write(DataOutput out) throws IOException {
        }

        @Override
        public void readFields(DataInput in) throws IOException {
        }

        public String toString() {
            return "{\"position.x\":1890,\"position.y\":11430,\"uid\":89775688,\"generator\":\"java:1.3:srv016108:4046 java:1.3:srv016108:4046\",\"pid\":674,\"time\":1399940194255,\"event\":\"playtime.start\"}";
        };
    };

    @Test(expected = NullPointerException.class)
    public void testPatchKeyNull() {
        JSONSerDe.patchKey(null);
    }

    @Test
    public void testPatchKeyEmpty() {
        assertEquals("", JSONSerDe.patchKey(""));
    }

    @Test
    public void testPatchKeyToLowerCase() {
        assertEquals("xxx", JSONSerDe.patchKey("XxX"));
    }

    @Test
    public void testPatchKeyReplaceMinus() {
        assertEquals("x_x", JSONSerDe.patchKey("x-x"));
    }

    @Test
    public void testPatchKeyReplaceDot() {
        assertEquals("x_x", JSONSerDe.patchKey("x.x"));
    }

    @Test
    public void testPatchKeyuntouched() {
        assertEquals("xox", JSONSerDe.patchKey("xox"));
    }
    
    @Test
    public void testDeserializationByExample() throws SerDeException {
        JSONSerDe jsonSerDe = new JSONSerDe();
        
        // init
        Configuration testConfig = new Configuration();
        Properties properties = new Properties();
        properties.setProperty(serdeConstants.LIST_COLUMNS, "position_x,position_y,uid,pid,time,generator,event");
        properties.setProperty(serdeConstants.LIST_COLUMN_TYPES, "int,int,int,tinyint,bigint,string,string");
        jsonSerDe.initialize(testConfig, properties);

        List<?> result = (List<?>)jsonSerDe.deserialize(EXAMPLE);
        
        assertNotNull(result);
        assertEquals(7, result.size());
        for (Object element : result) {
            assertNotNull(element);
        }
    }
}
