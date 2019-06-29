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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author minhh
 */
@Entity
@Table(name = "NhanVien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n")
    , @NamedQuery(name = "NhanVien.findByMaNhanVien", query = "SELECT n FROM NhanVien n WHERE n.maNhanVien = :maNhanVien")
    , @NamedQuery(name = "NhanVien.findByTenNhanVien", query = "SELECT n FROM NhanVien n WHERE n.tenNhanVien = :tenNhanVien")
    , @NamedQuery(name = "NhanVien.findByCmnd", query = "SELECT n FROM NhanVien n WHERE n.cmnd = :cmnd")
    , @NamedQuery(name = "NhanVien.findByDiaChi", query = "SELECT n FROM NhanVien n WHERE n.diaChi = :diaChi")
    , @NamedQuery(name = "NhanVien.findBySdt", query = "SELECT n FROM NhanVien n WHERE n.sdt = :sdt")
    , @NamedQuery(name = "NhanVien.findByEmail", query = "SELECT n FROM NhanVien n WHERE n.email = :email")
    , @NamedQuery(name = "NhanVien.findByTrangThai", query = "SELECT n FROM NhanVien n WHERE n.trangThai = :trangThai")
    , @NamedQuery(name = "NhanVien.findByUsername", query = "SELECT n FROM NhanVien n WHERE n.username = :username")
    , @NamedQuery(name = "NhanVien.findByPasswords", query = "SELECT n FROM NhanVien n WHERE n.passwords = :passwords")
    , @NamedQuery(name = "NhanVien.findByLoaitaikhoan", query = "SELECT n FROM NhanVien n WHERE n.loaitaikhoan = :loaitaikhoan")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maNhanVien")
    private Integer maNhanVien;
    @Column(name = "tenNhanVien")
    private String tenNhanVien;
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
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "passwords")
    private String passwords;
    @Basic(optional = false)
    @Column(name = "loaitaikhoan")
    private String loaitaikhoan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maNhanVien")
    private List<TTThue> tTThueList;

    public NhanVien() {
    }

    public NhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public NhanVien(Integer maNhanVien, String username, String passwords, String loaitaikhoan) {
        this.maNhanVien = maNhanVien;
        this.username = username;
        this.passwords = passwords;
        this.loaitaikhoan = loaitaikhoan;
    }

    public Integer getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getLoaitaikhoan() {
        return loaitaikhoan;
    }

    public void setLoaitaikhoan(String loaitaikhoan) {
        this.loaitaikhoan = loaitaikhoan;
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
        hash += (maNhanVien != null ? maNhanVien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.maNhanVien == null && other.maNhanVien != null) || (this.maNhanVien != null && !this.maNhanVien.equals(other.maNhanVien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NhanVien[ maNhanVien=" + maNhanVien + " ]";
    }
    
}
