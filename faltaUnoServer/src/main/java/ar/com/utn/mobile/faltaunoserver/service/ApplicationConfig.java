package ar.com.utn.mobile.faltaunoserver.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author lgonzalez
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ar.com.utn.mobile.faltaunoserver.service.CanchasFacadeREST.class);
        resources.add(ar.com.utn.mobile.faltaunoserver.service.PartidosFacadeREST.class);
        resources.add(ar.com.utn.mobile.faltaunoserver.service.UsuarioPartidoFacadeREST.class);
        resources.add(ar.com.utn.mobile.faltaunoserver.service.UsuariosFacadeREST.class);
    }
    
}
