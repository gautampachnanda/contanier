package org.pachnanda.springbootdockermvn.repositories;


import org.pachnanda.springbootdockermvn.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}