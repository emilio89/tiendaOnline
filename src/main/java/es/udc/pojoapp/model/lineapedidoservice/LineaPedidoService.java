/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.model.lineapedidoservice;

import es.udc.pojoapp.model.lineapedido.LineaPedido;
import es.udc.pojoapp.model.pedido.Pedido;
import java.util.List;

/**
 *
 * @author Emilio
 */
public interface LineaPedidoService {
  
    public void registrarLineaPedido (List Productos, Pedido pedido) ;

    public List<LineaPedido> listarLineasPorIdPedido (long idPedido);
  
}
