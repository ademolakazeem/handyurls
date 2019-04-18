package com.lmig.gs.globalproducts.handyuls.service;

import com.lmig.gs.globalproducts.handyuls.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User create(User user);

    User findUserByNnumber(String nnumber);

    List<User> getUsers(String nnumber);

    User getUser(Long id, String nnumber);
}