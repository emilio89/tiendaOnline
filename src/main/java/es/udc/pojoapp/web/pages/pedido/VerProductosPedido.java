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
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropaservice.RopaService;
import es.udc.pojoapp.model.stocktalla.StockTalla;
import es.udc.pojoapp.model.stocktallaservice.StockTallaService;
import es.udc.pojoapp.web.pages.Index;
import java.util.Iterator;
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

@Inject
private StockTallaService stockTallaService;

@Inject
private RopaService ropaService;



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
  
  
  void onValidateFromcomprobarStockForm () throws InstanceNotFoundException{

    //Esto hai que Hacerlo con EL DAO es decir un metodo UPDATE!!
    
    List<LineaPedido> lineas = pedido.getLineaPedidos();
    Iterator i = lineas.iterator();
    LineaPedido lineaPedido = null;
    
    while (i.hasNext()) {

       LineaPedido lineaActual = (LineaPedido)i.next();
       StockTalla stock = stockTallaService.findStockTalla(lineaActual.getIdStockTalla());
       
       if (stock.getStock() < lineaActual.getNumeroUnidades()){
         
          Ropa ropa = ropaService.findRopa(lineaActual.getIdRopa());
          pedidoService.actualizarEstado(pedido.getIdPedido(),ropa.getNombre() + " Producto Sin STOCK");
          
          
       } 
       else {
         stockTallaService.actualizarStock
             (stock.getIdStockTalla(), stock.getStock() - lineaActual.getNumeroUnidades());
         pedidoService.actualizarEstado(pedido.getIdPedido(), "Enviado");
         
       
       }

        
      }
    

    }

  Object onSuccessFromcomprobarStockForm () {
  
   return VerPedidosTramitado.class;
  
  }
}
