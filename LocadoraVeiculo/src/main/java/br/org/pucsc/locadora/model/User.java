/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.pucsc.locadora.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author paulo
 */
@Entity
@Table(name="user")
@NamedQuery(name = "user.igual", query = "SELECT o FROM User o WHERE o.id =:id ")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public static final int TP_USER_BASIC = 1;
    
    public static final int MASC = 1;
    public static final int FEM = 2;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private Long id;
    
    @Column(name = "email", nullable = false, length=255)
    private String email;
    
    @Column(name = "user", nullable = false, length=30)
    private String user;
    
    @Column(name = "name", nullable = false, length=255)
    private String name;
    
    @Column(name = "password", nullable = false, length=20)
    private String password;
    
    @Column(name = "tpuser", nullable = false)
    private Integer tpuser;
    
    @Column(name = "dtcreate")
    @Temporal(TemporalType.TIMESTAMP) 
    private Date dtcreate;
    
    @Column(name = "dtedit")
    @Temporal(TemporalType.TIMESTAMP) 
    private Date dtedit;
    
    @Column(name = "phone", length=20)
    private String phone;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "gender")
    private Integer gender;
    
    @Column(name = "dtbirth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtbirth;
    
    @Column(name = "latitude")
    private Double latitude;
    
    @Column(name = "longitude")
    private Double longitude;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTpuser() {
        return tpuser;
    }

    public void setTpuser(Integer tpuser) {
        this.tpuser = tpuser;
    }

    public Date getDtcreate() {
        return dtcreate;
    }

    public void setDtcreate(Date dtcreate) {
        this.dtcreate = dtcreate;
    }

    public Date getDtedit() {
        return dtedit;
    }

    public void setDtedit(Date dtedit) {
        this.dtedit = dtedit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDtbirth() {
        return dtbirth;
    }

    public void setDtbirth(Date dtbirth) {
        this.dtbirth = dtbirth;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof User)) {
            return false;
        }
        
        User other = (User) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        sb.append(" - ");
        sb.append(getName());
        
        return sb.toString();
    }
    
}
