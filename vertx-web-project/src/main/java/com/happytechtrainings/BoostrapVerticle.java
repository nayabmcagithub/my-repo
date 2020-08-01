package com.happytechtrainings;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class BoostrapVerticle extends AbstractVerticle{
	@Override
	public void start() throws Exception {
		System.out.println("BoostrapVerticle.start()");
		HttpServer server = vertx.createHttpServer();
		
		Router router = Router.router(vertx);
		router.get("/getCustomers").handler(context->{
			JsonObject customer = new JsonObject();
			customer.put("name", "nayab");
			context.response().end(customer.encodePrettily());
		});
		
		//put create doc
		//post update doc
		//patch partial update doc
		//delete  delete the doc
		
		
		
		router.put("/createCustomer").handler(BodyHandler.create()).handler(context->{
			
			JsonObject customer = context.getBodyAsJson();
			System.out.println("Got the Customer :"+ customer.toString());
			
			JsonObject res = new JsonObject();
			res.put("message", "customer created successfully");
			context.response().end(res.encodePrettily());
		});
		
		router.post("/updateCustomer").handler(BodyHandler.create()).handler(context->{
			System.out.println("Post method");
			JsonObject customer = context.getBodyAsJson();
			System.out.println("Got the Customer :"+ customer.toString());
			
			JsonObject res = new JsonObject();
			res.put("message", "customer created successfully");
			context.response().end(res.encodePrettily());
		});
		
		router.patch("/patchCustomer").handler(BodyHandler.create()).handler(context->{
			
			JsonObject customer = context.getBodyAsJson();
			System.out.println("Got the Customer :"+ customer.toString());
			
			JsonObject res = new JsonObject();
			res.put("message", "customer created successfully");
			context.response().end(res.encodePrettily());
		});
		
		router.delete("/deleteCustomer").handler(BodyHandler.create()).handler(context->{
			
			JsonObject customer = context.getBodyAsJson();
			System.out.println("Got the Customer :"+ customer.toString());
			
			JsonObject res = new JsonObject();
			res.put("message", "customer created successfully");
			context.response().end(res.encodePrettily());
		});
		
		// Path Parameters
		
		
		router.get("/getCustomer/:id/:name").handler(context->{
			
			String id = context.request().getParam("id");
			String name = context.request().getParam("name");
			System.out.println("ID is:"+id);
			System.out.println("Name is:"+name);
			JsonObject customer = new JsonObject();
			customer.put("name", "nayab");
			context.response().end(customer.encodePrettily());
		});
		
		// Query Parameters
		router.get("/fetchCustomer").handler(context->{
			
			MultiMap params = context.request().params();
			String name =  params.get("name");
			String email =  params.get("email");
			System.out.println("Query Param Name : "+name);
			System.out.println("Query Param Email : "+email);
			JsonObject customer = new JsonObject();
			customer.put("name", "nayab");
			context.response().end(customer.encodePrettily());
		});
		server.requestHandler(router).listen(8080);
	}
}
