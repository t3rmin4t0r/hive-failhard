hive-failhard
=============

A UDF built for failure testing

```
   add jar target/failhard-1.0-SNAPSHOT.jar;
   CREATE TEMPORARY FUNCTION failhard as 'org.notmysock.hive.udf.FailHard';
   select count(l_orderkey) from lineitem where failhard(cast(l_orderkey as int)) < 1;
```

will trigger failure on first attempts.

TODO: rand() distributed failure.
