package priv.zc.example.storm;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.testing.TestWordSpout;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.zc.example.storm.bolt.ExclamationBolt;

/**
 * 17/5/23.
 */
public class ExclamationTopology {
    private static Logger logger = LoggerFactory.getLogger(ExclamationTopology.class);
    public static void main(String[] args) {
        logger.info("main start");
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("words", new TestWordSpout(), 1);
        builder.setBolt("exclaim1", new ExclamationBolt(), 1).shuffleGrouping(
                "words");
        builder.setBolt("exclaim2", new ExclamationBolt(), 1).shuffleGrouping("exclaim1");
        StormTopology topology = builder.createTopology();
        if(args!=null && args.length>0 && args[0].equals("test")){
            clusterRun(topology);
        }
        else
        {
            localRun(topology);
        }
    }

    public static void localRun(StormTopology topology){
        logger.info("local start");
        Config conf = new Config();
        conf.setDebug(false);
        conf.setNumWorkers(2);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("test",conf,topology);
        Utils.sleep(10000);
        cluster.killTopology("test");
        cluster.shutdown();
    }

    public static void clusterRun(StormTopology topology){
        logger.info("local start");
        Config conf = new Config();
        conf.setDebug(false);
        conf.setNumWorkers(2);

        try {
            StormSubmitter.submitTopology("test",conf,topology);
        } catch (AlreadyAliveException e) {
            e.printStackTrace();
        } catch (InvalidTopologyException e) {
            e.printStackTrace();
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }
    }
}
