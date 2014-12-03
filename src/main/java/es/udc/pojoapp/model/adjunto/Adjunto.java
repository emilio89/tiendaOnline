/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.udc.pojoapp.model.adjunto;

import es.udc.pojoapp.model.ropa.Ropa;
import javax.persistence.*;

/**
 *
 * @author emilio
 */
@Entity
public class Adjunto  {
  
  
    private long idAdjunto;
    private String nombreAdjunto;
    private Ropa ropa;
    

    public Adjunto(){};
    public Adjunto(String nombreAdjunto) {
        this.nombreAdjunto = nombreAdjunto;
    }

    @Column(name = "idAdjunto")
    @SequenceGenerator( // It only takes effect for
    name = "idAdjuntoGenerator", // databases providing identifier
    sequenceName = "AdjuntoSeq")
    // generators.       
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idAdjuntoGenerator")

    public long getIdAdjunto() {
        return idAdjunto;
    }

    public void setIdAdjunto(long idAdjunto) {
        this.idAdjunto = idAdjunto;
    }

    public String getNombreAdjunto() {
        return nombreAdjunto;
    }

    public void setNombreAdjunto(String nombreAdjunto) {
        this.nombreAdjunto = nombreAdjunto;
    }

 @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="idRopa")
    public Ropa getRopa() {
    return ropa;
  }

  public void setRopa(Ropa ropa) {
    this.ropa = ropa;
  }

    
    
}
