/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Ejb;

import WEBEntity.Employeetb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bhatt Jaimin
 */
@Local
public interface empEJBLocal {
    public List<Employeetb> getall();
    public void addEmployee(Employeetb emp);
    public void updateEmployee(Employeetb emp);
    public void delete(int empid);
}
