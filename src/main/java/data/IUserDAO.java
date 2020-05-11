package data;

import dto.UserDTO;

import java.lang.reflect.Array;
import java.util.List;

public interface IUserDAO {
    public Boolean createUser(UserDTO user);
    public UserDTO readUser(UserDTO user);
    public List<UserDTO> readAll();
    public Boolean updateUser(UserDTO user);
    public Boolean deleteUser(UserDTO user);
    public Integer getVacantId();
}
