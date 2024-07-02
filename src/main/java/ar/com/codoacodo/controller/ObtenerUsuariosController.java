package ar.com.codoacodo.controller;

import ar.com.codoacodo.domain.Usuarios;
import ar.com.codoacodo.service.UsuariosService;


public class ObtenerUsuariosController {
    public static void main(String[] args) {

        Long idUsuario = 1l;

        UsuariosService service = new UsuariosService();

        Usuarios usuario = service.obtener(idUsuario);

        //mapper > Usuario > UsuariosDTO: TPH
        System.out.println(usuario);
    }
}
