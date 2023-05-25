package com.example.ontapbuoi7.service.imp;

import ch.qos.logback.core.util.FileUtil;
import com.example.ontapbuoi7.dto.StudentDTO;
import com.example.ontapbuoi7.exception.NotFoundException;
import com.example.ontapbuoi7.model.Student;
import com.example.ontapbuoi7.repo.StudenrRepository;
import com.example.ontapbuoi7.service.StudentService;
import com.example.ontapbuoi7.utils.UploadFileCloudinary;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImp implements StudentService {

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    StudenrRepository studentRepository;
    @Autowired
    UploadFileCloudinary uploadFileCloudinary;

    @Override
    public Student create(StudentDTO studentDTO) throws Exception {
//        Path staticPath = Paths.get("static");
//        Path imagePath = Paths.get("images");
//        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
//            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
//        }
//        Path file = CURRENT_FOLDER.resolve(staticPath)
//                .resolve(imagePath).resolve(studentDTO.getMultipartFile().getOriginalFilename());
//        try (OutputStream os = Files.newOutputStream(file)) {
//            os.write(studentDTO.getMultipartFile().getBytes());
//        }

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setPhoto(uploadFileCloudinary.getUrlFromFile(studentDTO.getMultipartFile()));
        return studentRepository.save(student);
    }

    @Override
    public Student create2(StudentDTO studentDTO) throws IOException {
        return null;
    }

    @Override
    public void deleteImgStudent(int id) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()){
            throw new NotFoundException("Khong tim thay hoc sinh co id " + id);
        }

        uploadFileCloudinary.removeFileToUrl(student.get().getPhoto());
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            throw new NotFoundException("Khong co hoc sinh trong danh sach");
        } else {
            return students;
        }

    }

    @Override
    public void deleteStudent(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new NotFoundException("Khong tim thay hoc sinh co id " + id);
        } else {
            studentRepository.deleteById(id);
        }
    }
}
