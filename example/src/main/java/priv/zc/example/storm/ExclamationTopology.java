package priv.zc.example.storm;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.testing.TestWordSpout;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

import priv.zc.example.storm.bolt.ExclamationBolt;

/**
 * 17/5/23.
 */
public class ExclamationTopology {
    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("words", new TestWordSpout(), 1);
        builder.setBolt("exclaim1", new ExclamationBolt(), 1).shuffleGrouping(
                "words");
        builder.setBolt("exclaim2", new ExclamationBolt(), 1).shuffleGrouping("exclaim1");
        localRun(builder);
    }

    public static void localRun(TopologyBuilder builder){
        Config conf = new Config();
        conf.setDebug(false);
        conf.setNumWorkers(2);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("test",conf,builder.createTopology());
        Utils.sleep(10000);
        cluster.killTopology("test");
        cluster.shutdown();
    }

    public static void ClusterRun(TopologyBuilder builder){

    }
}
