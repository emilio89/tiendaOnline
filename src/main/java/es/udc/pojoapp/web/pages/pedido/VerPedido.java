/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.web.pages.pedido;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.lineapedidoservice.LineaPedidoService;
import es.udc.pojoapp.model.pedido.Pedido;
import es.udc.pojoapp.model.pedidoservice.PedidoService;
import es.udc.pojoapp.model.userprofile.UserProfile;
import es.udc.pojoapp.model.userservice.UserService;
import es.udc.pojoapp.web.pages.Index;
import es.udc.pojoapp.web.services.AuthenticationPolicy;
import es.udc.pojoapp.web.services.AuthenticationPolicyType;
import es.udc.pojoapp.web.util.Carrito;
import es.udc.pojoapp.web.util.UserSession;
import java.util.Date;
import java.util.List;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Emilio
 */
@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
public class VerPedido {
  
  
  @Property
  @SessionState(create=false)
  private Carrito carrito;
  
  
  UserProfile userProfile;

  boolean verMensaje = false;
  boolean Hay = true;

  @Component
  Form borrarCarritoForm;
  
  @Component
  Form tramitarPedidoForm;

  @Inject
  private LineaPedidoService lineaPedidoService;
  
  @Inject
  private PedidoService pedidoService;
      
        
  @SessionState(create=false)
  private UserSession userSession;
    
  @Inject
  private UserService userService;
      
  
  
  @Property
    @Persist(PersistenceConstants.FLASH)
    // We use a String, not a Boolean, in the radio group value so that we can represent null. Boolean can't represent
    // null because Tapestry will coerce it to Boolean.FALSE. See https://issues.apache.org/jira/browse/TAPESTRY-1928 .
    private String valueForMyBoolean;
 
    @Property
    private Boolean myBoolean;
  
 @Inject
 Block t;
 @Inject
 Block f;
 @Inject
 Block n;
 

@InjectPage
private DatosPedido datosPedido;




  public boolean isHay() {
    
     if (!carrito.getProductos().isEmpty()){
      return true;}
     else{ return false;}
  }

  public void setHay(boolean hay) {
    
    if (!carrito.getProductos().isEmpty()){
      Hay = true;}
    else {Hay = false;}
  
  }
  
  
  
  public boolean isVerMensaje() {
    
    return verMensaje;
  }

  public void setVerMensaje(boolean verMensaje) {
    this.verMensaje = verMensaje;
  }

  
  
  public List getProductos() {
    return carrito.getProductos();
  }

//CADA LINEA DEL CARRITO es una linea De pedido en la persistencia
  //Despues todas esas lineas se meten en un PEDIDO (una vez tramitado....a)

  void onValidateSucessborrarCarritoForm() {
    if (borrarCarritoForm.isValid()) {}
  }
  
  
  void onValidatetramitarPedidoForm() {}
  
  
   Object onSuccessFromborrarCarritoForm() {
     
      //BORRA EL CARRITO!!
      carrito.vaciarCarrito();
   return Index.class;
   
   }
  
   
   Object onSuccessFromtramitarPedidoForm() throws InstanceNotFoundException {

   //  setVerMensaje(true);
   //  if (tramitarPedidoForm.isValid())
     //carrito = null;         
     userProfile = userService.findUserProfile(userSession.getUserProfileId());
     Date ahora = new Date();
     
     //falta por registrar el pedido
     Pedido pedido = new Pedido (ahora,carrito.calculaPrecio(),userProfile,(String)"pendiente");     
      pedidoService.registrarPedido(pedido);    
      lineaPedidoService.registrarLineaPedido(carrito.getProductos(),pedido);
      carrito.vaciarCarrito();
     //return VerPedidosTramitado.class;
      System.out.println(pedido.getIdPedido() + "ID PEDIDOOOOO");
        datosPedido.setIdPedido(pedido.getIdPedido());
         return datosPedido;

      }
   
	   void setupRender() {

        // First time in, valueForMyBoolean will be null.

        if (valueForMyBoolean == null) {
            valueForMyBoolean = "T";
        }

        // Set myBoolean based on valueForMyBoolean.

        if (valueForMyBoolean.equals("T")) {
            myBoolean = Boolean.TRUE;
        }
        else if (valueForMyBoolean.equals("F")) {
            myBoolean = Boolean.FALSE;
        }
        else if (valueForMyBoolean.equals("N")) {
            myBoolean = null;
        }
        else {
            throw new IllegalStateException(valueForMyBoolean);
        }
    }
           
      public Block getCase() {

        // If myBoolean was an int or enum we could use switch/case logic instead of if/else -
        // see http://tapestry.apache.org/switching-cases.html

        if (myBoolean == null) {
            return n;
        }
        else if (myBoolean == Boolean.TRUE) {
            return t;
        }
        else {
            return f;
        }
    }
      
      
  
   

}
