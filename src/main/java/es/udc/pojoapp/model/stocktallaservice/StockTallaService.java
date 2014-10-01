/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.stocktallaservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.stocktalla.StockTalla;
import java.util.List;

/**
 *
 * @author emilio
 */
public interface StockTallaService {
    
    
        public StockTalla registrarStockTalla (String talla, int stock, Ropa ropa);
    
        public StockTalla findStockTalla(Long idStockTalla)
            throws InstanceNotFoundException;
        /*
        public void actualizarRopa (String nombre, int precio,
            String color, String marca, String descripcion) 
                throws InstanceNotFoundException;
        
        
        */
        public StockTalla findStockTalla(Ropa ropa) throws InstanceNotFoundException;

        
        public List<StockTalla> listaStockTalla();
        public List<StockTalla> listaStockTalla(long idRopa);
        

        
    
}
