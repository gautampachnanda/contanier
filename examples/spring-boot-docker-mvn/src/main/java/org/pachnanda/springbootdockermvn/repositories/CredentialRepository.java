package org.pachnanda.springbootdockermvn.repositories;

import org.pachnanda.springbootdockermvn.models.Credential;
import org.pachnanda.springbootdockermvn.models.User;
import org.springframework.data.repository.CrudRepository;

public interface CredentialRepository extends CrudRepository<Credential, Integer> {
}