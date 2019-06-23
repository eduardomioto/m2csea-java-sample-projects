package br.com.mioto.cloud.controllers;

import br.com.mioto.cloud.services.*;
import br.com.mioto.cloud.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping( value = "/orders" )
@RestController
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private RestTemplate restTemplate;

    @Autowired
    private AccessManagerService accessManagerService;

    @Autowired
    private UserManagerService userManagerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private MailRelayService mailRelayService;

    @Autowired
    private BillingService billingService;

    @Autowired
    private BenefitsService benefitsService;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Order getOrder() {
        log.info("Order Rest >> getOrder");

        log.info("Order Rest >> accessManagerService");
        Access access       = restTemplate.getForObject(accessManagerService.getUrl(), Access.class);

        log.info("Order Rest >> userManagerService");
        User user           = restTemplate.getForObject(userManagerService.getUrl(), User.class);

        log.info("Order Rest >> productService");
        List<Product> listProduct     = restTemplate.getForObject(productService.getUrl(), List.class);

        log.info("Order Rest >> deliveryService");
        Delivery delivery   = restTemplate.getForObject(deliveryService.getUrl(), Delivery.class);

        //log.info("Order Rest >> mailRelayService");
        //Mail mail           = restTemplate.getForObject(mailRelayService.getUrl(), Mail.class);

        log.info("Order Rest >> billingService");
        Billing billing     = restTemplate.getForObject(billingService.getUrl(), Billing.class);

        //log.info("Order Rest >> benefitsService");
        //Benefits benefits   = restTemplate.getForObject(benefitsService.getUrl(), Benefits.class);


		Order order = new Order();
        order.setUser(user);
        order.setListProduct(listProduct);
        order.setDelivery(delivery);
        order.setBilling(billing);
        //order.setBenefits(benefits);
		return order;
	}
}