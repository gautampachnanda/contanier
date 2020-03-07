package uk.co.aaditech.validation;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.co.aaditech.validation.models.User;
import uk.co.aaditech.validation.services.ValidatingService;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ValidatingServiceTest {

    @Autowired
    private ValidatingService service;

    @Test
    public void whenInputIsInvalid_thenThrowsException(){
        User user = invalidUser();
        log.info("{}",user.toString());
        assertThrows(ConstraintViolationException.class, () -> {
            service.validateInput(user);
        });
    }

    private User invalidUser() {
       return User.builder().build();
    }

}