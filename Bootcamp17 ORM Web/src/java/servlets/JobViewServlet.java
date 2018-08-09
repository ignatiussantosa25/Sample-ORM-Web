/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.JobController;
import entities.Job;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tools.HibernateUtil;

/**
 *
 * @author Ignatius
 */
@WebServlet(name = "JobViewServlet", urlPatterns = {"/jobViewServlet"})
public class JobViewServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        RequestDispatcher requestDispatcher = null;
        JobController jobController = new JobController(HibernateUtil.getSessionFactory());
        try (PrintWriter out = response.getWriter()) {
            session.setAttribute("message", jobController.getAll());
            requestDispatcher = request.getRequestDispatcher("views/cobaView.jsp");
            
            requestDispatcher.forward(request, response);
//            JobController jc = new JobController(HibernateUtil.getSessionFactory());
//            out.println("<h1>Data Jobs with Servlet</h1>");
//            int i = 1;
//            for (Job job : jc.getAll()) {
//                out.println(i+". "+job.getJobId() + " - "+job.getJobTitle()+", has salaries between USD "+job.getMinSalary()+ " and "+job.getMaxSalary());
//                out.println("<hr>");
//                i++;
//            }


//            out.print("test jalan");
//
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/jobView.jsp");
//
////            requestDispatcher.forward(request, response);
//            requestDispatcher.include(request, response);

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
