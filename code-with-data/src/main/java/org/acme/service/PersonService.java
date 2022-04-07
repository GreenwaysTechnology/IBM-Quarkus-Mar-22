package org.acme.service;

import org.acme.repository.Person;
import org.acme.repository.Status;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@ApplicationScoped
public class PersonService {

    public List<Person> findAll() {
        return Person.listAll();
    }

    @Transactional
    public String createPerson() {
        Person person = new Person();
        person.name = "Subramanian";
        person.birth = LocalDate.of(1981, Month.APRIL, 10);
        person.status = Status.Alive;
        //save into db
        Person.persist(person);
        return "Created";
    }
}
