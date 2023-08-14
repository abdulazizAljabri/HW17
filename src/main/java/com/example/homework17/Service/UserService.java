package com.example.homework17.Service;


import com.example.homework17.Model.User;
import com.example.homework17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userrepository;

    public List<User> getUsers() {
        return userrepository.findAll();
    }

    public void addUser(User user) {
        userrepository.save(user);
    }


    public Boolean deleteUser(Integer id) {
        User removeUser = userrepository.getById(id);
        if(removeUser == null) {
            return false;
        }
        userrepository.delete(removeUser);
        return true;
    }

    public Boolean updateUser(Integer id, User user) {
        User updateUser = userrepository.getById(id);

        if (updateUser == null){
            return false;
        }
        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());
        updateUser.setUsername(user.getName());
        userrepository.save(updateUser);
        return true;
    }

}
