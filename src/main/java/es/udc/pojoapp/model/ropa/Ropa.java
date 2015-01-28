    /********************* EMILIO DOMÍNGUEZ SANCHEZ *********************/
package es.udc.pojoapp.model.ropa;

import es.udc.pojoapp.model.adjunto.Adjunto;
import es.udc.pojoapp.model.categoria.CategoriaDao;
import es.udc.pojoapp.model.comentario.Comentario;
import es.udc.pojoapp.model.etiqueta.Etiqueta;
import es.udc.pojoapp.model.stocktalla.StockTalla;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Emilio
 */
@Entity
public class Ropa {
  private long idRopa;
  private String nombre;
  private int precio;
  private String color;
  private String marca;
  private String descripcion;
  
  
  private long idCategoria;
  
  private List<Comentario> comentarios=new ArrayList<Comentario>();
  private List<StockTalla> stocktalla = new ArrayList <StockTalla>();
  
  
  private List<Etiqueta> etiquetas= new ArrayList<Etiqueta>();
  private List<Adjunto> adjuntos= new ArrayList <Adjunto>();
  
public Ropa() {};


//CONSTRUCTOR SIN IMAGEN


    //CONSTRUCTOR CON CATEGORIA
    public Ropa(String nombre, int precio, String color, String marca, String descripcion, 
            Long categoria) {
    
    	/**
		 * NOTE: "idRopa" *must* be left as "null" since its value is
		 * automatically generated.
		 */
    this.nombre = nombre;
    this.precio = precio;
    this.color = color;
    this.marca = marca;
    this.descripcion = descripcion;
    this.idCategoria = categoria;
    
  }
    //CONTRSTRUCTOR CON IMAGEN
 /*   public Ropa(String nombre, int precio, String color, String marca, String descripcion, Adjunto imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.color = color;
        this.marca = marca;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
  

  */
  @Column(name = "idRopa")
  @SequenceGenerator( // It only takes effect for
  name = "idRopaGenerator", // databases providing identifier
  sequenceName = "RopaSeq")
  // generators.       
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "idRopaGenerator")
  public long getIdRopa() {
      return idRopa;
    }

  public void setIdRopa(long idRopa) {
      this.idRopa = idRopa;
    }

    public String getNombre() {
      return nombre;
    }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

    public int getPrecio() {
      return precio;
    }

    public void setPrecio(int precio) {
      this.precio = precio;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public String getMarca() {
      return marca;
    }

    public void setMarca(String marca) {
      this.marca = marca;
    }

    public String getDescripcion() {
      return descripcion;
    }

    public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
    }



      @OneToMany(mappedBy = "ropa",fetch = FetchType.LAZY)
      public List<Comentario> getComentarios() {
          return comentarios;
      }

      public void setComentarios(List<Comentario> comentarios) {
          this.comentarios = comentarios;
      }

      @OneToMany(mappedBy = "ropa",fetch = FetchType.LAZY)
      @Fetch(value = FetchMode.SUBSELECT) //añadido para poder tener varios fetch 
      public List<StockTalla> getStocktalla() {
        return stocktalla;
      }

  public void setStocktalla(List<StockTalla> stocktalla) {
    this.stocktalla = stocktalla;
  }
      

  
  

     @ManyToMany
      public List<Etiqueta> getEtiquetas() {
          return etiquetas;
      }

      public void setEtiquetas(List<Etiqueta> etiquetas) {
          this.etiquetas = etiquetas;
      }

  @OneToMany(mappedBy = "ropa")
  public List<Adjunto> getAdjuntos() {
    return adjuntos;
  }

  public void setAdjuntos(List<Adjunto> adjuntos) {
    this.adjuntos = adjuntos;
  }

  
  
  public Long getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Long idCategoria) {
    this.idCategoria = idCategoria;
  }

  
  public void addComentarios (Comentario coment){
  
    comentarios.add(coment);
  
  }    
  
  public void addStockTalla (StockTalla stock) {
  stocktalla.add(stock);
  
  
  }
      
      
  }



