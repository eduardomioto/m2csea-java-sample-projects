package br.com.mioto.cloud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAOImpl {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://mysql:3306/mc2sea-metrics?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "admin");
    }
}
