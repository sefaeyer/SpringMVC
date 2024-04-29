package com.tpe.repository;

import com.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository {

    List<Student> findAll();

    void saveOrUpdat(Student student);

    void delete(Student student);

    Optional<Student> findById(Long id);//NullPointerException almamak icin
                                        //null yerine bos optional objesi doner
                                        //DIKKAT Null cikabilir



}
