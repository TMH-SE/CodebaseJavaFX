/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author minhh
 */
@Entity
@Table(name = "TTPhiTreHan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTPhiTreHan.findAll", query = "SELECT t FROM TTPhiTreHan t")
    , @NamedQuery(name = "TTPhiTreHan.findByMaTTPhiTreHan", query = "SELECT t FROM TTPhiTreHan t WHERE t.maTTPhiTreHan = :maTTPhiTreHan")
    , @NamedQuery(name = "TTPhiTreHan.findByTongPhiTreHan", query = "SELECT t FROM TTPhiTreHan t WHERE t.tongPhiTreHan = :tongPhiTreHan")
    , @NamedQuery(name = "TTPhiTreHan.findByTrangThai", query = "SELECT t FROM TTPhiTreHan t WHERE t.trangThai = :trangThai")
    , @NamedQuery(name = "TTPhiTreHan.findByMaKhachHang", query = "SELECT t FROM TTPhiTreHan t WHERE t.maKhachHang = :maKhachHang")})
public class TTPhiTreHan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maTTPhiTreHan")
    private Integer maTTPhiTreHan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tongPhiTreHan")
    private BigDecimal tongPhiTreHan;
    @Column(name = "trangThai")
    private Boolean trangThai;
    @Column(name = "maKhachHang")
    private Integer maKhachHang;
    @JoinColumn(name = "maTTPhiTreHan", referencedColumnName = "maKhachHang", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private KhachHang khachHang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maTTPhiTreHan")
    private List<CTPhiTreHan> cTPhiTreHanList;

    public TTPhiTreHan() {
    }

    public TTPhiTreHan(Integer maTTPhiTreHan) {
        this.maTTPhiTreHan = maTTPhiTreHan;
    }

    public Integer getMaTTPhiTreHan() {
        return maTTPhiTreHan;
    }

    public void setMaTTPhiTreHan(Integer maTTPhiTreHan) {
        this.maTTPhiTreHan = maTTPhiTreHan;
    }

    public BigDecimal getTongPhiTreHan() {
        return tongPhiTreHan;
    }

    public void setTongPhiTreHan(BigDecimal tongPhiTreHan) {
        this.tongPhiTreHan = tongPhiTreHan;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @XmlTransient
    public List<CTPhiTreHan> getCTPhiTreHanList() {
        return cTPhiTreHanList;
    }

    public void setCTPhiTreHanList(List<CTPhiTreHan> cTPhiTreHanList) {
        this.cTPhiTreHanList = cTPhiTreHanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTTPhiTreHan != null ? maTTPhiTreHan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTPhiTreHan)) {
            return false;
        }
        TTPhiTreHan other = (TTPhiTreHan) object;
        if ((this.maTTPhiTreHan == null && other.maTTPhiTreHan != null) || (this.maTTPhiTreHan != null && !this.maTTPhiTreHan.equals(other.maTTPhiTreHan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TTPhiTreHan[ maTTPhiTreHan=" + maTTPhiTreHan + " ]";
    }
    
}
