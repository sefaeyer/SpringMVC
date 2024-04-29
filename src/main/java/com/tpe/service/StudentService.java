package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//@Copmponent in ozellesmis(gelismis) halidir
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository repository;

    //1-a
    @Override
    public List<Student> listAllStudents() {

        return repository.findAll();
    }

    //2-b
    @Override
    public void addOrUpdateStudent(Student student) {
        repository.saveOrUpdat(student);

    }

    @Override
    public Student findStudentById(Long id) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
