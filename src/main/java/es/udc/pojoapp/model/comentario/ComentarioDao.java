/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.comentario;


import es.udc.pojo.modelutil.dao.GenericDao;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.ropa.Ropa;
import java.util.List;

/**
 *
 * @author emilio
 */
public interface ComentarioDao extends GenericDao<Comentario, Long>{
     /**
     * Returns an Comentario by idComentario ( not identifier)
     *
     * @param idComentario 
     * @return Comentario
     */
          public Comentario findByIdComentario(long idComentario) throws InstanceNotFoundException;

          public void anadirComentario (Comentario comentario);
                public List<Comentario> listaComentario();
                
           public List<Comentario> listaComentario(long idRopa);


}
