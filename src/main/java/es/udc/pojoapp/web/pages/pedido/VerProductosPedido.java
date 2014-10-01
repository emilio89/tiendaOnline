/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.web.pages.pedido;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.lineapedido.LineaPedido;
import es.udc.pojoapp.model.lineapedidoservice.LineaPedidoService;
import es.udc.pojoapp.model.pedido.Pedido;
import es.udc.pojoapp.model.pedidoservice.PedidoService;
import es.udc.pojoapp.web.pages.Index;
import java.util.List;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Emilio
 */
public class VerProductosPedido {
  
  long idpe;
  @Property
  Pedido pedido;
  Pedido pedido2;
  
  @Property 
  LineaPedido lineaPedido;

  
  @Inject
  private PedidoService pedidoService;
  
  
@Inject
private LineaPedidoService lineaPedidoService;



@Component
private Form comprobarStockForm;
  
  public long getAccountContext() {

    return pedido.getIdPedido();
  }


  public long getIdpe() {
    return idpe;
  }

  public void setIdpe(long idpe) {
    this.idpe = idpe;
  }

    
  void onActivate (long pedidoId) throws InstanceNotFoundException {
    this.idpe = pedidoId;
    this.pedido = pedidoService.buscarPedido(pedidoId);

  }
  
  long onPassivate () {
    
    return pedido.getIdPedido();
    }
   
   
  public List<LineaPedido> getListaProductosPedido () {  
    return lineaPedidoService.listarLineasPorIdPedido(pedido.getIdPedido());
    
  }
  
  
  void onValidateFromcomprobarStockForm (){

    //Esto hai que Hacerlo con EL DAO es decir un metodo UPDATE!!
    pedido.setEstado("Enviado");




    }

  Object onSuccessFromcomprobarStockForm () {
  
   return VerPedidosTramitado.class;
  
  }
}
