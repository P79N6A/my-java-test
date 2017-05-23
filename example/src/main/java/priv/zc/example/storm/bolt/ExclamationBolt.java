package priv.zc.example.storm.bolt;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 17/5/23.
 */
public class ExclamationBolt implements IRichBolt {
    private Logger logger = LoggerFactory.getLogger(getClass());
    OutputCollector _collector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        logger.debug("prepare");
        _collector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        logger.debug("execute");
        _collector.emit(tuple, new Values(tuple.getString(0) + "!!!"));
        _collector.ack(tuple);
    }

    @Override
    public void cleanup() {
        logger.debug("cleanup");
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        logger.debug("declareOutputFields");
        outputFieldsDeclarer.declare(new Fields("word"));

    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        logger.debug("getComponentConfiguration");
        return null;
    }
}
