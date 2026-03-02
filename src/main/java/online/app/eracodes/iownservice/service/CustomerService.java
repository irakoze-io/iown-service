package online.app.eracodes.iownservice.service;

import online.app.eracodes.iownservice.model.CustomerDetails;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerDetails> getCustomerDetails(long customerId);
}
