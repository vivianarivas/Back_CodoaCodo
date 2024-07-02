package ar.com.codoacodo.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import ar.com.codoacodo.domain.Usuarios;
import ar.com.codoacodo.dto.UsuariosDTO;
import ar.com.codoacodo.service.UsuariosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/ActualizarUsuariosController")
public class ActualizarUsuariosController extends HttpServlet {
    @Override
    protected void doPut(
        HttpServletRequest req, // acá viene todo desde el front
        HttpServletResponse resp // acá respondemos al front
    ) throws ServletException, IOException {

        // Leer el JSON enviado en el cuerpo de la solicitud
        String json = req.getReader()
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));

        // Convertir el JSON a un objeto UsuariosDTO
        ObjectMapper mapper = new ObjectMapper();
        UsuariosDTO usuarioDto = mapper.readValue(json, UsuariosDTO.class);

        // Crear una instancia del servicio de usuarios
        UsuariosService service = new UsuariosService();

        // Imprimir el usuario DTO recibido
        System.out.println(usuarioDto);

        // Actualizar el usuario
        service.actualizar(usuarioDto);

        // Obtener el usuario actualizado y enviarlo de vuelta como respuesta
        Usuarios actualizado = service.obtener(usuarioDto.getId_usuario());
        String jsonResponse = mapper.writeValueAsString(actualizado);

        // Configurar la respuesta
        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write(jsonResponse);
    }
}
