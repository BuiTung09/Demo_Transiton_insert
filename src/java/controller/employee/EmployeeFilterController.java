/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.employee;

import dal.DepartmentDBContext;
import dal.EmployeeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import model.Department;
import model.Employee;

/**
 *
 * @author sonnt-local hand-some
 */
public class EmployeeFilterController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String raw_id = request.getParameter("id");
        String raw_name = request.getParameter("name");
        String raw_gender = request.getParameter("gender");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String raw_address = request.getParameter("address");
        String raw_did = request.getParameter("did");
        
        //validate data - regular expression (XSS,SQL Injection, Command Injection, Business Rules)
        
        Integer id = (raw_id!=null)&&(!raw_id.isBlank())
                ?Integer.parseInt(raw_id):null;
        String name = raw_name;
        Boolean gender = (raw_gender!=null)&&(!raw_gender.equals("both"))
                ?raw_gender.equals("male"):null;
        Date from = (raw_from!=null)&&(!raw_from.isBlank())
                ?Date.valueOf(raw_from):null;
        Date to = (raw_to!=null)&&(!raw_to.isBlank())
                ?Date.valueOf(raw_to):null;
        String adress = raw_address;
        Integer did = (raw_did!=null) && (!raw_did.equals("-1"))
                ?Integer.parseInt(raw_did): null;
        
        EmployeeDBContext dbEmp = new EmployeeDBContext();
        ArrayList<Employee> emps = dbEmp.search(id, name, gender, from, to, adress, did);
        DepartmentDBContext dbDept = new DepartmentDBContext();
        ArrayList<Department> depts = dbDept.list();
        
        
        request.setAttribute("depts", depts);
        request.setAttribute("emps", emps);
        
        request.getRequestDispatcher("../view/employee/filter.jsp").forward(request, response);
            
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
