package br.com.mioto.cloud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mioto.cloud.dao.ResponseTimeDAO;
import br.com.mioto.cloud.vo.Product;

@RequestMapping( value = "/products" )
@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ResponseTimeDAO responseTimeDAO;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public List<Product> getProducts() {

		final List<Product> list = new ArrayList<Product>();

		Product product = new Product();
		product.setId(1);
		product.setName("Product A");
		product.setPrice(15.50);
		product.setWeight(0.3);
		list.add(product);

		product = new Product();
		product.setId(2);
		product.setName("Product B");
		product.setPrice(29.90);
		product.setWeight(1.0);
		list.add(product);

		product = new Product();
		product.setId(3);
		product.setName("Product C");
		product.setPrice(99.90);
		product.setWeight(2.0);
		list.add(product);

		return list;
	}

	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	@ResponseBody
	public Product getProduct(@PathVariable( "id" ) Integer id) {
		final Product product = new Product();
		product.setId(id);

		if(id  == 1){
			product.setName("Product A");
			product.setPrice(15.50);
			product.setWeight(0.3);
		}else if(id == 2){
			product.setName("Product B");
			product.setPrice(29.90);
			product.setWeight(1.0);
		}else if (id == 3) {
			product.setName("Product C");
			product.setPrice(99.90);
			product.setWeight(2.0);
		}
		return product;
	}

	@RequestMapping( value = "/{id}/fare", method = RequestMethod.GET )
	@ResponseBody
	public Product getProductFare(@PathVariable( "id" ) Integer id) {
		final Product product = new Product();
		product.setId(id);

		if(id  == 1){
			product.setName("Product A");
			product.setPrice(15.50);
			product.setWeight(0.3);
		}else if(id == 2){
			product.setName("Product B");
			product.setPrice(29.90);
			product.setWeight(1.0);
		}else if (id == 3) {
			product.setName("Product C");
			product.setPrice(99.90);
			product.setWeight(2.0);
		}

        log.info("CalculateFare >> Preparing to Send Call");
        log.info("CalculateFare <<  Fare Received Successfully");

		return product;
	}
}