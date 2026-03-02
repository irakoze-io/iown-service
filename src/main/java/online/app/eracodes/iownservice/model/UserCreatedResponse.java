package online.app.eracodes.iownservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserCreatedResponse(
        String userId,
        String customerId,
        String message
) {
}
