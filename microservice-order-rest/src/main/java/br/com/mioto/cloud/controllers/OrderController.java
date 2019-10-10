package br.com.mioto.cloud.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mioto.cloud.dao.ResponseTimeDAO;
import br.com.mioto.cloud.vo.Order;

@RequestMapping( value = "/orders" )
@RestController
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    ResponseTimeDAO responseTimeDAO;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Order getOrder() {
        log.info("Order Rest >> getOrder");

		final Order order = new Order();
        //order.setUser(user);
        //order.setListProduct(listProduct);
        //order.setDelivery(delivery);
        //order.setBilling(billing);
        //order.setBenefits(benefits);
		return order;
	}
}