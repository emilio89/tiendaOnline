/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.recomendacion;

import es.udc.pojo.modelutil.dao.GenericDaoHibernate;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author emilio
 */
@Repository("RecomendacionDao")
public class RecomendacionDaoHibernate extends
	GenericDaoHibernate<Recomendacion, Long> implements RecomendacionDao {
         @Autowired
      private SessionFactory sessionFactory;
    
        public Recomendacion findByidRecomendacion(long idRecomendacion) 
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
    
          public Recomendacion findByIdsRopa (long idRopa1, long idRopa2) throws InstanceNotFoundException {
             Recomendacion recomendacion = (Recomendacion) getSession().createQuery(
    			"SELECT u FROM Recomendacion u WHERE (u.idRopa1 = :idRopa1) and (u.idRopa2 = :idRopa2)")
    			.setParameter("idRopa1", idRopa1).setParameter("idRopa2", idRopa2)
    			.uniqueResult();
    	if (recomendacion == null) {
   			throw new InstanceNotFoundException(idRopa1, Recomendacion.class.getName());
    	} else {
    		return recomendacion;
    	}  
        
            
            }
        
        public long findIdRopa1 (long idRopa1) {
       /* long devolver = (long)0;
        System.out.println("Entra en findIDropa 1 ++" + devolver);
        devolver = (long) getSession().createQuery(
    			"SELECT u.ropa1.idRopa FROM Recomendacion u WHERE u.ropa1.idRopa = :idRopa1")
    			.setParameter("idRopa1", idRopa1)
    			.uniqueResult(); */
        return 0; 
        }

    public long findIdRopa2 (long idRopa2) {
  /*    long devolver = (long)0;
    
             devolver = (long) getSession().createQuery(
    			"SELECT u.ropa2.idRopa FROM Recomendacion u WHERE u.ropa2.idRopa2 = :idRopa2")
    			.setParameter("idRopa2", idRopa2)
    			.uniqueResult();*/
        return 0;
    }
    
    
    // Lista todas las Recomendaciones con todas sus propiedades.  
       public List<Recomendacion> listaTodasRecomendaciones() {
    Query query = getSession().createQuery("SELECT u FROM Recomendacion u");
        List<Recomendacion> listaRecomendaciones= query.list();
        return listaRecomendaciones;
    
    
    
    }
        
       public void insertarRecomendacion (Recomendacion recomendacion) {
       
       sessionFactory.getCurrentSession().save(recomendacion);
       }
       
}
