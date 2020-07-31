package com.happytechtrainings;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class BoostrapVerticle extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		System.out.println("BoostrapVerticle.start()");
		HttpServer server = vertx.createHttpServer();
		
		Router router = Router.router(vertx);
		router.get("/getCustomers").handler(context->{
			JsonObject customer = new JsonObject();
			customer.put("name", "nayab");
			context.response().end(customer.encodePrettily());
		});
		
		server.requestHandler(router).listen(8080);
	}
}
