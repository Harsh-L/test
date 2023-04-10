/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author ritesh
 */
@Entity
@Table(name = "billmaster")
@NamedQueries({
    @NamedQuery(name = "Billmaster.findAll", query = "SELECT b FROM Billmaster b"),
    @NamedQuery(name = "Billmaster.findByBillid", query = "SELECT b FROM Billmaster b WHERE b.billid = :billid"),
    @NamedQuery(name = "Billmaster.findByGrosstotal", query = "SELECT b FROM Billmaster b WHERE b.grosstotal = :grosstotal")})
public class Billmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "billid")
    private Integer billid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grosstotal")
    private int grosstotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billid")
    private List<Billdetail> billdetailList;
    @JoinColumn(name = "custid", referencedColumnName = "custid")
    @ManyToOne(optional = false)
    private Customer custid;

    public Billmaster() {
    }

    public Billmaster(Integer billid) {
        this.billid = billid;
    }

    public Billmaster(Integer billid, int grosstotal) {
        this.billid = billid;
        this.grosstotal = grosstotal;
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public int getGrosstotal() {
        return grosstotal;
    }

    public void setGrosstotal(int grosstotal) {
        this.grosstotal = grosstotal;
    }

    public List<Billdetail> getBilldetailList() {
        return billdetailList;
    }

    public void setBilldetailList(List<Billdetail> billdetailList) {
        this.billdetailList = billdetailList;
    }

    public Customer getCustid() {
        return custid;
    }

    public void setCustid(Customer custid) {
        this.custid = custid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billid != null ? billid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billmaster)) {
            return false;
        }
        Billmaster other = (Billmaster) object;
        if ((this.billid == null && other.billid != null) || (this.billid != null && !this.billid.equals(other.billid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Billmaster[ billid=" + billid + " ]";
    }
    
}
