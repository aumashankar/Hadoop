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
public class RenamingFileInHdfs {

	public static void main(String[] args) throws IOException {
		//Represents a FileSystem in Hadoop distributed environment
		FileSystem fileSystem = FileSystem.get(new Configuration());
		//Represents a path to file or directory in HDFS
		Path source = new Path("/j2eedev/playArea/readMe.txt");
		Path renamePath = new Path("/j2eedev/playArea/readMe1.txt");
		boolean status = fileSystem.rename(source, renamePath);
		System.out.println("Rename: " + status);
	}

}
