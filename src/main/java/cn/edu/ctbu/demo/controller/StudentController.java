package cn.edu.ctbu.demo.controller;

import cn.edu.ctbu.demo.domain.Student;
import cn.edu.ctbu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/student/list")
    public String list(Model model){

        List<Student> students = studentService.findAll();
        model.addAttribute("data",students);

        return "student/list";
    }

}
