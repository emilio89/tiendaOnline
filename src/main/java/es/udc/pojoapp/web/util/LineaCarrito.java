/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.web.util;

import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.stocktalla.StockTalla;

/**
 *
 * @author Emilio
 */
public class LineaCarrito {
  
  private String nombreRopa;
  private int precio;
  private int cantidad = 1;
  private Ropa ropa;
  private long idStockTalla;
  

  
  public LineaCarrito(int precio, Ropa ropa, long idStockTalla) {
    this.precio = precio;
    this.ropa = ropa;
    this.idStockTalla = idStockTalla;
  }

  public int getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) {
    this.precio = precio;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = this.cantidad + cantidad;
  }

  public Ropa getRopa() {
    return ropa;
  }

  public void setRopa(Ropa ropa) {
    this.ropa = ropa;
  }

  public String getNombreRopa() {
    return ropa.getNombre();
  }

  public void setNombreRopa(String nombreRopa) {
    this.nombreRopa = nombreRopa;
  }

  public long getIdStockTalla() {
    return idStockTalla;
  }

  public void setIdStockTalla(long idStockTalla) {
    this.idStockTalla = idStockTalla;
  }

 
  
  
  
}
