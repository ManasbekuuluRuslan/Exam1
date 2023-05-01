package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
   @Id
   @GeneratedValue(generator = "course_gen",strategy = GenerationType.SEQUENCE)
   @SequenceGenerator(name = "course_gen",sequenceName = "course_seq",allocationSize = 1)
   private Long id;
   private String courseName;
   private LocalDate dateOfStart;

   public Course(String courseName, LocalDate dateOfStart) {
      this.courseName = courseName;
      this.dateOfStart = dateOfStart;
   }

   @Override
   public String toString() {
      return "Course{" +
              "id=" + id +
              ", courseName='" + courseName + '\'' +
              ", dateOfStart=" + dateOfStart +
              '}';
   }
}
