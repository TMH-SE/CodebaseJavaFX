/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
@Table(name = "CTDatCD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTDatCD.findAll", query = "SELECT c FROM CTDatCD c")
    , @NamedQuery(name = "CTDatCD.findByMaCTDatCD", query = "SELECT c FROM CTDatCD c WHERE c.maCTDatCD = :maCTDatCD")
    , @NamedQuery(name = "CTDatCD.findBySoLuong", query = "SELECT c FROM CTDatCD c WHERE c.soLuong = :soLuong")
    , @NamedQuery(name = "CTDatCD.findByTrangThai", query = "SELECT c FROM CTDatCD c WHERE c.trangThai = :trangThai")})
public class CTDatCD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maCTDatCD")
    private Integer maCTDatCD;
    @Column(name = "soLuong")
    private Integer soLuong;
    @Column(name = "trangThai")
    private Boolean trangThai;
    @JoinColumn(name = "maTTDatCD", referencedColumnName = "maTTDatCD")
    @ManyToOne(optional = false)
    private TTDatCD maTTDatCD;
    @JoinColumn(name = "maTuaCD", referencedColumnName = "maTuaCD")
    @OneToOne(optional = false)
    private TuaCD maTuaCD;

    public CTDatCD() {
    }

    public CTDatCD(Integer maCTDatCD) {
        this.maCTDatCD = maCTDatCD;
    }

    public Integer getMaCTDatCD() {
        return maCTDatCD;
    }

    public void setMaCTDatCD(Integer maCTDatCD) {
        this.maCTDatCD = maCTDatCD;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public TTDatCD getMaTTDatCD() {
        return maTTDatCD;
    }

    public void setMaTTDatCD(TTDatCD maTTDatCD) {
        this.maTTDatCD = maTTDatCD;
    }

    public TuaCD getMaTuaCD() {
        return maTuaCD;
    }

    public void setMaTuaCD(TuaCD maTuaCD) {
        this.maTuaCD = maTuaCD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCTDatCD != null ? maCTDatCD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTDatCD)) {
            return false;
        }
        CTDatCD other = (CTDatCD) object;
        if ((this.maCTDatCD == null && other.maCTDatCD != null) || (this.maCTDatCD != null && !this.maCTDatCD.equals(other.maCTDatCD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CTDatCD[ maCTDatCD=" + maCTDatCD + " ]";
    }
    
}
