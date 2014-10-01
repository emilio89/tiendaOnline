    /*
 */

package es.udc.pojoapp.web.pages.ropa;

import es.udc.pojoapp.model.adjunto.Adjunto;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropa.RopaDao;
import es.udc.pojoapp.model.ropaservice.RopaService;
import es.udc.pojoapp.model.stocktalla.StockTalla;
import es.udc.pojoapp.web.services.AuthenticationPolicy;
import es.udc.pojoapp.web.services.AuthenticationPolicyType;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author emilio
 */

@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
public class ActualizarRopa {
    

   /* @Property
    private Adjunto adjunto;*/  
    
    
    @Property
    Ropa ropa;
    
    @Property
    StockTalla stockTalla;
    
  
    
     @Inject
    private RopaService ropaService;
        
    
    public List<Ropa> getListaRopa() {
    return ropaService.listaRopa();
  }   
    
    public List <Ropa> getRopas() {
    
    return ropaService.listaRopa();
    
    
    }    
     
    
    
}
