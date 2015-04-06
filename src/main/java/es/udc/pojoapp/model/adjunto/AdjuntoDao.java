/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.adjunto;

import es.udc.pojo.modelutil.dao.GenericDao;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.ropa.Ropa;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import org.springframework.orm.hibernate3.support.BlobByteArrayType;

/**
 *
 * @author emilio
 */
public interface AdjuntoDao extends GenericDao<Adjunto, Long>{
     /**
     * Returns an Adjunto by nombreAdjunto ( not identifier)
     *
     * @param nombreAdjunto 
     * @return Adjunto
     */
  
      public Adjunto findByNombreAdjunto(String nombreAdjunto) throws InstanceNotFoundException;
      public Adjunto findByIdRopa(Long idRopa) throws InstanceNotFoundException;
      public List<Adjunto> listaAdjunto ();
      public void anadirAdjunto (Adjunto adjunto);
      public BlobByteArrayType imagenById (Long idRopa);
      
      public byte[] imagenById2 (Long idRopa);
      public String[] imagenById3 (Long idRopa);
      
      
      public List listaIndex ();
      
      
      
      public List<Blob> listaIndexSoloImagen ();
}