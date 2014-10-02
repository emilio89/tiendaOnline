

package es.udc.pojoapp.model.ropaservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropa.RopaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author emilio
 */
@Service("RopaService")
@Transactional
public class RopaServiceImpl implements RopaService {
    
    
  
  @Autowired
  private RopaDao ropaDao;      
  
    
       
  
  public Ropa registrarRopa (String nombre, int precio,
            String color, String marca, String descripcion, long idCategoria) 
            
  {
     
    Ropa ropa = new Ropa(nombre, precio, color, marca, descripcion, idCategoria);
    //ropaDao.save(ropa);
    ropaDao.anadirRopa(ropa);
    return ropa;
   }
       
       
  public Ropa registrarRopa (Ropa ropa)
  {
    ropaDao.anadirRopa(ropa);
    ropaDao.save(ropa);
    return ropa;
       
  }
       
       
  @Transactional(readOnly = true)
  public Ropa findRopa(Long idRopa) throws InstanceNotFoundException 
  {
    return ropaDao.find(idRopa);
  }

  @Transactional
  public List<Ropa> listaRopa()
  {   
    return ropaDao.listaRopa();
    
  }
       
       
   public void borrarRopa(){

     
    }
    
  public void actualizarRopa(long idRopa, String nombre, int precio,
            String color, String marca, String descripcion)
               throws InstanceNotFoundException 
  {
        
    Ropa ropa = ropaDao.find(idRopa);
    ropa.setNombre(nombre);
    ropa.setPrecio(precio);
    ropa.setColor(color);
    ropa.setMarca(marca);
    ropa.setDescripcion(descripcion);
 
   }
 
  
  
  
}

