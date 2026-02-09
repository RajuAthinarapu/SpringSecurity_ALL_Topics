package com.Raju.SpringSecurity_ALLtopics.Controller;

import com.Raju.SpringSecurity_ALLtopics.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

  List<Student> students = new ArrayList<>(List.of(
          new Student(1,"raju","35"),
          new Student(2,"shiva","45"),
          new Student(3,"ramu","55")));



    @GetMapping("/students")
    public List<Student> getallstudent(){
        return students;
    }
    @PostMapping("/students")
    public Student addstudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
@GetMapping("/csrf-token")
public CsrfToken getcsfrtokenid(HttpServletRequest request)  {
    return (CsrfToken) request.getAttribute("_csrf");

}




}
