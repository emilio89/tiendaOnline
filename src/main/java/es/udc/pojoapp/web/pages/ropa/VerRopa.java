/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.web.pages.ropa;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.comentario.Comentario;
import es.udc.pojoapp.model.comentarioservice.ComentarioService;
import es.udc.pojoapp.model.pedidoservice.PedidoService;
import es.udc.pojoapp.model.recomendacion.Recomendacion;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropaservice.RopaService;
import es.udc.pojoapp.model.stocktalla.StockTalla;
import es.udc.pojoapp.model.stocktallaservice.StockTallaService;
import es.udc.pojoapp.model.userprofile.UserProfile;
import es.udc.pojoapp.model.userservice.UserService;
import es.udc.pojoapp.web.pages.Index;
import es.udc.pojoapp.web.services.AuthenticationPolicy;
import es.udc.pojoapp.web.services.AuthenticationPolicyType;
import es.udc.pojoapp.web.util.Carrito;
import es.udc.pojoapp.web.util.LineaCarrito;
import es.udc.pojoapp.web.util.UserSession;
import java.util.List;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.SelectModelFactory;


/**
 *
 * @author Emilio
 */
public class VerRopa {
   /* @Property
    private Adjunto adjunto;*/  
    
    long id;
    Ropa ropa;
    UserProfile userProfile;
    
    @Property
    Comentario comentario;
    @Property
    Recomendacion recomendacion;
    @Property
    StockTalla stockTalla;
    
    @Property
    private long idStockTalla;

    @Inject
    private RopaService ropaService;
    
    @Inject
    private StockTallaService stockTallaService;
    
    @Property
    private SelectModel stockTallaSelectModel;
    
    @Inject
    SelectModelFactory selectModelFactory;  
    
    @Inject
    private ComentarioService comentarioService;
    
    @Component
    Form anadirCarritoForm;
    
     @SessionState(create=false)
    private UserSession userSession;
    @Inject
    private UserService userService;
    
    
    @Inject
    private PedidoService pedidoService;
    
    @Property
    private String coment;
    
     @Component
    private Form comentarioForm;
     
    @SessionState(create=false)
    private Carrito carrito= new Carrito();

  public Ropa getRopa() {
    return ropa;
  }

  public void setRopa(Ropa ropa) {
    this.ropa = ropa;
  }
    
    
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
        ropa  = ropaService.findRopa(ropaId);
    }
  
    long onPassivate () {
    
    return ropa.getIdRopa();
    }
    
     void onValidateFromcomentarioForm() throws InstanceNotFoundException  
     {
       
      if (!comentarioForm.isValid()) 
        {
         return;
        }
      userProfile = userService.findUserProfile(userSession.getUserProfileId());
      comentarioService.registrarComentario(coment, userProfile, ropa);
     
     }
    

  void onValidateFromanadirCarritoForm () throws InstanceNotFoundException  {
   
    if (!anadirCarritoForm.isValid()) {

      return;

    }
    //NON ME DEIXA FACER ESTO, MIRAR OUTRAS ALTERNATIVAS!! 
    LineaCarrito lineaCarrito2 = new LineaCarrito
            (ropa.getPrecio(),ropa, idStockTalla);
    carrito.anadirProducto(lineaCarrito2); 
      
  }
        
    /* Object onActionFromAnadir(long idRopa) throws InstanceNotFoundException
    {
      
      Ropa ropa2 = ropaService.findRopa(idRopa);
      LineaCarrito lineaCarrito = new LineaCarrito 
              (ropa2.getPrecio(),ropa2, idStockTalla);
      carrito.anadirProducto(lineaCarrito); 
      return Index.class;
 
    } */
     Object onSuccess () {
     
       return Index.class;
     
     }
     
    void setupRender () {
    
      List<StockTalla> stockTallas = stockTallaService.listaStockTalla(ropa.getIdRopa());
      stockTallaSelectModel = selectModelFactory.create(stockTallas, "talla");
    
    }
 
  public List<Comentario> getListaComentarios() throws InstanceNotFoundException {

    long idrop = ropa.getIdRopa();
    return comentarioService.listaComentario(idrop);
    
  }
  
    public List<Recomendacion> getListaRecomendaciones() throws InstanceNotFoundException {

    return pedidoService.listaRecomendaciones();
    
  }
    
  
}
