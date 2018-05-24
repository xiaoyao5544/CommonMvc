package com.common.mvc.x.network.nettty;

import com.common.mvc.x.model.BaseModel;
import com.common.mvc.x.network.BaseResponse;
import com.common.mvc.x.network.NetworkCallback;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author xiao
 * @date 2018/5/22
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<BaseResponse<BaseModel>> {

    private NetworkCallback mCallback;

    public NettyClientHandler() {
    }

    public NettyClientHandler(NetworkCallback callback) {
        this.mCallback = callback;
    }

    /**
     * 连接建立准备通信时调用
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    /**
     * 服务器返回消息的回调
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, BaseResponse msg) throws Exception {

    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    /**
     * exceptionCaught()事件处理方法是当出现Throwable对象才会被调用，
     * 即当Netty由于IO错误或者处理器在处理事件时抛出的异常时。
     * 在大部分情况下，捕获的异常应该被记录下来并且把关联的channel给关闭掉。
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
