package com.projeto.accessingdatahospital;

//name="author": "Paulo Victor" //

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Isso significa que esta classe é um controlador
@RequestMapping(path = "/user") // Isso significa que os URLs começam com / user (após o caminho do aplicativo)
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired // faz o star do nosso objeto
    private UserRepository userRepository;

    @PostMapping(path = "/") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String status, @RequestParam String local, @RequestParam String propsedTime, @RequestParam String actualStartTime, @RequestParam String endTime, @RequestParam String exitTime) {

        if (userRepository.findByName(name) != null) {
            return "O nome digitado já existe.";
        }

        try {

            User n = new User();
            n.setName(name);
            n.setStatus(status);
            n.setLocal(local);
            n.setPropsedTime(propsedTime);
            n.setActualStartTime(actualStartTime);
            n.setEndTime(endTime);
            n.setExitTime(exitTime);
            userRepository.save(n);
            return "Ok ao gravar.";

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateUser(@PathVariable int id, @RequestParam String name, @RequestParam String status, @RequestParam String local, @RequestParam String propsedTime, @RequestParam String actualStartTime, @RequestParam String endTime, @RequestParam String exitTime) {
       
        User n = userRepository.findById(id);
        n.setName(name);
        n.setStatus(status);
        n.setLocal(local);
        n.setPropsedTime(propsedTime);
        n.setActualStartTime(actualStartTime);
        n.setEndTime(endTime);
        n.setExitTime(exitTime);
        userRepository.save(n);
        return "Ok ao atualizar.";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "Ok ao apagar.";
    }

}