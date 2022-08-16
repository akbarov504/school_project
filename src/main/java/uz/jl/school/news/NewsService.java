package uz.jl.school.news;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.jl.school.base.AbstractService;
import uz.jl.school.file.File;
import uz.jl.school.file.FileService;
import uz.jl.school.news.dto.NewsCreateDTO;
import uz.jl.school.news.dto.NewsUpdateDTO;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class NewsService extends AbstractService<NewsMapper, NewsRepository> {
    private final FileService fileService;

    public NewsService(NewsMapper mapper, NewsRepository repository, FileService fileService) {
        super(mapper, repository);
        this.fileService = fileService;
    }

    public News get(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("New not found !");
        });
    }

    public List<News> list() {
        return repository.findAll();
    }

    public List<News> listForHomePage() {
        PageRequest request = PageRequest.of(0, 2);
        return repository.findAll(request).getContent();
    }

    public void create(NewsCreateDTO dto) {
        File save = null;
        try {
            save = fileService.save(dto.getImage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        News news = new News(dto.getTitle(), dto.getDescription(), save, dto.getBody());
        repository.save(news);
    }

    public void update(NewsUpdateDTO dto) {
        News news = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new RuntimeException("News not found !");
        });
        news.setTitle(dto.getTitle());
        news.setDescription(dto.getDescription());
        try {
            news.setImage(fileService.save(dto.getImage()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        news.setBody(dto.getBody());
        repository.save(news);
    }

    public void delete(Integer id) {
        News news = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("News not found !");
        });
        news.setDeleted(true);
        repository.save(news);
    }
}
