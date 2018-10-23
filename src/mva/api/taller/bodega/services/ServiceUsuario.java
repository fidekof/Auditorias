package mva.api.taller.bodega.services;

import mva.api.taller.bodega.bo.BoUsuario;
import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.interfaces.InterfaceUsuario;
import mva.api.taller.bodega.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ServiceUsuario implements InterfaceUsuario {

    @Override
    public Collection<Usuario> ConsUserGet(Usuario user, String cedula) {
        return (new BoUsuario()).UserConsultGet(user, (new ConexionJde()), cedula);
    }

    @Override
    public String SaveUser(String cedula, String longname, String codjde, String codperf, String descperf) {
        return (new BoUsuario()).SavedUser((new ConexionJde()), cedula, longname, codjde, codperf, descperf);
    }

    @Override
    public String UpdateUser(String cedula, String longname, String codjde, String codperf, String descperf) {
        return (new BoUsuario()).UpdatedUser((new ConexionJde()), cedula, longname, codjde, codperf, descperf);
    }

    @Override
    public String DeleteUser(String cedula) {
        return (new BoUsuario()).DeletedUser((new ConexionJde()), cedula);
    }

    @Override
    public Collection<Usuario> ConsUser(Usuario user, String cedula) {
        return (new BoUsuario()).UserConsultOne(user, (new ConexionJde()), cedula);
    }

    @Override
    public Collection<Usuario> ConsALLUser() {
        return (new BoUsuario()).UserConsultALL((new ConexionJde()));
    }
}
