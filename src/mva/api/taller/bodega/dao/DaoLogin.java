package mva.api.taller.bodega.dao;

import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.models.Tools;
import mva.api.taller.bodega.models.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoLogin {
    public static final int ALL_BY_BODEGA = 1;
    public static final int ALL_BY_BODEGA_AND_PRODUCTCODE = 2;
    public static final int ALL_BY_BODEGA_AND_UBICACIONES = 3;
    public static final int ALL_BY_BODEGA_UDITORIA = 4;

    public ArrayList<Usuario> UserGetDAO(Usuario user, ConexionJde conexionJde, String usuario, String password) {
        return this.getUser(user, usuario, password, conexionJde);
    }

    private ArrayList<Usuario> getUser(Usuario user, String usuario, String password, ConexionJde conexionJde) {

        ArrayList<Usuario> usertArrayList = new ArrayList<Usuario>();
        String sentencia = "";
        String where = " ";
        String sql = "";
        sql = Usuario.SELECT_USER;
        where = " WHERE TRIM(U.USER_NAME)='" + usuario + "' AND TRIM(U.USER_PASSWORD)='" + password + "'";
        sentencia = sql + where;
        if (usuario != null && password != null) {
            usertArrayList = getUserFromOpen(sentencia, conexionJde);
        }


        return usertArrayList;
    }

    private ArrayList<Usuario> getUserFromOpen(String sql, ConexionJde conexionJde) {

        ArrayList<Usuario> UserArrayList = new ArrayList<Usuario>();
        Statement stmt;
        try {
            stmt = conexionJde.getConexionOpenMotorec().getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs != null) {
                Usuario user;
                if (rs.next()) {
                    user = new Usuario();
                    user.setUsername(Tools.cleanString(rs.getString("USER_NAME")));
                    user.setLastname(Tools.cleanString(rs.getString("USER_LAST_NAME")));
                    user.setUserRol(Tools.cleanString(rs.getString("USER_ROL")));
                    user.setEstado(true);
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


}
