package com.happytechtrainings;

import com.happytechtrainings.verticles.FirstVerticle;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonObject;

public class MainVerticle extends AbstractVerticle{
	
	@Override
	public void start() throws Exception {
		ConfigStoreOptions fileStore = new ConfigStoreOptions().setType("file").setOptional(true)
				.setConfig(new JsonObject().put("path", "my-config.hocon"));
		ConfigStoreOptions sysPropsStore = new ConfigStoreOptions().setType("sys");
		ConfigRetrieverOptions options = new ConfigRetrieverOptions().addStore(fileStore).addStore(sysPropsStore);
		ConfigRetriever retriever = ConfigRetriever.create(vertx, options);

		retriever.getConfig(json -> {
			  JsonObject result = json.result();
			  int instance = result.getInteger("first-verticle-instances");
			  System.out.println("Num of instances:"+ instance);
			  
			   FirstVerticle fv = new FirstVerticle();
				DeploymentOptions doptions =  new DeploymentOptions();
				doptions.setConfig(result);
				doptions.setWorker(false);
				doptions.setInstances(instance);
				
				vertx.deployVerticle(fv,doptions);	
		});
		
	}
}
