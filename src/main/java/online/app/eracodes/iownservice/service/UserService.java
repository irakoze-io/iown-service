package online.app.eracodes.iownservice.service;

import online.app.eracodes.iownservice.model.UserCreatedResponse;

import java.util.Optional;

public interface UserService {
    Optional<UserCreatedResponse> createUser(long customerId);
}
