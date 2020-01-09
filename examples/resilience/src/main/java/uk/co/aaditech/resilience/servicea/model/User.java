package uk.co.aaditech.resilience.servicea.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.co.aaditech.resilience.servicea.PhoneType;

import java.util.EnumMap;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
    private String name;
    private String address;
    private String email;
    private String postCode;
    private List<EnumMap<PhoneType, String>> phoneNumbers;
}
