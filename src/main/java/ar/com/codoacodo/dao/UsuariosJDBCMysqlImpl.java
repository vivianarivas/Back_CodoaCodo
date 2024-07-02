package ar.com.codoacodo.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import ar.com.codoacodo.domain.Usuarios;

public class UsuariosJDBCMysqlImpl implements UsuariosDAO{

    @Override
    public Usuarios getById(Long id) {        
        String sql = "SELECT * FROM usuarios WHERE id_usuario = "+id;

        Usuarios usuario = null;
        Connection connection = null;
        try{
            //Conexion a la base
            connection = AdministradorDeConexiones.conectar();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            if(resultset.next()) {
                Long id_usr = resultset.getLong(1);
                String nombre = resultset.getString(2);
                String apellido = resultset.getString(3);
                String email = resultset.getString(4);
                String pass = resultset.getString(5);
                
                usuario = new Usuarios(id_usr, nombre, apellido, email, pass);
            }
        }catch(Exception e) {
            System.err.println(e);
        } finally {
            //siempre: cierro conexion
            AdministradorDeConexiones.desconectar(connection);
        }
        return usuario;
    }

    @Override
    public void create(Usuarios UsuariosDto) {
        String sql = "INSERT INTO usuarios (nombre, apellido, email, pass) values(?,?,?,?)";
        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, UsuariosDto.getNombre());
            pst.setString(2, UsuariosDto.getApellido());
            pst.setString(3, UsuariosDto.getEmail());
            pst.setString(4, UsuariosDto.getPass());
            
            pst.executeUpdate();
            if(pst.getUpdateCount() > 0) {
                System.out.println("Usuario Agregado Correctamente!!");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            AdministradorDeConexiones.desconectar(connection);
        }        
    }

    @Override
    public ArrayList<Usuarios> findAll() {
        
        String sql = "SELECT * FROM usuarios"; 

        ArrayList<Usuarios> listaDeUsuarios = new ArrayList<>();
        Connection connection = null;
        try{
            
            connection = AdministradorDeConexiones.conectar();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            while(resultset.next()) {
                Long id = resultset.getLong(1);
                String nombre = resultset.getString(2);
                String apellido = resultset.getString(3);
                String email = resultset.getString(4);
                String pass = resultset.getString(5);
                

                Usuarios unUsuario = new Usuarios(id, nombre, apellido, email, pass);
                listaDeUsuarios.add(unUsuario);
            }
        }catch(Exception e) {
            System.err.println(e);
        } finally {
            //siempre: cierro conexion
            AdministradorDeConexiones.desconectar(connection);
        }

        return listaDeUsuarios;
    }

    @Override
    public void update(Usuarios usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, pass = ? WHERE id_usuario = ?";

        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getPass());
            
            pst.setLong(5, usuario.getId_usuario());

            pst.executeUpdate();
            if(pst.getUpdateCount() > 0) {
                System.out.println("El Usuario se Actualizo correctamente");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            AdministradorDeConexiones.desconectar(connection);
        }    
    }

    @Override
    public void delete(Long id_usuario) {
       
        String sql = "DELETE FROM usuarios where id_usuario = ?";
    
        Connection connection = AdministradorDeConexiones.conectar();
    
            try {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setLong(1, id_usuario);
    
                pst.executeUpdate();
                if(pst.getUpdateCount() == 0) {
                    throw new RuntimeException("No se pudo eliminar el Usuario");
                }
            }catch(Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally {
                AdministradorDeConexiones.desconectar(connection);
            } 
    }
    
}
