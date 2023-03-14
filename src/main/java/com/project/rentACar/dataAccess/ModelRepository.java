package com.project.rentACar.dataAccess;

import com.project.rentACar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository  extends JpaRepository<Model,String> {
}
