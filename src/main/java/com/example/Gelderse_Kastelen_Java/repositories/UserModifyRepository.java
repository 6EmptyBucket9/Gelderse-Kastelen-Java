package com.example.Gelderse_Kastelen_Java.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.Gelderse_Kastelen_Java.models.UserModify;

@SpringBootApplication
@Repository
public interface UserModifyRepository extends CrudRepository<UserModify, Integer>, JpaSpecificationExecutor<UserModify> {

}
