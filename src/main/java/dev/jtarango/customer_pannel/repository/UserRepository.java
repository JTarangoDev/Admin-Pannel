package dev.jtarango.customer_pannel.repository;

import dev.jtarango.customer_pannel.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE email LIKE %:email% OR address LIKE %:address%")
    List<User> findByEmailOrAddress(@Param("email") String email, @Param("address") String address);

    @Query("SELECT u FROM User u WHERE email LIKE %:email%")
    List<User> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE email = :email AND password = :password")
    List<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
