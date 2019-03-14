package com.mkyong.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/json/product")
public class JSONService {

	@GET
	@Path("/get")
	@Produces("application/json")
	public ArrayList<Product> getProductInJSON() {

		Product product = new Product();
		product.setName("iPad 5");
		product.setQty(999);
		Product product1 = new Product();
		product1.setName("iPad 6");
		product1.setQty(999);
		ArrayList<Product> arrayList=new ArrayList<Product>();
		arrayList.add(product);
		arrayList.add(product1);
		
		return arrayList; 

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Product product) {

		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();
		
	}
	
}