package springsecure.controller;

/*
 * @Author : Shahzadi Parveen
 * @Project Name : springsecure
 * @Created : 23-03-2022
 * @Mailto : shahzadicdac13@gmail.com
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springsecure.model.User;
import springsecure.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //all users
    @GetMapping("/get")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    //return single user
   // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    //save user data
    @PostMapping("/save")
    public User add(@RequestBody User user){
        return this.userService.addUser(user);
    }
}
