package es.udc.pojoapp.web.pages.ropa;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.categoria.Categoria;
import es.udc.pojoapp.model.categoriaservice.CategoriaService;
import es.udc.pojoapp.model.descuento.Descuento;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropaservice.RopaService;
import es.udc.pojoapp.model.stocktalla.StockTalla;
import es.udc.pojoapp.model.stocktallaservice.StockTallaService;
import es.udc.pojoapp.web.pages.Index;
import es.udc.pojoapp.web.services.AuthenticationPolicy;
import es.udc.pojoapp.web.services.AuthenticationPolicyType;
import java.io.File;
import java.util.List;
import org.apache.tapestry5.SelectModel;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.SelectModelFactory;

/**
 *
 * @author emilio
 */
@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
public class RegistrarRopa {
  
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
    private String nombreAdjunto;
    
    
    @Property
    private long idCategoria;
    
    
    
    @Property 
    private int stock;
    
    @Property
    private String talla;
        
        
    @Inject
    private RopaService ropaService;

    @Inject
    private StockTallaService stockTallaService;
    
    @Component
    private Form registrarRopaForm;
    

    @Property
    Categoria categoria;

  
    @Inject
    private CategoriaService categoriaService;
    
    @Property
    private SelectModel categoriaSelectModel;

    @Inject
    SelectModelFactory selectModelFactory;
    
    
    public List<Categoria> getListaCategoriaRopa() {
      
    return categoriaService.listaCategoria();
    
  }
       
    
    void onValidateFromregistrarRopaForm() throws InstanceNotFoundException {
            
      if (!registrarRopaForm.isValid()) 
          {
           return;
          }
      File archivo = new File ("/Users/Emilio/Dropbox/Facultad/PFC/pojo-app/img" );
      Ropa ropa = ropaService.registrarRopa(nombre, precio, color, marca, 
                  descripcion, idCategoria);   
      
      StockTalla stockTalla = stockTallaService.registrarStockTalla(talla, stock, ropa);
          
          
        }

        
     Object onSuccessFromregistrarRopaForm() {
          
          return Index.class;
      }
        



     // Muestra el SELECT de la lista de categorias, para seleccionar una.
    void setupRender() {
      
        List<Categoria> categorias = categoriaService.listaCategoria();
        categoriaSelectModel = selectModelFactory.create(categorias, "nombreCategoria");
    }
    
    
}
