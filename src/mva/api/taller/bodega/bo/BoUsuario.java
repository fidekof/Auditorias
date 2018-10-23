package mva.api.taller.bodega.bo;

import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.dao.DaoUsuario;
import mva.api.taller.bodega.models.Usuario;

import java.util.ArrayList;

public class BoUsuario {
    public ArrayList<Usuario> UserConsultGet(Usuario user, ConexionJde conexionJDE, String cedula) {
        ArrayList<Usuario> userArrayList = new ArrayList<Usuario>();
        if (conexionJDE != null) {
            try {
                DaoUsuario daousuario = new DaoUsuario();
                userArrayList = daousuario.UserConsGetDAO(user, conexionJDE, cedula);
            } catch (Exception e) {
                return userArrayList;
            } finally {
                conexionJDE.desconectarJD();
            }
        }
        return userArrayList;
    }

    public String SavedUser(ConexionJde conexionMotorec, String cedula, String longname, String codjde, String codperf, String desperf) {
        String result = "ERROR";
        if (conexionMotorec != null) {
            try {
                DaoUsuario daousuario = new DaoUsuario();
                result = daousuario.UserSavedDAO(conexionMotorec, cedula, longname, codjde, codperf, desperf);
            } catch (Exception e) {
                return result;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return result;
    }

    public String UpdatedUser(ConexionJde conexionMotorec, String cedula, String longname, String codjde, String codperf, String desperf) {
        String result = "ERROR";
        if (conexionMotorec != null) {
            try {
                DaoUsuario daousuario = new DaoUsuario();
                result = daousuario.UpdateUserDAO(conexionMotorec, cedula, longname, codjde, codperf, desperf);
            } catch (Exception e) {
                return result;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return result;
    }

    public String DeletedUser(ConexionJde conexionMotorec, String cedula) {
        String result = "ERROR";
        if (conexionMotorec != null) {
            try {
                DaoUsuario daousuario = new DaoUsuario();
                result = daousuario.DeleteUserDAO(conexionMotorec, cedula);
            } catch (Exception e) {
                return result;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return result;
    }

    public ArrayList<Usuario> UserConsultOne(Usuario user, ConexionJde conexionJDE, String cedula) {
        ArrayList<Usuario> userArrayList = new ArrayList<Usuario>();
        if (conexionJDE != null) {
            try {
                DaoUsuario daousuario = new DaoUsuario();
                userArrayList = daousuario.UserConsOneDAO(user, conexionJDE, cedula);
            } catch (Exception e) {
                return userArrayList;
            } finally {
                conexionJDE.desconectarJD();
            }
        }
        return userArrayList;
    }

    public ArrayList<Usuario> UserConsultALL(ConexionJde conexionJDE) {
        ArrayList<Usuario> userArrayList = new ArrayList<Usuario>();
        if (conexionJDE != null) {
            try {
                DaoUsuario daousuario = new DaoUsuario();
                userArrayList = daousuario.UserConsAllDAO(conexionJDE);
            } catch (Exception e) {
                return userArrayList;
            } finally {
                conexionJDE.desconectarJD();
            }
        }
        return userArrayList;
    }
}
