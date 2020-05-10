package rest;

import dto.UserDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/user")
public class UserService {
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

//    //TODO: CRUD - methods below
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean createIngredient(UserDTO user) {
        boolean result = false;
        if(!existsUser(user)) {
            users.add(user);
            result = true;
        }
        return result;
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

    @POST
    @Path("/read")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO readIngredient(UserDTO user) {
        return findUser(user);
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean updateIngredient(UserDTO user) {
        UserDTO u = findUser(user);
        if(u != null) {
            u.setUserId(user.getUserId());
            u.setUserName(user.getUserName());
            u.setIni(user.getIni());
            u.setCpr(user.getCpr());
            u.setPassword(user.getPassword());
            u.setRole(user.getRole());
            return true;
        }
        return false;
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean deleteIngredient(UserDTO user) {
        if(existsUser(user)) {
            UserDTO u = findUser(user);
            users.remove(u);
            return true;
        }
        return false;
    }
}

/* example JSON:

{
    "userId": 2324,
    "userName": "Stig Hoegh",
    "ini": "SH",
    "cpr": "010281-2855",
    "password": "pojo",
    "role": "Admin"
}

 */