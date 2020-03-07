package uk.co.aaditech.validation.controller;

import lombok.Data;

import java.util.Collection;
import java.util.List;
@Data
public class ValidationErrorResponse {
    private List<Violation> violations;

}
