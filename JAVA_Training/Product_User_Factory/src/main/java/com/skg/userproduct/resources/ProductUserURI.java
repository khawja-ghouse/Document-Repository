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

@Path("/api/")
public class ProductUserURI {

	ProductAvailabilityService productAvailabilityService = null;

	public ProductUserURI() throws InvalidUserProductException, SQLException, IOException {
		productAvailabilityService = new ProductAvailabilityService();
	}

	@GET
	@Path("getAllProductForUser/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProductForUser(@PathParam("userId") String userId) {
		try {
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
	public List<Product> getAllProductForUserForCategory(@QueryParam("userId") String userId,
			@QueryParam("category") String category) {
		try {
			return productAvailabilityService.getAllProductForUserForCategory(userId, category);

		} catch (InvalidUserProductException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
