/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.web.pages.ropa;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.categoria.Categoria;
import es.udc.pojoapp.model.categoriaservice.CategoriaService;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropaservice.RopaService;
import es.udc.pojoapp.web.pages.Index;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Emilio
 */
public class ModificarRopa {
  
  
  @Property
  private long idRopa;
  
  @Property 
  private String nombre;
  
  @Property
  private int precio;
  
  @Property 
  private String color;
    @Property
  private String marca;
  
  @Property 
  private String descripcion;
  @Property 
  private int numPuntos;
  
  
   @SessionState(create=false)
  Ropa ropa;
  
  @Inject
  RopaService ropaService;
  
  
  
  void onActivate (long idRopa ) throws InstanceNotFoundException {
        ropa = ropaService.findRopa(idRopa);
  }
  
   void onPrepareForRender()  {
    idRopa = ropa.getIdRopa();
    nombre = ropa.getNombre();
    precio = ropa.getPrecio();
    color = ropa.getColor();
    marca = ropa.getMarca();
    descripcion = ropa.getDescripcion();
    numPuntos = ropa.getNumPuntos();
    }
   
   
    Object onSuccess() throws InstanceNotFoundException {
      ropaService.actualizarRopa(idRopa, nombre, precio, color, marca, descripcion,numPuntos);
        return Index.class;

    }
}
