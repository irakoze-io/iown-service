package online.app.eracodes.iownservice.repo;

import online.app.eracodes.iownservice.entity.User;
import online.app.eracodes.iownservice.model.CreateUserSpResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from public.sp_create_user(:customerId, :firstname, :lastname, :password, :role)",
            nativeQuery = true)
    CreateUserSpResult createUser(
            @Param("p_customerid") long customerId,
            @Param("p_firstname") String firstname,
            @Param("p_lastname") String lastname,
            @Param("p_password") String password,
            @Param("p_role") String role
    ) throws Exception;
}
