/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.adjunto;

import es.udc.pojo.modelutil.dao.GenericDaoHibernate;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.comentario.Comentario;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author emilio
 */
@Repository("AdjuntoDao")
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
     
     
     public List<Adjunto> listaAdjunto () {
       
      Query query = getSession().createQuery("SELECT a FROM Adjunto a");
      List<Adjunto> listaAdjunto= query.list();
      return listaAdjunto;
     
     
     }
    
}
