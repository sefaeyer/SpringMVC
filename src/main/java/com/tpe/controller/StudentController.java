package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.IStudentService;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller//requestler bu classta karsilanacak ve ilgili metotlarla maplenecek
@RequestMapping("/students")//http:localhost:8080/SpringMvc/students/...
//class:tum metodlar icin gecerli olur
//method:sadece ilgili methodu requestle maplar
public class StudentController {


    private IStudentService service;

    @Autowired//sadece 1 tane parametreli const varsa @Autowired zorunlu degil
    public StudentController(IStudentService service) {
        this.service = service;
    }


    //controllerda metodlar geriye mav veya String data tipi dondurebilir.


    //http:localhost:8080/SpringMvc/students/hi + GET
    @GetMapping("/hi")
    public ModelAndView sayHi() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hi,");
        mav.addObject("messagebody", "I am a Student Management System");
        mav.setViewName("hi");
        return mav;
    }

    //view resolver  : /WEB-INF/views/hi.jsp dosyasini bulur ve maw icindeki modali dosyaya bind eder.
    //Client e gonderir


    //1-tum ogrencileri listeleme:
    // http://localhost:8080/SpringMvc/students + GET
    @GetMapping
    public ModelAndView getStudents(){

        List<Student> allStudents= service.listAllStudents();

        ModelAndView mav=new ModelAndView();
        mav.addObject("studentList",allStudents);
        mav.setViewName("students");
        return mav;
    }


    //2-ogrenciyi kaydetme
    //http://localhost:8080/SpringMvc/students/new + GET
    @GetMapping("/new")
    public String sendForm(@ModelAttribute("student") Student student){
        return "studentForm";
    }
    //ModelAttribute anotasyonu view katmani ile controller arasinda
    //model in transferini saglar
    //islem sonunda : student in firstname lastname ve grade degerleri set edilmis halde
    // controller classinda yer alir


    //2-a: ogrenciyi DB ye ekleme
    // http://localhost:8080/SpringMvc/students/saveStudent + POST
    @PostMapping("/saveStudent")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult){
    //----------------------(--------------/(OPSIYONEL)/---------------)//

        if(bindingResult.hasErrors()){
            return "studentForm";
        }

        service.addOrUpdateStudent(student);

        return "redirect:/students";  //https://localhost:8080/SpringMvc/students + GET
    }


    //3-mevcut ogrenciyi guncelleme
    //http://localhost:8081/SpringMVC/students/update?id=1


    //4-mevcut ogrenciyi silme
    //http://localhost:8081/SpringMVC/students/delete/1











}
