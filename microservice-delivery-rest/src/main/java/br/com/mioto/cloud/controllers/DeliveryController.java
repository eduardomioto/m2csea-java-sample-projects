package br.com.mioto.cloud.controllers;

import br.com.mioto.cloud.services.AccessManagerService;
import br.com.mioto.cloud.services.FareService;
import br.com.mioto.cloud.vo.Access;
import br.com.mioto.cloud.vo.Delivery;
import br.com.mioto.cloud.vo.Fare;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

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

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Delivery getDelivery() {
		
		log.info("Basket Rest Service >> getDelivery");

		Access access = restTemplate.getForObject(accessManagerService.getUrl(), Access.class);

        Delivery delivery = new Delivery();

        log.info("CalculateFare >> Preparing to Send Call");
		Fare fare = restTemplate.getForObject(fareService.getUrl(), Fare.class);
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