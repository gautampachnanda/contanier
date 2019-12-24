package org.pachnanda.springbootdockermvn.controllers;

import lombok.extern.slf4j.Slf4j;
import org.pachnanda.springbootdockermvn.models.User;
import org.pachnanda.springbootdockermvn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/all")
    public List<User> all() {
        log.info("Finding all users");
       Iterable<User> all = userRepository.findAll();

        List<User> results = new ArrayList<User>();
        all.forEach(results::add);
        log.info("found {} users",results.size());
        for(User result:results){
            log.info("{} addresses:{} credential:{}",result, result.getAddresses(),result.getCredential());

        }
        return results;
    }
}
