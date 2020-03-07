package uk.co.aaditech.validation.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import uk.co.aaditech.validation.models.User;

import javax.validation.Valid;

@Service
@Validated
public class ValidatingService {

    public void validateInput(@Valid User input){
        // do something
    }
}
