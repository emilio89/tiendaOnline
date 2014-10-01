/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.adjunto;

import es.udc.pojo.modelutil.dao.GenericDao;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;

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

}