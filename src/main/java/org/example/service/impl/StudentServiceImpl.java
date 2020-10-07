package org.example.service.impl;

import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int nums=studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> findStudent() {
        List<Student> students=studentDao.selectStudents();
        return students;
    }

    @Override
    public int deleteStudent(Integer id) {
        Integer nums=studentDao.deleteStudent(id);
        return nums;
    }

    @Override
    public int updateStudent(Student student) {
        int nums=studentDao.updateStudent(student);
        return nums;
    }
}
