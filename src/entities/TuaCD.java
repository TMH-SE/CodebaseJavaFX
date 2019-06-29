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
@Table(name = "TuaCD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TuaCD.findAll", query = "SELECT t FROM TuaCD t")
    , @NamedQuery(name = "TuaCD.findByMaTuaCD", query = "SELECT t FROM TuaCD t WHERE t.maTuaCD = :maTuaCD")
    , @NamedQuery(name = "TuaCD.findByTenTuaCD", query = "SELECT t FROM TuaCD t WHERE t.tenTuaCD = :tenTuaCD")
    , @NamedQuery(name = "TuaCD.findByMoTa", query = "SELECT t FROM TuaCD t WHERE t.moTa = :moTa")
    , @NamedQuery(name = "TuaCD.findBySoLuongTon", query = "SELECT t FROM TuaCD t WHERE t.soLuongTon = :soLuongTon")
    , @NamedQuery(name = "TuaCD.findByThoiGianThue", query = "SELECT t FROM TuaCD t WHERE t.thoiGianThue = :thoiGianThue")
    , @NamedQuery(name = "TuaCD.findByGiaThue", query = "SELECT t FROM TuaCD t WHERE t.giaThue = :giaThue")
    , @NamedQuery(name = "TuaCD.findByTrangThai", query = "SELECT t FROM TuaCD t WHERE t.trangThai = :trangThai")})
public class TuaCD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maTuaCD")
    private Integer maTuaCD;
    @Column(name = "tenTuaCD")
    private String tenTuaCD;
    @Column(name = "moTa")
    private String moTa;
    @Column(name = "soLuongTon")
    private Integer soLuongTon;
    @Column(name = "thoiGianThue")
    private Integer thoiGianThue;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "giaThue")
    private BigDecimal giaThue;
    @Column(name = "trangThai")
    private Boolean trangThai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maTuaCD")
    private List<CD> cDList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "maTuaCD")
    private CTDatCD cTDatCD;

    public TuaCD() {
    }

    public TuaCD(Integer maTuaCD) {
        this.maTuaCD = maTuaCD;
    }

    public Integer getMaTuaCD() {
        return maTuaCD;
    }

    public void setMaTuaCD(Integer maTuaCD) {
        this.maTuaCD = maTuaCD;
    }

    public String getTenTuaCD() {
        return tenTuaCD;
    }

    public void setTenTuaCD(String tenTuaCD) {
        this.tenTuaCD = tenTuaCD;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Integer getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(Integer thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

    public BigDecimal getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(BigDecimal giaThue) {
        this.giaThue = giaThue;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public List<CD> getCDList() {
        return cDList;
    }

    public void setCDList(List<CD> cDList) {
        this.cDList = cDList;
    }

    public CTDatCD getCTDatCD() {
        return cTDatCD;
    }

    public void setCTDatCD(CTDatCD cTDatCD) {
        this.cTDatCD = cTDatCD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTuaCD != null ? maTuaCD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TuaCD)) {
            return false;
        }
        TuaCD other = (TuaCD) object;
        if ((this.maTuaCD == null && other.maTuaCD != null) || (this.maTuaCD != null && !this.maTuaCD.equals(other.maTuaCD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TuaCD[ maTuaCD=" + maTuaCD + " ]";
    }
    
}
