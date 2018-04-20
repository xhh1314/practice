package practice.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class NettyTest {

    private static final Channel channel = new NioSocketChannel();

    public static void connect() {
        ChannelFuture channelFuture = channel.connect(new InetSocketAddress("127.0.0.1", 8081));
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    ByteBuf buffer = Unpooled.copiedBuffer("hello", Charset.defaultCharset());
                    ChannelFuture wf = channelFuture.channel().writeAndFlush(buffer);
                } else {
                    throw new RuntimeException();
                }
            }
        });
    }

}
