package es.udc.pojoapp.web.pages;

import es.udc.pojoapp.model.adjunto.Adjunto;
import es.udc.pojoapp.model.adjuntoservice.AdjuntoService;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropaservice.RopaService;
import es.udc.pojoapp.web.util.Carrito;
import java.util.List;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.upload.services.UploadedFile;

public class Index {
       
    @Property
    private Ropa ropa;
    
    @Property
    private Adjunto adjunto;
        
    @Property
    String nombreAdjunto;

    String direccion ;
    
    private int precioCarrito=0;
    
    
    
    
     @Inject
    private RopaService ropaService;
     
     @Inject
     private AdjuntoService adjuntoService;
            
     
     @Property
     @SessionState(create=false)
     private Carrito carrito = new Carrito ();
     
     
     private boolean siHayCarrito=false;
     
     @Inject
private AssetSource assetSource;


     
     public Asset getSignImage() {
    final String path = "Users/Emilio/Dropbox/Facultad/PFC/pojo-app/ ";
    return assetSource.getContextAsset(path, null);
}
    
    public List<Ropa> getListaRopa() {
    return ropaService.listaRopa();
  }

    
  
    public List<Adjunto> getListaAdjunto() {
      return adjuntoService.listaAdjuntos();
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

  
  
  public String getDireccion() {
    return   System.getProperty("user.dir");
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
    
    
    

  public int getPrecioCarrito() {
    return carrito.calculaPrecio();
  }

  public void setPrecioCarrito(int precioCarrito) {
    this.precioCarrito = precioCarrito;
  }

   

     
}
