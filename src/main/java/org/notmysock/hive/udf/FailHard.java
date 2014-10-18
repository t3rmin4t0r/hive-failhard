package org.notmysock.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.udf.UDFType;
import org.apache.hadoop.io.IntWritable;

@UDFType(deterministic = false)
public class FailHard extends UDF {
	private static int attempts = 0;
	public final Object XX = null;
	public final IntWritable evaluate(IntWritable a) {
		if (attempts == 0) {
			attempts++;
			System.err.println(XX.toString());
			return a;
		}
		return a;
	}
}
