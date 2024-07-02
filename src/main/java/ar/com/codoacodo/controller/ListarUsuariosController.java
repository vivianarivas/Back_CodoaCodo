package ar.com.codoacodo.controller;


import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codoacodo.domain.Usuarios;
import ar.com.codoacodo.service.UsuariosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ListarUsuariosController")
public class ListarUsuariosController extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {       

     //1 crear el service
     UsuariosService service = new UsuariosService();

     //2 ejecuto el metodo
     ArrayList<Usuarios> listado = service.listarUsuarios();

     ObjectMapper mapper = new ObjectMapper();

     //convierto Objecto java a json string
     //ahora respondo al front: json, Convirtiendo el nuevo Clientes a json
     String usuariosJSON = mapper.writeValueAsString(listado);
     
     //mostrar por consola|enviar al frontend
     resp.getWriter().println(usuariosJSON);        

    }
}
