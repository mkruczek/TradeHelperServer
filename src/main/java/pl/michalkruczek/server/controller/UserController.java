package pl.michalkruczek.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.michalkruczek.server.dto.UserDto;
import pl.michalkruczek.server.model.User;
import pl.michalkruczek.server.repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikr on 03/09/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @RequestMapping("/checkLogin/login={login}&pass={pass}")
    public Boolean checkLogin(@PathVariable String login, @PathVariable String pass) {

        User user = userRepository.findByLogin(login);

        if (user.getPassword().equals(pass)) {
            return true;
        }

        return false;
    }


    @RequestMapping("/add")
    public String addUser(@RequestBody UserDto userDto) throws ParseException {
        User user = new User();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());

        userRepository.save(user);

        return "Add user: " + user.getName() + " " + user.getSurname();
    }

    @RequestMapping("/all")
    public List<UserDto> allUser() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<UserDto>();

        for (User user : userList) {
            UserDto userDto = new UserDto();

            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setSurname(user.getSurname());
            userDto.setLogin(user.getLogin());
            userDto.setPassword(user.getPassword());

            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    @RequestMapping("/id={id}")
    public UserDto singleUserById(@PathVariable long id) {
        User user = userRepository.findOne(id);
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    @RequestMapping("/login={login}")
    public UserDto singleUserByLogin(@PathVariable String login) {
        User user = userRepository.findByLogin(login);
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    @RequestMapping(value = "/update/{login}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable String login, @RequestBody UserDto userDto) {
        User user = userRepository.findByLogin(login);

        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());

        userRepository.save(user);

        return "Update user: " + user.getName() + " " + user.getSurname();
    }

    @RequestMapping(value = "/delete/id={id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable long id) {

        String userName = userRepository.findOne(id).getName() + " " + userRepository.findOne(id).getSurname();

        userRepository.delete(id);

        return "Delete user: " + userName;
    }

    @RequestMapping(value = "/delete/login={login}", method = RequestMethod.DELETE)
    public String deleteUserByLogin(@PathVariable String login) {

        String userName = userRepository.findByLogin(login).getName() + " " + userRepository.findByLogin(login).getSurname();

        User user = userRepository.findByLogin(login);

        userRepository.delete(user);

        return "Delete user: " + userName;
    }

}

