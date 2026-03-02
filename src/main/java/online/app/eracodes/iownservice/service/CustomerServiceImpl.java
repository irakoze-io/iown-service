package online.app.eracodes.iownservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.app.eracodes.iownservice.model.CustomerDetails;
import online.app.eracodes.iownservice.repo.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Optional<CustomerDetails> getCustomerDetails(long customerId) {
        try {
            var customer = repository.findById(customerId).orElseThrow();
            return Optional.of(new CustomerDetails(customer));
        } catch (Exception e) {
            log.error("Error fetching customer details for customerId: {}", customerId, e);
            return Optional.empty();
        }
    }
}
