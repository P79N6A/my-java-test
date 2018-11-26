package priv.zc.example.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;

/**
 * Created by  on 17/7/31.
 */
public class JavaClient {

    public static void main(String[] args) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum",
                "sh01-ne-gss01.sh01.baidu.com:8181,sh01-ne-gss02.sh01.baidu.com:8181,sh01-ne-gss03.sh01.baidu"
                        + ".com:8181");
        conf.set("hbase.master", "sh01-ne-gss01.sh01.baidu.com:8611");
        //        conf.set("hbase.zookeeper.property.clientport","8181");
        // HBaseAdmin hAdmin = new HBaseAdmin(conf);
        Connection connection = ConnectionFactory.createConnection(conf);
        Admin admin = connection.getAdmin();
        Table table = connection.getTable(TableName.valueOf("test"));
        Scan scan = new Scan();
        //        HTable table = new HTable(conf,"test");
        ResultScanner results = table.getScanner(scan);
        for (Result result : results) {
            System.out.println(result);
            for (Cell cell : result.rawCells()) {
                System.out.println("Row Name: " + new String(CellUtil.cloneRow(cell)));
                System.out.println("Timestamp: " + cell.getTimestamp());
                System.out.println("column Family: " + new String(CellUtil.cloneFamily(cell)));
                System.out.println("Column Name: " + new String(CellUtil.cloneQualifier(cell)));
                System.out.println("Value: " + new String(CellUtil.cloneValue(cell)));
            }
//            for (KeyValue cell : result.raw()) {
//                System.out.println("Row Name: " + new String(cell.getRow()));
//                System.out.println("Timestamp: " + cell.getTimestamp());
//                System.out.println("column Family: " + new String(cell.getFamily()));
//                System.out.println("Row Name: " + new String(cell.getQualifier()));
//                System.out.println("Value: " + new String(cell.getValue()));
//            }
        }
    }
}
