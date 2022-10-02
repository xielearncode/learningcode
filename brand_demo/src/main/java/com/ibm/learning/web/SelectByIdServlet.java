package com.ibm.learning.web; /**
 * @Author 谢飞
 * @Date 2022/9/30 21:21
 */

import com.ibm.learning.dao.BrandMapper;
import com.ibm.learning.entity.Brand;
import com.ibm.learning.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SelectByIdServlet", value = "/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    BrandService brandService = new BrandService();

    public SelectByIdServlet() throws IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Brand brand = brandService.selectById(Integer.parseInt(id));
        request.setAttribute("brand",brand);

        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
