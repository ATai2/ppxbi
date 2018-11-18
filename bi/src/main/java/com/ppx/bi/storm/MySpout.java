package com.ppx.bi.storm;



import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * Created by maoxiangyi on 2016/4/27.
 */
public class MySpout extends BaseRichSpout {
    SpoutOutputCollector collector;

    //��ʼ������
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;
    }

    //storm ����� while(true) ����nextTuple����
    public void nextTuple() {
        collector.emit(new Values("i am lilei love hanmeimei"));
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
       declarer.declare(new Fields("love"));
    }
}
