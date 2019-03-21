package services;

import dao.CountryDao;
import entity.Country;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("resttest")
@Stateless
public class CountryRest {

    @Inject
    CountryDao cdao;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addCountry(Country c) {
        cdao.addCountry(c);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void editCountry(Country c) {
        cdao.edit(c);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Country> getAllCountries() {
        return cdao.getAll();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Country getById(@PathParam ("id") Integer id) {
        return cdao.findById(id);
    }
    
    @DELETE
    @Path("{id}")
    public void deleteCountry(@PathParam ("id") Integer id) {
        cdao.delete(id);
    }
    
}
