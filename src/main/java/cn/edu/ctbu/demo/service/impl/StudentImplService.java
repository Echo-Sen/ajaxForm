package cn.edu.ctbu.demo.service.impl;

import cn.edu.ctbu.demo.domain.Student;
import cn.edu.ctbu.demo.repository.StudentRepository;
import cn.edu.ctbu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImplService implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(){

        return studentRepository.findAll();

    }

    /**
     * 只分页的查询
     * @param pageable
     * @return
     */
    public Page<Student> findAll(Pageable pageable){

        return studentRepository.findAll(pageable);

    }

    /**
    * 按id进行查询
    */
    public Student findById(Integer id){

        return studentRepository.findById(id).orElse(null);

    }

    /**
     * 按名字进行查询,like
     */
    public List<Student> findByName(String name){

        return studentRepository.findByNameLike(name);

    }


//    public List<Student> findByNameAndPassword(String name, String password){
//
//        return studentRepository.findByNameAndPassword(name,password);
//
//    }

    public Student insert(Student student){
        return studentRepository.save(student);
    }

//    public List<Student> findByNo(String no){
//
//        return studentRepository.findByNoLike(no);
//
//    }

    public Student update(Student student){
        return studentRepository.save(student);
    }

    public void delete(Student student){
        studentRepository.delete(student);
    }

    public void delete(Integer id){

        Student student = new Student();
        student.setId(id);

        studentRepository.delete(student);

    }

    public Student getById(Integer id){
        Student student=studentRepository.findById(id).orElse(null);
        return student;
    }

}
