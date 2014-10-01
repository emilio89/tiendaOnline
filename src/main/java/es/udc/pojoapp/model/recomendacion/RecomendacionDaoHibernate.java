/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.recomendacion;

import es.udc.pojo.modelutil.dao.GenericDaoHibernate;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author emilio
 */
@Repository("RecomendacionDao")

public class RecomendacionDaoHibernate extends
	GenericDaoHibernate<Recomendacion, Long> implements RecomendacionDao {
    
    
        public Recomendacion findByidRecomendacion(int idRecomendacion) 
                        throws InstanceNotFoundException{
            Recomendacion recomendacion = (Recomendacion) getSession().createQuery(
    			"SELECT u FROM Recomendacion u WHERE u.idRecomendacion = :idRecomendacion")
    			.setParameter("idRecomendacion", idRecomendacion)
    			.uniqueResult();
    	if (recomendacion == null) {
   			throw new InstanceNotFoundException(idRecomendacion, Recomendacion.class.getName());
    	} else {
    		return recomendacion;
    	}  
        
        }

    
}
