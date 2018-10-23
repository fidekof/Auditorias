package mva.api.taller.bodega.interfaces;

import mva.api.taller.bodega.models.Usuario;

import java.util.Collection;

public interface InterfaceUsuario {
    public Collection<Usuario> ConsUserGet(Usuario user, String cedula);

    public String SaveUser(String cedula, String longname, String codjde, String codperf, String desperf);

    public String UpdateUser(String cedula, String longname, String codjde, String codperf, String desperf);

    public String DeleteUser(String cedula);

    public Collection<Usuario> ConsUser(Usuario user, String cedula);

    public Collection<Usuario> ConsALLUser();
}

