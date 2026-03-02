package online.app.eracodes.iownservice.model;

import online.app.eracodes.iownservice.entity.Customer;

public record CustomerDetails(
        long customerId,
        String accountNumber,
        String name,
        String msisdn,
        String gender,
        String dateOfBirth,
        String address,
        String city,
        String householdId
) {
    public CustomerDetails(Customer customer) {
        this(
                customer.getId(),
                customer.getAccount(),
                customer.getLastName() + " " + customer.getLastName(),
                customer.getMsisdn(),
                customer.getGender(),
                customer.getDob().toString(),
                customer.getAddress(),
                customer.getCity(),
                customer.getHouseHoldId()
        );
    }
}
