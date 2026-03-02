package online.app.eracodes.iownservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customers")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "account")
    private String account;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "msisdn")
    private String msisdn;

    @Column(name = "gender")
    private String gender;

    private LocalDate dob;

    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "house_hold_id")
    private String houseHoldId;

    @Column(name = "created_at")
    private OffsetDateTime createdDate;
}
