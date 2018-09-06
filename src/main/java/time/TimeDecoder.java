package time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TimeDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
        log.info("进入decode");
        if (in.readableBytes() < 4) {
            return; // (3)
        }
        out.add(new UnixTime(in.readUnsignedInt())); //将Object 加到List说明 解码成功 ，才允许进入下一个handler
    }
}
