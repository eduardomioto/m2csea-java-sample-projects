package br.com.mioto.cloud.controllers;

import java.sql.SQLException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mioto.cloud.dao.ResponseTimeDAO;
import br.com.mioto.cloud.vo.User;

@RequestMapping( value = "/users" )
@RestController
public class UserManagementController {

	private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    ResponseTimeDAO responseTimeDAO;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public User getUser() {

	    final Date start = new Date();
		log.info("User Manager Service >> getUser");
		final User user = new User();
		user.setUser("Usuario 12345");

		try {
		    final Date end = new Date();
            responseTimeDAO.storeResponseTime("microservice-user-manager-rest", end.getTime() - start.getTime());
        } catch (final SQLException e) {
            log.error("Error: ", e);
        }

		return user;
	}
}