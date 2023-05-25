package com.example.buoi7.service;

import com.example.buoi7.dto.UserDTO;
import com.example.buoi7.model.User;
import com.example.buoi7.repo.UserRepository;
import com.example.buoi7.utlts.UploadFileCloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserService {

    @Autowired
    UploadFileCloudinary uploadFileCloudinary;


    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(String name, String address, MultipartFile multipartFile) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(multipartFile.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(multipartFile.getBytes());
        }
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setPhoto(imagePath.resolve(multipartFile.getOriginalFilename()).toString());
        return userRepository.save(user);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create2(UserDTO userDTO) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(userDTO.getMultipartFile().getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(userDTO.getMultipartFile().getBytes());
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setPhoto(imagePath.resolve(userDTO.getMultipartFile().getOriginalFilename()).toString());
        return userRepository.save(user);
    }

    public User createNewUser3(String name, String address, MultipartFile multipartFile)  {
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        try {
            String urlImage=uploadFileCloudinary.getUrlFromFile(multipartFile);
            user.setPhoto(urlImage);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return  userRepository.save(user);
    }


}
