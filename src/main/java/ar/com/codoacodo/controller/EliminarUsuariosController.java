package ar.com.codoacodo.controller;

import java.io.IOException;

import ar.com.codoacodo.service.UsuariosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarUsuariosController")
public class EliminarUsuariosController extends HttpServlet{
        
        @Override
        protected void doDelete(
            HttpServletRequest req,//aca viene lo del front
            HttpServletResponse resp//aca se manda al front
        ) throws ServletException, IOException {
    
            //capturo el id que viene desde el front
            String id = req.getParameter("id_usuario");
    
            UsuariosService service = new UsuariosService();
    
            Long idLong = Long.parseLong(id);
    
            service.eliminar(idLong);
    
            resp.setStatus(HttpServletResponse.SC_OK);
        } 
      
}
