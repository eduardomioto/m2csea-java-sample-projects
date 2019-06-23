package br.com.mioto.cloud.controllers;

import br.com.mioto.cloud.services.AccessManagerService;
import br.com.mioto.cloud.services.FareService;
import br.com.mioto.cloud.vo.Access;
import br.com.mioto.cloud.vo.Billing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RequestMapping( value = "/billing" )
@RestController
public class BillingController {

	private static final Logger log = LoggerFactory.getLogger(BillingController.class);

	//@Autowired
	//private AccessManagerService accessManagerService;

    //@Autowired
    //private RestTemplate restTemplate;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Billing getBilling() {
		
		log.info("Basket Rest Service >> getDelivery");

		//Access access = restTemplate.getForObject(accessManagerService.getUrl(), Access.class);

		Billing billing = new Billing();
		billing.setPaymentDate(new Date());
		billing.setPaymentType(1);
		return billing;
	}
}