/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.puntosExtra;

import es.udc.pojo.modelutil.dao.GenericDaoHibernate;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.etiqueta.Etiqueta;


/**
 *
 * @author emilio
 */
public class PuntosExtraDaoHibernate extends
		GenericDaoHibernate<PuntosExtra, Long> implements PuntosExtraDao {
 
    
    
    	public PuntosExtra findByNumeroPuntosExtra(int numeroPuntosExtra) throws InstanceNotFoundException {

    	PuntosExtra puntosextra = (PuntosExtra) getSession().createQuery(
    			"SELECT u FROM Descuento u WHERE u.numeroPuntosExtra = :numeroPuntosExtra")
    			.setParameter("numeroPuntosExtra", numeroPuntosExtra)
    			.uniqueResult();
    	if (puntosextra == null) {
   			throw new InstanceNotFoundException(numeroPuntosExtra, Etiqueta.class.getName());
    	} else {
    		return puntosextra;
    	}
        
        }
    
}
