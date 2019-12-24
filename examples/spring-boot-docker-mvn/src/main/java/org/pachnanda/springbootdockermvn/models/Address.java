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
@Table(name="ADDRESS")
@Entity
public class Address extends AuditModel {

    @Id
    @GeneratedValue
    @Column(name="ADDRESS_ID")
    private Long id;

    @Column(name="LINE_ONE")
    private String lineOne;

    @Column(name="LINE_TWO")
    private String lineTwo;

    @Column(name="LINE_THREE")
    private String lineThree;

    @Column(name="LINE_FOUR")
    private String lineFour;

    @Column(name="POST_CODE")
    private String postCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @JsonBackReference
    public User getUser(){
        return this.user;
    }
}
