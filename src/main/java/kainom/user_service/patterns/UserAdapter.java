package kainom.user_service.patterns;

import com.kainom.dtos.UserDTO;

import kainom.user_service.model.User;

public class UserAdapter implements IUserAdapter {
    private static UserAdapter userAdapter;

    private UserAdapter() {

    }

    @Override
    public UserDTO adaptToDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setNome(user.getNome());
        userDto.setCpf(user.getCpf());
        userDto.setEndereco(user.getEndereco());
        userDto.setEmail(user.getEmail());
        userDto.setTelefone(user.getTelefone());
        userDto.setDataCadastro(user.getDataCadastro());
        return userDto;
    }

    @Override
    public User adaptToModel(UserDTO userDto) {
        User user = new User();
        user.setNome(userDto.getNome());
        user.setCpf(userDto.getCpf());
        user.setEndereco(userDto.getEndereco());
        user.setEmail(userDto.getEmail());
        user.setTelefone(userDto.getTelefone());
        user.setDataCadastro(userDto.getDataCadastro());
        return user;
    }

    public static UserAdapter getInstance() {
        if (userAdapter == null) {
            synchronized (UserAdapter.class) {
                userAdapter = new UserAdapter();
            }
        }
        return userAdapter;
    }

}
