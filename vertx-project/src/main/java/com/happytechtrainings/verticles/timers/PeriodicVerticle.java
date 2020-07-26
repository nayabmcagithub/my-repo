package com.happytechtrainings.verticles.timers;

import io.vertx.core.AbstractVerticle;

public class PeriodicVerticle extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		System.out.println("PeriodicVerticle.start()");
		
		vertx.setTimer(1000, handler->{
			System.out.println("I am delayed by 1 second");
		});
		
		vertx.setPeriodic(2000, handler->{
			System.out.println("I am printing every 2 seconds");
		});
	}
}
