package br.org.pucsc.locadora.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="precolocacao")
public class PrecoLocacao  implements Serializable {
 
    private static final long serialVersionUID = 11L;
    
    public static final Integer TP_KM_LIVRE = 1;
    public static final Integer TP_KM_PERCORRIDO = 2;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private Long id;
    
    @Column(name="idcategoria",nullable = false)
    private Long idcategoria;
    
    @Column(name = "preco", nullable = false)
    private Double preco;
    
    @Column(name = "tpkm", nullable = false)
    private Integer tpkm;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idcategoria", referencedColumnName="id", insertable = false, updatable = false)  
    private Categoria categoria;

    public PrecoLocacao() {
    }

    public PrecoLocacao(final Long id, final Long idcategoria, final Double preco, final Integer tpkm) {
        this.id = id;
        this.idcategoria = idcategoria;
        this.preco = preco;
        this.tpkm = tpkm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Long idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getTpkm() {
        return tpkm;
    }

    public void setTpkm(Integer tpkm) {
        this.tpkm = tpkm;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof PrecoLocacao)) {
            return false;
        }
        
        PrecoLocacao other = (PrecoLocacao) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        
        return sb.toString();
    }
}