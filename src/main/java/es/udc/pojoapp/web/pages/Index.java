package es.udc.pojoapp.web.pages;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropaservice.RopaService;
import es.udc.pojoapp.web.util.Carrito;
import es.udc.pojoapp.web.util.LineaCarrito;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Index {
       
    @Property
    private Ropa ropa;
    
    private int precioCarrito=0;
    
     @Inject
    private RopaService ropaService;
     
     @Property
     @SessionState(create=false)
     private Carrito carrito = new Carrito ();
     
     private boolean siHayCarrito=false;
    
    public List<Ropa> getListaRopa() {
    return ropaService.listaRopa();
  }

   
    public List <Ropa> getRopas() {
    
    return ropaService.listaRopa();
    
    }
    
    public void getSiHayCarrito () {
    
    if (carrito.getProductos().isEmpty()) {
     siHayCarrito= false;
    }else {
      siHayCarrito = true;
    }
    
    
    }

  public boolean isSiHayCarrito() {
   if (carrito.getProductos().isEmpty()) {
     return false;
    }else {
      return true;
    }
  }

  public void setSiHayCarrito(boolean siHayCarrito) {
    this.siHayCarrito = siHayCarrito;
  }
    
    
    

  public int getPrecioCarrito() {
    return carrito.calculaPrecio();
  }

  public void setPrecioCarrito(int precioCarrito) {
    this.precioCarrito = precioCarrito;
  }

    


 



    
     void onActionFromAnadir(long idRopa) throws InstanceNotFoundException
    {
      /*
      Ropa ropa = ropaService.findRopa(idRopa);
      LineaCarrito lineaCarrito = new LineaCarrito 
              (ropa.getPrecio(),ropa);
      carrito.anadirProducto(lineaCarrito); */
 
    } 


     
}
