/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.web.pages.pedido;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.pedido.Pedido;
import es.udc.pojoapp.model.pedidoservice.PedidoService;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Emilio
 */
public class VerPedidosTramitado {
  
  @Property
  Pedido pedido;
  
  
  @Inject
  private PedidoService pedidoService;
  
  
  
  
  public List<Pedido> getPedidosTramitados () {
    return pedidoService.listaPedidos();
  
  }

  
 
  
  
  
}
