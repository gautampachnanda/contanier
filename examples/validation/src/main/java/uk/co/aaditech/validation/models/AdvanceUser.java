package uk.co.aaditech.validation.models;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Data
public class AdvanceUser {

    @NotNull(message = "Name cannot be null")
    private String name;

    @AssertTrue
    private boolean working;

    @Size(min = 10, max = 200, message = "Number of characters should be in between 10 and 200 inclusive")
    private String aboutMe;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be more than 150")
    private int age;

    @Email(message = "Email should be valid")
    private String email;

    private List<@NotBlank String> preferences;

    private LocalDate dateOfBirth;

}