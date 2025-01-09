package kainom.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kainom.dtos.UserDTO;

import kainom.user_service.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")

    public List<UserDTO> getUsers() {

        return userService.getAll();

    }

    @GetMapping("/{id}")

    UserDTO findById(@PathVariable("id") Long id) {
        return userService.findById(id);

    }

    @PostMapping("/")

    UserDTO newUser(@RequestBody UserDTO userDTO) {

        return userService.save(userDTO);

    }

    @GetMapping("/cpf/{cpf}")
    UserDTO findByCpf(@RequestParam(name = "key", required = true) String key, @PathVariable("cpf") String cpf) {
        return userService.findByCpf(cpf, key);

    }

    @DeleteMapping("/{id}")

    UserDTO delete(@PathVariable("id") Long id) {

        return userService.delete(id);

    }

    @GetMapping("/search")
    public List<UserDTO> queryByName(@RequestParam(name = "nome", required = true) String nome) {

        return userService.queryByName(nome);

    }

}
