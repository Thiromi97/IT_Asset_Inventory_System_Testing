package com.ITAssetInventory.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig()
    {
        File src = new File("D:\\Thiromi\\ime_auto\\IT_Asset_Inventory_System_Testing\\Configuration\\config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getBaseURL()
    {
        return pro.getProperty("baseUrl");
    }

    public String getUsername()
    {
        return pro.getProperty("username");
    }

    public String getPassword()
    {
        return pro.getProperty("password");
    }

    public String getChromePath()
    {
        return pro.getProperty("chromePath");
    }

    public String getEdgePath()
    {
       return pro.getProperty("edgePath");
    }

}
