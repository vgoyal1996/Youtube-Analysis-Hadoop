import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text,FloatWritable,Text,FloatWritable> {
	public void reduce(Text key,Iterable<FloatWritable> values,Context context) throws IOException,InterruptedException{
		float sum=0;
		int l=0;
		for(FloatWritable val:values){
			l+=1;
			sum+=val.get();
		}
		sum=sum/l;
		context.write(key, new FloatWritable(sum));
	}
}
