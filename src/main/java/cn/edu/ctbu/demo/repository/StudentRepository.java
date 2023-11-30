package cn.edu.ctbu.demo.repository;

import cn.edu.ctbu.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAll();

    /**
     * 按名字查询
     * @param name
     * @return
     */
    List<Student> findByNameLike(String name);

    /**
     * 按名字和密码查询
     * @param Name
     * @param password
     * @return
     */
//    List<Student> findByNameAndPassword(String Name, String password);

    /**
     * 查找工号最晚进校
     * @param no
     * @return
     */
//    List<Student> findByNoLike(String no);

}
