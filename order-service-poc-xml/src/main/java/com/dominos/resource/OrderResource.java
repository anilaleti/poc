package com.dominos.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dominos.req.CustomerDetails;
import com.dominos.req.DeliveryDetails;
import com.dominos.req.Order;

@Path("/order")

public class OrderResource {

	/**
	 * @param Order
	 * @return String
	 */
	@Path("/createOrder")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

	public Response createOrder(Order order) {

		System.out.println("Entred into createOrder()...");
		String returnString = "created succesfully";
		System.out.println("Exiting from createOrder()...");
		return Response.ok().entity(returnString).build();

	}

	/**
	 * @param orderId
	 * @return Order
	 */
	@Path("/getOrder")
	@GET
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

	public Response getOrder(@QueryParam(value = "orderId") String orderId) {
		// http://localhost:7070/order-web/order/getOrder?orderId=1234
		System.out.println("Entred into getOrder()...");
		Order order = new Order();
		order.setDate("10-9-2018");
		order.setOrderId("101");
		order.setPrice("4000");
		order.setQty("4");
		order.setProductName("pizza");
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustName("Anil");
		customerDetails.setMobileNum("91777");
		DeliveryDetails deliveryDetails = new DeliveryDetails();
		deliveryDetails.setDlvryLocation("Sr Nagar");
		order.setCstmrDtls(customerDetails);
		order.setDelvryDtls(deliveryDetails);
		System.out.println("Exiting from getOrder()...");
		return Response.ok().entity(order).build();
	}

	/**
	 * @param String
	 * @return String
	 */
	@Path("/updateOrder")
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

	public Response updateOrder(@QueryParam(value = "orderId") String orderId) {
		System.out.println("Entred into updateOrder()...");
		String returnString = "updated succesfully";
		System.out.println("Exiting from updateOrder()...");
		return Response.ok().entity(returnString).build();

	}

	@Path("/healthCheck")
	@GET
	public String healthCheck() {
		return "order service is runnig fine.........";

	}

}
