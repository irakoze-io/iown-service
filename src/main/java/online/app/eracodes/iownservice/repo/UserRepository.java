package online.app.eracodes.iownservice.repo;

import online.app.eracodes.iownservice.entity.User;
import online.app.eracodes.iownservice.model.CreateUserSpResult;
import online.app.eracodes.iownservice.model.UserLoginResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Create a new user using a stored procedure.
     *
     * @param customerId Customer ID
     * @param firstName  User's first name
     * @param lastName   User's last name
     * @param password   User's password
     * @param role       User's role
     * @return Result of the stored procedure execution
     * @throws Exception if an error occurs during execution
     */
    @Query(value = "select * from public.sp_create_user(?, ?, ?, ?, ?)",
            nativeQuery = true)
    CreateUserSpResult createUser(
            @Param("p_customerid") long customerId,
            @Param("p_firstname") String firstName,
            @Param("p_lastname") String lastName,
            @Param("p_password") String password,
            @Param("p_role") String role
    ) throws Exception;

    /**
     * Execute user login using a stored procedure.
     *
     * @param username  User's username
     * @param password  User's password
     * @param ipAddress User's IP address
     * @return Result of the stored procedure execution
     * @throws Exception if an error occurs during execution
     */
    @Query(value = "select * from public.sp_user_login(?, ?, ?)",
            nativeQuery = true)
    UserLoginResult executeUserLogin(
            @Param("p_username") String username,
            @Param("p_password") String password,
            @Param("p_ipaddress") String ipAddress
    ) throws Exception;
}
