/********************* EMILIO DOMÍNGUEZ SACHEZ *********************/


package es.udc.pojoapp.model.recomendacion;

import es.udc.pojoapp.model.ropa.Ropa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author emilio
 */
@Entity
public class Recomendacion {
    private long idRecomendacion;
    private Ropa ropa1;
    private Ropa ropa2;
    private int numVeces;

    public Recomendacion(){};
    
    public Recomendacion(Ropa ropa1, Ropa ropa2, int numVeces) {
        this.ropa1 = ropa1;
        this.ropa2 = ropa2;
        this.numVeces = numVeces;
    }
    @Column(name = "idRecomendacion")
    @SequenceGenerator( // It only takes effect for
    name = "idRecomendacionGenerator", // databases providing identifier
    sequenceName = "RecomendacionSeq")
    // generators.       
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idRecomendacionGenerator")
    public long getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(long idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

  @OneToOne
    public Ropa getRopa1() {
        return ropa1;
    }

    public void setRopa1(Ropa ropa1) {
        this.ropa1 = ropa1;
    }

  @OneToOne
    public Ropa getRopa2() {
        return ropa2;
    }

    public void setRopa2(Ropa ropa2) {
        this.ropa2 = ropa2;
    }

    public int getNumVeces() {
        return numVeces;
    }

    public void setNumVeces(int numVeces) {
        this.numVeces = numVeces;
    }
    
}
