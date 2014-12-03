/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.model.pedidoservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.lineapedido.LineaPedido;
import es.udc.pojoapp.model.pedido.Pedido;
import es.udc.pojoapp.model.recomendacion.Recomendacion;
import java.util.List;

/**
 *
 * @author Emilio
 */
public interface PedidoService {
  
  public void registrarPedido (Pedido pedido) ;
  public List<Pedido> listaPedidos();
  public Pedido buscarPedido (long idPedido) throws InstanceNotFoundException;
  public List<LineaPedido> listaPedidosLineas(long idPedido);
  public void actualizarEstado (long idPedido, String estado) throws InstanceNotFoundException;
  
   public void actualizarNumVeces (long id1, long id2) throws InstanceNotFoundException;
      public long findIdRopa1 (long idRopa);
      
     public long findIdRopa2 (long idRopa);
  public void insertarPedidoService (long id1, long id2);
  
   public List<Recomendacion> listaRecomendaciones () ;
}
