package com.tpe.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please provide first name!")//"  "(blank),""(empty),null i da kabul etmez
    @Column(nullable = false)
    private String firstName;

    @NotEmpty(message = "Please provide last name!")//""(empty),null i da kabul etmez
    @Column(nullable = false)
    private String lastName;

    @NotNull(message = "Please provide grade!")//null kabul etmez
    @Column(nullable = false)
    @Max(100)
    private Integer grade;

    private LocalDateTime createDate=LocalDateTime.now();


    //getter setter  -----------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

//    public void setCreateDate(LocalDateTime createDate) {
//        this.createDate = createDate;
//    }


//    -- GEREK YOK --
//    //toString  -----------------------------------------
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", grade=" + grade +
//                ", createDate=" + createDate +
//                '}';
//    }
}
