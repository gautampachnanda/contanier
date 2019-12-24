package org.pachnanda.springbootdockermvn.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Table(name="APP_USER")
@Entity
public class User extends AuditModel {

    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @OneToMany(mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Address> addresses;

    @OneToOne(mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Credential credential;

    @JsonBackReference
    public Credential getCredential(){
        return this.credential;
    }

    @JsonBackReference

    public Set<Address> getAddresses(){
        return this.addresses;
    }

}
