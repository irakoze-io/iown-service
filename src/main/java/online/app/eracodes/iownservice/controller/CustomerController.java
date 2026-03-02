package online.app.eracodes.iownservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.app.eracodes.iownservice.model.CustomerDetails;
import online.app.eracodes.iownservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetails> getCustomerDetails(@PathVariable long id) {
        log.info("Fetching customer details for customerId: {}", id);
        return customerService.getCustomerDetails(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
