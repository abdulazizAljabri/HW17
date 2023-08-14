package com.example.homework17.Controller;

import com.example.homework17.ApiRespones.ApiResponse;
import com.example.homework17.Model.User;
import com.example.homework17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public List<User> allUser() {
        return userService.getUsers();
    }
    @PostMapping("/add")
     public ResponseEntity addUser(@RequestBody @Valid User user , Errors error) {
        if (error.hasErrors()){
            String errorMessage = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
         userService.addUser(user);
         return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("success added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user , Errors error) {
        if (error.hasErrors()){
            String errorMessage = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        Boolean user1 = userService.updateUser(id, user);
        if (user1 != null){
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("success updated"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Wrong id"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        Boolean user1 = userService.deleteUser(id);
        if (user1 != null){
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("success deleted"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Wrong id"));
    }

}
