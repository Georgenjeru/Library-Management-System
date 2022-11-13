package com.restapi;


import com.bean.BookBeanI;
import com.bean.IssueBeanI;
import com.model.Book;
import com.model.Issue;
import com.rest.BaseRestApi;
import com.rest.ResponseWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/book")
public class IssueApi extends BaseRestApi {

    @EJB
    private IssueBeanI issueBean;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Issue issue) {
        try {
            issueBean.add(issue);
            return Response.status(Response.Status.OK).entity(new ResponseWrapper()).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ResponseWrapper(false, ex.getMessage())).build();
        }

    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() throws Exception {
        return Response.status(Response.Status.OK).entity(issueBean.getList()).build();
    }


}

