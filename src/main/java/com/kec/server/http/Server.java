package com.kec.server.http;

import io.javalin.Javalin;

public class Server {
    private static void setupRoutes(final Javalin app) {
        app.get("/", ctx -> {
            String q = ctx.queryParam("name");
            if (q == null) {
                ctx.result("Hello World");
            } else {
                ctx.result("Hello " + q);
            }
        });

        app.get("/:name", ctx -> {
            ctx.result("Hello " + ctx.pathParam("name"));
        });
    }

    public static void main(String[] args) {
        int port = 8080;
        Javalin app = Javalin.create();
        setupRoutes(app);
        app.start(port);
    }
}
