package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.service.enity.Event;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventPancheRepository implements PanacheRepository<Event> {
    
}
