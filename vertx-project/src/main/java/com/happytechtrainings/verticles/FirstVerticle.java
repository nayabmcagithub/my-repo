package com.happytechtrainings.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class FirstVerticle  extends AbstractVerticle{
	@Override
	public void start(Future<Void> startFuture) throws Exception {
		System.out.println("FirstVerticle.start()");
	}
}
