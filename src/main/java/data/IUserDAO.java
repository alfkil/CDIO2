package data;

import dto.UserDTO;

public interface IUserDAO {
    public Boolean createUser(UserDTO user);
    public UserDTO readUser(UserDTO user);
    public Boolean updateUser(UserDTO user);
    public Boolean deleteUser(UserDTO user);
}
