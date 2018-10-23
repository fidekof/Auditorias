package mva.api.taller.bodega.models;

import mva.api.taller.bodega.conexion.ConexionJde;

import java.sql.*;

public class Usuario {
    private String username;
    private String Password;
    private String lastname;
    private String userRol;
    private Boolean estado;
    private String codigoJde;
    private String cedula;

    public Usuario(String username, String Password, String lastname, String userRol) {
        this.setUsername(username);
        this.setPassword(Password);
        this.setLastname(lastname);
    }

    public Usuario() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserRol() {
        return userRol;
    }

    public void setUserRol(String userRol) {
        this.userRol = userRol;
    }

    private static final String User_name = "";
    private static final String password_user = "";
    private static final String last_name_user = "";
    private static final String rol_user = "";

    public static final String SELECT_USER = " SELECT " +
            " U.USER_CEDULA," +
            " U.USER_NAME," +
            " U.USER_LONG_NAME, " +
            " U.USER_ROL," +
            " U.USER_PASSWORD " +
            " U.USER_AN8 " +
            " FROM JDE_TO_OPEN_USERS U";

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Usuario(String username, String Password, String lastname, String userRol, String CodigoJde, String cedula) {
        this.setUsername(username);
        this.setPassword(Password);
        this.setLastname(lastname);
        this.setCodigoJde(CodigoJde);
        this.setCedula(cedula);
    }

    public String getCodigoJde() {
        return codigoJde;
    }

    public void setCodigoJde(String codigoJde) {
        this.codigoJde = codigoJde;
    }

    public static final String SELECT_USER_JDE = " SELECT " +
            " F0101.ABALPH USER_LONG_NAME," +
            " F0101.ABTAX USER_CEDULA," +
            " F0101.ABAN8 USER_AN8 " +
            " FROM PRODDTA.F0101 F0101";

    public static final String SELECT_USER_EXISTENTE = " SELECT * " +
            "FROM JDE_TO_OPEN_USERS U";

    public static final String SELECT_USER_ONE = " SELECT " +
            " U.USER_CEDULA," +
            " U.USER_NAME," +
            " U.USER_LONG_NAME, " +
            " U.USER_ROL," +
            " U.USER_PASSWORD " +
            " U.USER_USER " +
            " U.USER_AN8 " +
            " FROM JDE_TO_OPEN_USERS U";

    public static final String SELECT_USER_ALL = " SELECT " +
            " U.USER_CEDULA," +
            " U.USER_NAME," +
            " U.USER_LONG_NAME, " +
            " U.USER_ROL," +
            " U.USER_PASSWORD " +
            " U.USER_USER " +
            " U.USER_AN8 " +
            " FROM JDE_TO_OPEN_USERS U";

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int InsertUser(Connection con, String cedula, String longname, String codjde, String codPerf, String desPerf) {
        int result = 0;
        String Descrip = "";
        if (codPerf.equals("A")) {
            Descrip = "Administrador";
        }
        if (codPerf.equals("O")) {
            Descrip = "Operativo";
        }
        if (codPerf.equals("S")) {
            Descrip = "Supervisor";
        }


        if (con != null) {
            String sql = "  INSERT INTO JDE_TO_OPEN_USERS(USER_CEDULA, USER_NAME, USER_LONG_NAME, USER_ROL, USER_PASSWORD, USER_USER, USER_AN8) VALUES (" +
                    " ?, " +
                    " TRIM(?), " +
                    " TRIM(?), " +
                    " ?," +
                    " TRIM(?)," +
                    " TRIM(?)," +
                    " ?" +
                    " )";
            try {
                PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

                st.setString(1, cedula);
                st.setString(2, cedula);
                st.setString(3, longname);
                st.setString(4, codPerf);
                st.setString(5, cedula);
                st.setString(6, Descrip);
                st.setString(7, Tools.formatNumberToJDE(codjde, 3, Tools.SIGNO_DECIMAL));
                result = st.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
                result = 0;
            }
        }
        return result;
    }

    public Boolean cnUser(ConexionJde conexionJde, String cedula) {
        boolean resp = false;
        String sentencia = "";
        String sql = SELECT_USER_EXISTENTE;
        String where = " WHERE USER_CEDULA='" + cedula + "'";
        sentencia = sql + where;
        Statement stmt;
        try {
            stmt = conexionJde.getConexionOpenMotorec().getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sentencia);
            if (rs != null) {
                if (rs.next()) {
                    resp = true;
                } else {
                    resp = false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            resp = false;
        } finally {
            conexionJde.desconectarJD();
            return resp;
        }
    }

    public int UpdateUser(Connection con, String cedula, String longname, String codjde, String codPerf, String desPerf) {
        int result = 0;
        String Sentencia = "";
        String where = "";
        if (con != null) {
            where = "WHERE USER_CEDULA='" + cedula + "'";
            String sql = "  UPDATE JDE_TO_OPEN_USERS  SET  USER_LONG_NAME='?', USER_ROL='?',USER_USER='?'";
            Sentencia = sql + where;
            try {
                PreparedStatement st = con.prepareStatement(Sentencia, PreparedStatement.RETURN_GENERATED_KEYS);

                st.setString(1, longname);
                st.setString(2, codPerf);
                st.setString(3, desPerf);
                result = st.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
                result = 0;
            }
        }
        return result;
    }

    public int DeleteUser(Connection con, String cedula) {
        int result = 0;
        String Sentencia = "";
        String where = "";
        if (con != null) {
            where = "WHERE USER_CEDULA='" + cedula + "'";
            String sql = "  DELETE FROM JDE_TO_OPEN_USERS";
            Sentencia = sql + where;
            try {
                PreparedStatement st = con.prepareStatement(Sentencia, PreparedStatement.RETURN_GENERATED_KEYS);
                result = st.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
                result = 0;
            }
        }
        return result;
    }
}