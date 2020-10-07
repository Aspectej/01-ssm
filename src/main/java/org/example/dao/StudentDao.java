package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {
    //添加学生
    int insertStudent(Student student);
    //使用ajax查询学生
    List<Student> selectStudents();
    //删除学生
    int deleteStudent(Integer id);
    //更新学生
    int updateStudent(Student student);
}
