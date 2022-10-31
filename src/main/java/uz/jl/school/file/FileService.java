package uz.jl.school.file;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.env.Environment;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class FileService {
    private final FileRepository repository;
    private static final String uploadDirectory = "uploads";
    private static final Path rootDir = Path.of(uploadDirectory);
    private final Environment environment;

    @PostConstruct
    public void init() {
        if (!Files.exists(rootDir)) {
            try {
                Files.createDirectories(rootDir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static final String extensions = "{jpg};{png};{PNG};{JPG};{jpeg};{JPEG};";

    public File save(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalName);
        if (Objects.isNull(extension) || !extensions.contains(extension)) {
            throw new RuntimeException("File format not supported !");
        }
        String generatedName = System.currentTimeMillis() + "." + extension;
        Path path = rootDir.resolve(generatedName);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        String url = "http://"+environment.getProperty("prod.server.ip") + ":" + environment.getProperty("prod.server.port") + "/download/" + generatedName;
        File saveFile = new File(file.getSize(), originalName, generatedName, extension, (uploadDirectory + generatedName), url);
        return repository.save(saveFile);
    }

    public org.springframework.core.io.Resource download(String name) {
        org.springframework.core.io.Resource resource;
        try {
            Path location = rootDir.resolve(name);
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
