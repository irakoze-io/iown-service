package online.app.eracodes.iownservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.app.eracodes.iownservice.model.CreateUser;
import online.app.eracodes.iownservice.model.UserCreatedResponse;
import online.app.eracodes.iownservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users"/*, version = "1.0"*/)
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<UserCreatedResponse>
    createUser(@Validated @RequestBody CreateUser request) {
        var allowedRoles = List.of("ROLE_USER", "ROLE_VIEWER", "ROLE_SUPERVISOR");
        if (!allowedRoles.contains(request.role())) {
            return ResponseEntity.badRequest().build();
        }

        if (request.role().equals("ROLE_ADMIN")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        var result = userService.createUser(request.customerId(),
                request.firstname(),
                request.lastname(),
                request.password(),
                request.role());

        return result.userId() == null ? ResponseEntity.badRequest()
                                         .body(UserCreatedResponse.builder()
                                               .message(result.message()).build())
                : ResponseEntity.ok(result);
    }
}
