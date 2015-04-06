/********************* EMILIO DOMÍNGUEZ SACHEZ *********************/

package es.udc.pojoapp.model.pedido;

import es.udc.pojo.modelutil.dao.GenericDao;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.adjunto.Adjunto;
import es.udc.pojoapp.model.lineapedido.LineaPedido;
import java.util.List;


public interface PedidoDao extends GenericDao<Pedido, Long>{
    
    
    
    /**
     * Returns an Pedido by idPedido ( Ropa identifier)
     *
     * @param idPedido the pedido identifier
     * @return the Pedido
     */
  
      public Pedido findByidPedido(long idPedido) throws InstanceNotFoundException;

      public void anadirPedido (Pedido pedido);
    
      public List<Pedido> listaTodosPedidos ();
      
      public List<Pedido> listaPedidosUsuario (long userProfileId);
      public List<LineaPedido> listaPedidosLineas (long idPedido);
}
