/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.stocktallaservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropa.RopaDao;
import es.udc.pojoapp.model.stocktalla.StockTalla;
import es.udc.pojoapp.model.stocktalla.StockTallaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author emilio
 */
@Service("StockTallaService")
@Transactional
public class StockTallaServiceImpl implements StockTallaService {
    
    @Autowired
    private StockTallaDao stockTallaDao;      
  
    
       public StockTalla registrarStockTalla (String talla, int stock,Ropa ropa) 
            {

         StockTalla stocktalla = new StockTalla(talla, stock, ropa);
         stockTallaDao.anadirStockTalla(stocktalla);
         ropa.addStockTalla(stocktalla);
         return stocktalla;
       }
       
       public StockTalla registrarStockTalla (StockTalla stockTalla)
       {
       stockTallaDao.anadirStockTalla(stockTalla);
       stockTallaDao.save(stockTalla);
       return stockTalla;
       
       }
       
       
       @Transactional(readOnly = true)
       public StockTalla findStockTalla(Long idStockTalla) throws InstanceNotFoundException{
                 return stockTallaDao.find(idStockTalla);
       
       }

        @Transactional(readOnly = true)
       public StockTalla findStockTalla(Ropa ropa) throws InstanceNotFoundException{
                 return stockTallaDao.findByRopa(ropa);
       
       }
       @Transactional
       public List<StockTalla> listaStockTalla(){
       
       return stockTallaDao.listaStockTalla();
       
       }
       
      
 @Transactional
       public List<StockTalla> listaStockTalla(long idRopa){
       
       return stockTallaDao.listaStockTalla(idRopa);
       
       }
       

  /*     
       public void actualizarRopa(String nombre, int precio,
            String color, String marca, String descripcion)
               throws InstanceNotFoundException {
        
         Ropa ropa = ropaDao.find((long)2);
         ropa.setNombre(nombre);
         ropa.setPrecio(precio);
         ropa.setColor(color);
         ropa.setMarca(marca);
         ropa.setDescripcion(descripcion);
                
       
       }
       * 
       * 
       */
    
}

