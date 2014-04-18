package org.j2eedev.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 */
public class FileReadWithOffsetPosition {

	public static void main(String[] args) throws IOException {
		//Path represents a file or directory in Hadoop distributed environment
		Path fileToRead = new Path("/j2eedev/playArea/writeFile.txt");
		//Represents a FileSystem in Hadoop distributed environment
		FileSystem fs = FileSystem.get(new Configuration());
		//Input stream to read a file in Hdfs.
		FSDataInputStream inputStream = null;
		try {
			inputStream = fs.open(fileToRead);
			System.out.print("start postion=" + inputStream.getPos() + ": ");
			IOUtils.copyBytes(inputStream, System.out, 4096, false);
			inputStream.seek(11);
			System.out.print("start postion=" + inputStream.getPos() + ": ");
			IOUtils.copyBytes(inputStream, System.out, 4096, false);
			inputStream.seek(0);
			System.out.print("start postion=" + inputStream.getPos() + ": ");
			IOUtils.copyBytes(inputStream, System.out, 4096, false);
		} finally {
			IOUtils.closeStream(inputStream);
		}
	}

}
