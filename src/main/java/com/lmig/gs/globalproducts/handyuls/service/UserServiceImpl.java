package com.lmig.gs.globalproducts.handyuls.service;

import com.lmig.gs.globalproducts.handyuls.model.User;
import com.lmig.gs.globalproducts.handyuls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByNnumber(String nnumber) {
        return userRepository.findByNnumber(nnumber);
    }

    @Override
    public List<User> getUsers(String nnumber) {
        User user = userRepository.findByNnumber(nnumber);
        List<User> users = userRepository.findAll();
        if (user != null && users != null) {
            return users;
        }
        return null;
    }

    @Override
    public User getUser(Long id, String nnumber) {
        User existingUser = userRepository.findByNnumber(nnumber);
        User user = userRepository.findOne(id);
        if (existingUser != null && user != null) {
            System.out.println("found user to display:" + user.getName());
            return user;
        }
        return null;
    }
}