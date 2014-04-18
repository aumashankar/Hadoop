package org.j2eedev.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 *
 */
public class CopyFileToHdfs {

	public static void main(String[] args) throws IOException {
		//Represents a FileSystem in Hadoop distributed environment 
		FileSystem fs = FileSystem.get(new Configuration());
		//Path represents a File or Directory in Hadoop distributed environment
		Path fromLocal = new Path("/home/hadoop/Training/exercises/sample_data/hamlet.txt");
		Path toHdfs = new Path("/j2eedev/playArea/hamlet.txt");
		//It is similar to copyFromLocal command in HDFS shell.
		fs.copyFromLocalFile(fromLocal, toHdfs);
	}

}
