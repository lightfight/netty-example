package com.game;

import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *
 *
 *
 * </pre>
 *
 * @author ursobeautiful@qq.com
 * @since 2018/7/2 上午10:32
 */
public class GameUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameUtil.class);

    public static void track(ByteBuf buf){

        StringBuilder builder = new StringBuilder();
        for(int i=0; i< buf.capacity(); i++){
            builder.append(buf.getByte(i)).append(", ");
        }

        LOGGER.info(builder.toString());
    }

    public static byte[] toBytes(ByteBuf buf){
        byte[] bytes = new byte[buf.capacity()];
        buf.readBytes(bytes);
        return bytes;
    }
}
