package rest;

import data.IUserDAO;
import data.TransientData;
import dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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

    @GET
    @Path("/readAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> readIngredient() {
        return data.readAll();
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

    @GET
    @Path("/id")
    public Integer getVacantId() {
        return data.getVacantId();
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