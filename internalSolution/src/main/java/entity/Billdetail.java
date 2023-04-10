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
import javax.validation.constraints.NotNull;

/**
 *
 * @author ritesh
 */
@Entity
@Table(name = "billdetail")
@NamedQueries({
    @NamedQuery(name = "Billdetail.findAll", query = "SELECT b FROM Billdetail b"),
    @NamedQuery(name = "Billdetail.findByBilldetailid", query = "SELECT b FROM Billdetail b WHERE b.billdetailid = :billdetailid"),
    @NamedQuery(name = "Billdetail.findByQty", query = "SELECT b FROM Billdetail b WHERE b.qty = :qty"),
    @NamedQuery(name = "Billdetail.findByTotal", query = "SELECT b FROM Billdetail b WHERE b.total = :total")})
public class Billdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "billdetailid")
    private Integer billdetailid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @JoinColumn(name = "billid", referencedColumnName = "billid")
    @ManyToOne(optional = false)
    private Billmaster billid;
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    @ManyToOne(optional = false)
    private Product productid;

    public Billdetail() {
    }

    public Billdetail(Integer billdetailid) {
        this.billdetailid = billdetailid;
    }

    public Billdetail(Integer billdetailid, int qty, int total) {
        this.billdetailid = billdetailid;
        this.qty = qty;
        this.total = total;
    }

    public Integer getBilldetailid() {
        return billdetailid;
    }

    public void setBilldetailid(Integer billdetailid) {
        this.billdetailid = billdetailid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Billmaster getBillid() {
        return billid;
    }

    public void setBillid(Billmaster billid) {
        this.billid = billid;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billdetailid != null ? billdetailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billdetail)) {
            return false;
        }
        Billdetail other = (Billdetail) object;
        if ((this.billdetailid == null && other.billdetailid != null) || (this.billdetailid != null && !this.billdetailid.equals(other.billdetailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Billdetail[ billdetailid=" + billdetailid + " ]";
    }
    
}
