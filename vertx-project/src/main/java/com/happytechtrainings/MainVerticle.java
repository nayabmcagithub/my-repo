package com.happytechtrainings;

import com.happytechtrainings.verticles.FirstVerticle;

import io.vertx.core.Vertx;

public class MainVerticle {
	public static void main(String[] args) {
		Vertx vertx = Vertx.factory.vertx();
		FirstVerticle fv =  new FirstVerticle();
		vertx.deployVerticle(fv);
	}
}
