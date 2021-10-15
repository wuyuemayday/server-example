package com.kec.server.websocket;

import io.javalin.Javalin;

public class Server {

    private static void routes(final Javalin app) {
        app.ws("/", ws -> {
            ws.onConnect(ctx -> {
                String username = ctx.getSessionId();
                ctx.send(username + " connected");
            });
            ws.onClose(ctx -> {
                String username = ctx.getSessionId();
                ctx.send(username + " closed");
            });
            ws.onMessage(ctx -> {
                String username = ctx.getSessionId();
                ctx.send(username + " said " + ctx.message());
            });
        });
    }

    public static void main(String[] args) {
        Javalin app = Javalin.create();
        routes(app);
        app.start(8081);
    }
}
