package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.IStudentService;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller//requestler bu classta karsilanacak ve ilgili metotlarla maplenecek
@RequestMapping("/students")//http:localhost:8080/SpringMvc/students/...
//class:tum metodlar icin gecerli olur
//method:sadece ilgili methodu requestle maplar
public class StudentController {

//    @Autowired
//    private IStudentService service;

    //http:localhost:8080/SpringMvc/students/hi + GET
    @GetMapping("/hi")
    public ModelAndView sayHi() {
        ModelAndView maw = new ModelAndView();
        maw.addObject("message", "Hi,");
        maw.addObject("messagebody", "I am a Student Management System");
        maw.setViewName("hi");
        return maw;
    }

    //view resolver  : /WEB-INF/views/hi.jsp dosyasini bulur ve maw icindeki modali dosyaya bind eder.
    //Client e gonderir


    //1-tum ogrencileri listeleme:
    // http://localhost:8080/SpringMvc/students + GET
//    @GetMapping
//    public ModelAndView getStudents(){
//
//        List<Student> allStudents= service.listAllStudents();
//
//        ModelAndView mav=new ModelAndView();
//        mav.addObject("studentList",allStudents);
//        mav.setViewName("students");
//        return mav;
//    }







}
