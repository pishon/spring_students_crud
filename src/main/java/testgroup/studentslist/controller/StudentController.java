package testgroup.studentslist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import testgroup.studentslist.model.Student;
import testgroup.studentslist.service.StudentService;

import java.util.List;


//класс-контроллер, обрабатывающий запросы
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allStudents() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("students");

        List<Student> studentsList = studentService.allStudents();
        modelAndView.addObject("studentsList", studentsList);

        return modelAndView;
    }


    // редактирование
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Student student = studentService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject(student);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editStudent(@ModelAttribute("student") Student student) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        if (student.getName().length() > 0)
            studentService.edit(student);

        return modelAndView;
    }


    // добавление
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return  modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addStudent(@ModelAttribute("student") Student student) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        if (student.getName().length() > 0)
            studentService.add(student);

        return modelAndView;
    }


    // удаление
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Student student = studentService.getById(id);
        studentService.delete(student);
        return modelAndView;
    }


}
