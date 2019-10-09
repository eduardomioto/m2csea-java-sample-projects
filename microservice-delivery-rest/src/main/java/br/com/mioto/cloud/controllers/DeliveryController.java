package br.com.mioto.cloud.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.mioto.cloud.dao.ResponseTimeDAO;
import br.com.mioto.cloud.services.AccessManagerService;
import br.com.mioto.cloud.services.FareService;
import br.com.mioto.cloud.vo.Access;
import br.com.mioto.cloud.vo.Delivery;
import br.com.mioto.cloud.vo.Fare;

@RequestMapping( value = "/deliveries" )
@RestController
public class DeliveryController {

	private static final Logger log = LoggerFactory.getLogger(DeliveryController.class);

	@Autowired
	private AccessManagerService accessManagerService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FareService fareService;

    @Autowired
    ResponseTimeDAO responseTimeDAO;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Delivery getDelivery() {

		log.info("Basket Rest Service >> getDelivery");

		final Access access = restTemplate.getForObject(accessManagerService.getUrl(), Access.class);

        final Delivery delivery = new Delivery();

        log.info("CalculateFare >> Preparing to Send Call");
		final Fare fare = restTemplate.getForObject(fareService.getUrl(), Fare.class);
		log.info("CalculateFare <<  Fare Received Successfully");

        delivery.setAddress("Rua example");
        delivery.setCity("City example");
        delivery.setDeliveryDateExecuted(new Date());
        delivery.setReceivedBy("John Example");
        delivery.setReference("Reference Example");
        delivery.setFare(fare);

		return delivery;
	}
}