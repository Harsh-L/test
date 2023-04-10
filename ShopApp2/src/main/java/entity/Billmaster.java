/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "billmaster")
@NamedQueries({
    @NamedQuery(name = "Billmaster.findAll", query = "SELECT b FROM Billmaster b"),
    @NamedQuery(name = "Billmaster.findByBid", query = "SELECT b FROM Billmaster b WHERE b.bid = :bid"),
    @NamedQuery(name = "Billmaster.findByGrandtotal", query = "SELECT b FROM Billmaster b WHERE b.grandtotal = :grandtotal")})
public class Billmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bid")
    private Integer bid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "grandtotal")
    private Double grandtotal;
    @OneToMany(mappedBy = "bid")
    private Collection<Billdetail> billdetailCollection;
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne
    private Cust cid;

    public Billmaster() {
    }

    public Billmaster(Integer bid) {
        this.bid = bid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Double getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(Double grandtotal) {
        this.grandtotal = grandtotal;
    }

    public Collection<Billdetail> getBilldetailCollection() {
        return billdetailCollection;
    }

    public void setBilldetailCollection(Collection<Billdetail> billdetailCollection) {
        this.billdetailCollection = billdetailCollection;
    }

    public Cust getCid() {
        return cid;
    }

    public void setCid(Cust cid) {
        this.cid = cid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billmaster)) {
            return false;
        }
        Billmaster other = (Billmaster) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Billmaster[ bid=" + bid + " ]";
    }
    
}
