package com.ppx.bi.storm;



import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maoxiangyi on 2016/4/27.
 */
public class MyCountBolt extends BaseRichBolt {
    OutputCollector collector;
    Map<String, Integer> map = new HashMap<String, Integer>();

    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
    }
    public void execute(Tuple input) {
        String word = input.getString(0);
        Integer num = input.getInteger(1);
        System.out.println(Thread.currentThread().getId() + "    word:"+word);
        if (map.containsKey(word)){
            Integer count = map.get(word);
            map.put(word,count + num);
        }else {
            map.put(word,num);
        }
//        System.out.println("count:"+map);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
       //��ݔ��
    }
}
