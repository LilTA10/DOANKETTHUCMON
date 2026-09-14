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
@WebServlet(name = "CalculationServlet", urlPatterns = {"/CalculationServlet"})
public class CalculateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Kết quả tính toán</title></head>");
        out.println("<body>");
        out.println("<h2>KẾT QUẢ TÍNH TOÁN</h2>");

        try {
            double a = Double.parseDouble(request.getParameter("soA"));
            double b = Double.parseDouble(request.getParameter("soB"));
            String phepToan = request.getParameter("phepToan");
            
            double ketQua = 0;
            boolean hopLe = true;
            String thongBaoLoi = "";

            switch (phepToan) {
                case "+":
                    ketQua = a + b;
                    break;
                case "-":
                    ketQua = a - b;
                    break;
                case "*":
                    ketQua = a * b;
                    break;
                case "/":
                    // Kiểm tra trường hợp chia cho 0
                    if (b == 0) {
                        hopLe = false;
                        thongBaoLoi = "Không thể chia cho 0!";
                    } else {
                        ketQua = a / b;
                    }
                    break;
                default:
                    hopLe = false;
                    thongBaoLoi = "Phép toán không hợp lệ!";
            }

            if (hopLe) {
                out.println("<p>Số a: <b>" + a + "</b></p>");
                out.println("<p>Số b: <b>" + b + "</b></p>");
                out.println("<p>Phép toán: <b>" + phepToan + "</b></p>");
                out.println("<h3>Kết quả: <span style='color:green;'>" + ketQua + "</span></h3>");
            } else {
                out.println("<h3 style='color:red;'>Lỗi: " + thongBaoLoi + "</h3>");
            }

        } catch (NumberFormatException e) {
            out.println("<h3 style='color:red;'>Lỗi: Vui lòng nhập số hợp lệ!</h3>");
        }

        out.println("<br><a href='tinhtoan.html'>Quay lại</a>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("tinhtoan.html");
    }
}
