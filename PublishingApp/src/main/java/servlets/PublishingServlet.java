/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import ejb.PublishingBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "PublishingServlet", urlPatterns = {"/PublishingServlet"})
public class PublishingServlet extends HttpServlet {
    
    @EJB PublishingBeanLocal pbl;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PublishingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
           //pbl.createCustomer("Vivek", "Rawat");
          // pbl.addAddressToCustomer("Y-123", "Surat", "Gujarat", "395001", 10);
          // pbl.addAddressToCustomer("First Str", "Vadodara", "Gujarat", "385001", 10);
           
          Collection<Integer> ids = new ArrayList<>();
          ids.add(3);
          ids.add(4);
          ids.add(5);
          
          //pbl.addSubscriptionsToCustomer(10, ids);
          
          //pbl.removeSubscriptionsFromCustomer(10, ids);
          
//          pbl.removeAddressOfCustomer(6, 10);
//          pbl.removeAddressOfCustomer(7, 10);
          
          
         // pbl.removeCustomer(10);
          
          
          
          
            
            
            Collection<Customer> custs = pbl.getAllCustomers();
           for(Customer c : custs)
           {
              out.println("<br/> id : "+ c.getCustomerID()+ " Name : "+ c.getFirstName()+ " "+ c.getLastName());
             
              Collection<Address> addresses = pbl.getAddressesOfCustomer(c.getCustomerID());
              
              for(Address a : addresses)
              {
                   out.println("<br/> aid : "+ a.getAddressId()+ " Street : "+ a.getStreet()+ " City : "+ a.getCity());
             
             
              }
              
              Collection<Subscription> subs = pbl.getSubscriptionsOfCustomer(c.getCustomerID());
              
              for(Subscription s : subs)
              {
                   out.println("<br/> sid : "+ s.getSubscriptionId()+ " Title : "+ s.getTitle()+ " Type : "+ s.getType());
             
              }
              
              
              out.println("<hr/>");
               
           }
            
            
            
            
            
            
            out.println("<h1>Servlet PublishingServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
