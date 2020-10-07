package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Student;
import org.example.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    @RequestMapping("/some.do")
    public ModelAndView  doSome(Student student){
        ModelAndView mv=new ModelAndView();
        int nums=studentService.addStudent(student);
        String tips="用户注册失败!";
        if(nums>0){
            tips="用户:"+student.getName()+",注册成功!";
        }
        mv.addObject("tips",tips);
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value="/queryStudents.do")
    @ResponseBody
    public List<Student> queryStudent(HttpServletResponse response) throws IOException {
        List<Student> students=studentService.findStudent();
        return students;
        /*ObjectMapper om=new ObjectMapper();
        String json=om.writeValueAsString(students);
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
        out.close();*/
    }
    @RequestMapping("/deleteStudent.do")
    public ModelAndView deleteStudent(Integer id){
        int nums=studentService.deleteStudent(id);
        ModelAndView mv=new ModelAndView();
        String tips="用户删除成功";
        if(nums>0){
            tips="编号为:"+id+"的用户删除成功!";
        }
        mv.addObject("tips",tips);
        mv.setViewName("delete");
        return mv;
    }

    //更新学生
    @RequestMapping("/updateStudent.do")
    public ModelAndView updateStudent(Student student){
        int nums=studentService.updateStudent(student);
        ModelAndView mv=new ModelAndView();
        String tips="用户修改失败!";
        if(nums>0){
            tips="用户编号:"+student.getId()+",修改信息成功";
        }
        mv.addObject("tips",tips);
        mv.setViewName("update");
        return mv;
    }
}
