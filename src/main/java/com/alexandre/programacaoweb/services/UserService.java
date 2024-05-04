package com.alexandre.programacaoweb.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.programacaoweb.entities.User;
import com.alexandre.programacaoweb.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {            
            userRepository.deleteById(id);
            return user.get();
        }

        throw new NoSuchElementException("No value present");
    }

    public User update(Long id, User newUser) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            existingUser.map(user -> {

                if (newUser.getNome() != null && !newUser.getNome().isEmpty()){
                    user.setNome(newUser.getNome());
                }

                if (newUser.getEmail() != null && !newUser.getEmail().isEmpty()){
                    user.setEmail(newUser.getEmail());
                }

                if (newUser.getTelefone() != null && !newUser.getTelefone().isEmpty()){
                    user.setTelefone(newUser.getTelefone());
                }

                if (newUser.getPassword() != null && !newUser.getPassword().isEmpty()){
                    user.setPassword(newUser.getPassword());
                }

                return userRepository.save(user);
            });

            return existingUser.get();
        }
        
        throw new NoSuchElementException("No value present");
        
    }
}
