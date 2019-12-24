package org.pachnanda.springbootdockermvn.repositories;

import org.pachnanda.springbootdockermvn.models.Address;
import org.pachnanda.springbootdockermvn.models.Credential;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository  extends CrudRepository<Address, Integer> {
}