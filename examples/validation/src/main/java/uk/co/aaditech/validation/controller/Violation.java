package uk.co.aaditech.validation.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Violation {
    private String path;
    private String message;

}
