package org.j2eedev.hadoop.hdfs;

import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 */
public class ReadingFile {

	public static void main(String[] args) throws IOException {
		//Path represents a File or directory in distributed FileSystem
		Path fileToRead = new Path("/home/hadoop/j2eedev/hadoop/data/readMe.txt");
		//Represents a FileSystem in Hadoop
		FileSystem fs = FileSystem.get(new Configuration());
		InputStream input = null;
		try {
			input = fs.open(fileToRead);
			//IOUtils class to read/write bytes to a File.
			IOUtils.copyBytes(input, System.out, 4096);
		} finally {
			IOUtils.closeStream(input);
		}
	}

}
