#! /bin/bash

HDFS="/home/hadoop/apps/hadoop-2.9.1/bin/hadoop fs"
streaming_dir="/spark/streaming"

$HDFS -rm "${streaming_dir}" '/tmp/*' > /dev/null 2>&1
$HDFS -rm "${streaming_dir}" '/*' > /dev/null 2>&1

while [1]; do
    ./sample_web_log.py > test.log
    tmplog="access.`date + '%s'`.log
