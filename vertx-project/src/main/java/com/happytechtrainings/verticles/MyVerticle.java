package com.happytechtrainings.verticles;

import io.vertx.core.AbstractVerticle;

public class MyVerticle extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		System.out.println("MyVerticle.start()");
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("MyVerticle.stop()");
	}
}
