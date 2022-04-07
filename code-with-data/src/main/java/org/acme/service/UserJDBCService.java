package org.acme.service;

import io.agroal.api.AgroalDataSource;
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
public class UserJDBCService {

    @Inject
    AgroalDataSource defaultDataSource;
    List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("H2- db init is called");
        try {
            Connection connection = defaultDataSource.getConnection();
            System.out.println(connection);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE user(id INT NOT NULL,  title VARCHAR(50))");
            stmt.executeUpdate("INSERT INTO user " + "VALUES (101, 'Subramanian')");
            stmt.executeUpdate("INSERT INTO user " + "VALUES (102, 'Ram')");
            stmt.executeUpdate("INSERT INTO user " + "VALUES (103, 'Karthik')");

            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                //System.out.println(rs.getInt(1) + "  " + rs.getString(2));
                users.add(new User(rs.getInt(1), rs.getString(2)));
            }
            stmt.close();
            connection.close();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public List<User> listUsers() {
        return users;
    }
}
