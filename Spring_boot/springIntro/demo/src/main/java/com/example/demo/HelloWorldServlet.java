package com.example.demo;

import java.io.IOException;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hola")
public class HelloWorldServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{

        ServletOutputStream out = response.getOutputStream();


        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hola Mundo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Referencia</h1>");
        out.println("<a href='/reference'>Pagina referenciada</a><br>");
        out.println("<a href='/download'>Descargar pagina</a><br>");
        out.println("<a href='/redirect'>Redireccionar</a><br>");
        out.println("<a href='/cookies'>Cookies</a><br>");
        out.println("<a href='/form'>formulario</a><br>");
        out.println("</body>");
        out.println("</html>");
    }
}
