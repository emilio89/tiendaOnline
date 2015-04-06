/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.model.adjuntoservice;

import es.udc.pojoapp.model.adjunto.Adjunto;
import es.udc.pojoapp.model.ropa.Ropa;
import java.sql.Blob;
import java.util.List;

/**
 *
 * @author Emilio
 */
public interface AdjuntoService {
  
   public List<Adjunto> listaAdjuntos () ;
   public List listaRopaIndex ();
    public List<Blob> listaRopaIndexSoloImagen ();
}
