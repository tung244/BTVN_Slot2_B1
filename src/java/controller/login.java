package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="login", urlPatterns={"/login"})
public class login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet hello</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet hello at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String email = request.getParameter("email");
        String pass = request.getParameter("pw");
        String confirm = request.getParameter("confirm");
        String adUser = "admin";
        String adPass = "123";
        String customUser = "custom";
        String customPass = "321";
        String ms = "";
        PrintWriter out = response.getWriter();
        if(username.isBlank()||email.isBlank()||pass.isBlank()){
             ms+="Yêu cầu điền thông tin";
         }
//        else if(!pass.equals(confirm)){
//            ms+= "Pass and confirm must be the same value";
//        }
        
        else if(username.equalsIgnoreCase(adUser) && !pass.equals(adPass)){
            request.getRequestDispatcher("forgetpass.html").forward(request, response);
        }
        else if(!username.equalsIgnoreCase(customUser) || pass.equals(customPass)){
            ms+="Tài khoản hoặc mật khẩu không chính xác";
        }    
        else{
            request.getRequestDispatcher("home.html").forward(request, response);
        }
        out.append("<div><h1 style=\"color: red;\">"+ms+"</h1></div>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
