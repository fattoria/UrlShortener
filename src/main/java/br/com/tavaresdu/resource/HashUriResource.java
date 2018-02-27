package br.com.tavaresdu.resource;

import br.com.tavaresdu.dao.HashUriDAOService;
import br.com.tavaresdu.model.HashUri;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@RequestScoped
@Path("/hashuri")
public class HashUriResource {
    @EJB
    HashUriDAOService hashUriDAOService;

    @POST
    @Consumes("application/json")
    public HashUri create(HashUri hashUri) {
        hashUriDAOService.persist(hashUri);
        return hashUri;
    }

    @GET
    @Path("/{id:[0-9]*}")
    @Produces("application/json")
    public Response findById(@PathParam("id") int id) {
        HashUri hashUri = hashUriDAOService.findById(id);
        if (hashUri == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(hashUri).build();
    }

    @GET
    @Produces("application/json")
    public List listAll(
            @QueryParam("start") final Integer startPosition,
            @QueryParam("max") final Integer maxResult) {
        List hashUris = hashUriDAOService.findAll();
        return hashUris;
    }

}