/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author minhh
 */
@Entity
@Table(name = "CD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CD.findAll", query = "SELECT c FROM CD c")
    , @NamedQuery(name = "CD.findByMaCD", query = "SELECT c FROM CD c WHERE c.maCD = :maCD")
    , @NamedQuery(name = "CD.findByTrangThai", query = "SELECT c FROM CD c WHERE c.trangThai = :trangThai")})
public class CD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maCD")
    private Integer maCD;
    @Column(name = "trangThai")
    private String trangThai;
    @JoinColumn(name = "maTuaCD", referencedColumnName = "maTuaCD")
    @ManyToOne(optional = false)
    private TuaCD maTuaCD;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "maCD")
    private CTThue cTThue;

    public CD() {
    }

    public CD(Integer maCD) {
        this.maCD = maCD;
    }

    public Integer getMaCD() {
        return maCD;
    }

    public void setMaCD(Integer maCD) {
        this.maCD = maCD;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public TuaCD getMaTuaCD() {
        return maTuaCD;
    }

    public void setMaTuaCD(TuaCD maTuaCD) {
        this.maTuaCD = maTuaCD;
    }

    public CTThue getCTThue() {
        return cTThue;
    }

    public void setCTThue(CTThue cTThue) {
        this.cTThue = cTThue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCD != null ? maCD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CD)) {
            return false;
        }
        CD other = (CD) object;
        if ((this.maCD == null && other.maCD != null) || (this.maCD != null && !this.maCD.equals(other.maCD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CD[ maCD=" + maCD + " ]";
    }
    
}
