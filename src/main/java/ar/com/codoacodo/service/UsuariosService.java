package ar.com.codoacodo.service;

import java.util.ArrayList;

import ar.com.codoacodo.dao.UsuariosDAO;
import ar.com.codoacodo.dao.UsuariosJDBCMysqlImpl;
import ar.com.codoacodo.domain.Usuarios;
import ar.com.codoacodo.dto.UsuariosDTO;

public class UsuariosService {
    
    private UsuariosDAO dao;

    public UsuariosService() {
        //Interface i = new ClaseQueImplementaLaInterface();
        this.dao = new UsuariosJDBCMysqlImpl();
    }

    public Usuarios obtener(Long id) {
        return this.dao.getById(id);
    }

    public void crear(UsuariosDTO dto) {

        Usuarios usuario = new Usuarios(
            dto.getNombre(), 
            dto.getApellido(),            
            dto.getEmail(),
            dto.getPass());

        this.dao.create(usuario);
    }

    public ArrayList<Usuarios> listarUsuarios() {
        return this.dao.findAll();
    }

    public void actualizar(UsuariosDTO dto) {
        Usuarios usuario = new Usuarios(
            dto.getId_usuario(),
            dto.getNombre(), 
            dto.getApellido(),            
            dto.getEmail(),
            dto.getPass());
        this.dao.update(usuario);
    }

    public void eliminar(Long id) {
       this.dao.delete(id);
    }
}
