package online.app.eracodes.iownservice.service;

import online.app.eracodes.iownservice.model.UserCreatedResponse;


public interface UserService {
    UserCreatedResponse
    createUser(long customerId, String firstname, String lastname, String password, String role);
}
