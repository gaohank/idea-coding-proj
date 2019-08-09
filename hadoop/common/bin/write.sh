#!/usr/bin/env bash
output=/tmp/sequenceFile

hadoop fs -rm -R -skipTrash ${output}

spark-submit \
    --conf spark.yarn.job.owners="gaosongling" \
    --master "yarn" \
    --deploy-mode "cluster" \
    --driver-memory 4g \
    --executor-memory 10g \
    --num-executors 8 \
    --conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
    --class cn.gaohank.idea.hadoop.common.WriteData \
    target/common-1.0.jar ${output}