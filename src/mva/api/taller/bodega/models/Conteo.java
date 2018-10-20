package mva.api.taller.bodega.models;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class Conteo {
    public static final int BUSCAR_TODO = 1;
    public static final int BUSCAR_POR_ITEM = 2;
    public static final int BUSCA_UBICACION = 3;
    public static final int BUSCAR_RANGO_UBUCACIONES = 4;
    public static final int BUSCAR_MAESTRO_OPEN = 5;
    public static final int BUSCAR_MAESTRO_JDE = 6;
    private static final String CC_001 = "C001";
    private static final String CC_003 = "C003";
    private static final String CC_002 = "C002";
    public static final String SELECT_CONTEO = " SELECT * FROM (SELECT  " +
            " P.BODEGA, " +
            " P.UBICACION, " +
            " P.CODIGO, " +
            " NVL(P.CANTIDAD,0)/100 CANTIDAD, " +
            " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION, " +
            " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO, " +
            " P.FAMILIA,  " +
            " P.NUMERO_CORTO, " +
            " C.OBSERVACION, " +
            " NVL(C.CONTEO1,-9999999)/1000  CONTEO1, " +
            " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1, " +
            " NVL(C.CONTEO2,-9999999)/1000  CONTEO2, " +
            " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2, " +
            " NVL(C.CONTEO3,-9999999)/1000  CONTEO3, " +
            " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3, " +
            " C.AUDITORIA, " +
            " C.GRUPO ," +
            " C.GRUPOC1, " +
            " C.GRUPOC2, " +
            " C.GRUPOC3, " +
            " C.OBSERVACIONC1, " +
            " C.OBSERVACIONC2, " +
            " C.OBSERVACIONC3 " +
            " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C ";


    public static final String SELECT_MAESTRO_OPEN = " SELECT " +
            "             ' ' BODEGA, " +
            "             ' ' UBICACION, " +
            "             M.CODIGO, " +
            "             0          CANTIDAD, " +
            "             TRIM(M.DESCRIPCION1) || '===' || TRIM(M.DESCRIPCION2) AS DESCRIPCION, " +
            "             M.COSTO_UNITARIO COSTO_UNITARIO, " +
            "             M.FAMILIA, " +
            "             ' ' NUMERO_CORTO, " +
            "             ' ' OBSERVACION, " +
            "             0   CONTEO1, " +
            "             0   DIFERENCIA1, " +
            "             0   CONTEO2, " +
            "             0   DIFERENCIA2, " +
            "             0   CONTEO3, " +
            "             0   DIFERENCIA3, " +
            "             ' ' AUDITORIA, " +
            "             ' ' GRUPO, " +
            "             ' ' GRUPOC1, " +
            "             ' ' GRUPOC2, " +
            "             ' ' GRUPOC3, " +
            "             ' ' OBSERVACIONC1, " +
            "             ' ' OBSERVACIONC2, " +
            "             ' ' OBSERVACIONC3 " +
            " FROM JDE_TO_OPEN_MAESTROINVENTARIOS M ";


    // Atributos
    private String observacion;
    private String conteocode;
    private String bodega;
    private String ubicacion;
    private String codigo;
    private String cantidad;
    private String grupo;
    private String descripcion;
    private String auditoria;
    private String conteo1;
    private String diferencia1;
    private String observacion1;
    private String grupoc1;
    private String conteo2;
    private String diferencia2;
    private String observacion2;
    private String grupoc2;
    private String conteo3;
    private String diferencia3;
    private String observacion3;
    private String grupoc3;
    private String costounitario;
    private String familia;
    private String conteofinal;

    public Conteo(String observacion, String conteocode, String bodega, String ubicacion, String codigo, String cantidad, String grupo, String descripcion, String auditoria, String conteo1, String diferencia1, String observacion1, String grupoc1, String conteo2, String diferencia2, String observacion2, String grupoc2, String conteo3, String diferencia3, String observacion3, String grupoc3, String costounitario, String familia, String conteofinal) {
        this.observacion = observacion;
        this.conteocode = conteocode;
        this.bodega = bodega;
        this.ubicacion = ubicacion;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.grupo = grupo;
        this.descripcion = descripcion;
        this.auditoria = auditoria;
        this.conteo1 = conteo1;
        this.diferencia1 = diferencia1;
        this.observacion1 = observacion1;
        this.grupoc1 = grupoc1;
        this.conteo2 = conteo2;
        this.diferencia2 = diferencia2;
        this.observacion2 = observacion2;
        this.grupoc2 = grupoc2;
        this.conteo3 = conteo3;
        this.diferencia3 = diferencia3;
        this.observacion3 = observacion3;
        this.grupoc3 = grupoc3;
        this.costounitario = costounitario;
        this.familia = familia;
        this.conteofinal = conteofinal;
    }


    public String getConteofinal() {
        return conteofinal;
    }

    public void setConteofinal(String conteofinal) {
        this.conteofinal = conteofinal;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getCostounitario() {
        return costounitario;
    }

    public void setCostounitario(String costounitario) {
        this.costounitario = costounitario;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getConteocode() {
        return conteocode;
    }

    public void setConteocode(String conteocode) {
        this.conteocode = conteocode;
    }

    public Conteo() {
    }

    public String getBodega() {
        return bodega;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(String auditoria) {
        this.auditoria = auditoria;
    }

    public String getConteo1() {
        return conteo1;
    }

    public void setConteo1(String conteo1) {
        this.conteo1 = conteo1;
    }


    public void calculeDiferencias() {
        if (this.cantidad != null && this.cantidad.trim().isEmpty() == false && this.conteo1 != null && this.conteo1.trim().isEmpty() == false) {
            this.diferencia1 = " " + (Integer.parseInt(Tools.formatNumberToJDE(this.conteo1, 3, Tools.SIGNO_DECIMAL)) - Integer.parseInt(Tools.formatNumberToJDE(this.cantidad, 3, Tools.SIGNO_DECIMAL)));
        }
    }

    public String getDiferencia1() {
        return diferencia1;
    }

    public void setDiferencia1(String diferencia1) {
        this.diferencia1 = diferencia1;
    }

    public String getConteo2() {
        return conteo2;
    }

    public void setConteo2(String conteo2) {
        this.conteo2 = conteo2;
    }

    public String getDiferencia2() {
        return diferencia2;
    }

    public void setDiferencia2(String diferencia2) {
        this.diferencia2 = diferencia2;
    }

    public String getConteo3() {
        return conteo3;
    }

    public void setConteo3(String conteo3) {
        this.conteo3 = conteo3;
    }

    public String getDiferencia3() {
        return diferencia3;
    }

    public void setDiferencia3(String diferencia3) {
        this.diferencia3 = diferencia3;
    }


    public String getObservacion1() {
        return observacion1;
    }

    public void setObservacion1(String observacion1) {
        this.observacion1 = observacion1;
    }

    public String getgrupoc1() {
        return grupoc1;
    }

    public void setgrupoc1(String grupoc1) {
        this.grupoc1 = grupoc1;
    }

    public String getObservacion2() {
        return observacion2;
    }

    public void setObservacion2(String observacion2) {
        this.observacion2 = observacion2;
    }

    public String getgrupoc2() {
        return grupoc2;
    }

    public void setgrupoc2(String grupoc2) {
        this.grupoc2 = grupoc2;
    }

    public String getObservacion3() {
        return observacion3;
    }

    public void setObservacion3(String observacion3) {
        this.observacion3 = observacion3;
    }

    public String getgrupoc3() {
        return grupoc3;
    }

    public void setgrupoc3(String grupoc3) {
        this.grupoc3 = grupoc3;
    }

    public int generarInsertItem(Connection con) {
        int result = 0;
        if (con != null) {
            String sql = "  INSERT INTO JDE_TO_OPEN_PRODUCTO(AUDITORIA, BODEGA, UBICACION, CODIGO, DESCRIPCION, DESCRIPCION2, CANTIDAD, COSTO_UNITARIO, FAMILIA) VALUES (" +
                    " TRIM(?), " +
                    " TRIM(?), " +
                    " TRIM(?), " +
                    " TRIM(?), " +
                    " TRIM(?)," +
                    " TRIM(?)," +
                    " ?," +
                    " ?," +
                    " TRIM(?)" +
                    " )";
            try {
                PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                String des1 = " ", des2 = " ", partes[];
                if (this.descripcion != null && this.descripcion.isEmpty() == false) {
                    partes = this.descripcion.split("===");
                    if (partes.length > 1) {
                        des1 = partes[0].replace("===", "");
                        des2 = partes[1].replace("===", "");
                    } else {
                        des1 = this.descripcion.replace("===", "");
                        des2 = " ";
                    }
                }

                st.setString(1, this.auditoria);
                st.setString(2, this.bodega);
                st.setString(3, this.ubicacion);
                st.setString(4, this.codigo);
                st.setString(5, des1);
                st.setString(6, des2);
                st.setString(7, Tools.formatNumberToJDE(this.cantidad, 3, Tools.SIGNO_DECIMAL));
                st.setString(8, this.costounitario);
                st.setString(9, this.familia);
                result = st.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
                result = 0;
            }
        }
        return result;
    }


    public int generarInsertConteo(Connection con) {
        int result = 0;
        if (con != null) {
            String sql = "  INSERT INTO JDE_TO_OPEN_CONTEO(BODEGA ," +
                    "   UBICACION," +
                    "   CODIGO," +
                    "   DESCRIPCION," +
                    "   CANTIDAD," +
                    "   GRUPO," +
                    "   AUDITORIA, " +
                    "   FAMILIA, " +
                    "   COSTO_UNITARIO," +
                    "   OBSERVACION " +
                    " ) VALUES (" +
                    " TRIM(?), " +
                    " TRIM(?), " +
                    " TRIM(?), " +
                    " TRIM(?)," +
                    " ?," +
                    " TRIM(?)," +
                    " TRIM(?)," +
                    " TRIM(?)," +
                    " ?," +
                    " TRIM(?) " +
                    " )";
            try {
                PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                st.setString(1, this.bodega);
                st.setString(2, this.ubicacion);
                st.setString(3, this.codigo);
                st.setString(4, this.descripcion);
                st.setString(5, Tools.formatNumberToJDE(this.cantidad, 3, Tools.SIGNO_DECIMAL));
                st.setString(6, this.grupo);
                st.setString(7, this.auditoria);
                st.setString(8, this.familia);
                st.setString(9, Tools.formatNumberToJDE(this.costounitario, 3, Tools.SIGNO_DECIMAL));
                st.setString(10, this.observacion);

                result = st.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
                result = 0;
            }
        }
        return result;
    }

    public int generarUpdateConteo(Connection con) {
        String set = sqlSetConteo();
        int result = 0;
        String sql = " ";
        if (set != null && set.trim().isEmpty() == false && con != null) {

            sql = " UPDATE JDE_TO_OPEN_CONTEO " + set + " " +
                    " WHERE  TRIM(UPPER(BODEGA)) = TRIM(?) AND " +
                    " TRIM(UPPER(UBICACION)) = TRIM(?) AND " +
                    " TRIM(UPPER(CODIGO)) = TRIM(?) AND " +
                    " TRIM(UPPER(AUDITORIA)) = TRIM(?) ";


            try {
                PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                st.setString(1, Tools.formatNumberToJDE(this.conteo1, 3, Tools.SIGNO_DECIMAL));
                st.setString(2, this.diferencia1);
                st.setString(3, this.grupoc1);
                st.setString(4, this.observacion);
                st.setString(5, this.observacion1);
                st.setString(6, this.bodega.trim().toUpperCase());
                st.setString(7, this.ubicacion.toUpperCase());
                st.setString(8, this.codigo.toUpperCase());
                st.setString(9, this.auditoria.toUpperCase());

                result = st.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
                result = 0;
            }
        }
        return result;
    }


    private String sqlSetConteo() {
        String result = " ";
        if (this.conteocode == null || this.conteocode.isEmpty()) {
            return result;
        }
        if (this.conteocode.toUpperCase().compareToIgnoreCase(Conteo.CC_001) == 0) {
            result = "  SET CONTEO1 = ?, " +
                    "  DIFERENCIA1  = ?, " +
                    "  GRUPOC1  = TRIM(?), " +
                    "  OBSERVACION  = TRIM(?), " +
                    "  OBSERVACIONC1  = TRIM(?) ";
        } else {
            if (this.conteocode.toUpperCase().compareToIgnoreCase(Conteo.CC_002) == 0) {
                result = "  SET CONTEO2 = ? ," +
                        "  DIFERENCIA2 = ? , " +
                        "  GRUPOC2  = TRIM(?), " +
                        "  OBSERVACION  = TRIM(?), " +
                        "  OBSERVACIONC2  = TRIM(?) ";
            } else {

                if (this.conteocode.toUpperCase().compareToIgnoreCase(Conteo.CC_003) == 0) {
                    result = "  SET CONTEO3 = ?, " +
                            "   DIFERENCIA3 = ?, " +
                            "  GRUPOC3  = TRIM(?), " +
                            "  OBSERVACION  = TRIM(?), " +
                            "  OBSERVACIONC3  = TRIM(?) ";
                }
            }
        }
        return result;
    }


    public String getSqlByTypeSearch(int typeSearch) {
        String where = " ";
        String sql = "";
        switch (typeSearch) {
            case 999: {
                sql = Conteo.SELECT_CONTEO;
                where = "  WHERE " +
                        "    TRIM(P.BODEGA) =  TRIM('" + this.bodega + " ') " +
                        "    AND TRIM(P.CODIGO) = TRIM(C.CODIGO) " +
                        "    AND TRIM(P.BODEGA) = TRIM(C.BODEGA) " +
                        "    AND TRIM(P.UBICACION) = TRIM(C.UBICACION) " +
                        "    AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) " +
                        " ) " +
                        "                         ORDER BY TRIM(UBICACION) ASC ";
                break;
            }
            case Conteo.BUSCAR_TODO: {
                sql = Conteo.SELECT_CONTEO;
                if (this.conteocode != null) {
                    if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_001) == 0) {
                        where = "  WHERE " +
                                "    TRIM(P.BODEGA) =  TRIM('" + this.bodega + " ') " +
                                "    AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+)) " +
                                "    AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+)) " +
                                "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION(+)) " +
                                "  AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA)) " +
                                // -----------------------------------------------------------------------------
                                " ) " +
                                "    ORDER BY TRIM(UBICACION) ASC ";
                    } else {
                        if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_002) == 0) {
                            where = "  WHERE   " +
                                    " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                    "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                    " AND TRIM(C.AUDITORIA) = TRIM('" + this.auditoria + "')   " +
                                    " AND NVL(C.DIFERENCIA1,-999999)!= 0 " +
                                    " UNION " +
                                    " SELECT   " +
                                    " P.BODEGA, " +
                                    " P.UBICACION, " +
                                    " P.CODIGO,  " +
                                    " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                    " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                    " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                    " P.FAMILIA,   " +
                                    " P.NUMERO_CORTO,  " +
                                    " C.OBSERVACION, " +
                                    " NVL(C.CONTEO1, -1000000)/1000 CONTEO1,  " +
                                    " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                    " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                    " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                    " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                    " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                    " C.AUDITORIA,  " +
                                    " C.GRUPO, " +
                                    " C.GRUPOC1, " +
                                    " C.GRUPOC2, " +
                                    " C.GRUPOC3, " +
                                    " C.OBSERVACIONC1, " +
                                    " C.OBSERVACIONC2, " +
                                    " C.OBSERVACIONC3 " +
                                    " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                    " WHERE   " +
                                    " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                    " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                    " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                    " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  TRIM(CV.AUDITORIA) = TRIM('" + this.auditoria + "') AND TRIM(CV.BODEGA) = TRIM('" + this.bodega + "')))  " +
                                    " ORDER BY TRIM(UBICACION) ASC ";
                        } else {
                            if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_003) == 0) {
                                where = " WHERE   " +
                                        " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                        "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                        " AND TRIM(C.AUDITORIA) = TRIM('" + this.auditoria + "')   " +
                                        " AND ((NVL(C.DIFERENCIA1,-999999) != NVL(C.DIFERENCIA2,-888888) AND NVL(C.DIFERENCIA1,-999999)!=0 AND NVL(C.DIFERENCIA2,-888888)!=0)) " +
                                        " UNION " +
                                        " SELECT   " +
                                        " P.BODEGA, " +
                                        " P.UBICACION, " +
                                        " P.CODIGO,  " +
                                        " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                        " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                        " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                        " P.FAMILIA,   " +
                                        " P.NUMERO_CORTO,  " +
                                        " C.OBSERVACION, " +
                                        " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                        " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                        " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                        " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                        " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                        " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                        " C.AUDITORIA,  " +
                                        " C.GRUPO, " +
                                        " C.GRUPOC1, " +
                                        " C.GRUPOC2, " +
                                        " C.GRUPOC3, " +
                                        " C.OBSERVACIONC1, " +
                                        " C.OBSERVACIONC2, " +
                                        " C.OBSERVACIONC3 " +
                                        " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                        " WHERE   " +
                                        " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                        " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                        " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                        " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  TRIM(CV.AUDITORIA) = TRIM('" + this.auditoria + "') AND TRIM(CV.BODEGA) = TRIM('" + this.bodega + "')))  " +
                                        " ORDER BY TRIM(UBICACION) ASC ";
                            }
                        }
                    }
                }
                break;
            }


            case Conteo.BUSCAR_POR_ITEM: {
                sql = Conteo.SELECT_CONTEO;
                if (this.conteocode != null) {
                    if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_001) == 0) {
                        where = "  WHERE " +
                                "    TRIM(P.BODEGA) =  TRIM('" + this.bodega + " ') " +
                                "    AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+)) " +
                                "    AND TRIM(P.CODIGO) LIKE TRIM('" + this.codigo.trim() + "%') " +
                                "    AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+)) " +
                                "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION(+)) " +
                                "    AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))) " +
                                "    ORDER BY TRIM(UBICACION) ASC ";
                    } else {
                        if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_002) == 0) {
                            where = "  WHERE   " +
                                    " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                    "    AND TRIM(P.CODIGO) LIKE TRIM('" + this.codigo.trim() + "%') " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                    "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                    " AND TRIM(C.AUDITORIA) = TRIM('" + this.auditoria + "')   " +

                                    " AND NVL(C.DIFERENCIA1,-999999)!= 0 " +
                                    " UNION " +
                                    " SELECT   " +
                                    " P.BODEGA, " +
                                    " P.UBICACION, " +
                                    " P.CODIGO,  " +
                                    " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                    " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                    " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                    " P.FAMILIA,   " +
                                    " P.NUMERO_CORTO,  " +
                                    " C.OBSERVACION, " +
                                    " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                    " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                    " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                    " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                    " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                    " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                    " C.AUDITORIA,  " +
                                    " C.GRUPO, " +
                                    " C.GRUPOC1, " +
                                    " C.GRUPOC2, " +
                                    " C.GRUPOC3, " +
                                    " C.OBSERVACIONC1, " +
                                    " C.OBSERVACIONC2, " +
                                    " C.OBSERVACIONC3 " +
                                    " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                    " WHERE   " +
                                    " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                    "    AND TRIM(P.CODIGO) LIKE TRIM('" + this.codigo.trim() + "%') " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                    " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                    " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                    " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  TRIM(CV.AUDITORIA) = TRIM('" + this.auditoria + "') AND TRIM(CV.BODEGA) = TRIM('" + this.bodega + "')))  " +
                                    " ORDER BY TRIM(UBICACION) ASC ";
                        } else {
                            if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_003) == 0) {
                                where = " WHERE   " +
                                        " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                        "    AND TRIM(P.CODIGO) LIKE TRIM('" + this.codigo.trim() + "%') " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                        "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                        " AND TRIM(C.AUDITORIA) = TRIM('" + this.auditoria + "')   " +
                                        " AND ((NVL(C.DIFERENCIA1,-999999) != NVL(C.DIFERENCIA2,-888888) AND NVL(C.DIFERENCIA1,-999999)!=0 AND NVL(C.DIFERENCIA2,-888888)!=0)) " +
                                        " UNION " +
                                        " SELECT   " +
                                        " P.BODEGA, " +
                                        " P.UBICACION, " +
                                        " P.CODIGO,  " +
                                        " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                        " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                        " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                        " P.FAMILIA,   " +
                                        " P.NUMERO_CORTO,  " +
                                        " C.OBSERVACION, " +
                                        " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                        " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                        " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                        " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                        " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                        " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                        " C.AUDITORIA,  " +
                                        " C.GRUPO, " +
                                        " C.GRUPOC1, " +
                                        " C.GRUPOC2, " +
                                        " C.GRUPOC3, " +
                                        " C.OBSERVACIONC1, " +
                                        " C.OBSERVACIONC2, " +
                                        " C.OBSERVACIONC3 " +
                                        " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                        " WHERE   " +
                                        " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                        "    AND TRIM(P.CODIGO) LIKE TRIM('" + this.codigo.trim() + "%') " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                        " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                        " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                        " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  TRIM(CV.AUDITORIA) = TRIM('" + this.auditoria + "') AND TRIM(CV.BODEGA) = TRIM('" + this.bodega + "')))  " +
                                        " ORDER BY TRIM(UBICACION) ASC ";
                            }
                        }
                    }
                }
                break;
            }


            case Conteo.BUSCA_UBICACION: {
                sql = Conteo.SELECT_CONTEO;
                if (this.conteocode != null) {
                    if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_001) == 0) {
                        where = "  WHERE " +
                                "    UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + " ')) " +
                                "    AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+)) " +
                                "    AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+)) " +
                                "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION(+)) " +
                                "    AND UPPER(TRIM(P.UBICACION)) LIKE UPPER(TRIM('" + this.ubicacion.trim() + "%'))" +
                                "   AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))) " +
                                "    ORDER BY TRIM(UBICACION) ASC ";
                    } else {
                        if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_002) == 0) {
                            where = "  WHERE   " +
                                    " TRIM(P.BODEGA) = UPPER(TRIM('" + this.bodega + "'))  " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                    "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                    "    AND UPPER(TRIM(P.UBICACION)) LIKE UPPER(TRIM('" + this.ubicacion.trim() + "%'))" +
                                    " AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "'))   " +
                                    " AND NVL(C.DIFERENCIA1,-999999)!= 0 " +
                                    " UNION " +
                                    " SELECT   " +
                                    " P.BODEGA, " +
                                    " P.UBICACION, " +
                                    " P.CODIGO,  " +
                                    " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                    " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                    " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                    " P.FAMILIA,   " +
                                    " P.NUMERO_CORTO,  " +
                                    " C.OBSERVACION, " +
                                    " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                    " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                    " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                    " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                    " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                    " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                    " C.AUDITORIA,  " +
                                    " C.GRUPO, " +
                                    " C.GRUPOC1, " +
                                    " C.GRUPOC2, " +
                                    " C.GRUPOC3, " +
                                    " C.OBSERVACIONC1, " +
                                    " C.OBSERVACIONC2, " +
                                    " C.OBSERVACIONC3 " +
                                    " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                    " WHERE   " +
                                    " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                    " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                    "    AND UPPER(TRIM(P.UBICACION)) LIKE UPPER(TRIM('" + this.ubicacion.trim() + "%'))" +
                                    " AND UPPER(TRIM(C.AUDITORIA(+))) = UPPER(TRIM('" + this.auditoria + "'))   " +
                                    " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  UPPER(TRIM(CV.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) AND UPPER(TRIM(CV.BODEGA)) = UPPER(TRIM('" + this.bodega + "'))))  " +
                                    " ORDER BY TRIM(UBICACION) ASC ";
                        } else {
                            if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_003) == 0) {
                                where = " WHERE   " +
                                        " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                        "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                        "    AND UPPER(TRIM(P.UBICACION)) LIKE UPPER(TRIM('" + this.ubicacion.trim() + "%'))" +
                                        " AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) " +
                                        " AND ((NVL(C.DIFERENCIA1,-999999) != NVL(C.DIFERENCIA2,-888888) AND NVL(C.DIFERENCIA1,-999999)!=0 AND NVL(C.DIFERENCIA2,-888888)!=0)) " +
                                        " UNION " +
                                        " SELECT   " +
                                        " P.BODEGA, " +
                                        " P.UBICACION, " +
                                        " P.CODIGO,  " +
                                        " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                        " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                        " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                        " P.FAMILIA,   " +
                                        " P.NUMERO_CORTO,  " +
                                        " C.OBSERVACION, " +
                                        " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                        " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                        " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                        " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                        " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                        " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                        " C.AUDITORIA,  " +
                                        " C.GRUPO, " +
                                        " C.GRUPOC1, " +
                                        " C.GRUPOC2, " +
                                        " C.GRUPOC3, " +
                                        " C.OBSERVACIONC1, " +
                                        " C.OBSERVACIONC2, " +
                                        " C.OBSERVACIONC3 " +
                                        " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                        " WHERE   " +
                                        " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                        " AND UPPER(TRIM(P.UBICACION)) = UPPER(TRIM(C.UBICACION(+)))   " +
                                        "    AND UPPER(TRIM(P.UBICACION)) LIKE UPPER(TRIM('" + this.ubicacion.trim() + "%'))" +
                                        " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                        " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  UPPER(TRIM(CV.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) AND UPPER(TRIM(CV.BODEGA)) = UPPER(TRIM('" + this.bodega + "'))))  " +
                                        " ORDER BY TRIM(UBICACION) ASC ";
                            }
                        }
                    }
                }
                break;
            }

            case Conteo.BUSCAR_RANGO_UBUCACIONES: {
                sql = Conteo.SELECT_CONTEO;
                if (this.conteocode != null) {
                    if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_001) == 0) {
                        where = "  WHERE " +
                                "    UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + " ')) " +
                                "    AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+)) " +
                                "    AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+)) " +
                                "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION(+)) " +
                                "    AND UPPER(TRIM(P.UBICACION)) BETWEEN UPPER(TRIM('" + this.ubicacion + "')) AND UPPER(TRIM('" + this.observacion + "')) " +
                                "   AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))) " +
                                "    ORDER BY TRIM(UBICACION) ASC ";
                    } else {
                        if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_002) == 0) {
                            where = "  WHERE   " +
                                    " TRIM(P.BODEGA) = UPPER(TRIM('" + this.bodega + "'))  " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                    "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                    "    AND UPPER(TRIM(P.UBICACION)) BETWEEN UPPER(TRIM('" + this.ubicacion + "')) AND UPPER(TRIM('" + this.observacion + "')) " +
                                    " AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "'))   " +
                                    " AND NVL(C.DIFERENCIA1,-999999)!= 0 " +
                                    " UNION " +
                                    " SELECT   " +
                                    " P.BODEGA, " +
                                    " P.UBICACION, " +
                                    " P.CODIGO,  " +
                                    " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                    " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                    " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                    " P.FAMILIA,   " +
                                    " P.NUMERO_CORTO,  " +
                                    " C.OBSERVACION, " +
                                    " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                    " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                    " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                    " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                    " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                    " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                    " C.AUDITORIA,  " +
                                    " C.GRUPO, " +
                                    " C.GRUPOC1, " +
                                    " C.GRUPOC2, " +
                                    " C.GRUPOC3, " +
                                    " C.OBSERVACIONC1, " +
                                    " C.OBSERVACIONC2, " +
                                    " C.OBSERVACIONC3 " +
                                    " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                    " WHERE   " +
                                    " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                    " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                    "    AND UPPER(TRIM(P.UBICACION)) BETWEEN UPPER(TRIM('" + this.ubicacion + "')) AND UPPER(TRIM('" + this.observacion + "')) " +
                                    " AND UPPER(TRIM(C.AUDITORIA(+))) = UPPER(TRIM('" + this.auditoria + "'))   " +
                                    " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  UPPER(TRIM(CV.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) AND UPPER(TRIM(CV.BODEGA)) = UPPER(TRIM('" + this.bodega + "'))))  " +
                                    " ORDER BY TRIM(UBICACION) ASC ";
                        } else {
                            if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_003) == 0) {
                                where = " WHERE   " +
                                        " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                        "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                        "    AND UPPER(TRIM(P.UBICACION)) BETWEEN UPPER(TRIM('" + this.ubicacion + "')) AND UPPER(TRIM('" + this.observacion + "')) " +
                                        " AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) " +
                                        " AND ((NVL(C.DIFERENCIA1,-999999) != NVL(C.DIFERENCIA2,-888888) AND NVL(C.DIFERENCIA1,-999999)!=0 AND NVL(C.DIFERENCIA2,-888888)!=0)) " +
                                        " UNION " +
                                        " SELECT   " +
                                        " P.BODEGA, " +
                                        " P.UBICACION, " +
                                        " P.CODIGO,  " +
                                        " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                        " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                        " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                        " P.FAMILIA,   " +
                                        " P.NUMERO_CORTO,  " +
                                        " C.OBSERVACION, " +
                                        " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                        " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                        " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                        " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                        " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                        " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                        " C.AUDITORIA,  " +
                                        " C.GRUPO, " +
                                        " C.GRUPOC1, " +
                                        " C.GRUPOC2, " +
                                        " C.GRUPOC3, " +
                                        " C.OBSERVACIONC1, " +
                                        " C.OBSERVACIONC2, " +
                                        " C.OBSERVACIONC3 " +
                                        " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                        " WHERE   " +
                                        " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                        " AND UPPER(TRIM(P.UBICACION)) = UPPER(TRIM(C.UBICACION(+)))   " +
                                        "    AND UPPER(TRIM(P.UBICACION)) BETWEEN UPPER(TRIM('" + this.ubicacion + "')) AND UPPER(TRIM('" + this.observacion + "')) " +
                                        " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                        " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  UPPER(TRIM(CV.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) AND UPPER(TRIM(CV.BODEGA)) = UPPER(TRIM('" + this.bodega + "'))))  " +
                                        " ORDER BY TRIM(UBICACION) ASC ";
                            }
                        }
                    }
                }
                break;
            }

            case Conteo.BUSCAR_MAESTRO_OPEN: {
                sql = SELECT_MAESTRO_OPEN;
                where = " WHERE TRIM(M.CODIGO) = '" + this.getCodigo() + "'";
                break;
            }
            default: {
                sql = Conteo.SELECT_CONTEO;
                where = "  WHERE " +
                        "    TRIM(P.BODEGA) =  TRIM('" + this.bodega + " ') " +
                        "    AND TRIM(P.CODIGO) = TRIM(C.CODIGO) " +
                        "    AND TRIM(P.BODEGA) = TRIM(C.BODEGA) " +
                        "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                        "                         AND TRIM(C.AUDITORIA) = TRIM('" + this.auditoria + " ')) " +
                        "                         ORDER BY TRIM(UBICACION) ASC ";
            }
        }
        return sql + where;
    }


    public void generarConteoFinal() {

        Double cantidad = 0.00, conteo1 = 0.00, diferencia1 = 0.00, conteo2 = 0.00,
                diferencia2 = 0.00, conteo3 = 0.00, diferencia3 = 0.00, cfinal = 0.00;
        cantidad = Tools.stringToDoube(this.cantidad);
        conteo1 = Tools.stringToDoube(this.conteo1);
        diferencia1 = Tools.stringToDoube(this.diferencia1);
        conteo2 = Tools.stringToDoube(this.conteo2);
        diferencia2 = Tools.stringToDoube(this.diferencia2);
        conteo3 = Tools.stringToDoube(this.conteo3);
        diferencia3 = Tools.stringToDoube(this.diferencia3);

        conteo1 = (conteo1 == -9999.999) ? 0 : conteo1;
        diferencia1 = (diferencia1 == -9999.999) ? 0 : diferencia1;
        conteo2 = (conteo2 == -9999.999) ? 0 : conteo2;
        diferencia2 = (diferencia2 == -9999.999) ? 0 : diferencia2;
        conteo3 = (conteo3 == -9999.999) ? 0 : conteo3;
        diferencia3 = (diferencia3 == -9999.999) ? 0 : diferencia3;
        if (conteo1 == 0 && diferencia1 == 0 && conteo2 == 0 && diferencia2 == 0 && conteo3 == 0 && diferencia3 == 0) {
            cfinal = cantidad * (-1);
        } else {
            if ((conteo1 - cantidad) == 0) {
                cfinal = diferencia1;
            } else {
                if ((conteo1 - cantidad) != 0) {

                    if (conteo2 == 0 && diferencia2 == 0 && conteo3 == 0 && diferencia3 == 0) {
                        cfinal = diferencia1;
                    } else {
                        if ((conteo2 - cantidad) == 0 || (conteo1 - cantidad) == (conteo2 - cantidad)) {
                            cfinal = diferencia2;
                        } else {
                            if (conteo3 - cantidad == 0
                                    || (conteo2 - cantidad) == (conteo3 - cantidad)
                                    || (conteo1 - cantidad) == (conteo3 - cantidad)
                                    || ((conteo1 - cantidad) != (conteo3 - cantidad)
                                    && (conteo2 - cantidad) != (conteo3 - cantidad)
                                    && (conteo1 - cantidad) != (conteo2 - cantidad))) {
                                cfinal = diferencia3;
                            } else {
                                cfinal = cantidad * (-1);
                            }
                        }
                    }
                }
            }

        }

        this.conteofinal = "" + cfinal;

    }


    public String getSqlResumenByTypeSearch(int typesearch) {
        String where = " ";
        String sql = "";
        switch (typesearch) {

            case Conteo.BUSCAR_TODO: {
                sql = Conteo.SELECT_CONTEO;
                if (this.conteocode != null) {
                    if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_001) == 0) {
                        where = " SELECT AUDITORIA, BODEGA, GRUPOC1, SUM(CONTEO1) CONTEO1, COUNT(UBICACION) UBICACION, SUM(CANTIDAD) CANTIDAD, SUM(COSTO_UNITARIO * CANTIDAD) COSTO_UNITARIO, SUM(CONTEO1*COSTO_UNITARIO)CONTEO2 " +
                                " FROM " +
                                " (" +
                                " SELECT TRIM(C.AUDITORIA) AUDITORIA, " +
                                " UPPER(TRIM(C.BODEGA))    BODEGA, " +
                                " UPPER(TRIM(C.GRUPOC1))   GRUPOC1, " +
                                " NVL(C.CONTEO1, 0) / 1000  CONTEO1, " +
                                " UPPER(TRIM(C.UBICACION)) UBICACION, " +
                                " (NVL(C.CANTIDAD, 0) / 1000) CANTIDAD, " +
                                " (NVL(C.COSTO_UNITARIO, 0) / 10000) COSTO_UNITARIO, " +
                                " (NVL(C.CONTEO1, 0) / 10000) CONTEO2 " +
                                " FROM JDE_TO_OPEN_CONTEO C " +
                                " WHERE UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) " +
                                " AND UPPER(TRIM(C.BODEGA)) = UPPER(TRIM('" + this.bodega + "')) " +
                                " AND NVL(C.DIFERENCIA1,-999999) != -999999 " +
                                " UNION " +
                                " SELECT UPPER(TRIM(P.AUDITORIA))    AUDITORIA, " +
                                " UPPER(TRIM(P.BODEGA))       BODEGA, " +
                                " TO_NCHAR('FALTANTE') GRUPOC1, " +
                                " 0                    CONTEO1, " +
                                " UPPER(TRIM(NVL(P.UBICACION,'---')))  UBICACION, " +
                                " (NVL(P.CANTIDAD, 0) / 100)  CANTIDAD, " +
                                " (NVL(P.COSTO_UNITARIO, 0) / 10000) COSTO_UNITARIO, " +
                                " (NVL(P.COSTO_UNITARIO, 0) / 10000) CONTEO2 " +
                                " FROM JDE_TO_OPEN_PRODUCTO P " +
                                " WHERE UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) " +
                                " AND UPPER(TRIM(P.BODEGA)) = UPPER(TRIM('" + this.bodega + "')) " +
                                " AND UPPER(TRIM(P.CODIGO)) NOT IN (SELECT UPPER(TRIM(CV.CODIGO)) FROM JDE_TO_OPEN_CONTEO CV WHERE " +
                                " UPPER(TRIM(CV.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) AND " +
                                " NVL(CV.DIFERENCIA1,-999999) != -999999 AND " +
                                " UPPER(TRIM(CV.BODEGA)) = UPPER(TRIM('" + this.bodega + "'))))  RESUMEN " +
                                " GROUP BY RESUMEN.AUDITORIA, RESUMEN.BODEGA, RESUMEN.GRUPOC1 " +
                                " ORDER BY RESUMEN.GRUPOC1 ";
                    } else {
                        if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_002) == 0) {
                            where = " SELECT TRIM(C.AUDITORIA) AUDITORIA,  TRIM(C.BODEGA) BODEGA, TRIM(C.GRUPOC2)  GRUPOC1, SUM(NVL(C.CONTEO1,0)/1000) CONTEO1, COUNT(C.UBICACION) UBICACION, SUM(NVL(C.CANTIDAD,0)/100) CANTIDAD, SUM(NVL(C.COSTO_UNITARIO,0)) COSTO_UNITARIO FROM JDE_TO_OPEN_CONTEO C WHERE TRIM(C.AUDITORIA) = TRIM('" + this.auditoria + "') AND TRIM(C.BODEGA) = TRIM('" + this.bodega + "')  AND NVL(C.DIFERENCIA1,-999999)!= 0 GROUP BY C.AUDITORIA, C.GRUPOC2, C.BODEGA " +
                                    " UNION " +
                                    " SELECT TRIM(P.AUDITORIA) AUDITORIA, TRIM(P.BODEGA) BODEGA, TO_NCHAR('G999') GRUPOC1,         -9999 AS CONTEO1, COUNT(P.UBICACION) UBICACION, SUM(NVL(P.CANTIDAD,0)/100) CANTIDAD,            SUM(NVL(P.COSTO_UNITARIO,0)) COSTO_UNITARIO FROM JDE_TO_OPEN_PRODUCTO P WHERE TRIM(P.AUDITORIA) = TRIM('" + this.auditoria + "') AND TRIM(P.BODEGA) = TRIM('" + this.bodega + "') AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  TRIM(CV.AUDITORIA) = TRIM('" + this.auditoria + "') AND TRIM(CV.BODEGA) = TRIM('" + this.bodega + "')) GROUP BY P.AUDITORIA, P.BODEGA ";
                        } else {
                            if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_003) == 0) {
                                where = " WHERE   " +
                                        " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                        "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                        " AND TRIM(C.AUDITORIA) = TRIM('" + this.auditoria + "')   " +
                                        " AND ((NVL(C.DIFERENCIA1,-999999) != NVL(C.DIFERENCIA2,-888888) AND NVL(C.DIFERENCIA1,-999999)!=0 AND NVL(C.DIFERENCIA2,-888888)!=0)) " +
                                        " UNION " +
                                        " SELECT   " +
                                        " P.BODEGA, " +
                                        " P.UBICACION, " +
                                        " P.CODIGO,  " +
                                        " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                        " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                        " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                        " P.FAMILIA,   " +
                                        " P.NUMERO_CORTO,  " +
                                        " C.OBSERVACION, " +
                                        " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                        " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                        " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                        " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                        " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                        " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                        " C.AUDITORIA,  " +
                                        " C.GRUPO, " +
                                        " C.GRUPOC1, " +
                                        " C.GRUPOC2, " +
                                        " C.GRUPOC3, " +
                                        " C.OBSERVACIONC1, " +
                                        " C.OBSERVACIONC2, " +
                                        " C.OBSERVACIONC3 " +
                                        " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                        " WHERE   " +
                                        " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                        " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                        " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                        " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  TRIM(CV.AUDITORIA) = TRIM('" + this.auditoria + "') AND TRIM(CV.BODEGA) = TRIM('" + this.bodega + "')))  " +
                                        " ORDER BY TRIM(UBICACION) ASC ";
                            }
                        }
                    }
                }
                break;
            }


            case Conteo.BUSCAR_POR_ITEM: {
                sql = Conteo.SELECT_CONTEO;
                if (this.conteocode != null) {
                    if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_001) == 0) {
                        where = "    WHERE " +
                                "    TRIM(P.BODEGA) =  TRIM('" + this.bodega + " ') " +
                                "    AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+)) " +
                                "    AND TRIM(P.CODIGO) LIKE TRIM('" + this.codigo.trim() + "%') " +
                                "    AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+)) " +
                                "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION(+)) " +
                                "    AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))) " +
                                "    ORDER BY TRIM(UBICACION) ASC ";
                    } else {
                        if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_002) == 0) {
                            where = "  WHERE   " +
                                    " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                    "    AND TRIM(P.CODIGO) LIKE TRIM('" + this.codigo.trim() + "%') " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                    "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                    " AND TRIM(C.AUDITORIA) = TRIM('" + this.auditoria + "')   " +

                                    " AND NVL(C.DIFERENCIA1,-999999)!= 0 " +
                                    " UNION " +
                                    " SELECT   " +
                                    " P.BODEGA, " +
                                    " P.UBICACION, " +
                                    " P.CODIGO,  " +
                                    " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                    " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                    " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                    " P.FAMILIA,   " +
                                    " P.NUMERO_CORTO,  " +
                                    " C.OBSERVACION, " +
                                    " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                    " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                    " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                    " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                    " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                    " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                    " C.AUDITORIA,  " +
                                    " C.GRUPO, " +
                                    " C.GRUPOC1, " +
                                    " C.GRUPOC2, " +
                                    " C.GRUPOC3, " +
                                    " C.OBSERVACIONC1, " +
                                    " C.OBSERVACIONC2, " +
                                    " C.OBSERVACIONC3 " +
                                    " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                    " WHERE   " +
                                    " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                    "    AND TRIM(P.CODIGO) LIKE TRIM('" + this.codigo.trim() + "%') " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                    " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                    " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                    " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  TRIM(CV.AUDITORIA) = TRIM('" + this.auditoria + "') AND TRIM(CV.BODEGA) = TRIM('" + this.bodega + "')))  " +
                                    " ORDER BY TRIM(UBICACION) ASC ";
                        } else {
                            if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_003) == 0) {
                                where = " WHERE   " +
                                        " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                        "    AND TRIM(P.CODIGO) LIKE TRIM('" + this.codigo.trim() + "%') " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                        "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                        " AND TRIM(C.AUDITORIA) = TRIM('" + this.auditoria + "')   " +
                                        " AND ((NVL(C.DIFERENCIA1,-999999) != NVL(C.DIFERENCIA2,-888888) AND NVL(C.DIFERENCIA1,-999999)!=0 AND NVL(C.DIFERENCIA2,-888888)!=0)) " +
                                        " UNION " +
                                        " SELECT   " +
                                        " P.BODEGA, " +
                                        " P.UBICACION, " +
                                        " P.CODIGO,  " +
                                        " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                        " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                        " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                        " P.FAMILIA,   " +
                                        " P.NUMERO_CORTO,  " +
                                        " C.OBSERVACION, " +
                                        " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                        " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                        " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                        " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                        " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                        " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                        " C.AUDITORIA,  " +
                                        " C.GRUPO, " +
                                        " C.GRUPOC1, " +
                                        " C.GRUPOC2, " +
                                        " C.GRUPOC3, " +
                                        " C.OBSERVACIONC1, " +
                                        " C.OBSERVACIONC2, " +
                                        " C.OBSERVACIONC3 " +
                                        " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                        " WHERE   " +
                                        " TRIM(P.BODEGA) =  TRIM('" + this.bodega + "')   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                        "    AND TRIM(P.CODIGO) LIKE TRIM('" + this.codigo.trim() + "%') " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                        " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                        " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                        " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  TRIM(CV.AUDITORIA) = TRIM('" + this.auditoria + "') AND TRIM(CV.BODEGA) = TRIM('" + this.bodega + "')))  " +
                                        " ORDER BY TRIM(UBICACION) ASC ";
                            }
                        }
                    }
                }
                break;
            }


            case Conteo.BUSCA_UBICACION: {
                sql = Conteo.SELECT_CONTEO;
                if (this.conteocode != null) {
                    if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_001) == 0) {
                        where = "  WHERE " +
                                "    UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + " ')) " +
                                "    AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+)) " +
                                "    AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+)) " +
                                "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION(+)) " +
                                "    AND UPPER(TRIM(P.UBICACION)) LIKE UPPER(TRIM('" + this.ubicacion.trim() + "%'))" +
                                "   AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))) " +
                                "    ORDER BY TRIM(UBICACION) ASC ";
                    } else {
                        if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_002) == 0) {
                            where = "  WHERE   " +
                                    " TRIM(P.BODEGA) = UPPER(TRIM('" + this.bodega + "'))  " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                    "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                    "    AND UPPER(TRIM(P.UBICACION)) LIKE UPPER(TRIM('" + this.ubicacion.trim() + "%'))" +
                                    " AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "'))   " +
                                    " AND NVL(C.DIFERENCIA1,-999999)!= 0 " +
                                    " UNION " +
                                    " SELECT   " +
                                    " P.BODEGA, " +
                                    " P.UBICACION, " +
                                    " P.CODIGO,  " +
                                    " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                    " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                    " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                    " P.FAMILIA,   " +
                                    " P.NUMERO_CORTO,  " +
                                    " C.OBSERVACION, " +
                                    " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                    " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                    " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                    " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                    " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                    " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                    " C.AUDITORIA,  " +
                                    " C.GRUPO, " +
                                    " C.GRUPOC1, " +
                                    " C.GRUPOC2, " +
                                    " C.GRUPOC3, " +
                                    " C.OBSERVACIONC1, " +
                                    " C.OBSERVACIONC2, " +
                                    " C.OBSERVACIONC3 " +
                                    " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                    " WHERE   " +
                                    " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                    " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                    "    AND UPPER(TRIM(P.UBICACION)) LIKE UPPER(TRIM('" + this.ubicacion.trim() + "%'))" +
                                    " AND UPPER(TRIM(C.AUDITORIA(+))) = UPPER(TRIM('" + this.auditoria + "'))   " +
                                    " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  UPPER(TRIM(CV.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) AND UPPER(TRIM(CV.BODEGA)) = UPPER(TRIM('" + this.bodega + "'))))  " +
                                    " ORDER BY TRIM(UBICACION) ASC ";
                        } else {
                            if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_003) == 0) {
                                where = " WHERE   " +
                                        " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                        "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                        "    AND UPPER(TRIM(P.UBICACION)) LIKE UPPER(TRIM('" + this.ubicacion.trim() + "%'))" +
                                        " AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) " +
                                        " AND ((NVL(C.DIFERENCIA1,-999999) != NVL(C.DIFERENCIA2,-888888) AND NVL(C.DIFERENCIA1,-999999)!=0 AND NVL(C.DIFERENCIA2,-888888)!=0)) " +
                                        " UNION " +
                                        " SELECT   " +
                                        " P.BODEGA, " +
                                        " P.UBICACION, " +
                                        " P.CODIGO,  " +
                                        " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                        " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                        " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                        " P.FAMILIA,   " +
                                        " P.NUMERO_CORTO,  " +
                                        " C.OBSERVACION, " +
                                        " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                        " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                        " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                        " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                        " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                        " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                        " C.AUDITORIA,  " +
                                        " C.GRUPO, " +
                                        " C.GRUPOC1, " +
                                        " C.GRUPOC2, " +
                                        " C.GRUPOC3, " +
                                        " C.OBSERVACIONC1, " +
                                        " C.OBSERVACIONC2, " +
                                        " C.OBSERVACIONC3 " +
                                        " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                        " WHERE   " +
                                        " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                        " AND UPPER(TRIM(P.UBICACION)) = UPPER(TRIM(C.UBICACION(+)))   " +
                                        "    AND UPPER(TRIM(P.UBICACION)) LIKE UPPER(TRIM('" + this.ubicacion.trim() + "%'))" +
                                        " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                        " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  UPPER(TRIM(CV.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) AND UPPER(TRIM(CV.BODEGA)) = UPPER(TRIM('" + this.bodega + "'))))  " +
                                        " ORDER BY TRIM(UBICACION) ASC ";
                            }
                        }
                    }
                }
                break;
            }

            case Conteo.BUSCAR_RANGO_UBUCACIONES: {
                sql = Conteo.SELECT_CONTEO;
                if (this.conteocode != null) {
                    if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_001) == 0) {
                        where = "  WHERE " +
                                "    UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + " ')) " +
                                "    AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+)) " +
                                "    AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+)) " +
                                "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION(+)) " +
                                "    AND UPPER(TRIM(P.UBICACION)) BETWEEN UPPER(TRIM('" + this.ubicacion + "')) AND UPPER(TRIM('" + this.observacion + "')) " +
                                "   AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))) " +
                                "    ORDER BY TRIM(UBICACION) ASC ";
                    } else {
                        if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_002) == 0) {
                            where = "  WHERE   " +
                                    " TRIM(P.BODEGA) = UPPER(TRIM('" + this.bodega + "'))  " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                    "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                    "    AND UPPER(TRIM(P.UBICACION)) BETWEEN UPPER(TRIM('" + this.ubicacion + "')) AND UPPER(TRIM('" + this.observacion + "')) " +
                                    " AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "'))   " +
                                    " AND NVL(C.DIFERENCIA1,-999999)!= 0 " +
                                    " UNION " +
                                    " SELECT   " +
                                    " P.BODEGA, " +
                                    " P.UBICACION, " +
                                    " P.CODIGO,  " +
                                    " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                    " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                    " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                    " P.FAMILIA,   " +
                                    " P.NUMERO_CORTO,  " +
                                    " C.OBSERVACION, " +
                                    " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                    " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                    " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                    " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                    " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                    " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                    " C.AUDITORIA,  " +
                                    " C.GRUPO, " +
                                    " C.GRUPOC1, " +
                                    " C.GRUPOC2, " +
                                    " C.GRUPOC3, " +
                                    " C.OBSERVACIONC1, " +
                                    " C.OBSERVACIONC2, " +
                                    " C.OBSERVACIONC3 " +
                                    " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                    " WHERE   " +
                                    " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                    " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+))   " +
                                    "    AND UPPER(TRIM(P.UBICACION)) BETWEEN UPPER(TRIM('" + this.ubicacion + "')) AND UPPER(TRIM('" + this.observacion + "')) " +
                                    " AND UPPER(TRIM(C.AUDITORIA(+))) = UPPER(TRIM('" + this.auditoria + "'))   " +
                                    " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  UPPER(TRIM(CV.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) AND UPPER(TRIM(CV.BODEGA)) = UPPER(TRIM('" + this.bodega + "'))))  " +
                                    " ORDER BY TRIM(UBICACION) ASC ";
                        } else {
                            if (this.conteocode.trim().compareToIgnoreCase(Conteo.CC_003) == 0) {
                                where = " WHERE   " +
                                        " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO)   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA)   " +
                                        "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                                        "    AND UPPER(TRIM(P.UBICACION)) BETWEEN UPPER(TRIM('" + this.ubicacion + "')) AND UPPER(TRIM('" + this.observacion + "')) " +
                                        " AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) " +
                                        " AND ((NVL(C.DIFERENCIA1,-999999) != NVL(C.DIFERENCIA2,-888888) AND NVL(C.DIFERENCIA1,-999999)!=0 AND NVL(C.DIFERENCIA2,-888888)!=0)) " +
                                        " UNION " +
                                        " SELECT   " +
                                        " P.BODEGA, " +
                                        " P.UBICACION, " +
                                        " P.CODIGO,  " +
                                        " NVL(P.CANTIDAD,0)/100 CANTIDAD,  " +
                                        " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION,  " +
                                        " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO,  " +
                                        " P.FAMILIA,   " +
                                        " P.NUMERO_CORTO,  " +
                                        " C.OBSERVACION, " +
                                        " NVL(C.CONTEO1,-9999999)/1000  CONTEO1,  " +
                                        " NVL(C.DIFERENCIA1,-9999999)/1000  DIFERENCIA1,  " +
                                        " NVL(C.CONTEO2,-9999999)/1000  CONTEO2,  " +
                                        " NVL(C.DIFERENCIA2,-9999999)/1000  DIFERENCIA2,  " +
                                        " NVL(C.CONTEO3,-9999999)/1000  CONTEO3,  " +
                                        " NVL(C.DIFERENCIA3,-9999999)/1000  DIFERENCIA3,  " +
                                        " C.AUDITORIA,  " +
                                        " C.GRUPO, " +
                                        " C.GRUPOC1, " +
                                        " C.GRUPOC2, " +
                                        " C.GRUPOC3, " +
                                        " C.OBSERVACIONC1, " +
                                        " C.OBSERVACIONC2, " +
                                        " C.OBSERVACIONC3 " +
                                        " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C   " +
                                        " WHERE   " +
                                        " UPPER(TRIM(P.BODEGA)) =  UPPER(TRIM('" + this.bodega + "'))   " +
                                        " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+))   " +
                                        " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+))   " +
                                        " AND UPPER(TRIM(P.UBICACION)) = UPPER(TRIM(C.UBICACION(+)))   " +
                                        "    AND UPPER(TRIM(P.UBICACION)) BETWEEN UPPER(TRIM('" + this.ubicacion + "')) AND UPPER(TRIM('" + this.observacion + "')) " +
                                        " AND UPPER(TRIM(P.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + " ')) AND UPPER(TRIM(C.AUDITORIA)) = UPPER(TRIM(P.AUDITORIA))   " +
                                        " AND TRIM(P.CODIGO)  NOT IN (SELECT TRIM(CV.CODIGO) FROM  JDE_TO_OPEN_CONTEO CV  WHERE  UPPER(TRIM(CV.AUDITORIA)) = UPPER(TRIM('" + this.auditoria + "')) AND UPPER(TRIM(CV.BODEGA)) = UPPER(TRIM('" + this.bodega + "'))))  " +
                                        " ORDER BY TRIM(UBICACION) ASC ";
                            }
                        }
                    }
                }
                break;
            }

            case Conteo.BUSCAR_MAESTRO_OPEN: {
                sql = SELECT_MAESTRO_OPEN;
                where = " WHERE TRIM(M.CODIGO) = '" + this.getCodigo() + "'";
                break;
            }
            default: {
                sql = Conteo.SELECT_CONTEO;
                where = "  WHERE " +
                        "    TRIM(P.BODEGA) =  TRIM('" + this.bodega + " ') " +
                        "    AND TRIM(P.CODIGO) = TRIM(C.CODIGO) " +
                        "    AND TRIM(P.BODEGA) = TRIM(C.BODEGA) " +
                        "    AND NVL(TRIM(P.UBICACION),'---') = TRIM(C.UBICACION) " +
                        "                         AND TRIM(C.AUDITORIA) = TRIM('" + this.auditoria + " ')) " +
                        "                         ORDER BY TRIM(UBICACION) ASC ";
            }
        }
        return where;
    }
}
