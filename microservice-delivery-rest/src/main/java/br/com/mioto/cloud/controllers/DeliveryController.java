package br.com.mioto.cloud.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mioto.cloud.dao.ResponseTimeDAO;
import br.com.mioto.cloud.vo.Delivery;

@RequestMapping( value = "/deliveries" )
@RestController
public class DeliveryController {

	private static final Logger log = LoggerFactory.getLogger(DeliveryController.class);

    @Autowired
    ResponseTimeDAO responseTimeDAO;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Delivery getDelivery() {

		log.info("Basket Rest Service >> getDelivery");

		final Delivery delivery = new Delivery();

        delivery.setAddress("Rua example");
        delivery.setCity("City example");
        delivery.setDeliveryDateExecuted(new Date());
        delivery.setReceivedBy("John Example");
        delivery.setReference("Reference Example");
        //delivery.setFare(fare);

		return delivery;
	}
}