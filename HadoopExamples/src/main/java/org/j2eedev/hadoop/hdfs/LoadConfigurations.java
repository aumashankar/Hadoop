package org.j2eedev.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 */
public class LoadConfigurations {
	private final static String PROP_NAME = "fs.default.name"; 
	public static void main(String[] args) {
		//Configuration class is to load configuration in Hadoop distributed environment.
		//Loads properties from files such as core-site.xml,hdfs-site.xml,yarn-site.xml etc.,
		Configuration configuration = new Configuration();
		System.out.println("After construction: " + configuration.get(PROP_NAME));
		configuration.addResource(new Path("/home/hadoop/Training/CDH4/hadoop-2.0.0-cdh4.0.0/conf/core-site.xml"));
		System.out.println("After addResource: " + configuration.get(PROP_NAME));
		configuration.set(PROP_NAME, "hdfs://localhost:8111");
		System.out.println("After configuration set: " + configuration.get(PROP_NAME));
	}

}
