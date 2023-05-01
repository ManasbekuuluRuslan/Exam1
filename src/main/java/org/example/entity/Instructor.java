package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(generator = "instructor_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "instructor_gen",sequenceName = "instructor_seq",allocationSize = 1)
    private Long id;
    @Column(name = "instructor_name")
    private String instructorName;
    private String email;
    @Column(name = "phone_number")
    private int phoneNumber;
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Course> courses;

    public Instructor(String instructorName, String email, int phoneNumber) {
        this.instructorName = instructorName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
