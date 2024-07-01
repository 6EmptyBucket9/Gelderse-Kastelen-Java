package com.example.Gelderse_Kastelen_Java.repositories;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Gelderse_Kastelen_Java.models.Activiteiten;



@SpringBootApplication
@Repository
public interface ActiviteitenRepository extends CrudRepository<Activiteiten, Integer>, JpaSpecificationExecutor<Activiteiten> {
  
}
