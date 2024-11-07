package org.example.listexpendeces;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String list;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        list = "";
        FileReader reader = new FileReader("List.txt");
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) > 0) {
            if (numRead > 0) {
                list += new String(buf, 0, numRead);
            }
        }
        reader.close();
        PrintWriter out = response.getWriter();
        out.println(list);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String text = request.getParameter("textField");
        Integer price = Integer.valueOf(request.getParameter("price"));

        FileWriter write = new FileWriter("List.txt", true);
        write.write(price + " : " + text + "\n");
        write.close();

        doGet(request, response);
    }

    public void destroy() {
    }
}