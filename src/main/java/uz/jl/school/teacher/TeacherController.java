package uz.jl.school.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.jl.school.base.AbstractController;

@Controller
@RequestMapping(value = "/teacher/*")
public class TeacherController extends AbstractController<TeacherService> {
    public TeacherController(TeacherService service) {
        super(service);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String getPage(@PathVariable Integer id, Model model) {
        model.addAttribute("teacher", service.get(id));
        return "teacher-single";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("teacher_list", service.list());
        return "teachers";
    }
}
