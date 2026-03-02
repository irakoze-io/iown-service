package online.app.eracodes.iownservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.app.eracodes.iownservice.model.UserCreatedResponse;
import online.app.eracodes.iownservice.repo.UserRepository;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Override
    public UserCreatedResponse
    createUser(long customerId, String firstname, String lastname, String password, String role) {
        try {
            var createUserResult = userRepo.createUser(customerId, firstname, lastname, password, role);
            return UserCreatedResponse.builder()
                    .customerId(String.valueOf(customerId))
                    .userId(createUserResult.getNewUserId().toString())
                    .build();
        } catch (Exception e) {
            log.error("Failed to create user", e);
            return null;
        }
    }
}
