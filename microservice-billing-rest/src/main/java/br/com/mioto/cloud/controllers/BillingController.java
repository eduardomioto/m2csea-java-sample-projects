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
import br.com.mioto.cloud.vo.Billing;

@RequestMapping( value = "/billing" )
@RestController
public class BillingController {

	private static final Logger log = LoggerFactory.getLogger(BillingController.class);

	//@Autowired
	//private AccessManagerService accessManagerService;

    //@Autowired
    //private RestTemplate restTemplate;

    @Autowired
    ResponseTimeDAO responseTimeDAO;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Billing getBilling() {

		log.info("Basket Rest Service >> getDelivery");

		//Access access = restTemplate.getForObject(accessManagerService.getUrl(), Access.class);

		final Billing billing = new Billing();
		billing.setPaymentDate(new Date());
		billing.setPaymentType(1);
		return billing;
	}
}