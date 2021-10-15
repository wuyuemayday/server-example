package com.kec.client.websocket;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

public class EchoClient extends WebSocketListener {

    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        System.out.println(text);
    }

    @Override
    public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
        System.out.println(reason);
    }

    public static void main(String[] args) {
        final OkHttpClient client = new OkHttpClient();
        final Request req = new Request.Builder()
                .url("ws://localhost:8081")
                .build();
        WebSocket ws = client.newWebSocket(req, new EchoClient());

        ws.send("hey man!");
        ws.send("haha");
        ws.send("abc");
        ws.close(1000, "closed");

        client.dispatcher().executorService().shutdown();
    }
}
