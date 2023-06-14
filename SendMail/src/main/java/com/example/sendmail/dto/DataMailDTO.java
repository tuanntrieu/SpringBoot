package com.example.sendmail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataMailDTO {
    private String to;// là email mình sẽ gửi thông tin đến (do người dùng cung cấp).
    private String subject;//chủ đề của email mình tạo.
    private String content;//là nội dung của email đó.
    private Map<String, Object> props;// đây mình sử dụng để truyền các thông tin "động" ví dụ như mật khẩu, token... vào template và gửi cho người dùng.
}
