package com.confused.HelperClasses;

import java.io.FileReader;
import java.util.Properties;

public class ConfigHelper
{
        public String getProperty(String key)
        {
            try
            {
                String fileName =  "src/test/java/com/confused/config/config.properties";
                FileReader reader = new FileReader(fileName);
                Properties prop=new Properties();
                prop.load(reader);

                return prop.getProperty(key);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return "Exception encountered";

        }
}
