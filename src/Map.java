import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable,Text,Text,FloatWritable> {
	private Text videoName = new Text();
	private FloatWritable rating = new FloatWritable();
	
	public void map(LongWritable key, Text value, Context context) throws IOException,InterruptedException{
		String line = value.toString();
		String str[] = line.split("\t");
		if(str.length>7){
			videoName.set(str[0]);
			if(str[6].matches("\\d+.+")){
				float f = Float.parseFloat(str[6]);
				rating.set(f);
			}
		}
		context.write(videoName, rating);
	}
}
