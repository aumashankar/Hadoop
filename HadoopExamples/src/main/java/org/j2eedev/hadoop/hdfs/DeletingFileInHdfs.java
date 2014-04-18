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
public class DeletingFileInHdfs {
	public static void main(String[] args) throws IOException {
		//Configuration class is load Configurations to Hadoop environment from conf files such as core-site.xml,hdfs-site.xml etc.,
		Configuration conf = new Configuration();
		//Represents a FileSystem in Hadoop distributed environment
		FileSystem fs = FileSystem.get(conf);
		//Represents a file or directory in Hadoop distributed environment
		Path pathToDelete = new Path("/j2eedev/playArea/writeFile.txt");
		//delete method in filesystem delete either a file or directory, if it is a directory and you want to delete recursively directory items then 2nd arg of method should be true.
		boolean status = fs.delete(pathToDelete, false);
		System.out.println("Deleted: " + status);
	}
}
