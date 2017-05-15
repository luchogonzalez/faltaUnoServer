/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.utn.mobile.faltaunoserver.service;

import ar.com.utn.mobile.faltaunoserver.UsuarioPartido;
import ar.com.utn.mobile.faltaunoserver.UsuarioPartidoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author lgonzalez
 */
@Stateless
@Path("ar.com.utn.mobile.faltaunoserver.usuariopartido")
public class UsuarioPartidoFacadeREST extends AbstractFacade<UsuarioPartido> {

    @PersistenceContext(unitName = "ar.com.utn.mobile_faltaUnoServer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private UsuarioPartidoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;partidoId=partidoIdValue;usuarioId=usuarioIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ar.com.utn.mobile.faltaunoserver.UsuarioPartidoPK key = new ar.com.utn.mobile.faltaunoserver.UsuarioPartidoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> partidoId = map.get("partidoId");
        if (partidoId != null && !partidoId.isEmpty()) {
            key.setPartidoId(new java.lang.Short(partidoId.get(0)));
        }
        java.util.List<String> usuarioId = map.get("usuarioId");
        if (usuarioId != null && !usuarioId.isEmpty()) {
            key.setUsuarioId(new java.lang.Short(usuarioId.get(0)));
        }
        return key;
    }

    public UsuarioPartidoFacadeREST() {
        super(UsuarioPartido.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(UsuarioPartido entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, UsuarioPartido entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ar.com.utn.mobile.faltaunoserver.UsuarioPartidoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public UsuarioPartido find(@PathParam("id") PathSegment id) {
        ar.com.utn.mobile.faltaunoserver.UsuarioPartidoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UsuarioPartido> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UsuarioPartido> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
