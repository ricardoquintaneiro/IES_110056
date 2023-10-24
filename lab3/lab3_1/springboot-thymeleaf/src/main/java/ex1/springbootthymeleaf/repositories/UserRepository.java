package ex1.springbootthymeleaf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ex1.springbootthymeleaf.entities.MyUser;

@Repository
public interface UserRepository extends CrudRepository<MyUser, Long> {}
