package com.happytechtrainings.verticles.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class ConsumerVerticle extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		vertx.eventBus().consumer("consumer",message->{
			System.out.println("I have received a message: " + message.body());
			JsonObject reply = new JsonObject();
			reply.put("message", "Received the message");
			message.reply(reply);
		});
	}
}
