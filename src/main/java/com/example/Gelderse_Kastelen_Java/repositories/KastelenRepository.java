package com.example.Gelderse_Kastelen_Java.repositories;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Gelderse_Kastelen_Java.models.Kastelen;

@SpringBootApplication
@Repository
public interface KastelenRepository extends CrudRepository<Kastelen, Integer>, JpaSpecificationExecutor<Kastelen> {
  
}
