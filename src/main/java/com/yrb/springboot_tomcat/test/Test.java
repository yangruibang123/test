package com.yrb.springboot_tomcat.test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args){

    }
    public void executeQuery(DataSource dataSource,String sql, Consumer<ResultSet> resultSetConsumer, long tryLockTimeout, TimeUnit tryLockTimeUnit) {
        boolean success;


        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();

        ) {
            ResultSetMetaData s=statement.getMetaData();
            resultSetConsumer.accept(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
