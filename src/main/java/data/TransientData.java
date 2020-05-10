package data;

import dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransientData implements IUserDAO {
    static List<UserDTO> users = new ArrayList<>();

    //Insert some dummy data
    static {
        users.add(new UserDTO(2324, "Stig Hoegh", "SH", "010281-2855", "pojo", "Admin"));
    }

    private Boolean existsUser(UserDTO user) {
        for (UserDTO u:
                users) {
            if(user.getCpr() == u.getCpr())
                return true;
            if(user.getUserId() == u.getUserId())
                return true;
            if(user.getUserName().equals(u.getUserName()))
                return true;
        }
        return false;
    }

    private UserDTO findUser(UserDTO user) {
        for(UserDTO u : users) {
            if(user.getUserId() == u.getUserId())
                return u;
            if(user.getUserName() != null && user.getUserName().equals(u.getUserName()))
                return u;
            if(user.getCpr() != null && user.getCpr().equals(u.getCpr()))
                return u;
        }
        return null;
    }

    public Boolean createUser(UserDTO user) {
        if(!existsUser(user)) {
            users.add(user);
            return true;
        }
        return false;
    }

    public UserDTO readUser(UserDTO user) {
        return findUser(user);
    }

    public Boolean updateUser(UserDTO user) {
        UserDTO u = findUser(user);
        if(u != null) {
            u.setUserId(user.getUserId());
            if(user.getUserName() != null) u.setUserName(user.getUserName());
            if(user.getIni() != null) u.setIni(user.getIni());
            if(user.getCpr() != null) u.setCpr(user.getCpr());
            if(user.getPassword() != null) u.setPassword(user.getPassword());
            if(user.getRole() != null) u.setRole(user.getRole());
            return true;
        }
        return false;
    }

    public Boolean deleteUser(UserDTO user) {
        if(existsUser(user)) {
            UserDTO u = findUser(user);
            users.remove(u);
            return true;
        }
        return false;
    }

}