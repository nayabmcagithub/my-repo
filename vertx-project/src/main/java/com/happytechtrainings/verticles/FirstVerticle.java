package com.happytechtrainings.verticles;

import io.vertx.core.AbstractVerticle;

public class FirstVerticle  extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		System.out.println("FirstVerticle.start()");
	}
}
