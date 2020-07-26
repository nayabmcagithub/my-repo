package com.happytechtrainings.verticles;

import io.vertx.core.AbstractVerticle;

public class CustomerVerticle extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		System.out.println("CustomerVerticle.start()");
	}
}
