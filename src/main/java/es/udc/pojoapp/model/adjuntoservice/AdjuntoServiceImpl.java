/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.model.adjuntoservice;

import es.udc.pojoapp.model.adjunto.Adjunto;
import es.udc.pojoapp.model.adjunto.AdjuntoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Emilio
 */

@Service("AdjuntoService")
@Transactional
public class AdjuntoServiceImpl implements AdjuntoService {
  
  @Autowired
  AdjuntoDao adjuntoDao;
  

  
  @Transactional
  public List<Adjunto> listaAdjuntos () {
    return adjuntoDao.listaAdjunto();
  
  }
 

  
  
}
