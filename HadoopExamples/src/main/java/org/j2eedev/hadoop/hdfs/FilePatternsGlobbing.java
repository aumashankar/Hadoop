package org.j2eedev.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 */
public class FilePatternsGlobbing {
	public static void main(String[] args) throws IOException {
		/**
		 *  A filename pattern is composed of regular characters and special pattern matching characters, which are:

    		?               - Matches any single character.
		 	*       		- Matches zero or more characters.
  			[abc]   		- Matches a single character from character set {a,b,c}.
			[a-b]   		- Matches a single character from the character range {a...b}. Note that character a must be lexicographically less than or equal to character b.
			[^a]    		- Matches a single character that is not from character set or range {a}. Note that the ^ character must occur immediately to the right of the opening bracket.
			\c      		- Removes (escapes) any special meaning of character c.
			{ab,cd} 		- Matches a string from the string set {ab, cd}
    		{ab,c{de,fh}}   - Matches a string from the string set {ab, cde, cfh} 
		 */
		//args[0] --> something like /j2eedev/hadoop/data/glob/read*
		Path globPattern = new Path(args[0]); 
		//Represents a FileSystem in Hadoop distributed environment
		FileSystem fileSystem = FileSystem.get(new Configuration());
		//Like listStatus(), globStatus() is used to list files when filePattern globbing is used.
		FileStatus[] files = fileSystem.globStatus(globPattern);
		for (FileStatus file : files) {
			System.out.println(file.getPath().getName());
		}
	}
}
