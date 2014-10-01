/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.model.descuentoservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.descuento.Descuento;
import es.udc.pojoapp.model.descuento.DescuentoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emilio
 */
@Service("DescuentoService")
@Transactional
public class DescuentoServiceImpl implements DescuentoService {
  
  
  
    @Autowired
    private DescuentoDao descuentoDao;
  

  
   
   public Descuento registrarDescuento ( Long porcentajeDescuento) 
            {

         Descuento descuento = new Descuento( porcentajeDescuento);
         descuentoDao.anadirDescuento(descuento);      
         return descuento;
       }
   
     public Descuento registrarDescuento (String nombreDescuento, Long porcentajeDescuento) 
            {

         Descuento descuento = new Descuento(nombreDescuento, porcentajeDescuento);
         descuentoDao.anadirDescuento(descuento);      
         return descuento;
       }
       
       public Descuento registrarDescuento(Descuento descuento)
       {
       descuentoDao.save(descuento);
       return descuento;
       
       }
       
       
       @Transactional(readOnly = true)
       public Descuento findDescuento(Long idDescuento) throws InstanceNotFoundException{
                 return descuentoDao.find(idDescuento);
       
       }

  
       @Transactional
       public List<Descuento> listaDescuento(){
       
       return descuentoDao.listaDescuento();
       
       }
  
}
