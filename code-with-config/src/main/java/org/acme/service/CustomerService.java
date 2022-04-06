package org.acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CustomerService {
    @Inject
    CustomerConfiguration customerConfiguration;

    public String getCustomerId() {
        return customerConfiguration.id().orElse("0");
    }

    public String getCustomerName() {
        return customerConfiguration.name().orElse("name");
    }

    public String getCustomerCity() {
        return customerConfiguration.city().orElse("city");
    }
}
