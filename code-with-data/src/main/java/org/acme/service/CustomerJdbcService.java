package org.acme.service;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import org.acme.service.enity.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerJdbcService {

    //inject datasource according to service
    @Inject
    @DataSource("customers")
    AgroalDataSource defaultDataSource;

    List<User> customers = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("H2- db init is called");
        try {
            Connection connection = defaultDataSource.getConnection();
            System.out.println(connection);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE customer(id INT NOT NULL,  title VARCHAR(50))");
            stmt.executeUpdate("INSERT INTO customer " + "VALUES (101, 'Dhivya Sree')");
            stmt.executeUpdate("INSERT INTO customer " + "VALUES (102, 'Srisha')");
            stmt.executeUpdate("INSERT INTO customer " + "VALUES (103, 'Geetha Subramanian')");

            ResultSet rs = stmt.executeQuery("select * from customer");
            while (rs.next()) {
                customers.add(new User(rs.getInt(1), rs.getString(2)));
            }
            stmt.close();
            connection.close();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public List<User> listCustomers() {
        return customers;
    }


}
