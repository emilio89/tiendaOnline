/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.web.pages.categoria;

import es.udc.pojoapp.model.categoria.Categoria;
import es.udc.pojoapp.model.categoria.CategoriaDao;
import es.udc.pojoapp.model.categoriaservice.CategoriaService;
import es.udc.pojoapp.web.services.AuthenticationPolicy;
import es.udc.pojoapp.web.services.AuthenticationPolicyType;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Emilio
 */
@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
public class ModificarCategoria {

  @Property
  Categoria categoria;
  
   @Inject
   private CategoriaService categoriaService;
   
   
    
    public List<Categoria> getListaCategoria() {
    return categoriaService.listaCategoria();
  }


    
    public List <Categoria> getCategorias() {
    return categoriaService.listaCategoria();
    
    
    }
  
  
}
