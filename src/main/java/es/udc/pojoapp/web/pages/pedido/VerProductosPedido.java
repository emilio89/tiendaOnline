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
import java.util.ArrayList;
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
  
  
  void anadirComprarRecomendaciones (ArrayList<Long> listaIds) throws InstanceNotFoundException {
    boolean realizado = false;
    for (int i=0; i<listaIds.size(); i++) {
      System.out.println("Entra 1 "+ listaIds.get(i));
      long id =pedidoService.findIdRopa1(listaIds.get(i));
      long id2 = pedidoService.findIdRopa2(listaIds.get(i));
       long id3=0;
      long id4=0;       
      if (id!=0) {
                //lo encuentra en idRopa1    
        for (int j=0; j<listaIds.size();j++) {
        // recorrer la lista buscando solo en idRopa2
          id3= pedidoService.findIdRopa2(listaIds.get(j));
          if (id3 !=0 && id2!=id3 && id3!=id4) {
            System.out.println("entra 2 -> id: "+id +" id3 "+id3);
             pedidoService.actualizarNumVeces(id, id3);
            //si lo encuentra acutaliza numVeces
          }        
      }
     }else if (id2!=0) {
        //lo encuentra en idRopa2
        for (int z=0;z<listaIds.size();z++){
        //Recorrer la lista buscando solo en idRopa1
            id4 = pedidoService.findIdRopa1(listaIds.get(z));
          if (id4 !=0 && id3!=id4 && id2!=id3){
            System.out.println("entra 3 -> id4: "+id4 +" id2  "+id2);
            pedidoService.actualizarNumVeces(id4, id2);
          } else {
            if (listaIds.get(i) != listaIds.get(z))
            pedidoService.insertarPedidoService(listaIds.get(i),listaIds.get(z));
            //añadir la relacion ¿que relacion? creo que listaIds.get(i) con
            // listaIds.get(z) y numVeces = 1
          }
          
        }  
      }
     else if (id==0 & id2==0) {
      //no está en idropa1 ni en idropa2
       //por lo que hai q añadir ese id, con el resto a recomendaciones....
        //añadir listaIds.get(i) en id1 con 
        //HACER YA, PARA INSERTAR RECOMENDACION Y PARA ACUALIZAR NUMVECES
       // Ropa ropa1 = ropaService.findRopa(id);
         for (int k=0; k<listaIds.size(); k++) {
           if (id != listaIds.get(k)) {
             pedidoService.insertarPedidoService(id, listaIds.get(k));   
           }
         }       
         
      }
    }
   
  } 
  
  
  
  void onValidateFromcomprobarStockForm () throws InstanceNotFoundException{

    //Esto hai que Hacerlo con EL DAO es decir un metodo UPDATE!!
    
    List<LineaPedido> lineas = pedido.getLineaPedidos();
    ArrayList<Long> listaIds = new ArrayList<Long> ();
    Iterator i = lineas.iterator();
    LineaPedido lineaPedido = null;
    int count = 0;
    while (i.hasNext()) {
       count++;
       LineaPedido lineaActual = (LineaPedido)i.next();
       listaIds.add(lineaActual.getIdRopa());
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
    anadirComprarRecomendaciones(listaIds);

    }

  Object onSuccessFromcomprobarStockForm () {
  
   return VerPedidosTramitado.class;
  
  }
}
