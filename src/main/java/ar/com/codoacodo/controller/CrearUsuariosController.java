package ar.com.codoacodo.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import ar.com.codoacodo.dto.UsuariosDTO;
import ar.com.codoacodo.service.UsuariosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/CrearUsuariosController")
public class CrearUsuariosController extends HttpServlet {

    protected void doPost(
        HttpServletRequest req,//aca viene todo desde el front
        HttpServletResponse resp//aca respondemos al front
    ) throws ServletException, IOException {

        
        String json = req.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));
            
        
        ObjectMapper mapper = new ObjectMapper();

        UsuariosDTO usuarioDto = mapper.readValue(json, UsuariosDTO.class);

        UsuariosService service = new UsuariosService();

        System.out.println(usuarioDto);

        service.crear(usuarioDto);

        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

}
