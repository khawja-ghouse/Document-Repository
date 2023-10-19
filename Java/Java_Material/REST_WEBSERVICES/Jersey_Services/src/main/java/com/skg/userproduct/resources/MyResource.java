package com.skg.userproduct.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.model.Product;
import com.skg.userproduct.services.ProductAvailabilityService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("productUser")
public class MyResource {

	ProductAvailabilityService productAvailabilityService = null;

	public MyResource() throws InvalidUserProductException, SQLException, IOException {
		productAvailabilityService = new ProductAvailabilityService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/getAllProductForUser/{userId}")
	public List<Product> getAllProductForUser(@PathParam("userId") String userId) {
		try {
//			ObjectMapper mapper = new ObjectMapper();

//			return response = Response.status(Status.OK)
//					.entity(mapper.writeValueAsString(productAvailabilityService.getAllProductForUser(userId))).build();
			return productAvailabilityService.getAllProductForUser(userId);
		} catch (InvalidUserProductException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllProductForUserForCategory")
	public Response getAllProductForUserForCategory(@QueryParam("userId") String userId,
			@QueryParam("category") String category) {
		Response response = null;
		try {
			ObjectMapper mapper = new ObjectMapper();

			return response = Response.status(Status.OK).entity(mapper
					.writeValueAsString(productAvailabilityService.getAllProductForUserForCategory(userId, category)))
					.build();

		} catch (InvalidUserProductException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
