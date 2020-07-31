package com.happytechtrainings;

import com.happytechtrainings.verticles.FirstVerticle;

import io.vertx.core.AbstractVerticle;

public class BootstrapVerticle extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		//vertx.deployVerticle("com.happytechtrainings.verticles.FirstVerticle");
		vertx.deployVerticle(FirstVerticle.class.getName());
		//vertx.deployVerticle(new FirstVerticle());
	}
}
