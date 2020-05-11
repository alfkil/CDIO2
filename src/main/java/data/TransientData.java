package data;

import dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class TransientData implements IUserDAO {
    static List<UserDTO> users = new ArrayList<>();

    //Insert some dummy data
    static {
        users.add(new UserDTO(1, "Stig Hoegh", "SH", "010281-2855", "pojo", "Admin"));
        users.add(new UserDTO(2, "Noam Chomski", "NC", "020382-2755", "uncle", "Pharmacist"));
        users.add(new UserDTO(3, "Ole Bole", "OB", "030483-2655","user", "Team leader"));
    }

    private Boolean existsUser(UserDTO user) {
        for (UserDTO u:
                users) {
            if(user.getCpr() != null && user.getCpr().equals(u.getCpr()))
                return true;
            if(user.getUserId() == u.getUserId())
                return true;
            if(user.getUserName() != null && user.getUserName().equals(u.getUserName()))
                return true;
        }
        return false;
    }

    private Boolean existsUser(int id) {
        for(UserDTO u : users) {
            if(u.getUserId() == id)
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

    @Override
    public Boolean createUser(UserDTO user) {
        if(!existsUser(user)) {
            users.add(user);
            return true;
        }
        return false;
    }

    @Override
    public UserDTO readUser(UserDTO user) {
        return findUser(user);
    }

    @Override
    public List<UserDTO> readAll() {
        return users;
    }

    @Override
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

    @Override
    public Boolean deleteUser(UserDTO user) {
        if(existsUser(user)) {
            UserDTO u = findUser(user);
            users.remove(u);
            return true;
        }
        return false;
    }

    @Override
    public Integer getVacantId() {
        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            if(!existsUser(i))
                return i;
        }
        return null;
    }
}
