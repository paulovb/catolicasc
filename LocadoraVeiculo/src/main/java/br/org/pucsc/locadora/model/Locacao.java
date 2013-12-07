package br.org.pucsc.locadora.model;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="locacao")
public class Locacao implements Serializable {
 
    private static final long serialVersionUID = 11L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private Long id;
    
    @Column(name="idcarro",nullable = false)
    private Long idcarro;
   
    @Column(name="idcliente",nullable = false)
    private Long idcliente;
      
    @Column(name="idprecolocacao",nullable = false)
    private Long idprecolocacao;
      
    @Column(name="preco",nullable = false)
    private Double preco;
       
    @Column(name="km",nullable = false)
    private Integer km;

    @Column(name="dt_create")    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dtcreate;
    
    @Column(name="dt_devolucao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dtdevolucao;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idcarro", referencedColumnName="id", insertable = false, updatable = false)  
    private Carro carro;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idcliente", referencedColumnName="id", insertable = false, updatable = false)  
    private Cliente cliente;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idprecolocacao", referencedColumnName="id", insertable = false, updatable = false)  
    private PrecoLocacao precolocacao;
    
    public Locacao() {
    }

    public Locacao(final Long id, final Long idcarro, final Long idprecolocacao,  final Double preco, final Integer tpkm) {
        this.id = id;
        this.idcarro = idcarro;
        this.idprecolocacao = idprecolocacao;
        this.preco = preco;
        this.km = tpkm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Long getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(Long idcarro) {
        this.idcarro = idcarro;
    }

    public Long getIdprecolocacao() {
        return idprecolocacao;
    }

    public void setIdprecolocacao(Long idprecolocacao) {
        this.idprecolocacao = idprecolocacao;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public PrecoLocacao getPrecolocacao() {
        return precolocacao;
    }

    public void setPrecolocacao(PrecoLocacao precolocacao) {
        this.precolocacao = precolocacao;
    }
    
    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDtcreate() {
        return dtcreate;
    }

    public void setDtcreate(Date dtcreate) {
        this.dtcreate = dtcreate;
    }

    public Date getDtdevolucao() {
        return dtdevolucao;
    }

    public void setDtdevolucao(Date dtdevolucao) {
        this.dtdevolucao = dtdevolucao;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Locacao)) {
            return false;
        }
        
        Locacao other = (Locacao) object;
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