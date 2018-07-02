package com.genoprime.netty.example;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 *
 *
 *  web socket 客户端测试类
 *
 *
 * </pre>
 *
 * @author ursobeautiful@qq.com
 * @since 2018/6/30 上午11:10
 */
public class WebSocketClientTest {


    @Test
    public void connect() throws Exception {
        final String url = "ws://localhost:8182/websocket";
        final WebSocketClient client = new WebSocketClient(url);
        client.open();

        // ## 发送string
//        client.eval("hello server");

        // ## 发送字节数组
        byte[] data = {100, 20, 10};
        client.sendBytes(data);

        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void connectHuobi() throws Exception {

        final String url = "ws://api.huobi.pro:80/ws";
        final WebSocketClient client = new WebSocketClient(url);
        client.open();

        // ## 发送string
        JSONObject sub = new JSONObject();
        sub.put("sub", "market.btcusdt.kline.1min");
        sub.put("id", "id1000");
        client.eval(sub.toString());

        // ## 阻塞住线程
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
    }

}
