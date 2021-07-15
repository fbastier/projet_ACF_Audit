package com.acfaudit.document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileTypeDetector;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.Stream;

import com.acfaudit.dto.AddDocument;
import com.acfaudit.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.MimeType;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService {

  private final Path root = Paths.get("uploads");

  @Autowired
  DocumentService documentService;

  @Override
  public void init() {
    try {
      Files.createDirectory(root);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }

  @Override
  public void save(MultipartFile file) {
    try {
      String fileName = file.getOriginalFilename();
      Long timestamp = Instant.now().getEpochSecond();
      Long memorySize = Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
      String path = PathService.buildPath(fileName, timestamp, memorySize);
      saveInDB(fileName, path);

    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  public AddDocument saveInDB(String fileName, String path) {
    AddDocument addDocument = new AddDocument();
    try {
      addDocument = documentService.save(fileName, path);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return addDocument;
  }

  @Override
  public Resource load(String filename) {
    try {
      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }

}
