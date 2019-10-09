package br.com.mioto.cloud.controllers;

import java.util.List;

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
import br.com.mioto.cloud.services.BenefitsService;
import br.com.mioto.cloud.services.BillingService;
import br.com.mioto.cloud.services.DeliveryService;
import br.com.mioto.cloud.services.MailRelayService;
import br.com.mioto.cloud.services.ProductService;
import br.com.mioto.cloud.services.UserManagerService;
import br.com.mioto.cloud.vo.Access;
import br.com.mioto.cloud.vo.Billing;
import br.com.mioto.cloud.vo.Delivery;
import br.com.mioto.cloud.vo.Order;
import br.com.mioto.cloud.vo.Product;
import br.com.mioto.cloud.vo.User;

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

    @Autowired
    ResponseTimeDAO responseTimeDAO;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Order getOrder() {
        log.info("Order Rest >> getOrder");

        log.info("Order Rest >> accessManagerService");
        final Access access       = restTemplate.getForObject(accessManagerService.getUrl(), Access.class);

        log.info("Order Rest >> userManagerService");
        final User user           = restTemplate.getForObject(userManagerService.getUrl(), User.class);

        log.info("Order Rest >> productService");
        final List<Product> listProduct     = restTemplate.getForObject(productService.getUrl(), List.class);

        log.info("Order Rest >> deliveryService");
        final Delivery delivery   = restTemplate.getForObject(deliveryService.getUrl(), Delivery.class);

        //log.info("Order Rest >> mailRelayService");
        //Mail mail           = restTemplate.getForObject(mailRelayService.getUrl(), Mail.class);

        log.info("Order Rest >> billingService");
        final Billing billing     = restTemplate.getForObject(billingService.getUrl(), Billing.class);

        //log.info("Order Rest >> benefitsService");
        //Benefits benefits   = restTemplate.getForObject(benefitsService.getUrl(), Benefits.class);


		final Order order = new Order();
        order.setUser(user);
        order.setListProduct(listProduct);
        order.setDelivery(delivery);
        order.setBilling(billing);
        //order.setBenefits(benefits);
		return order;
	}
}