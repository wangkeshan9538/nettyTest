package time;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.nio.channels.ReadableByteChannel;

import static io.netty.util.CharsetUtil.UTF_8;


@Slf4j
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    public TimeServerHandler() {
        log.info("new handler");
    }

   /* public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("服务器接收到连接");
        ByteBuf time = ctx.alloc().buffer(2);

        time.writeChar('1');

        final ChannelFuture f = ctx.writeAndFlush(time); // (3)

        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ByteBuf b1 = future.channel().alloc().buffer(2);
                b1.writeChar('2');
                ChannelFuture f2 = future.channel().writeAndFlush(b1);
                f2.addListener(ChannelFutureListener.CLOSE);
            }
        });*/


        public void channelActive (ChannelHandlerContext ctx) throws Exception {
            log.info("服务器接收到连接");
            final ByteBuf time = ctx.alloc().buffer(4); // (2)
            time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

            final ChannelFuture f = ctx.writeAndFlush(time); // (3)
            f.addListener(ChannelFutureListener.CLOSE);

            ctx.fireChannelActive();
        }


        @Override
        public void channelRead (ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf in = (ByteBuf) msg;
            log.info(in.toString(UTF_8));
            ctx.fireChannelRead(msg);
        }
    }
