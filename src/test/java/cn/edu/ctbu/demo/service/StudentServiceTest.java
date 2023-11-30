package cn.edu.ctbu.demo.service;

import cn.edu.ctbu.demo.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void findAll() {

        List<Student> students = studentService.findAll();

        assertNotNull(students);
    }

    @Test
    void findById() {

        Student student = studentService.findById(2021413327);

        assertNotNull(student);
    }

    @Test
    void findByNameLike() {

        List<Student> students = studentService.findByName("张%");

        assertNotNull(students);
    }

    /*@Test
    void findByNameAndPassword() {

        List<Student> students = studentService.findByNameAndPassword("丁扬","123456");

        assertNotNull(students);
    }*/

    /**
     * 增加数据
     */
    /*@Test
    void insert(){

        Student student = new Student();
        student.setName("赵四");
        student.setPassword("989898");
        student.setNo("2023002");
        student.setSex(1);
        student.setAge(22);

        studentService.insert(student);

        assertNotNull(student.getId());

    }*/

    /*@Test
    void findByNoLike() {

        List<Student> students = studentService.findByNo("2023%");

        assertNotNull(students);
    }*/

   /* @Test
    void update(){

        Student student = studentService.findById(2021413327);
        student.setPassword("666666");

        studentService.update(student);

        assertEquals(student.getPassword(),"666666");

    }*/

    /*@Test
    void delete(){

        studentService.delete(2021413327);
        Student student = studentService.findById(2021413327);

        assertNull(student);

    }*/


}