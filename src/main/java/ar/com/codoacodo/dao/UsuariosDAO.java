package ar.com.codoacodo.dao;

import java.util.ArrayList;

import ar.com.codoacodo.domain.Usuarios;

public interface UsuariosDAO {

    public Usuarios getById(Long id_usuario);
    public void create(Usuarios UsuariosDto);
    public ArrayList<Usuarios> findAll();
	public void update(Usuarios usuarios);
    public void delete(Long id_usuario);
}