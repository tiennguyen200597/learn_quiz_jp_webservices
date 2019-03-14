package com.app.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.app.config.AppConfig;
import com.app.entity.Student;
import com.app.service.StudentService;
@Path("/json/product")
public class JSONService {

	private AbstractApplicationContext context;

	@GET
	@Path("/get")
	@Produces("application/json")
	public List<Student> getProductInJSON() {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
	    StudentService studentService = (StudentService) context.getBean("studentService");
	    List<Student> listStudents = studentService.selectAllStudent();
		Product product = new Product();
		product.setName("iPad 5");
		product.setQty(999);
		Product product1 = new Product();
		product1.setName("iPad 6");
		product1.setQty(999);
		ArrayList<Product> arrayList=new ArrayList<Product>();
		arrayList.add(product);
		arrayList.add(product1);
		
		return listStudents; 

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Product product) {

		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();
		
	}
	
}