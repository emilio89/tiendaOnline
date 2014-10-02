/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.model.pedidoservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.lineapedido.LineaPedido;
import es.udc.pojoapp.model.pedido.Pedido;
import es.udc.pojoapp.model.pedido.PedidoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emilio
 */
@Service("PedidoService")
@Transactional
public class PedidoServiceImpl implements PedidoService {
  
  
  @Autowired
    private PedidoDao pedidoDao;
  
  public void registrarPedido (Pedido pedido) {
    
    pedidoDao.anadirPedido(pedido);
  
  }
  
   @Transactional
   public List<Pedido> listaPedidos() {
   
     return pedidoDao.listaTodosPedidos();
   
   }
   
   @Transactional
   public List<LineaPedido> listaPedidosLineas(long idPedido) {
     return pedidoDao.listaPedidosLineas(idPedido);
   }
   
   
     @Transactional(readOnly = true)
     public Pedido buscarPedido (long idPedido) throws InstanceNotFoundException{
     
     return pedidoDao.find(idPedido);
     }
     
     
     
     
    public void actualizarEstado (long idPedido, String estado) throws InstanceNotFoundException {
      Pedido ped = pedidoDao.find(idPedido);
      ped.setEstado(estado);

    
    }
     
     

   
}
