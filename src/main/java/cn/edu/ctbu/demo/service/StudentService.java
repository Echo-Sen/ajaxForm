package cn.edu.ctbu.demo.service;

import cn.edu.ctbu.demo.domain.Student;
import cn.edu.ctbu.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> findAll();

    /**
     * 只分页的查询
     * @param pageable
     * @return
     */
    Page<Student> findAll(Pageable pageable);

    Student findById(Integer id);

    List<Student> findByName(String name);


//    public List<Student> findByNameAndPassword(String name, String password){
//
//        return studentRepository.findByNameAndPassword(name,password);
//
//    }

    Student insert(Student student);

//    public List<Student> findByNo(String no){
//
//        return studentRepository.findByNoLike(no);
//
//    }

    Student update(Student student);

    void delete(Student student);

    void delete(Integer id);

    Student getById(Integer id);

}
