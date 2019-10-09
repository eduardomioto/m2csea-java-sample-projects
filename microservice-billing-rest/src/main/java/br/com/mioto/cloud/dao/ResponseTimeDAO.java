package br.com.mioto.cloud.dao;

import java.sql.SQLException;

public interface ResponseTimeDAO {

    public void storeResponseTime(String microservice, long responseTime) throws SQLException;
}
