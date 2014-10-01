/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.model.categoriaservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.categoria.Categoria;
import es.udc.pojoapp.model.ropa.Ropa;
import java.util.List;

/**
 *
 * @author Emilio
 */
public interface CategoriaService {
  
  public Categoria crearCategoria (String nombreCategoria, int idCategoriaPadre);
    
        public Categoria findCategoria(Long idCategoria)
            throws InstanceNotFoundException;
        
        
        
        public void borrarCategoria();
  public List<Categoria> listaCategoria();
  
    public void actualizarCategoria (long idCategoria, String nombreCategoria, 
            long idCategoriaPadre) throws InstanceNotFoundException;
}
