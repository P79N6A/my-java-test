import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import priv.zc.rpc.service.HelloService;
import priv.zc.rpc.service.HelloServiceHandler;

public class ServiceTest {
	public static void startSimpleServer(HelloService.Processor<HelloServiceHandler> processor) {
		try {
			TServerTransport serverTransport = new TServerSocket(9090);
			Args args = new Args(serverTransport).processor(processor);
			TServer server = new TThreadPoolServer(args);
			System.out.println("Starting the simple server...");
			server.serve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		startSimpleServer(new HelloService.Processor<HelloServiceHandler>(new HelloServiceHandler()));
	}
}
