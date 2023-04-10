/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "billdetail")
@NamedQueries({
    @NamedQuery(name = "Billdetail.findAll", query = "SELECT b FROM Billdetail b"),
    @NamedQuery(name = "Billdetail.findByBdid", query = "SELECT b FROM Billdetail b WHERE b.bdid = :bdid"),
    @NamedQuery(name = "Billdetail.findByQuantity", query = "SELECT b FROM Billdetail b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "Billdetail.findByTotal", query = "SELECT b FROM Billdetail b WHERE b.total = :total")})
public class Billdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bdid")
    private Integer bdid;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @JoinColumn(name = "bid", referencedColumnName = "bid")
    @ManyToOne
    private Billmaster bid;
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    @ManyToOne
    private Products pid;

    public Billdetail() {
    }

    public Billdetail(Integer bdid) {
        this.bdid = bdid;
    }

    public Integer getBdid() {
        return bdid;
    }

    public void setBdid(Integer bdid) {
        this.bdid = bdid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Billmaster getBid() {
        return bid;
    }

    public void setBid(Billmaster bid) {
        this.bid = bid;
    }

    public Products getPid() {
        return pid;
    }

    public void setPid(Products pid) {
        this.pid = pid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bdid != null ? bdid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billdetail)) {
            return false;
        }
        Billdetail other = (Billdetail) object;
        if ((this.bdid == null && other.bdid != null) || (this.bdid != null && !this.bdid.equals(other.bdid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Billdetail[ bdid=" + bdid + " ]";
    }
    
}
