package com.common.mvc.x.network.nettty;

import com.common.mvc.x.model.BaseModel;

import java.nio.ByteOrder;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import io.netty.util.CharsetUtil;

/**
 * @author xiao
 */
public class NettyClientManager {

    private static final int RECONNECTION = 60;

    private Channel channel;

    private Bootstrap bootstrap;

    private NioEventLoopGroup group;


    private static class SingletonHolder {
        private static final NettyClientManager INSTANCE = new NettyClientManager();
    }

    public static NettyClientManager getInstance() {
        return NettyClientManager.SingletonHolder.INSTANCE;
    }

    public NettyClientManager() {
        init();
    }

    private void init() {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(group);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                pipeline.addLast(new LengthFieldBasedFrameDecoder(ByteOrder.LITTLE_ENDIAN, 1024 * 1024, 4, 4, 0, 0, false));
                pipeline.addLast(new WriteTimeoutHandler(40));
                pipeline.addLast(new ReadTimeoutHandler(40));
                pipeline.addLast(new IdleStateHandler(RECONNECTION,RECONNECTION,0));
                pipeline.addLast(new NettyClientHandler());
            }
        });
    }

    /**
     * 连接
     *
     * @param host
     * @param port
     */
    public void connect(String host, int port) {
        try {
            //发起异步连接操作
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            channel = channelFuture.channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    /**
     * 发送tcp数据
     */
    public void sendNettyMessage(BaseModel msg) {
        if (isConnected()) {
            channel.writeAndFlush(msg);
        }
    }

    /**
     * 判断是否连接
     *
     * @return
     */
    public boolean isConnected() {
        if (channel != null && channel.isOpen() && channel.isActive()) {
            return true;
        }
        return false;
    }

    /**
     * 断开连接
     */
    public void disConnect() {
        if (group != null) {
            group.shutdownGracefully();
        }
    }
}
