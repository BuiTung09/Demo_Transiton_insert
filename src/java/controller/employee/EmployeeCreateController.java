/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.employee;

import controller.auth.BaseRBACController;
import controller.auth.BaseRequiredAuthenticationController;
import dal.DepartmentDBContext;
import dal.EmployeeDBContext;
import model.auth.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Department;
import model.Employee;
import java.sql.Date;

/**
 *
 * @author sonnt-local hand-some
 */
public class EmployeeCreateController extends BaseRBACController {
   
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doAuthorizedGet(HttpServletRequest request, HttpServletResponse response, User account)
    throws ServletException, IOException {
        DepartmentDBContext db = new DepartmentDBContext();
        ArrayList<Department> depts = db.list();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("../view/employee/create.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doAuthorizedPost(HttpServletRequest request, HttpServletResponse response, User account)
    throws ServletException, IOException {
        //read parameters
        String raw_name = request.getParameter("name");
        String raw_dob = request.getParameter("dob");
        String raw_gender = request.getParameter("gender");
        String raw_address = request.getParameter("address");
        String raw_did = request.getParameter("did");
        
        //validate data
        
        //object binding
        Employee e = new Employee();
        e.setName(raw_name);
        e.setGender(raw_gender.equals("male"));
        e.setDob(Date.valueOf(raw_dob));
        e.setAddress(raw_address);
        
        Department d = new Department();
        d.setId(Integer.parseInt(raw_did));
        e.setDept(d);
        
        e.setCreatedby(account);
        //save data
        EmployeeDBContext db = new EmployeeDBContext();
        db.insert(e);
        //response to user
        response.getWriter().println("New Eid:" + e.getId());
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
