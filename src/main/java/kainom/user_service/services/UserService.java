package kainom.user_service.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kainom.dtos.UserDTO;

import kainom.user_service.model.User;
import kainom.user_service.patterns.UserAdapter;
import kainom.user_service.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    private UserAdapter userAdapter = UserAdapter.getInstance();

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(e -> userAdapter.adaptToDto(e))
                .collect(Collectors.toList());

    }

    public UserDTO findById(long userId) {

        Optional<User> usuario = userRepository.findById(userId);
        if (usuario.isPresent()) {
            return userAdapter.adaptToDto(usuario.get());
        }

        return null;

    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(userAdapter.adaptToModel(userDTO));
        return userAdapter.adaptToDto(user);

    }

    public UserDTO delete(long userId) {

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {

            userRepository.delete(user.get());

        }

        return null;

    }

    public UserDTO findByCpf(String cpf) {

        User user = userRepository.findByCpf(cpf);

        if (user != null) {

            return userAdapter.adaptToDto(user);

        }

        return null;

    }

    public List<UserDTO> queryByName(String name) {

        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(e -> userAdapter.adaptToDto(e))
                .collect(Collectors.toList());

    }

}
