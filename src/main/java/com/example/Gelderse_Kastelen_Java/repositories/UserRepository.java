package com.example.Gelderse_Kastelen_Java.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Gelderse_Kastelen_Java.models.User;


@SpringBootApplication
@Repository
public interface UserRepository extends CrudRepository<User, Integer>, JpaSpecificationExecutor<User> {
    
    @Query("SELECT u FROM  User u WHERE ( u.email = :email) AND u.userId <> :id")
    public List<User> findUserByEmail(@Param("email") String email, @Param("id") Integer id);

    @Query("SELECT u.rol FROM  User u WHERE u.email = :email")
    String findUserRoleByEmail(@Param("email") String email);

    @Query("SELECT u FROM  User u WHERE (u.email = :email)")
    public List<User> validationByEmail(@Param("email") String email);
}
