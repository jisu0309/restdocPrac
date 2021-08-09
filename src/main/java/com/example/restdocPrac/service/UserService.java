package com.example.restdocPrac.service;

import com.example.restdocPrac.model.User;
import com.example.restdocPrac.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user){
        user.setCreateAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User read(Long id){

        return userRepository.findById(id)
                .orElseThrow(null);
    }

    public User update(User requestUser){
        Optional<User> user = userRepository.findById(requestUser.getId());

        return user.map(dbUser -> {
            dbUser.setAcocunt(requestUser.getAcocunt());
            dbUser.setEmail(requestUser.getEmail());
            dbUser.setPhoneNumber(requestUser.getPhoneNumber());
            dbUser.setUpdateAt(LocalDateTime.now());

            return dbUser;
        })
                .map(userRepository::save)
                .orElse(null);
    }

    public boolean delete(Long id){
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }




}
