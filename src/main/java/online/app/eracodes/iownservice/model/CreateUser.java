package online.app.eracodes.iownservice.model;

public record CreateUser(long customerId, String firstname, String lastname, String password, String role) {
}
