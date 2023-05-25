package com.example.buoi7.utlts;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Component
public class UploadFileCloudinary {

    @Autowired
    private Cloudinary cloudinary;

    // chuyen tu multipartfile ve file
    public File convertMultipartToFile(MultipartFile file)
            throws IOException {
        File convertFile = new File(Objects.requireNonNull(file.getOriginalFilename()));//khong null lay ra duong dan file
        FileOutputStream outputStream = new FileOutputStream(convertFile);
        outputStream.write(file.getBytes());//chuyen ve nhi phan
        outputStream.close();
        return convertFile;
    }

    //lấy đường dẫn từ File, day anh len cloud r lay link
    public String getUrlFromFile(MultipartFile multipartFile) throws Exception {
        try {
            // dau ? là 1 ẩn danh, de linh dong tra ve
            //day multi len cloud
            Map<?, ?> mapFile = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
            //Todo : ObjectUtils.emptyMap : returns an empty 'java.util.Map' object
            //Todo : mapFile.get("secure_url") : is a key used in the metadata returned after uploading an image
            // mac dinh cai secure
            return mapFile.get("secure_url").toString();
        } catch (Exception exception) {
            throw new Exception("The process get url from file failed!");
        }
    }

    //xoa dua tren URL
    public String removeFileToUrl(String url) throws Exception {
        try {
            cloudinary.uploader().destroy(url, ObjectUtils.emptyMap());
            return "Remove file to url is successfully";
        } catch (Exception exception) {
            throw new Exception("Upload image failed");
        }
    }
}
