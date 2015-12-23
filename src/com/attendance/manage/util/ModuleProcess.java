package com.attendance.manage.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;


public class  ModuleProcess {

    public static Map<String, String> getModuleMap() {
        Properties prop = loadProperties(); 
        Map result=new HashMap(prop);
        return result!=null?result:new HashMap();
    }
    
    public static Iterator<Object> getModuleIds() {
        Properties prop = loadProperties(); 
        return prop!=null&&!prop.isEmpty()?prop.keySet().iterator():null;
    }
    
    public static String getModuleNameById(String id) {
        Properties prop = loadProperties(); 
        return prop!=null&&prop.containsKey(id)?prop.getProperty(id):"";
    }

    /**
     * 读取配置文件
     * @param:@return
     * @return:Properties
     * @author:dailu
     * @time:2014-3-20 上午10:06:27
     */
    private static Properties loadProperties() {
        Properties prop = new Properties(); 
        InputStream in = new ModuleProcess().getClass().getResourceAsStream("processinfo.properties"); 
        try { 
            prop.load(in); 
        } catch (IOException e) { 
            Logger.getLogger(ModuleProcess.class).error("ERROR");
            e.printStackTrace(); 
        }
        return prop;
    }
    
	public static void main(String args[]){
	    Map<String, String>  m= ModuleProcess.getModuleMap();
	      System.out.println(m.get("ip"));
	}
}
