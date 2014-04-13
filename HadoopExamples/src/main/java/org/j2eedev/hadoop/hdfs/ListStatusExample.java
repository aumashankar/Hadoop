package org.j2eedev.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 */
public class ListStatusExample {

	public static void main(String[] args) throws Exception{
		//Path represents a file or directory in distributed hadoop environment.
		Path path = new Path("/");
		if ( args.length == 1){
			path = new Path(args[0]);
		}
		//Loads configuration properties for Hadoop environment. core-site.xml,hdfs-site.xml properties are loaded through Configuration class.
		Configuration conf = new Configuration();
		//Represents a FileSystem, an Abstract class
		/*Concrete Implementations in Hadoop
		 * DistributedFileSystem
		 * LocalFileSystem
		 * HttpFileSystem
		 * FtpFileSystem
		 * S3FileSystem -Amazon S3
		 * KosmosFileSystem 
		 * */
		FileSystem fs = FileSystem.get(conf);
		//Lists files or directories in distributed environment.
		FileStatus [] files = fs.listStatus(path);
		
		for (FileStatus file : files ){
			System.out.println(file.getPath().getName());
		}
	}
}
