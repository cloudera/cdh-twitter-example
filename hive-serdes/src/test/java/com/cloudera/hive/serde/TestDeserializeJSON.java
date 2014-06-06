package com.cloudera.hive.serde;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import junit.framework.Assert;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde.serdeConstants;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.io.Writable;
import org.junit.Before;
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
            return "{\"position.x\":1890,\"final.vc.credits\":62809152,\"position.y\":11430,\"uid\":89775688,\"generator\":\"java:1.3:srv016108:4046 java:1.3:srv016108:4046\",\"faction\":\"EIC\",\"final.ca.honour\":8622300,\"level\":19,\"pid\":674,\"gearscore.damageScore\":43869.266,\"position.area\":24,\"time\":1399940194255,\"final.rc.uridium\":4183,\"final.ca.xp\":1665637455,\"gearscore.tacticalScore\":1.045,\"gearscore\":5647.395,\"event\":\"playtime.start\",\"gearscore.hitpointsScore\":831525.0}";
        };
    };
    
    private JSONSerDe jsonSerDe;

    
    @Before
    public void setUp() throws Exception {
        jsonSerDe = new JSONSerDe();
        
        // init
        Configuration testConfig = new Configuration();
        Properties properties = new Properties();
        properties.setProperty(serdeConstants.LIST_COLUMNS, "position_x,position_y,uid,pid,time,event");
        properties.setProperty(serdeConstants.LIST_COLUMN_TYPES, "int,int,int,tinyint,bigint,string");
        jsonSerDe.initialize(testConfig, properties);
    }

    @Test
    public void test() throws SerDeException {
        List<?> result = (List<?>)jsonSerDe.deserialize(EXAMPLE);
        
        Assert.assertNotNull(result);
        for (Object element : result) {
            Assert.assertNotNull(element);
            
            System.out.println(element.getClass().getSimpleName()+ ": "+ element.toString());
        }
    }
}
