package com.cloudera.hive.serde;
import static org.junit.Assert.*;

import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde.serdeConstants;
import org.junit.Before;
import org.junit.Test;


public class TestDeserializeJSON {

    private JSONSerDe jsonSerDe;
    
    /*
    CREATE TABLE playtime_start (
        uid STRING,generator STRING,faction STRING,level STRING,pid STRING,time STRING,gearscore STRING,event STRING
    )
    */
    @Before
    public void setUp() throws Exception {
        jsonSerDe = new JSONSerDe();
        
        // init
        Configuration testConfig = new Configuration();
        Properties properties = new Properties();
        properties.setProperty(serdeConstants.LIST_COLUMNS, "uid,generator,faction,level,pid,time,gearscore,event");
        properties.setProperty(serdeConstants.LIST_COLUMN_TYPES, "string,string,string,string,string,string,string,string");
        jsonSerDe.initialize(testConfig, properties);
    }

    @Test
    public void test() {
        fail("Not yet implemented");
    }
}
