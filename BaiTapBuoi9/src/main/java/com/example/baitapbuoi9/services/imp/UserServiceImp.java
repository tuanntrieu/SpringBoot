package com.example.baitapbuoi9.services.imp;

import com.example.baitapbuoi9.dto.UserDTO;
import com.example.baitapbuoi9.enums.EnumRole;
import com.example.baitapbuoi9.exception.NotFoundException;
import com.example.baitapbuoi9.model.Role;
import com.example.baitapbuoi9.model.User;
import com.example.baitapbuoi9.repositories.RoleRepository;
import com.example.baitapbuoi9.repositories.UserRepository;
import com.example.baitapbuoi9.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User createNewUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role role = roleRepository.findRoleByRoleName(EnumRole.ROLE_USER);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public User getUserByID(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("Khong tim thay user co id la: " + id);
        } else {
            return userRepository.save(user.get());
        }
    }

    @Override
    public User editUserById(int id, UserDTO userDTO) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new NotFoundException("Khong tim thay user co id la: " + id);
        } else {
            user.get().setFullname(userDTO.getFullname());
            user.get().setAddress(userDTO.getAddress());
            user.get().setEmail(userDTO.getEmail());
            user.get().setBirthday(userDTO.getBirthday());
            user.get().setUsername(userDTO.getUsername());
            user.get().setPassword(passwordEncoder.encode(userDTO.getPassword()));
            return userRepository.save(user.get());
        }

    }

    @Override
    public void deleteUserById(int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new NotFoundException("Khong tim thay user co id la: " + id);
        } else {
            userRepository.deleteById(id);
        }

    }

    @Override
    public List<User> getAllUser(int page,int size) {

        if (page < 0) {
            return userRepository.findAll();
        }
        return userRepository.findAll(PageRequest.of(page, size, Sort.by("fullname").descending())).getContent();
    }

    @Override
    public List<User> searchUserByName(String name) {
        List<User> users = userRepository.searchUserByName(name);
        if (users.isEmpty()) {
            throw new NotFoundException("Khong co hoc sinh nao");
        }
        return users;
    }
}
