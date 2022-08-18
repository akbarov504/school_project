package uz.jl.school.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.jl.school.news.NewsService;
import uz.jl.school.teacher.TeacherService;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final NewsService newsService;
    private final TeacherService teacherService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("news_list", newsService.listForHomePage());
        model.addAttribute("teacher_list", teacherService.listForHomePage());
        return "index";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String aboutPage(Model model) {
        model.addAttribute("teacher_list", teacherService.listForHomePage());
        return "about";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactPage() {
        return "contact";
    }
}
