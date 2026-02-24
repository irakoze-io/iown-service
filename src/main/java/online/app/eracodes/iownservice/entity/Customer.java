package online.app.eracodes.iownservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity(name = "customers")
public class Customer {

    @Id
    @Column(name = "customerId")
    private Long id;

    @Column(name = "account")
    private String account;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "msisdn")
    private String msisdn;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dateOfBirth")
    private LocalDate dob;

    @Column(name = "homeAddress")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "houseHoldId")
    private String houseHoldId;

    @Column(name = "createdAt")
    private OffsetDateTime createdDate;
}
