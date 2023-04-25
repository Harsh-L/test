/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WEBEntity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Bhatt Jaimin
 */
@Entity
@Table(name = "employeetb")
@NamedQueries({
    @NamedQuery(name = "Employeetb.findAll", query = "SELECT e FROM Employeetb e"),
    @NamedQuery(name = "Employeetb.findByEmpid", query = "SELECT e FROM Employeetb e WHERE e.empid = :empid"),
    @NamedQuery(name = "Employeetb.findByName", query = "SELECT e FROM Employeetb e WHERE e.name = :name"),
    @NamedQuery(name = "Employeetb.findByEmail", query = "SELECT e FROM Employeetb e WHERE e.email = :email"),
    @NamedQuery(name = "Employeetb.findByPhone", query = "SELECT e FROM Employeetb e WHERE e.phone = :phone"),
    @NamedQuery(name = "Employeetb.findByDesignation", query = "SELECT e FROM Employeetb e WHERE e.designation = :designation"),
    @NamedQuery(name = "Employeetb.findByAddress", query = "SELECT e FROM Employeetb e WHERE e.address = :address")})
public class Employeetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empid")
    private Integer empid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phone")
    private long phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;

    public Employeetb() {
    }

    public Employeetb(Integer empid) {
        this.empid = empid;
    }

    public Employeetb(Integer empid, String name, String email, long phone, String designation, String address) {
        this.empid = empid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
        this.address = address;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empid != null ? empid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeetb)) {
            return false;
        }
        Employeetb other = (Employeetb) object;
        if ((this.empid == null && other.empid != null) || (this.empid != null && !this.empid.equals(other.empid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WEBEntity.Employeetb[ empid=" + empid + " ]";
    }
    
}
