package uk.co.aaditech.resilience.servicea;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.aaditech.resilience.servicea.model.User;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @GetMapping
    public List<User> users() {
        User one = User.builder().name("Gautam Pachnanda").address("Some Road, Some Town, Some county").postCode("SomePostCode").build();
        return Arrays.asList(one);
    }
}
