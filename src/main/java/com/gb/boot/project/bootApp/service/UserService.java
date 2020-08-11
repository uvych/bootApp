package com.gb.boot.project.bootApp.service;

import com.gb.boot.project.bootApp.exceptions.ResourceNotFoundException;
import com.gb.boot.project.bootApp.model.Product;
import com.gb.boot.project.bootApp.model.User;
import com.gb.boot.project.bootApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public  User getProductById(Long id){
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<User> getAllProduct(){
        return userRepository.findAll();
    }


    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public void saveOrUpdate(User user){
        userRepository.save(user);
    }
}
