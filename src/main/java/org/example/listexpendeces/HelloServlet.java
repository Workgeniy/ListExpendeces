package org.example.listexpendeces;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    Wallet wallet;

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = new Configuration().configure().buildSessionFactory().openSession();

        List<Wallet> products = session.createQuery("FROM Wallet", Wallet.class).getResultList();

        response.setContentType("text/html");

       PrintWriter content = response.getWriter();
       content.println("<html>");
       content.println("<head>");
       content.println("<title>List products:</title>");
       content.println("</head>");
       content.println("<body>");
       content.println("<h1>List products:</h1>");
       content.println("<ul>");
       for (Wallet product : products) {
           content.println("<li><h3>" + product.quantity + " : " + product.purpose + "<h3></li>");
       }
       content.println("</ul>");
       content.println("</body>");
       content.println("</html>");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String text = request.getParameter("textField");
        Integer price = Integer.valueOf(request.getParameter("price"));

        saveDB(text, price);

       doGet(request, response);
    }

    public void saveDB (String name, Integer price) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        wallet = new Wallet(name, price);


        Transaction transaction = session.beginTransaction();
        session.save(wallet);
        transaction.commit();

    }

    public void destroy() {
    }
}