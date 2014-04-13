package org.j2eedev.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 */
public class CreateNewDir {

	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		Path newDir = new Path("/training/playArea/j2eedev");
		FileSystem fs = FileSystem.get(conf);
		//mkdirs creates new directory in specified path with Path class
		boolean status = fs.mkdirs(newDir);
		System.out.println(status);
	}

}
