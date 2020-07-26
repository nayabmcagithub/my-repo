package com.happytechtrainings.verticles;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonObject;

public class BootstrapVerticle extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		
		ConfigStoreOptions fileStore = new ConfigStoreOptions()
				  .setType("file")
				  .setOptional(true)
				  .setConfig(new JsonObject().put("path", "my-config.hocon"));
				ConfigStoreOptions sysPropsStore = new ConfigStoreOptions().setType("sys");
				ConfigRetrieverOptions options = new ConfigRetrieverOptions().addStore(fileStore).addStore(sysPropsStore);
				ConfigRetriever retriever = ConfigRetriever.create(vertx, options);
				retriever.getConfig(json -> {
					  JsonObject configs = json.result();
					  int numInstances = configs.getInteger("verticle-instances");
					  DeploymentOptions doptions =  new DeploymentOptions();
						doptions.setInstances(numInstances);
						doptions.setWorker(false);
						vertx.deployVerticle(new FirstVerticle());
						vertx.deployVerticle(MyVerticle.class.getName(),doptions);
						vertx.deployVerticle("com.happytechtrainings.verticles.CustomerVerticle",doptions);
					});
		
		
	}
}
