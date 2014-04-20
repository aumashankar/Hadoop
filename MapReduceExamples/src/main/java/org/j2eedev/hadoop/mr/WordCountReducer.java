package org.j2eedev.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 *
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	//Override reduce() method of Reducer class
	@Override
	protected void reduce(Text token, Iterable<IntWritable> counts, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
        //Collect counts to sum
		for (IntWritable count : counts) {
			sum += count.get();
		}
		//Write token and count to Context
		context.write(token, new IntWritable(sum));
	}
}
