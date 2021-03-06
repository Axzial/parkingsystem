package com.parkit.parkingsystem.config;

import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j
public class DataBaseConfig {

    /**
     * Environment Variables for Database Ids
     */
    String PASSWORD = System.getenv("MYSQL_PASSWORD");
    String USERNAME = System.getenv("MYSQL_USER");
    String HOST = System.getenv("MYSQL_HOST");
    String DB = System.getenv("MYSQL_DB");

    /**
     * Open a new {@link Connection}
     * @return a {@link Connection}
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://"+HOST+"/"+DB, USERNAME, PASSWORD);
    }

    /**
     * Close a {@link ResultSet}
     * @param rs {@link ResultSet}
     */
    public void closeResultSet(ResultSet rs) {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                log.error("Error while closing result set",e);
            }
        }
    }
}
