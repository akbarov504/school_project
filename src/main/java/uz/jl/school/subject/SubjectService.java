package uz.jl.school.subject;

import org.springframework.stereotype.Service;
import uz.jl.school.base.AbstractService;
import uz.jl.school.subject.dto.SubjectCreateDTO;
import uz.jl.school.subject.dto.SubjectUpdateDTO;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SubjectService extends AbstractService<SubjectRepository> {
    public SubjectService(SubjectRepository repository) {
        super(repository);
    }

    public void create(SubjectCreateDTO dto) {
        Subject subject = new Subject(dto.getName(), dto.getCode(), dto.getValue());
        repository.save(subject);
    }

    public Subject get(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Subject not found !");
        });
    }

    public void update(SubjectUpdateDTO dto) {
        Subject subject = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new RuntimeException("Subject not found !");
        });

        subject.setName(dto.getName());
        subject.setCode(dto.getCode());
        subject.setValue(dto.getValue());
        repository.save(subject);
    }

    public void delete(Integer id) {
        Subject subject = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Subject not found !");
        });
        subject.setDeleted(true);
        repository.save(subject);
    }

    public List<Subject> list() {
        return repository.findAll();
    }

    public Subject getByCode(String subject) {
        return repository.findByCode(subject).orElseThrow(() -> {
            throw new RuntimeException("Subject not found !");
        });
    }
}
