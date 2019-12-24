package org.pachnanda.springbootdockermvn.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(exclude = "users")
@EqualsAndHashCode(exclude = "users")
@RequiredArgsConstructor
@Table(name="CREDENTIAL")
@Entity
public class Credential extends AuditModel{

    @Id
    @GeneratedValue
    @Column(name="CREDENTIAL_ID")
    private Long id;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @JsonBackReference
    public User getUser(){
        return this.user;
    }
}
