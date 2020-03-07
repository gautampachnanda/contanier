package uk.co.aaditech.validation.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import uk.co.aaditech.validation.models.validated.Customer;
import uk.co.aaditech.validation.models.validated.Reservation;

import java.time.LocalDate;

@Configuration
@ComponentScan({"uk.co.aaditech.validation.models","uk.co.aaditech.services"})
public class MethodValidationConfig {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Bean("customer")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Customer customer(String firstName, String lastName) {

        Customer customer = new Customer(firstName, lastName);
        return customer;
    }

    @Bean("reservation")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Reservation reservation(LocalDate begin, LocalDate end, Customer customer, int room) {

        Reservation reservation = new Reservation(begin, end, customer, room);
        return reservation;
    }
}