package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @Created: lidong on 2022/5/7 2:19 PM
 * @Description: nio
 * @version: 1.0.0
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8080));
            serverSocketChannel.configureBlocking(false);

            // 创建一个 selector
            Selector selector = Selector.open();
            // 这个selector 关心 OP_ACCEPT事件。 （客户端链接）
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                // 阻塞等待事件发生
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    handler(key);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final void handler(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isAcceptable()) {
            System.out.println("有人来了");
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);

            socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {
            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            int len = socketChannel.read(byteBuffer);
            System.out.println(new String(byteBuffer.array(), 0 ,len, StandardCharsets.UTF_8));
            ByteBuffer bufferToWrite = ByteBuffer.wrap("你也好".getBytes(StandardCharsets.UTF_8));
            socketChannel.write(bufferToWrite);
        }
    }
}
