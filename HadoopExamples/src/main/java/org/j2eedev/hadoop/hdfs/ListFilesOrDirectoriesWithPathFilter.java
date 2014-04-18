package org.j2eedev.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 */
public class ListFilesOrDirectoriesWithPathFilter {

	public static void main(String[] args) throws Exception{
		//Path represents a file or directory in Hadoop distributed environment
		Path path = new Path("/");
		if ( args.length == 1){
			path = new Path(args[0]);
		}
		//Configuration class to load configurations from conf files such as core-site.xml,hdfs-site.xml and yarn-site.xml etc.,
		Configuration configuration = new Configuration();
		//Represents a FileSystem in Hadoop distributed environment.
		FileSystem fileSystem = FileSystem.get(configuration);
		//Holds set of files / directories
		FileStatus [] files = fileSystem.listStatus(path, new PathFilter() {
			@Override
			public boolean accept(Path path) {
				if (path.getName().equals("user")){
					return false;
				}
				return true;
			}
		});
		
		for (FileStatus file : files ){
			System.out.println(file.getPath().getName());
		}
	}
}
