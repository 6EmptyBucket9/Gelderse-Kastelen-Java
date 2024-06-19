package com.example.Gelderse_Kastelen_Java.repositories;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Gelderse_Kastelen_Java.models.Rang;

@SpringBootApplication
@Repository
public interface RangenRepository extends CrudRepository<Rang, Integer>, JpaSpecificationExecutor<Rang> {
  
}
