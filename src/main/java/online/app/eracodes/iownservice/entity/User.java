package online.app.eracodes.iownservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private long id;

    @Column(name = "customer_id")
    //TODO: Customers many to one relationship with users here
    private long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String username;
    private String password;
    private String role;

    @Column(name = "created_at")
    private OffsetDateTime createdDate;

    @Column(name = "last_login_time")
    private OffsetDateTime lastLoginTime;
}
