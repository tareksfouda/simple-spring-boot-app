package com.example.review.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.review.model.User;
import com.example.review.service.UserService;


@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
 
//    @GetMapping
//    public ResponseEntity<String> getAll(@RequestParam Map<String, String> queryMap) {
//    	//return queryMap.get("test"); //ger the name of query param test
//    	return new ResponseEntity<String>(queryMap.get("test"), HttpStatus.OK);
//    }
    
    @GetMapping
    public List<User> index(@RequestParam Map<String, String> queryParams) {
    	if (queryParams.get("major") != null) {
    		System.out.println(queryParams.get("major"));
    		return userService.findByMajor(queryParams.get("major"));
    	}
    	System.out.println("TATA");
    	return userService.findAllUsers();
    }
    
    @PostMapping("/register")
    public ResponseEntity<User> store(@RequestBody User user) {
    	return new ResponseEntity<User>(userService.store(user), HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable long id) {
    	if (userService.findById(id).getId() != id) {
    		System.out.println("The id you entered does not exist" + userService.findById(id).getId());
    		return null;
    		}

    	return new ResponseEntity<User>(userService.update(user, id), HttpStatus.OK);
  }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable long id) {
    	if (userService.findById(id).getId() != id) {
    		System.out.println("The id you entered does not exist" + userService.findById(id).getId());
    		return null;
    		}

    	userService.delete(id);
    	return new ResponseEntity<User>(HttpStatus.OK);
  }
}
