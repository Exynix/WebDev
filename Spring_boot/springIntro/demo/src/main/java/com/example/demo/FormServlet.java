package com.example.demo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MimeTypeUtils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class FormServlet extends HttpServlet {

    Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{

        response.setHeader(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_HTML_VALUE);

        response.setStatus(300);
        response.setHeader(HttpHeaders.LOCATION, "/hola");
        
        ServletOutputStream out = response.getOutputStream();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Formulario</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Formulario</h1>");
        out.println("<form action='/form-proc' method='GET'>");
        out.println("<input type='text' name='nombre'>");
        out.println("<button>Enviar formulario</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
