package uz.jl.school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.jl.school.news.NewsService;
import uz.jl.school.news.dto.NewsCreateDTO;
import uz.jl.school.news.dto.NewsUpdateDTO;
import uz.jl.school.teacher.TeacherService;
import uz.jl.school.teacher.dto.TeacherCreateDTO;
import uz.jl.school.teacher.dto.TeacherUpdateDTO;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final NewsService newsService;
    private final TeacherService teacherService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage() {
        return "admin/admin";
    }

    @RequestMapping(value = "/admin/news", method = RequestMethod.GET)
    public String adminNewsPage(Model model) {
        model.addAttribute("news_list", newsService.list());
        return "admin/admin-news";
    }

    @RequestMapping(value = "/admin/news/create", method = RequestMethod.GET)
    public String adminNewsCreatePage() {
        return "admin/news-create";
    }

    @RequestMapping(value = "/admin/news/create/", method = RequestMethod.POST)
    public String adminNewsCreate(NewsCreateDTO dto, Model model) {
        newsService.create(dto);
        model.addAttribute("news_list", newsService.list());
        return "redirect:/admin/news";
    }

    @RequestMapping(value = "/admin/news/update/{id}", method = RequestMethod.GET)
    public String adminNewsUpdatePage(@PathVariable Integer id, Model model) {
        model.addAttribute("news", newsService.get(id));
        return "admin/news-update";
    }

    @RequestMapping(value = "/admin/news/update/{id}", method = RequestMethod.POST)
    public String adminNewsUpdate(NewsUpdateDTO dto, Model model) {
        newsService.update(dto);
        model.addAttribute("news_list", newsService.list());
        return "redirect:/admin/news";
    }

    @RequestMapping(value = "/admin/news/delete/{id}", method = RequestMethod.GET)
    public String adminNewsDeletePage(@PathVariable Integer id, Model model) {
        model.addAttribute("news", newsService.get(id));
        return "admin/news-delete";
    }

    @RequestMapping(value = "/admin/news/delete/{id}", method = RequestMethod.POST)
    public String adminNewsDelete(@PathVariable Integer id, Model model) {
        newsService.delete(id);
        model.addAttribute("news_list", newsService.list());
        return "redirect:/admin/news";
    }

    @RequestMapping(value = "/admin/teacher", method = RequestMethod.GET)
    public String adminTeacherPage(Model model) {
        model.addAttribute("teacher_list", teacherService.list());
        return "admin/admin-teacher";
    }

    @RequestMapping(value = "/admin/teacher/create", method = RequestMethod.GET)
    public String adminTeacherCreatePage() {
        return "admin/teacher-create";
    }

    @RequestMapping(value = "/admin/teacher/create/", method = RequestMethod.POST)
    public String adminTeacherCreate(TeacherCreateDTO dto, Model model) {
        teacherService.create(dto);
        model.addAttribute("teacher_list", teacherService.list());
        return "redirect:/admin/teacher";
    }

    @RequestMapping(value = "/admin/teacher/update/{id}", method = RequestMethod.GET)
    public String adminTeacherUpdatePage(@PathVariable Integer id, Model model) {
        model.addAttribute("teacher", teacherService.get(id));
        return "admin/teacher-update";
    }

    @RequestMapping(value = "/admin/teacher/update/{id}", method = RequestMethod.POST)
    public String adminTeacherUpdate(TeacherUpdateDTO dto, Model model) {
        teacherService.update(dto);
        model.addAttribute("teacher_list", teacherService.list());
        return "redirect:/admin/teacher";
    }

    @RequestMapping(value = "/admin/teacher/delete/{id}", method = RequestMethod.GET)
    public String adminTeacherDeletePage(@PathVariable Integer id, Model model) {
        model.addAttribute("teacher", teacherService.get(id));
        return "admin/teacher-delete";
    }

    @RequestMapping(value = "/admin/teacher/delete/{id}", method = RequestMethod.POST)
    public String adminTeacherDelete(@PathVariable Integer id, Model model) {
        teacherService.delete(id);
        model.addAttribute("teacher_list", teacherService.list());
        return "redirect:/admin/teacher";
    }
}
