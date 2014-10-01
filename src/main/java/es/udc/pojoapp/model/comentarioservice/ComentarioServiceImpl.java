/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.udc.pojoapp.model.comentarioservice;

import es.udc.pojo.modelutil.exceptions.InstanceNotFoundException;
import es.udc.pojoapp.model.comentario.Comentario;
import es.udc.pojoapp.model.comentario.ComentarioDao;
import es.udc.pojoapp.model.ropa.Ropa;
import es.udc.pojoapp.model.ropa.RopaDao;
import es.udc.pojoapp.model.userprofile.UserProfile;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author emilio
 */
@Service("ComentarioService")
@Transactional
public class ComentarioServiceImpl implements ComentarioService {
    
    @Autowired
    private ComentarioDao comentarioDao;
    
    
  
    
       public Comentario registrarComentario (String textoComentario, UserProfile usuario,
            Ropa ropa) throws InstanceNotFoundException 
            {
         Comentario comentario = new Comentario(textoComentario,usuario,ropa);
         ropa.addComentarios(comentario);
         comentarioDao.anadirComentario(comentario);
         return comentario;
       }
       
       /*public Comentario registrarComentario (Comentario comentario)
       {
          comentarioDao.anadirComentario(comentario);
          comentarioDao.save(comentario);        
          return comentario;
       
       }
       */
       
       @Transactional(readOnly = true)
       public Comentario findComentario(Long idComentario) throws InstanceNotFoundException{
                 return comentarioDao.find(idComentario);
       
       }

     
       
        @Transactional
       public List<Comentario> listaComentario(){
          
       return comentarioDao.listaComentario();
       
       }
        
        
         @Transactional
       public List<Comentario> listaComentario(long idRopa){
       return comentarioDao.listaComentario(idRopa);
       
       }
         
         
               public void borrarComentario(){
               
               
               }


       
    
    
}
