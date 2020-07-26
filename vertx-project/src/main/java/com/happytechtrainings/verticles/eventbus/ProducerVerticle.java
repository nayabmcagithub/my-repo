package com.happytechtrainings.verticles.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class ProducerVerticle extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		JsonObject message =  new JsonObject();
		message.put("name", "Nayab");
		vertx.eventBus().send("consumer", message,handler->{
			if(handler.succeeded()) {
				System.out.println("Got the ACK");
				System.out.println(handler.result().body());
			}else {
				System.out.println("Faild to deliver");
			}
		});
	}
}
