package com.crudProject.crudProject.repository;

import com.crudProject.crudProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface userRepository extends JpaRepository<User,Long> {

}
