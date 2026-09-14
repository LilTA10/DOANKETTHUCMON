/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cntt.edu.vn;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC-31
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Lấy thông tin tài khoản từ Form gửi lên
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Kết quả đăng nhập</title></head>");
        out.println("<body>");

        // Kiểm tra điều kiện: admin / 123
        if ("admin".equals(username) && "123".equals(password)) {
            out.println("<h2 style='color:green;'>Đăng nhập thành công</h2>");
            out.println("<p>Xin chào, <b>" + username + "</b>!</p>");
        } else {
            out.println("<h2 style='color:red;'>Tên đăng nhập hoặc mật khẩu không đúng</h2>");
            out.println("<br><a href='login.html'>Thử lại</a>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Tự động chuyển về trang login nếu truy cập trực tiếp bằng phương thức GET
        response.sendRedirect("login.html");
    }
}
