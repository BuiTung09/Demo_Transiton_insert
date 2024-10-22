/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.employee;

import controller.auth.BaseRBACController;
import controller.auth.BaseRequiredAuthenticationController;
import model.auth.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Employee;
import dal.EmployeeDBContext;

/**
 *
 * @author sonnt-local
 */
public class EmployeeListController extends BaseRBACController {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp, User account) throws ServletException, IOException {
        EmployeeDBContext db = new EmployeeDBContext();
        ArrayList<Employee> emps = db.list();
        req.setAttribute("emps", emps);
        req.getRequestDispatcher("../view/employee/list.jsp").forward(req, resp);
    
    
    }
    @Override
    protected void doAuthorizedGet(HttpServletRequest req, HttpServletResponse resp, User account) throws ServletException, IOException {
        processRequest(req, resp, account);
    }

    @Override
    protected void doAuthorizedPost(HttpServletRequest req, HttpServletResponse resp, User account) throws ServletException, IOException {
        processRequest(req, resp, account);
    }
    
}
