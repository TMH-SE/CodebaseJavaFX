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
@Table(name = "TTThue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTThue.findAll", query = "SELECT t FROM TTThue t")
    , @NamedQuery(name = "TTThue.findByMaTTThue", query = "SELECT t FROM TTThue t WHERE t.maTTThue = :maTTThue")
    , @NamedQuery(name = "TTThue.findByNgayThue", query = "SELECT t FROM TTThue t WHERE t.ngayThue = :ngayThue")
    , @NamedQuery(name = "TTThue.findByNgayTra", query = "SELECT t FROM TTThue t WHERE t.ngayTra = :ngayTra")
    , @NamedQuery(name = "TTThue.findByTongTien", query = "SELECT t FROM TTThue t WHERE t.tongTien = :tongTien")
    , @NamedQuery(name = "TTThue.findByTrangThai", query = "SELECT t FROM TTThue t WHERE t.trangThai = :trangThai")})
public class TTThue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maTTThue")
    private Integer maTTThue;
    @Column(name = "ngayThue")
    private String ngayThue;
    @Column(name = "ngayTra")
    private String ngayTra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tongTien")
    private BigDecimal tongTien;
    @Column(name = "trangThai")
    private Boolean trangThai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maTTThue")
    private List<CTThue> cTThueList;
    @JoinColumn(name = "maKhachHang", referencedColumnName = "maKhachHang")
    @ManyToOne(optional = false)
    private KhachHang maKhachHang;
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien")
    @ManyToOne(optional = false)
    private NhanVien maNhanVien;

    public TTThue() {
    }

    public TTThue(Integer maTTThue) {
        this.maTTThue = maTTThue;
    }

    public Integer getMaTTThue() {
        return maTTThue;
    }

    public void setMaTTThue(Integer maTTThue) {
        this.maTTThue = maTTThue;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public List<CTThue> getCTThueList() {
        return cTThueList;
    }

    public void setCTThueList(List<CTThue> cTThueList) {
        this.cTThueList = cTThueList;
    }

    public KhachHang getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(KhachHang maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public NhanVien getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(NhanVien maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTTThue != null ? maTTThue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTThue)) {
            return false;
        }
        TTThue other = (TTThue) object;
        if ((this.maTTThue == null && other.maTTThue != null) || (this.maTTThue != null && !this.maTTThue.equals(other.maTTThue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TTThue[ maTTThue=" + maTTThue + " ]";
    }
    
}
