package uz.jl.school.file;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class FileService {
    private final FileRepository repository;
    private static final String uploadDirectory = "src/main/resources/static/uploads/";
    private static final String extensions = "{jpg};{png};{PNG};{JPG};{jpeg};{JPEG};";

    public File save(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalName);
        if (Objects.isNull(extension) || !extensions.contains(extension)) {
            throw new RuntimeException("File format not supported !");
        }
        String generatedName = System.currentTimeMillis() + "." + extension;
        Path path = Paths.get(uploadDirectory + generatedName);
        Files.copy(file.getInputStream(), path);


        String url = "http://localhost:8080" + "/".concat("download/".concat(generatedName));
        File saveFile = new File(file.getSize(), originalName, generatedName, extension, (uploadDirectory + generatedName), url);
        return repository.save(saveFile);
    }

    public org.springframework.core.io.Resource download(String name) {
        org.springframework.core.io.Resource resource = null;
        try {
            Path location = Paths.get(uploadDirectory + name);
            resource = new UrlResource(location.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("File not found !");
        }
        return resource;
    }
}