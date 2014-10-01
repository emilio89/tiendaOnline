/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.model.etiquetaservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.etiqueta.Etiqueta;
import java.util.List;

/**
 *
 * @author Emilio
 */

public interface EtiquetaService {
   
  
      public Etiqueta registrarEtiqueta (String nombreEtiqueta);  
      
      
        public Etiqueta findEtiqueta(Long idEtiqueta)
            throws InstanceNotFoundException;
        /*
        public void actualizarRopa (String nombre, int precio,
            String color, String marca, String descripcion) 
                throws InstanceNotFoundException;
        
        
        */
        public Etiqueta findEtiqueta(String nombreEtiqueta) throws InstanceNotFoundException;

        
        public List<Etiqueta> listaEtiqueta();
      
      
  
}
