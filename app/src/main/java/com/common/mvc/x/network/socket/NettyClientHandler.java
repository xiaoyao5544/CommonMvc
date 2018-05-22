package com.common.mvc.x.network.socket;

import com.common.mvc.x.model.BaseModel;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author xiao
 * @date 2018/5/22
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<BaseModel> {


    /**
     * 服务器返回消息的回调
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, BaseModel msg) throws Exception {

    }
}
