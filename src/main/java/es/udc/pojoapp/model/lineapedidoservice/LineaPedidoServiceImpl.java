package es.udc.pojoapp.model.lineapedidoservice;

import es.udc.pojoapp.model.lineapedido.LineaPedido;
import es.udc.pojoapp.model.lineapedido.LineaPedidoDao;
import es.udc.pojoapp.model.pedido.Pedido;
import es.udc.pojoapp.web.util.LineaCarrito;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emilio
 */
@Service("LineaPedidoService")
@Transactional
public class  LineaPedidoServiceImpl implements LineaPedidoService{
  
  @Autowired
    private LineaPedidoDao lineaPedidoDao;
  
  
  public void registrarLineaPedido (List productos, Pedido pedido) {
    Iterator i = productos.iterator();
    LineaCarrito lineaCarrito;
    
        while (i.hasNext()) {     
       LineaCarrito linea = (LineaCarrito)i.next();
       LineaPedido lineaPedido = new LineaPedido
               (pedido,linea.getRopa().getIdRopa(),linea.getPrecio(),linea.getCantidad());
       
       pedido.addLineaPedido(lineaPedido);
       lineaPedidoDao.anadirLineaPedido(lineaPedido);

       
      }
    
        
  
  } 
      
        public List<LineaPedido> listarLineasPorIdPedido (long idPedido) {
        
        
       return lineaPedidoDao.ListarLineasPedido(idPedido);
        
        
        }
  
  
  }
    

