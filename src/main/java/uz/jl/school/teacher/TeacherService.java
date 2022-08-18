package uz.jl.school.teacher;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.jl.school.base.AbstractService;
import uz.jl.school.file.File;
import uz.jl.school.file.FileService;
import uz.jl.school.subject.SubjectService;
import uz.jl.school.teacher.dto.TeacherCreateDTO;
import uz.jl.school.teacher.dto.TeacherUpdateDTO;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class TeacherService extends AbstractService<TeacherRepository> {
    private final FileService fileService;
    private final SubjectService subjectService;

    public TeacherService(TeacherRepository repository, FileService fileService, SubjectService subjectService) {
        super(repository);
        this.fileService = fileService;
        this.subjectService = subjectService;
    }

    public Teacher get(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Teacher not found !");
        });
    }

    public List<Teacher> list() {
        return repository.findAll();
    }

    public List<Teacher> listForHomePage() {
        PageRequest request = PageRequest.of(0, 4);
        return repository.findAll(request).getContent();
    }

    public void create(TeacherCreateDTO dto) {
        File save = null;
        try {
            save = fileService.save(dto.getImage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Teacher teacher = new Teacher(dto.getFullName(), save, subjectService.getByCode(dto.getSubject()), dto.getAbout());
        repository.save(teacher);
    }

    public void update(TeacherUpdateDTO dto) {
        Teacher teacher = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new RuntimeException("Teacher not found !");
        });
        teacher.setFullName(dto.getFullName());
        teacher.setSubject(subjectService.getByCode(dto.getSubject()));
        try {
            teacher.setImage(fileService.save(dto.getImage()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        teacher.setAbout(dto.getAbout());
        repository.save(teacher);
    }

    public void delete(Integer id) {
        Teacher teacher = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Teacher not found !");
        });
        teacher.setDeleted(true);
        repository.save(teacher);
    }
}
