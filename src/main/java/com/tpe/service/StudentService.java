package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.StudentNotFoundException;
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

    //3-a
    @Override
    public Student findStudentById(Long id) {

        Student foundStudent=repository.findById(id).
                orElseThrow(()->new StudentNotFoundException("Student Not Found by ID: "+id)); //Supllier
        //findById metodunun geriye dondurdugu optional icinde
        //student varsa foundStudent degiskenine atar.
        //optional objesi bossa orElseThrow custom exception firlatilabilir.
        return foundStudent;
    }

    //4-a
    @Override
    public void deleteStudent(Long id) {
        //idsi verilen ogrenciyi bulalim
        Student student=findStudentById(id);
        repository.delete(student);

    }
}
