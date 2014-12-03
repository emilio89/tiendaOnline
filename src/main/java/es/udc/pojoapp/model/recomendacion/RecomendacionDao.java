/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.recomendacion;

import es.udc.pojo.modelutil.dao.GenericDao;
import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.pedido.Pedido;
import java.util.List;

/**
 *
 * @author emilio
 */
public interface RecomendacionDao extends GenericDao<Recomendacion, Long> {

    /**
     * Returns an Recomendacion by idRecomendacion ( Recomendacion identifier)
     *
     * @param idRecomentadion the Recomendacion identifier
     * @return the Recomendacion
     */
    public Recomendacion findByidRecomendacion(long idRecomendacion) throws InstanceNotFoundException;
    
    public Recomendacion findByIdsRopa (long idRopa1, long idRopa2) throws InstanceNotFoundException;
    
     public long findIdRopa1(long idRopa1);
    public long findIdRopa2(long idRopa2);
    
    
     public List<Recomendacion> listaTodasRecomendaciones();
     
     public void insertarRecomendacion (Recomendacion recomendacion);
}
