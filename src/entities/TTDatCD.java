/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author minhh
 */
@Entity
@Table(name = "TTDatCD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTDatCD.findAll", query = "SELECT t FROM TTDatCD t")
    , @NamedQuery(name = "TTDatCD.findByMaTTDatCD", query = "SELECT t FROM TTDatCD t WHERE t.maTTDatCD = :maTTDatCD")
    , @NamedQuery(name = "TTDatCD.findByNgayDat", query = "SELECT t FROM TTDatCD t WHERE t.ngayDat = :ngayDat")
    , @NamedQuery(name = "TTDatCD.findByTrangThai", query = "SELECT t FROM TTDatCD t WHERE t.trangThai = :trangThai")})
public class TTDatCD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maTTDatCD")
    private Integer maTTDatCD;
    @Column(name = "ngayDat")
    private String ngayDat;
    @Column(name = "trangThai")
    private Boolean trangThai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maTTDatCD")
    private List<CTDatCD> cTDatCDList;
    @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang")
    @ManyToOne(optional = false)
    private KhachHang maKhachHang;

    public TTDatCD() {
    }

    public TTDatCD(Integer maTTDatCD) {
        this.maTTDatCD = maTTDatCD;
    }

    public Integer getMaTTDatCD() {
        return maTTDatCD;
    }

    public void setMaTTDatCD(Integer maTTDatCD) {
        this.maTTDatCD = maTTDatCD;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public List<CTDatCD> getCTDatCDList() {
        return cTDatCDList;
    }

    public void setCTDatCDList(List<CTDatCD> cTDatCDList) {
        this.cTDatCDList = cTDatCDList;
    }

    public KhachHang getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(KhachHang maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTTDatCD != null ? maTTDatCD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTDatCD)) {
            return false;
        }
        TTDatCD other = (TTDatCD) object;
        if ((this.maTTDatCD == null && other.maTTDatCD != null) || (this.maTTDatCD != null && !this.maTTDatCD.equals(other.maTTDatCD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TTDatCD[ maTTDatCD=" + maTTDatCD + " ]";
    }
    
}
