package org.pachnanda.springbootdockermvn.controllers;

import org.pachnanda.springbootdockermvn.models.Address;
import org.pachnanda.springbootdockermvn.models.User;
import org.pachnanda.springbootdockermvn.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController {


    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping("/all")
    public Iterable<Address> all() {
        return addressRepository.findAll();
    }
}
