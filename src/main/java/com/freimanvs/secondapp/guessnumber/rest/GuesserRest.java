package com.freimanvs.secondapp.guessnumber.rest;

import com.freimanvs.secondapp.guessnumber.entities.Guesser;
import com.freimanvs.secondapp.guessnumber.service.beans.interfaces.GuesserServiceBean;
import io.swagger.annotations.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/v1/guessers")

@SwaggerDefinition(
        info = @Info(
                title = "Guesser Resource Swagger-generated API",
                description = "Guesser Resource Description example",
                version = "1.0.0",
                termsOfService = "share and care",
                contact = @Contact(
                        name = "name", email = "mail@mail.com",
                        url = "http://www.url.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org")),
        tags = {
                @Tag(name = "Guesser Resource Swagger-generated API",
                        description = "Description Example")
        },
        basePath = "/secondapp/api",
        schemes = {SwaggerDefinition.Scheme.HTTP},
        externalDocs = @ExternalDocs(
                value = "Developing a Swagger-enabled REST API using WebSphere Developer Tools",
                url = "https://tinyurl.com/swagger-wlp"))
@Api(tags = "Guesser Resource Swagger-generated API", produces = MediaType.APPLICATION_JSON)
public class GuesserRest implements RestCrud<Guesser> {

    @EJB
    private GuesserServiceBean guesserServiceBean;

    @Context
    private UriInfo info;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Override
    public Response getALL() {
        return Response.ok(guesserServiceBean.getList()).build();
    }

    @ApiOperation(value = "create",
            notes = "create",
            consumes = MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @ApiResponses({
            @ApiResponse(code = 201, message = "it has been created"),
            @ApiResponse(code = 400, message = "bad request")
    })

    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Override
    public Response add(Guesser obj) {
        Long id = guesserServiceBean.add(obj);
        return Response.created(info.getAbsolutePathBuilder().path("/" + id).build()).build();

    }

    @ApiOperation(value = "Get by id",
            notes = "Get by id",
            produces = MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "not found")
    })
    @ApiImplicitParam(name = "id", value = "id", dataType = "long", paramType = "path")

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Override
    public Response getById(@PathParam("id") Long id) {
        Guesser obj = guesserServiceBean.getById(id);

        if (obj == null)
            throw new NotFoundException();

        return Response.ok(obj).build();
    }

    @ApiOperation(value = "Delete",
            notes = "Delete")
    @ApiResponses({
            @ApiResponse(code = 204, message = "has been deleted"),
            @ApiResponse(code = 404, message = "not found")
    })
    @ApiImplicitParam(name = "id", value = "id", dataType = "long", paramType = "path")

    @DELETE
    @Path("/{id}")
    @Override
    public Response delete(@PathParam("id") Long id) {

        if (guesserServiceBean.getById(id) == null)
            throw new NotFoundException();

        guesserServiceBean.deleteById(id);
        return Response.noContent().build();
    }

    @ApiOperation(value = "Update",
            notes = "Update",
            consumes = MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @ApiResponses({
            @ApiResponse(code = 201, message = "has been updated"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 404, message = "not found")
    })
    @ApiImplicitParam(name = "id", value = "id", dataType = "long", paramType = "path")

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Override
    public Response update(@PathParam("id") Long id, Guesser obj) {

        if (guesserServiceBean.getById(id) == null)
            throw new NotFoundException();

        guesserServiceBean.updateById(id, obj);
        return Response.created(info.getAbsolutePath()).build();
    }
}
