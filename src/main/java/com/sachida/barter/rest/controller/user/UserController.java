package com.sachida.barter.rest.controller.user;

import com.sachida.barter.rest.api.user.NewPassRequestDTO;
import com.sachida.barter.rest.api.user.UserDTO;
import com.sachida.barter.rest.api.user.UserRequestDTO;
import com.sachida.barter.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Api
public class UserController {

    private UserService userService;

    @PostMapping
    @ApiOperation(value = "Create User")
    public UserDTO createUser(@Valid @RequestBody UserRequestDTO user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Get User")
    public UserDTO getUser(@PathVariable String userId) {
          return  userService.getUser(userId);
    }

    @DeleteMapping(value = "/{userId}/delete")
    @ApiOperation(value = "Delete User")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

    @PostMapping("/{userId}/new-pass")
    @ApiOperation(value = "Modify password")
    public UserDTO modifyPass(@PathVariable String userId, @RequestBody NewPassRequestDTO pass) {
        return userService.modifyPass(userId,pass);
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
