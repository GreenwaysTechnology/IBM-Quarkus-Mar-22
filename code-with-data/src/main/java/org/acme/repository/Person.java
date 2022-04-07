package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

//Looks like Repository layer
@Entity
public class Person extends PanacheEntity {
    //fields ;must be declared using public access modifer
    //id field need not be given because it is already declared in the base class
    public String name;
    public LocalDate birth;
    public Status status;

    //extra methods
    public static Person findByName(String name) {
        return find("name", name).firstResult();
    }

    public static List<Person> findAlive() {
        return list("status", Status.Alive);
    }

    public static void deleteStefs() {
        delete("name", "Stef");
    }
}
