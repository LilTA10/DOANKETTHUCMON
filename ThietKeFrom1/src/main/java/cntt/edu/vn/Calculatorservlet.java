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
@WebServlet(name = "CalculatorServlet", urlPatterns = {"/CalculatorServlet"})
public class Calculatorservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Kết quả tính tổng</title></head>");
        out.println("<body>");
        out.println("<h2>KẾT QUẢ TÍNH TỔNG</h2>");

        try {
            // Lấy giá trị chuỗi gửi từ Form và chuyển đổi sang kiểu số (double)
            double a = Double.parseDouble(request.getParameter("soA"));
            double b = Double.parseDouble(request.getParameter("soB"));
            double tong = a + b;

            out.println("<p>Số a = <b>" + a + "</b></p>");
            out.println("<p>Số b = <b>" + b + "</b></p>");
            out.println("<h3>Tổng (a + b) = <span style='color:red;'>" + tong + "</span></h3>");
        } catch (NumberFormatException e) {
            out.println("<p style='color:red;'>Lỗi: Vui lòng nhập số hợp lệ!</p>");
        }

        out.println("<br><a href='calculator.html'>Quay lại trang tính</a>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Chuyển hướng về trang nhập nếu truy cập trực tiếp bằng GET
        response.sendRedirect("calculator.html");
    }
}
