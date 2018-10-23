package mva.api.taller.bodega.bo;

import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.dao.DaoLogin;
import mva.api.taller.bodega.models.Usuario;

import java.util.ArrayList;

public class BoLogin {
    public ArrayList<Usuario> UserGet(Usuario user, ConexionJde conexionMotorec, String usuario, String password) {
        ArrayList<Usuario> userArrayList = new ArrayList<Usuario>();
        if (conexionMotorec != null) {
            try {
                DaoLogin daoLogin = new DaoLogin();
                userArrayList = daoLogin.UserGetDAO(user, conexionMotorec, usuario, password);
            } catch (Exception e) {
                return userArrayList;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return userArrayList;
    }

}
