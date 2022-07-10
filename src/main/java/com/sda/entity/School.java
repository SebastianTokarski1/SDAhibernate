package com.sda.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "school")
@NoArgsConstructor
@Getter
@ToString(exclude = "students")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToMany(
            mappedBy = "schools",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    Set<Student> students = new HashSet<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.addSchool(this);
    }
}
