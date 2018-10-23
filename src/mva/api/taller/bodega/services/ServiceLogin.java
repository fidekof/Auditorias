package mva.api.taller.bodega.services;

import mva.api.taller.bodega.bo.BoLogin;
import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.interfaces.InterfaceLogin;
import mva.api.taller.bodega.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ServiceLogin implements InterfaceLogin {

    @Override
    public Collection<Usuario> UserTypeSearch(Usuario user, String usuario, String password) {
        return (new BoLogin()).UserGet(user, (new ConexionJde()), usuario, password);
    }


}
