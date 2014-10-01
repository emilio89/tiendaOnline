/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.comentarioservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.comentario.Comentario;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.userprofile.UserProfile;
import java.util.List;

/**
 *
 * @author emilio
 */
public interface ComentarioService {
    
    
        public Comentario registrarComentario (String textoComentario, UserProfile usuario,
            Ropa Ropa) throws InstanceNotFoundException;
    
        public Comentario findComentario(Long idComentario)
            throws InstanceNotFoundException;

        
                
        public void borrarComentario();
        
    public List<Comentario> listaComentario();
       public List<Comentario> listaComentario(long idRopa);
}
