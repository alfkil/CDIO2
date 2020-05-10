package rest;

import data.IUserDAO;
import data.TransientData;
import dto.UserDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserService {

    IUserDAO data = new TransientData();

//    //TODO: CRUD - methods below
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean createUser(UserDTO user) {
        return data.createUser(user);
    }

    @POST
    @Path("/read")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO readIngredient(UserDTO user) {
        return data.readUser(user);
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean updateIngredient(UserDTO user) {
        return data.updateUser(user);
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean deleteIngredient(UserDTO user) {
        return data.deleteUser(user);
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