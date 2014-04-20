package org.j2eedev.hadoop.mr;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * 
 * @author Umashankar
 * http://j2eedev.org
 *
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable countOne = new IntWritable(1);
	private final Text reusableText = new Text();
    
	//Override map method of Mapper class
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException,
			InterruptedException {
        //Tokenize text using StringTokernizer
		StringTokenizer tokenizer = new StringTokenizer(value.toString());
		while (tokenizer.hasMoreTokens()) {
			reusableText.set(tokenizer.nextToken());
			//Write tokens into context
			context.write(reusableText, countOne);
		}
	}
}