package io.java.springbootstarter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.java.springbootstarter.Model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
