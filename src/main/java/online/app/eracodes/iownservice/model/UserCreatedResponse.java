package online.app.eracodes.iownservice.model;

import lombok.Builder;

@Builder
public record UserCreatedResponse(
        String userId,
        String customerId
) {
}
