package org.pachnanda.springbootdockermvn.controllers;

import org.pachnanda.springbootdockermvn.models.Credential;
import org.pachnanda.springbootdockermvn.models.User;
import org.pachnanda.springbootdockermvn.repositories.CredentialRepository;
import org.pachnanda.springbootdockermvn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credential")
public class CredentialController {

    @Autowired
    private CredentialRepository credentialRepository;

    @RequestMapping("/all")
    public Iterable<Credential> all() {
        return credentialRepository.findAll();
    }
}
