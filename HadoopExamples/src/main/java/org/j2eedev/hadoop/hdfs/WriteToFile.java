package org.j2eedev.hadoop.hdfs;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 */
public class WriteToFile {

	public static void main(String[] args) throws IOException {
		
		String textToWrite = "Hadoop|HBase|MapReduce|Pig|Hive|Flume|Sqoop|ZooKeeper|Mahout|Fuse|Cassendra|Mongo|Jaql!\n";
		InputStream in = new BufferedInputStream(new ByteArrayInputStream(textToWrite.getBytes()));
		//Path repersents a File or Directory in Hadoop distributed environment.
		Path toHdfs = new Path("/j2eedev/playArea/writeFile.txt");
		//Configuration class loads Hadoop environment configuration from core-site.xml,hdfs-site.xml etc.
		Configuration conf = new Configuration();
		//Represents a FileSystem on Hadoop environment.
		FileSystem fs = FileSystem.get(conf);
		//To write data, an OutputStream in Hadoop
		FSDataOutputStream out = fs.create(toHdfs);
		//IOUtils for copying stream of bytes.
		IOUtils.copyBytes(in, out, conf);
	}
}
