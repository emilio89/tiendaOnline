/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.ropaservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.ropa.Ropa;
import java.util.List;

/**
 *
 * @author emilio
 */
public interface RopaService {
    
    
        public Ropa registrarRopa (String nombre, int precio,
            String color, String marca, String descripcion, long idCategoria);
    
        public Ropa findRopa(Long idRopa)
            throws InstanceNotFoundException;
        
        public void actualizarRopa (long idRopa, String nombre, int precio,
            String color, String marca, String descripcion) 
                throws InstanceNotFoundException;
        
        
        public List<Ropa> listaRopa();
        
        public void borrarRopa();
        
    
}
