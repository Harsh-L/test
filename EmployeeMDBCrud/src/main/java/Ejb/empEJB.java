/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Ejb;

import WEBEntity.Employeetb;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Bhatt Jaimin
 */
@Stateless
public class empEJB implements empEJBLocal {

    @PersistenceContext(unitName = "jpaEMP")
    EntityManager em;
    @Override
    public List<Employeetb> getall() {
        List<Employeetb> emplist;
     emplist= em.createNamedQuery("Employeetb.findAll").getResultList();
     return emplist;
    }

    @Override
    public void addEmployee(Employeetb emp) {
        em.persist(emp);
    }

    @Override
    public void updateEmployee(Employeetb emp) {
        em.merge(emp);
    }

    @Override
    public void delete(int empid) {
        em.remove(em.find(Employeetb.class, empid));
    }

   
}
