import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import priv.zc.rpc.service.HelloService;

public class ClientTest {
	public static void main(String[] args) {
		try {
			TTransport transport = new TSocket("localhost", 9090);
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			HelloService.Client client = new HelloService.Client(protocol);
			int i = 0;
			while (true) {
				System.out.println(client.sayHello("bb" + i));
				i++;
				Thread.sleep(1000);
			}
			// transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
