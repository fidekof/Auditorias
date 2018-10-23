package mva.api.taller.bodega.dao;

import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.models.Tools;
import mva.api.taller.bodega.models.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoUsuario {
    public static final int ALL_BY_BODEGA = 1;
    public static final int ALL_BY_BODEGA_AND_PRODUCTCODE = 2;
    public static final int ALL_BY_BODEGA_AND_UBICACIONES = 3;
    public static final int ALL_BY_BODEGA_UDITORIA = 4;

    public ArrayList<Usuario> UserConsGetDAO(Usuario user, ConexionJde conexionJde, String cedula) {
        return this.getUserConsultjde(user, cedula, conexionJde);
    }

    public String UserSavedDAO(ConexionJde conexionJde, String cedula, String longname, String codjde, String codperf, String desperf) {
        return this.setUser(cedula, longname, codjde, codperf, desperf, conexionJde);
    }

    public String UpdateUserDAO(ConexionJde conexionJde, String cedula, String longname, String codjde, String codperf, String desperf) {
        return this.UpdateUser(conexionJde, cedula, longname, codjde, codperf, desperf);
    }

    public String DeleteUserDAO(ConexionJde conexionJde, String cedula) {
        return this.DeleteUser(conexionJde, cedula);
    }

    public ArrayList<Usuario> UserConsOneDAO(Usuario user, ConexionJde conexionJde, String cedula) {
        return this.getUserConsultOne(user, cedula, conexionJde);
    }

    public ArrayList<Usuario> UserConsAllDAO(ConexionJde conexionJde) {
        return this.getUserConsultALL(conexionJde);
    }

    private ArrayList<Usuario> getUserConsultjde(Usuario user, String cedula, ConexionJde conexionJde) {

        ArrayList<Usuario> usertArrayList = new ArrayList<Usuario>();
        String sentencia = "";
        String where = " ";
        String sql = "";
        sql = Usuario.SELECT_USER_JDE;
        where = " WHERE TRIM(F0101.ABTAX) = '" + cedula + "'";
        sentencia = sql + where;
        if (cedula != null && cedula != null) {
            usertArrayList = getUserConsFromOpen(sentencia, conexionJde);
        }
        return usertArrayList;
    }

    private ArrayList<Usuario> getUserConsultOne(Usuario user, String cedula, ConexionJde conexionMotorex) {

        ArrayList<Usuario> usertArrayList = new ArrayList<Usuario>();
        String sentencia = "";
        String where = " ";
        String sql = "";
        sql = Usuario.SELECT_USER_ONE;
        where = " WHERE U.USER_CEDULA='" + cedula + "'";
        sentencia = sql + where;
        if (cedula != null && cedula != null) {
            usertArrayList = getUserConsOneFromOpen(sentencia, conexionMotorex);
        }
        return usertArrayList;
    }

    private ArrayList<Usuario> getUserConsultALL(ConexionJde conexionMotorex) {

        ArrayList<Usuario> usertArrayList = new ArrayList<Usuario>();
        String sentencia = "";
        String where = " ";
        String sql = "";
        sql = Usuario.SELECT_USER_ALL;
        sentencia = sql;
        usertArrayList = getUserConsALLFromOpen(sentencia, conexionMotorex);
        return usertArrayList;
    }

    private ArrayList<Usuario> getUserConsFromOpen(String sql, ConexionJde conexionJde) {

        ArrayList<Usuario> UserArrayList = new ArrayList<Usuario>();
        Statement stmt;
        try {
            stmt = conexionJde.getConexionJde().getCon().createStatement();
            ResultSet rsu = stmt.executeQuery(sql);
            if (rsu != null) {
                Usuario user;
                if (rsu.next()) {
                    user = new Usuario();
                    user.setLastname(Tools.cleanString(rsu.getString("USER_LONG_NAME")));
                    user.setCedula(Tools.cleanString(rsu.getString("USER_CEDULA")));
                    user.setCodigoJde(Tools.cleanString(rsu.getString("USER_AN8")));
                    UserArrayList.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            UserArrayList.add(new Usuario());
        } finally {
            return UserArrayList;
        }
    }

    private ArrayList<Usuario> getUserConsOneFromOpen(String sql, ConexionJde conexionJde) {

        ArrayList<Usuario> UserArrayList = new ArrayList<Usuario>();
        Statement stmt;
        try {
            stmt = conexionJde.getConexionOpenMotorec().getCon().createStatement();
            ResultSet rsu = stmt.executeQuery(sql);
            if (rsu != null) {
                Usuario user;
                if (rsu.next()) {
                    user = new Usuario();
                    user.setUsername(Tools.cleanString(rsu.getString("USER_CEDULA")));
                    user.setLastname(Tools.cleanString(rsu.getString("USER_LAST_NAME")));
                    user.setUserRol(Tools.cleanString(rsu.getString("USER_ROL")));
                    user.setUserRol(Tools.cleanString(rsu.getString("USER_USER")));
                    UserArrayList.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            UserArrayList.add(new Usuario());
        } finally {
            return UserArrayList;
        }
    }

    private ArrayList<Usuario> getUserConsALLFromOpen(String sql, ConexionJde conexionJde) {

        ArrayList<Usuario> UserArrayList = new ArrayList<Usuario>();
        Statement stmt;
        try {
            stmt = conexionJde.getConexionOpenMotorec().getCon().createStatement();
            ResultSet rsu = stmt.executeQuery(sql);
            if (rsu != null) {
                Usuario user;
                while (rsu.next() == true) {
                    user = new Usuario();
                    user.setUsername(Tools.cleanString(rsu.getString("USER_CEDULA")));
                    user.setLastname(Tools.cleanString(rsu.getString("USER_LAST_NAME")));
                    user.setUserRol(Tools.cleanString(rsu.getString("USER_ROL")));
                    user.setUserRol(Tools.cleanString(rsu.getString("USER_USER")));
                    UserArrayList.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            UserArrayList.add(new Usuario());
        } finally {
            return UserArrayList;
        }
    }

    private String setUser(String cedula, String longname, String codjde, String codperf, String desPerf, ConexionJde conexionJde) {

        String result = "ERROR";
        if (cedula != null) {
            if (consultUser(cedula, conexionJde) != true) {

                result = UserSaveDAO(conexionJde, cedula, longname, codjde, codperf, desPerf);
            } else {
                result = "DUPLICADO";
            }
        }
        return result;
    }

    private boolean consultUser(String cedula, ConexionJde conexionMotorec) {

        boolean result = false;
        Usuario us = new Usuario();
        result = us.cnUser(conexionMotorec, cedula);
        return result;
    }

    public String UserSaveDAO(ConexionJde conexionMotorec, String cedula, String longname, String codjde, String codperf, String desPerf) {
        Statement statement = null;
        int resultado = 0;
        String salida = "ERROR";
        Connection connection = conexionMotorec.getConexionOpenMotorec().getCon();
        if (connection != null) {
            try {
                Usuario user = new Usuario();
                connection.setAutoCommit(false);
                resultado += user.InsertUser(connection, cedula, longname, codjde, codperf, desPerf);
                connection.commit();
                salida = resultado > 0 ? "OK" : "ERROR";

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                return salida;
            }
        }
        return salida;
    }

    public String UpdateUser(ConexionJde conexionMotorec, String cedula, String longname, String codjde, String codperf, String desPerf) {
        Statement statement = null;
        int resultado = 0;
        String salida = "ERROR";
        Connection connection = conexionMotorec.getConexionOpenMotorec().getCon();
        if (connection != null) {
            try {
                Usuario user = new Usuario();
                connection.setAutoCommit(false);
                resultado += user.UpdateUser(connection, cedula, longname, codjde, codperf, desPerf);
                connection.commit();
                salida = resultado > 0 ? "OK" : "ERROR";

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                return salida;
            }
        }
        return salida;
    }

    public String DeleteUser(ConexionJde conexionMotorec, String cedula) {
        Statement statement = null;
        int resultado = 0;
        String salida = "ERROR";
        Connection connection = conexionMotorec.getConexionOpenMotorec().getCon();
        if (connection != null) {
            try {
                Usuario user = new Usuario();
                connection.setAutoCommit(false);
                resultado += user.DeleteUser(connection, cedula);
                connection.commit();
                salida = resultado > 0 ? "OK" : "ERROR";

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                return salida;
            }
        }
        return salida;
    }
}
