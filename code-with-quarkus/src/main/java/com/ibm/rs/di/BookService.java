package com.ibm.rs.di;

import com.ibm.rs.di.interceptors.LogEvent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

@ApplicationScoped
//@Singleton
public class BookService {

    //Inject interface
    @Inject
    NumberGenerator numberGenerator;

    @PostConstruct
    public void init(){
        System.out.println("INIT");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Destroy");
    }

    //biz method
    @LogEvent
    public Book createBook() {
        Book book = new Book("Quarks In Action", 1000f, "Subramanian");
        book.setIsbn(numberGenerator.generateNumber());
        return book;
    }
}
