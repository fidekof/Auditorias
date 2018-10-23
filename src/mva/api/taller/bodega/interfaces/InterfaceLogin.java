package mva.api.taller.bodega.interfaces;

import mva.api.taller.bodega.models.Usuario;

import java.util.Collection;

public interface InterfaceLogin {
    public Collection<Usuario> UserTypeSearch(Usuario user, String usuario, String password);

}

