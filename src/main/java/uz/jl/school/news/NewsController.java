package uz.jl.school.news;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.jl.school.base.AbstractController;

@Controller
@RequestMapping(value = "/news/*")
public class NewsController extends AbstractController<NewsService> {
    public NewsController(NewsService service) {
        super(service);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String getPage(@PathVariable Integer id, Model model) {
        model.addAttribute("news", service.get(id));
        return "news-single";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("news_list", service.list());
        return "news";
    }
}
