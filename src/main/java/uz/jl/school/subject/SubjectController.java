package uz.jl.school.subject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.jl.school.base.AbstractController;
import uz.jl.school.subject.dto.SubjectCreateDTO;
import uz.jl.school.subject.dto.SubjectUpdateDTO;

@Controller
@RequestMapping(value = "/admin/subject*")
public class SubjectController extends AbstractController<SubjectService> {
    public SubjectController(SubjectService service) {
        super(service);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String adminSubjectPage(Model model) {
        model.addAttribute("subject_list", service.list());
        return "admin/admin-subject";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String adminSubjectCreatePage() {
        return "admin/subject-create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String adminSubjectCreate(SubjectCreateDTO dto, Model model) {
        service.create(dto);
        model.addAttribute("subject_list", service.list());
        return "redirect:/admin/subject";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String adminSubjectUpdatePage(@PathVariable Integer id, Model model) {
        model.addAttribute("subject", service.get(id));
        return "admin/subject-update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String adminSubjectUpdate(SubjectUpdateDTO dto, Model model) {
        service.update(dto);
        model.addAttribute("subject_list", service.list());
        return "redirect:/admin/subject";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String adminSubjectDeletePage(@PathVariable Integer id, Model model) {
        model.addAttribute("subject", service.get(id));
        return "admin/subject-delete";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String adminSubjectDelete(@PathVariable Integer id, Model model) {
        service.delete(id);
        model.addAttribute("subject_list", service.list());
        return "redirect:/admin/subject";
    }
}
