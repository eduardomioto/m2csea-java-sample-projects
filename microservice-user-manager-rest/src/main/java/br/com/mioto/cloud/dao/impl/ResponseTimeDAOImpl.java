package br.com.mioto.cloud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import br.com.mioto.cloud.dao.BaseDAOImpl;
import br.com.mioto.cloud.dao.ResponseTimeDAO;

@Component
public class ResponseTimeDAOImpl extends BaseDAOImpl implements ResponseTimeDAO  {

   @Override
public void storeResponseTime(String microservice, long responseTime) throws SQLException {
       final Connection conn =  getConnection();
       final String query = "INSERT INTO response_time (microservice, response_time) VALUES(?, ?)";

       final PreparedStatement preparedStmt = conn.prepareStatement(query);
       preparedStmt.setString (1, microservice);
       preparedStmt.setLong (2, responseTime);

       preparedStmt.execute();
       conn.close();
   }

}
