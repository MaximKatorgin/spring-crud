package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImp;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping
    public String userList(ModelMap model) {
        List<User> userList = userServiceImp.listUsers();
        model.addAttribute("users", userList);
        model.addAttribute("new_user", new User());
        return "userList";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user, ModelMap model) {
        userServiceImp.add(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userServiceImp.deleteById(id);
        System.out.println("user " + id + " deleted");
        return "redirect:/users";
    }


    @PatchMapping("/update")
    public String update(@RequestParam("userId") Long id,
                         @RequestParam("newName") String name,
                         @RequestParam("newAge") int age,
                         @RequestParam("newPhone") long phone) {
        userServiceImp.update(id, name, age, phone);
        return "redirect:/users";
    }

}
