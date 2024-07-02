package ar.com.codoacodo.domain;

public class Usuarios {
    private Long id_usuario;
    private String nombre;
    private String apellido;    
    private String email;
    private String pass;

    //Constructores
    public Usuarios(Long id_usuario,String nombre,String apellido,String email,String pass){
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pass = pass;
    }
    
    public Usuarios(String nombre,String apellido,String email,String pass){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pass = pass;
    }

    
    //Setters y Getters

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //toString
    @Override
    public String toString() {
        return "Usuarios [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email="
                + email + ", pass=" + pass + "]";
    }


}
