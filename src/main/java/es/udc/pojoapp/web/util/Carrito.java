/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.web.util;

import es.udc.pojoapp.model.ropa.Ropa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

/**
 *
 * @author Emilio
 */
public class Carrito {
  
  @Property
  private List productos = null;

  
  public Carrito() {
    productos = new ArrayList ();
  }


  public void anadirProducto (LineaCarrito lineaCarrito) {
    long idrop = lineaCarrito.getRopa().getIdRopa();
 
    if (buscarCarrito(idrop) != null ) {
        buscarCarrito(idrop).setCantidad(1);
    }
    else { productos.add(lineaCarrito);
    
          
    }
  }
    
    
    public int calculaPrecio () {
    
    int precio= 0;
    int precio2= 0;
    Iterator i = productos.iterator();
    LineaCarrito lineaCarrito = null;
        while (i.hasNext()) {
    
      
       LineaCarrito linea = (LineaCarrito)i.next();
       
      precio2 = linea.getPrecio() * linea.getCantidad();
      precio = precio + precio2;
    
      }
  
    return precio;
  } 
    
    
    
  
  
  
  public LineaCarrito buscarCarrito (long idropa) {
    
  Iterator i = productos.iterator();
  LineaCarrito lineaCarrito = null;
  while (i.hasNext()) {
    
      
       LineaCarrito linea = (LineaCarrito)i.next();
       
       if (linea.getRopa().getIdRopa() == idropa)
          {
            lineaCarrito = linea;
            break;
        }
    
    }
  
    return lineaCarrito;
  } 

  public List getProductos() {
    return productos;
  }

  public void setProductos(List productos) {
    this.productos = productos;
  }

  
  public void vaciarCarrito () {
  
  this.productos.clear();
  
  }

  
}