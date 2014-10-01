/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.adjunto;

import es.udc.pojo.modelutil.dao.GenericDaoHibernate;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
/**
 *
 * @author emilio
 */
public class AdjuntoDaoHibernate extends
		GenericDaoHibernate<Adjunto, Long> implements AdjuntoDao{
    
    
     public Adjunto findByNombreAdjunto(String nombreAdjunto) throws InstanceNotFoundException {

    	Adjunto adjunto = (Adjunto) getSession().createQuery(
    			"SELECT u FROM Adjunto u WHERE u.nombreAdjunto = :nombreAdjunto")
    			.setParameter("nombreAdjunto", nombreAdjunto)
    			.uniqueResult();
    	if (adjunto == null) {
   			throw new InstanceNotFoundException(nombreAdjunto, Adjunto.class.getName());
    	} else {
    		return adjunto;
    	}

	}
    
}
