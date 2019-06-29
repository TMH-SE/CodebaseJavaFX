/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CTThue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTThue.findAll", query = "SELECT c FROM CTThue c")
    , @NamedQuery(name = "CTThue.findByMaCTThue", query = "SELECT c FROM CTThue c WHERE c.maCTThue = :maCTThue")
    , @NamedQuery(name = "CTThue.findByPhiThue", query = "SELECT c FROM CTThue c WHERE c.phiThue = :phiThue")})
public class CTThue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maCTThue")
    private Integer maCTThue;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "phiThue")
    private BigDecimal phiThue;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "maCTThue")
    private CTPhiTreHan cTPhiTreHan;
    @JoinColumn(name = "maCD", referencedColumnName = "maCD")
    @OneToOne(optional = false)
    private CD maCD;
    @JoinColumn(name = "maTTThue", referencedColumnName = "maTTThue")
    @ManyToOne(optional = false)
    private TTThue maTTThue;

    public CTThue() {
    }

    public CTThue(Integer maCTThue) {
        this.maCTThue = maCTThue;
    }

    public Integer getMaCTThue() {
        return maCTThue;
    }

    public void setMaCTThue(Integer maCTThue) {
        this.maCTThue = maCTThue;
    }

    public BigDecimal getPhiThue() {
        return phiThue;
    }

    public void setPhiThue(BigDecimal phiThue) {
        this.phiThue = phiThue;
    }

    public CTPhiTreHan getCTPhiTreHan() {
        return cTPhiTreHan;
    }

    public void setCTPhiTreHan(CTPhiTreHan cTPhiTreHan) {
        this.cTPhiTreHan = cTPhiTreHan;
    }

    public CD getMaCD() {
        return maCD;
    }

    public void setMaCD(CD maCD) {
        this.maCD = maCD;
    }

    public TTThue getMaTTThue() {
        return maTTThue;
    }

    public void setMaTTThue(TTThue maTTThue) {
        this.maTTThue = maTTThue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCTThue != null ? maCTThue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTThue)) {
            return false;
        }
        CTThue other = (CTThue) object;
        if ((this.maCTThue == null && other.maCTThue != null) || (this.maCTThue != null && !this.maCTThue.equals(other.maCTThue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CTThue[ maCTThue=" + maCTThue + " ]";
    }
    
}
