package springsecure.service;

/*
 * @Author : Shahzadi Parveen
 * @Project Name : springsecure
 * @Created : 23-03-2022
 * @Mailto : shahzadicdac13@gmail.com
 */

import org.springframework.stereotype.Service;
import springsecure.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("abc","abc","abc@gmail.com"));
        list.add(new User("xyz","xyz","xyz@gmail.com"));
    }

    //get all users
    public List<User> getAllUsers()
    {
        return this.list;
    }

    //get single user
    public User getUser(String username){
        return this.list.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    //add new user
    public User addUser(User user){
        this.list.add(user);
        return user ;
    }
}
