package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ChannelTest {
    //	@Test
    public void testFileChannel() throws IOException {
        // Path path=Paths.get("C:\\Users\\zongchao\\Desktop\\缺陷.txt");
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\zongchao\\Desktop\\缺陷.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    //	@Test
    public void testServerSocketChannel() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer buf = ByteBuffer.allocate(100);
            int length = socketChannel.read(buf);
            while (length != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                length = socketChannel.read(buf);
            }
        }
    }

    //	@Test
    public void testSocketChannel1() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9000));
        ByteBuffer buf = ByteBuffer.allocate(300);
        buf.clear();
        buf.put("GET / HTTP/1.0\n\n".getBytes());
        buf.flip();
        socketChannel.write(buf);

        socketChannel.close();
    }

    //	@Test
    public void testSocketChannel() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("61.135.169.121", 80));
        ByteBuffer buf = ByteBuffer.allocate(300);
        ByteBuffer readBuf = ByteBuffer.allocate(400);
        buf.clear();
        buf.put("GET / HTTP/1.0\r\n\r\n".getBytes());
        buf.flip();
        socketChannel.write(buf);

        int length = socketChannel.read(readBuf);
        while (length != -1) {
            readBuf.flip();
            while (readBuf.hasRemaining()) {
                System.out.print((char) readBuf.get());
            }
            readBuf.clear();
            length = socketChannel.read(readBuf);
        }

        socketChannel.close();
    }
}
