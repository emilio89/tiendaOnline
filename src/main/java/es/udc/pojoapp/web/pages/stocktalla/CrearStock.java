/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.web.pages.stocktalla;

import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropaservice.RopaService;
import es.udc.pojoapp.web.services.AuthenticationPolicy;
import es.udc.pojoapp.web.services.AuthenticationPolicyType;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Emilio
 */
@AuthenticationPolicy(AuthenticationPolicyType.NON_AUTHENTICATED_USERS)
public class CrearStock {
  
 
    
    @Property
    Ropa ropa;
    
  
    
     @Inject
    private RopaService ropaService;
     
    
    
    public List<Ropa> getListaRopa() {
    return ropaService.listaRopa();
  }


            
    
    
    public List <Ropa> getRopas() {
    
    return ropaService.listaRopa();
    
    
    }
    

}
