/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.web.pages.ropa;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropa.RopaDao;
import es.udc.pojoapp.model.ropaservice.RopaService;
import es.udc.pojoapp.web.pages.Index;
import es.udc.pojoapp.web.services.AuthenticationPolicy;
import es.udc.pojoapp.web.services.AuthenticationPolicyType;
import es.udc.pojoapp.web.util.Carrito;
import es.udc.pojoapp.web.util.LineaCarrito;
import java.util.List;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;


/**
 *
 * @author Emilio
 */
@AuthenticationPolicy(AuthenticationPolicyType.NON_AUTHENTICATED_USERS)

public class VerRopa {
   /* @Property
    private Adjunto adjunto;*/  
    
    long id;
    
    @Property
    Ropa ropa;

    @Inject
    private RopaService ropaService;
     
    @Inject
    private RopaDao ropaDao;
    
    
    @SessionState(create=false)
    private Carrito carrito= new Carrito();
    
    
    public long getAccountContext() {
      
      return ropa.getIdRopa(); 
      
    }

    
    public List<Ropa> getListaRopa() {
      
      return ropaService.listaRopa();
    
    }


            
    
    
    public List <Ropa> getRopas() {
    
      return ropaService.listaRopa();
    
    
    }

    void onActivate(long ropaId) throws InstanceNotFoundException  
    {
        ropa = ropaService.findRopa(ropaId);
    }
  
    

        
     Object onActionFromAnadir(long idRopa) throws InstanceNotFoundException
    {
      
      Ropa ropa2 = ropaService.findRopa(idRopa);
      LineaCarrito lineaCarrito = new LineaCarrito 
              (ropa2.getPrecio(),ropa2);
      carrito.anadirProducto(lineaCarrito); 
      return Index.class;
 
    } 
    
   /* Object onActivate() 
    {
      
      return CrearStock.class;
    }
*/
    
  
}
