/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
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
@Table(name = "CTPhiTreHan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTPhiTreHan.findAll", query = "SELECT c FROM CTPhiTreHan c")
    , @NamedQuery(name = "CTPhiTreHan.findByMaCTPhiTreHan", query = "SELECT c FROM CTPhiTreHan c WHERE c.maCTPhiTreHan = :maCTPhiTreHan")
    , @NamedQuery(name = "CTPhiTreHan.findByPhiTreHan", query = "SELECT c FROM CTPhiTreHan c WHERE c.phiTreHan = :phiTreHan")
    , @NamedQuery(name = "CTPhiTreHan.findByTrangThai", query = "SELECT c FROM CTPhiTreHan c WHERE c.trangThai = :trangThai")})
public class CTPhiTreHan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maCTPhiTreHan")
    private Integer maCTPhiTreHan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "phiTreHan")
    private BigDecimal phiTreHan;
    @Column(name = "trangThai")
    private Boolean trangThai;
    @JoinColumn(name = "maCTThue", referencedColumnName = "maCTThue")
    @OneToOne(optional = false)
    private CTThue maCTThue;
    @JoinColumn(name = "maTTPhiTreHan", referencedColumnName = "maTTPhiTreHan")
    @ManyToOne(optional = false)
    private TTPhiTreHan maTTPhiTreHan;

    public CTPhiTreHan() {
    }

    public CTPhiTreHan(Integer maCTPhiTreHan) {
        this.maCTPhiTreHan = maCTPhiTreHan;
    }

    public Integer getMaCTPhiTreHan() {
        return maCTPhiTreHan;
    }

    public void setMaCTPhiTreHan(Integer maCTPhiTreHan) {
        this.maCTPhiTreHan = maCTPhiTreHan;
    }

    public BigDecimal getPhiTreHan() {
        return phiTreHan;
    }

    public void setPhiTreHan(BigDecimal phiTreHan) {
        this.phiTreHan = phiTreHan;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public CTThue getMaCTThue() {
        return maCTThue;
    }

    public void setMaCTThue(CTThue maCTThue) {
        this.maCTThue = maCTThue;
    }

    public TTPhiTreHan getMaTTPhiTreHan() {
        return maTTPhiTreHan;
    }

    public void setMaTTPhiTreHan(TTPhiTreHan maTTPhiTreHan) {
        this.maTTPhiTreHan = maTTPhiTreHan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCTPhiTreHan != null ? maCTPhiTreHan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTPhiTreHan)) {
            return false;
        }
        CTPhiTreHan other = (CTPhiTreHan) object;
        if ((this.maCTPhiTreHan == null && other.maCTPhiTreHan != null) || (this.maCTPhiTreHan != null && !this.maCTPhiTreHan.equals(other.maCTPhiTreHan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CTPhiTreHan[ maCTPhiTreHan=" + maCTPhiTreHan + " ]";
    }
    
}
