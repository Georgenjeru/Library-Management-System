package com.restapi;



import com.bean.AdminBeanI;
import com.model.Admin;
import com.rest.BaseRestApi;
import com.rest.ResponseWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
public class AdminApi extends BaseRestApi {

    @EJB
    private AdminBeanI adminBean;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Admin admin) {
        try {
            adminBean.add(admin);
            return Response.status(Response.Status.OK).entity(new ResponseWrapper()).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseWrapper(false, ex.getMessage())).build();
        }

    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return Response.status(Response.Status.OK).entity(adminBean.list()).build();
    }


}