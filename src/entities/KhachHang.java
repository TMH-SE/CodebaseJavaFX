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
@Table(name = "KhachHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k")
    , @NamedQuery(name = "KhachHang.findByMaKhachHang", query = "SELECT k FROM KhachHang k WHERE k.maKhachHang = :maKhachHang")
    , @NamedQuery(name = "KhachHang.findByTenKhachHang", query = "SELECT k FROM KhachHang k WHERE k.tenKhachHang = :tenKhachHang")
    , @NamedQuery(name = "KhachHang.findByCmnd", query = "SELECT k FROM KhachHang k WHERE k.cmnd = :cmnd")
    , @NamedQuery(name = "KhachHang.findByDiaChi", query = "SELECT k FROM KhachHang k WHERE k.diaChi = :diaChi")
    , @NamedQuery(name = "KhachHang.findBySdt", query = "SELECT k FROM KhachHang k WHERE k.sdt = :sdt")
    , @NamedQuery(name = "KhachHang.findByEmail", query = "SELECT k FROM KhachHang k WHERE k.email = :email")
    , @NamedQuery(name = "KhachHang.findByTrangThai", query = "SELECT k FROM KhachHang k WHERE k.trangThai = :trangThai")})
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maKhachHang")
    private Integer maKhachHang;
    @Column(name = "tenKhachHang")
    private String tenKhachHang;
    @Column(name = "CMND")
    private String cmnd;
    @Column(name = "diaChi")
    private String diaChi;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "email")
    private String email;
    @Column(name = "trangThai")
    private Boolean trangThai;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "khachHang")
    private TTPhiTreHan tTPhiTreHan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maKhachHang")
    private List<TTDatCD> tTDatCDList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maKhachHang")
    private List<TTThue> tTThueList;

    public KhachHang() {
    }

    public KhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Integer getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public TTPhiTreHan getTTPhiTreHan() {
        return tTPhiTreHan;
    }

    public void setTTPhiTreHan(TTPhiTreHan tTPhiTreHan) {
        this.tTPhiTreHan = tTPhiTreHan;
    }

    @XmlTransient
    public List<TTDatCD> getTTDatCDList() {
        return tTDatCDList;
    }

    public void setTTDatCDList(List<TTDatCD> tTDatCDList) {
        this.tTDatCDList = tTDatCDList;
    }

    @XmlTransient
    public List<TTThue> getTTThueList() {
        return tTThueList;
    }

    public void setTTThueList(List<TTThue> tTThueList) {
        this.tTThueList = tTThueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKhachHang != null ? maKhachHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.maKhachHang == null && other.maKhachHang != null) || (this.maKhachHang != null && !this.maKhachHang.equals(other.maKhachHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.KhachHang[ maKhachHang=" + maKhachHang + " ]";
    }
    
}
