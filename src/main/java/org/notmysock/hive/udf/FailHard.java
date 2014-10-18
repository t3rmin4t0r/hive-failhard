package org.notmysock.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.udf.UDFType;
import org.apache.hadoop.io.IntWritable;

@UDFType(deterministic = false)
public class FailSafe extends UDF {
	private int repeats = 0;
	public final IntWritable evaluate(IntWritable a) {
		if (a == null) {
			return a;
		}
		repeats++;
		if (repeats >= a.get()) {
			throw new RuntimeException();
		}
		return a;
	}
}
