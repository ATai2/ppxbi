package com.ppx.bi.storm;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

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
