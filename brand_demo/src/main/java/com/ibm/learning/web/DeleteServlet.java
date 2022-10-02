package com.ibm.learning.web; /**
 * @Author 谢飞
 * @Date 2022/9/30 22:20
 */

import com.ibm.learning.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/deleteServlet")
public class DeleteServlet extends HttpServlet {
    BrandService brandService = new BrandService();

    public DeleteServlet() throws IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        brandService.deleteById(Integer.parseInt(id));

        request.getRequestDispatcher("/selectAllServlet").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
