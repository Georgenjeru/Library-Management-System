package com.restapi;


import com.bean.LoginBeanI;
import com.model.User;
import com.model.Validate;
import com.rest.ResponseWrapper;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class ValidateApi {

    @EJB
    LoginBeanI loginBean;

    @PermitAll
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(RestLoginWrapper loginWrapper) {

        Validate validate = new Validate();
        validate.setUsername(loginWrapper.getUsername());
        validate.setPassword(loginWrapper.getPassword());
        try {
            User user = loginBean.login(validate);
            return Response.status(Response.Status.OK)
                    .entity(new ResponseWrapper("authorized", user.getBearerToken())).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseWrapper(false, ex.getMessage())).build();
        }



    }
}
