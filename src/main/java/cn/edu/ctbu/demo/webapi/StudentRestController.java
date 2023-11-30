package cn.edu.ctbu.demo.webapi;

import cn.edu.ctbu.demo.core.PageUtils;
import cn.edu.ctbu.demo.domain.Student;
import cn.edu.ctbu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/webapi/student")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    /**
     * url:/webapi/student/list
     * @return
     */
    @GetMapping("/list")
    public List<Student> getAll(){

        List<Student> students = studentService.findAll();
        return students;

    }

    /**
     * 分页读取全部内容
     * @return
     */
    @GetMapping("/getbypage")
    public PageUtils getByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size){

        Sort sort=Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Student> studentPage=studentService.findAll(pageable);

        PageUtils pageUtils = new PageUtils(studentPage.getContent(),studentPage.getTotalElements());

        return pageUtils;

    }

    /**
     * 新增学生
     * @param student
     * @return
     */
    @PostMapping("/insert")
    public Student insert(Student student){

        Student student1 = studentService.insert(student);
        return student1;

    }

    /**
     * 更新学生
     * @param student
     * @return
     */
    @PutMapping("/update")
    public Student update(Student student){

        Student student1=studentService.getById(student.getId());

        if(StringUtils.isEmpty(student.getPassword())){

            student.setPassword(student1.getPassword());

        }

        student = studentService.update(student);

        return student;

    }

    /**
     * 删除学生
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){

        studentService.delete(id);

    }

//    @DeleteMapping("/delete")
//    public void delete(Student student){
//
//        studentService.delete(student);
//
//    }

    @GetMapping("/get/{id}")
    public Student get(@PathVariable Integer id){

        Student student=studentService.getById(id);

        student.setPassword("");

        return student;
    }

}
