package com.lmig.gs.globalproducts.handyuls.controller;

import com.lmig.gs.globalproducts.handyuls.model.User;
import com.lmig.gs.globalproducts.handyuls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            userService.create(user);
            return ResponseEntity.created(new URI("/getUsers/" + user.getId())).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers(@RequestParam("nnumber") String nnumber) {
        List<User> users = userService.getUsers(nnumber);
        if (users != null) {
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") Long id, @RequestParam("nnumber") String nnumber) {
        User user = userService.getUser(id, nnumber);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
}
