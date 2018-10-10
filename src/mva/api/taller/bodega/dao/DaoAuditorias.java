package mva.api.taller.bodega.dao;

import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.models.Conteo;
import mva.api.taller.bodega.models.Tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoAuditorias {
    public static final int ALL_BY_BODEGA = 1;
    public static final int ALL_BY_BODEGA_AND_PRODUCTCODE = 2;
    public static final int ALL_BY_BODEGA_AND_UBICACIONES = 3;
    public static final int ALL_BY_BODEGA_UDITORIA = 4;

    public ArrayList<Conteo> ProductsGetAllByBodegaDAO(Conteo product, ConexionJde conexionJde, int typeSearch)
    {
        return this.getListProduct(product, null,  typeSearch, conexionJde);
    }


    public ArrayList<Conteo> getCountListDao(Conteo product, ConexionJde conexionJde, int typeSearch)
    {
        return this.getListConteo(product, null,  typeSearch, conexionJde);
    }


    public ArrayList<Conteo> ProductsGetAllByUbicacionDAO(Conteo productI, Conteo productF, ConexionJde conexionJde, int typeSearch)
    {
        return this.getListProduct(productI, productF,  typeSearch, conexionJde);
    }

    private ArrayList<Conteo> getListProduct(Conteo productI,Conteo productF, int option, ConexionJde conexionJde) {

        ArrayList<Conteo> productArrayList = new ArrayList<Conteo>();
        String wheresql = "";
        switch (option)
        {
            case ALL_BY_BODEGA:
            {
                if(productI != null && productI.getBodega() != null && productI.getBodega().trim().isEmpty()==false){

                    if(productI.getConteocode().compareToIgnoreCase("C002")==0)
                    {
                       wheresql = " WHERE \n" +
                               "                        TRIM(UPPER(P.BODEGA)) =  TRIM('"+productI.getBodega().toUpperCase()+"') " +
                               "                        AND TRIM(P.CODIGO) = TRIM(C.CODIGO) " +
                               "                        AND TRIM(P.BODEGA) = TRIM(C.BODEGA) " +
                               "                        AND TRIM(P.UBICACION) = TRIM(C.UBICACION) " +
                               "                        AND TRIM(UPPER(C.AUDITORIA)) = TRIM('"+productI.getAuditoria().toUpperCase()+"') " +
                               "                        AND C.DIFERENCIA1 != 0 " +
                               "                        ORDER BY P.UBICACION ASC ";


                    }
                    else{
                        if(productI.getConteocode().compareToIgnoreCase("C003")==0)
                        {
                            wheresql = " WHERE \n" +
                                    "                        TRIM(UPPER(P.BODEGA)) =  TRIM('"+productI.getBodega().toUpperCase()+"') " +
                                    "                        AND TRIM(P.CODIGO) = TRIM(C.CODIGO) " +
                                    "                        AND TRIM(P.BODEGA) = TRIM(C.BODEGA) " +
                                    "                        AND TRIM(P.UBICACION) = TRIM(C.UBICACION) " +
                                    "                        AND TRIM(UPPER(C.AUDITORIA)) = TRIM('"+productI.getAuditoria().toUpperCase()+"') " +
                                    "                        AND C.DIFERENCIA2 != 0 " +
                                    "                        ORDER BY P.UBICACION ASC ";
                        }
                        else{
                            wheresql =  " WHERE " +
                                    " TRIM(UPPER(P.BODEGA)) =  TRIM('"+productI.getBodega().toUpperCase()+"') " +
                                    " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+)) " +
                                    " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+)) " +
                                    " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+)) " +
                                    " AND TRIM(UPPER(C.AUDITORIA(+))) = TRIM('"+productI.getAuditoria().toUpperCase()+"') " +
                                    " ORDER BY P.UBICACION ASC ";
                        }
                    }
                    productArrayList = getListProductFromOpen(wheresql, conexionJde);
                }
                break;
            }

            case ALL_BY_BODEGA_AND_PRODUCTCODE:
            {
                if(productI != null &&
                        productI.getBodega() != null &&
                        productI.getBodega().trim().isEmpty()==false &&
                        productI.getCodigo() != null &&
                        productI.getCodigo().trim().isEmpty()==false
                ){

                    wheresql =  " WHERE " +
                            " TRIM(UPPER(P.BODEGA)) =  TRIM('"+productI.getBodega().toUpperCase().trim()+"') " +
                            " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+)) " +
                            " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+)) " +
                            " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+)) " +
                            " AND TRIM(UPPER(P.CODIGO)) LIKE TRIM('%"+productI.getCodigo().toUpperCase().trim()+"%') " +
                            " AND TRIM(UPPER(C.AUDITORIA(+))) = TRIM('"+productI.getAuditoria().toUpperCase()+"') " +
                            " ORDER BY P.UBICACION ASC ";

                    productArrayList = getListProductFromOpen(wheresql, conexionJde);
                }
                break;
            }


            case ALL_BY_BODEGA_AND_UBICACIONES:
            {
                if(productI != null &&
                        productI.getBodega() != null &&
                        productI.getBodega().trim().isEmpty()==false &&
                        productI.getUbicacion() != null &&
                        productI.getUbicacion().trim().isEmpty()==false &&
                        productF.getUbicacion() != null &&
                        productF.getUbicacion().trim().isEmpty()==false &&
                        productI.getConteocode() != null &&
                        productI.getConteocode().isEmpty() == false
                ){






                    wheresql =  " WHERE " +
                            " TRIM(UPPER(P.BODEGA)) =  TRIM('"+productI.getBodega().toUpperCase().trim()+"') " +
                            " AND TRIM(P.CODIGO) = TRIM(C.CODIGO(+)) " +
                            " AND TRIM(P.BODEGA) = TRIM(C.BODEGA(+)) " +
                            " AND TRIM(P.UBICACION) = TRIM(C.UBICACION(+)) " +
                            " AND TRIM(UPPER(P.UBICACION)) BETWEEN '" +productI.getUbicacion().toUpperCase().trim() +"' AND '" +productF.getUbicacion().toUpperCase().trim() + "' " +
                            " AND TRIM(UPPER(C.AUDITORIA(+))) = TRIM('"+productI.getAuditoria().toUpperCase()+"') " +
                            " ORDER BY P.UBICACION ASC ";

                    productArrayList = getListProductFromOpen(wheresql, conexionJde);
                }
                break;
            }

            default:
                {
                    productArrayList = new  ArrayList<Conteo>();
                    break;
                }
        }
        return productArrayList;
    }


    private ArrayList<Conteo> getListProductFromOpen(String sql, ConexionJde conexionJde) {

        ArrayList<Conteo> productArrayList = new ArrayList<Conteo>();
        Statement stmt;
        try
        {
            stmt = conexionJde.getConexionOpenMotorec().getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs != null) {
                Conteo conteo;
                while (rs.next() == true) {
                    conteo = new Conteo();
                    conteo.setBodega(Tools.cleanString(rs.getString("BODEGA")));
                    conteo.setUbicacion(Tools.cleanString(rs.getString("UBICACION")));

                    conteo.setCodigo(Tools.cleanString(rs.getString("CODIGO")));
                    conteo.setCantidad(Tools.cleanString(rs.getString("CANTIDAD")));

                    conteo.setDescripcion(Tools.cleanString(rs.getString("DESCRIPCION")));

                    conteo.setGrupo(Tools.cleanString(rs.getString("GRUPO")));
                    conteo.setAuditoria(Tools.cleanString(rs.getString("AUDITORIA")));

                    conteo.setConteo1(Tools.cleanString(rs.getString("CONTEO1")));
                    conteo.setDiferencia1(Tools.cleanString(rs.getString("DIFERENCIA1")));

                    conteo.setConteo2(Tools.cleanString(rs.getString("CONTEO2")));
                    conteo.setDiferencia2(Tools.cleanString(rs.getString("DIFERENCIA2")));

                    conteo.setConteo3(Tools.cleanString(rs.getString("CONTEO3")));
                    conteo.setDiferencia3(Tools.cleanString(rs.getString("DIFERENCIA3")));

                    conteo.setCostounitario(Tools.cleanString(rs.getString("COSTO_UNITARIO")));
                    conteo.setFamilia(Tools.cleanString(rs.getString("FAMILIA")));

                    conteo.setObservacion(Tools.cleanString(rs.getString("OBSERVACION")));

                    conteo.setgrupoc1(Tools.cleanString(rs.getString("GRUPOC1")));
                    conteo.setgrupoc2(Tools.cleanString(rs.getString("GRUPOC2")));
                    conteo.setgrupoc3(Tools.cleanString(rs.getString("GRUPOC3")));


                    conteo.setObservacion1(Tools.cleanString(rs.getString("OBSERVACIONC1")));
                    conteo.setObservacion2(Tools.cleanString(rs.getString("OBSERVACIONC2")));
                    conteo.setObservacion3(Tools.cleanString(rs.getString("OBSERVACIONC3")));


                    productArrayList.add(conteo);
                }

            }
        } catch (SQLException e) {
            productArrayList.add(new Conteo());
        }
        finally {
            return productArrayList;
        }

    }




    private ArrayList<Conteo> getListConteo(Conteo conteoI,Conteo conteoF, int option, ConexionJde conexionJde) {

        ArrayList<Conteo> conteoArrayList = new ArrayList<Conteo>();
        String wheresql = "";
        switch (option)
        {
            case ALL_BY_BODEGA:
            {
                if(conteoI != null && conteoI.getBodega() != null && conteoI.getBodega().trim().isEmpty()==false)
                {
                    wheresql = " WHERE " +
                            "                        TRIM(P.BODEGA) =  TRIM('"+conteoI.getBodega()+"') " +
                            "                        AND TRIM(P.CODIGO) = TRIM(C.CODIGO) " +
                            "                        AND TRIM(P.BODEGA) = TRIM(C.BODEGA) " +
                            "                        AND TRIM(P.UBICACION) = TRIM(C.UBICACION) " +
                            "                        AND TRIM(C.AUDITORIA) = TRIM('"+conteoI.getAuditoria()+"') " +
                            "                        ORDER BY TRIM(P.UBICACION) ASC ";


                    conteoArrayList = getListProductsCounts(wheresql, conexionJde);
                }
                break;
            }

            case ALL_BY_BODEGA_AND_PRODUCTCODE:
            {
                if(conteoI != null &&
                        conteoI.getBodega() != null &&
                        conteoI.getBodega().trim().isEmpty()==false &&
                        conteoI.getCodigo() != null &&
                        conteoI.getCodigo().trim().isEmpty()==false &&
                        conteoI.getAuditoria() != null &&
                        conteoI.getAuditoria().trim().isEmpty()==false
                ){

                    wheresql = " WHERE " +
                            "                        TRIM(P.BODEGA) =  TRIM('"+conteoI.getBodega().trim()+"') " +
                            "                        AND TRIM(P.CODIGO) LIKE '%"+conteoI.getCodigo().trim()+"%' "+
                            "                        AND TRIM(P.BODEGA) = TRIM(C.BODEGA) " +
                            "                        AND TRIM(P.UBICACION) = TRIM(C.UBICACION) " +
                            "                        AND TRIM(C.AUDITORIA) = TRIM('"+conteoI.getAuditoria()+"') " +
                            "                        ORDER BY TRIM(P.UBICACION) ASC ";


                    conteoArrayList = getListProductsCounts(wheresql, conexionJde);
                }
                break;
            }


            case ALL_BY_BODEGA_AND_UBICACIONES:
            {
                if(conteoI != null &&
                        conteoI.getBodega() != null &&
                        conteoI.getBodega().trim().isEmpty()==false &&
                        conteoI.getUbicacion() != null &&
                        conteoI.getUbicacion().trim().isEmpty()==false &&
                        conteoI.getAuditoria() != null &&
                        conteoI.getAuditoria().trim().isEmpty()==false &&
                        conteoF.getUbicacion() != null &&
                        conteoF.getUbicacion().trim().isEmpty()==false
                ){

                    wheresql = " WHERE " +
                            "   TRIM(P.BODEGA) =  TRIM('"+conteoI.getBodega()+"') " +
                            "   AND TRIM(P.CODIGO) = TRIM(C.CODIGO) " +
                            "   AND TRIM(P.BODEGA) = TRIM(C.BODEGA) " +
                            "   AND TRIM(P.UBICACION) = TRIM(C.UBICACION) " +
                            "   AND TRIM(C.UBICACION) BETWEEN '"
                            +   conteoI.getUbicacion().trim() +"' AND '"
                            +   conteoF.getUbicacion().trim() + "' AND " +
                            "                        AND TRIM(C.AUDITORIA) = TRIM('"+conteoI.getAuditoria()+"') " +
                            "                        ORDER BY TRIM(P.UBICACION) ASC ";



                    conteoArrayList = getListProductFromOpen(wheresql, conexionJde);
                }
                break;
            }

            default:
            {
                conteoArrayList = new  ArrayList<Conteo>();
                break;
            }
        }
        return conteoArrayList;
    }



    private ArrayList<Conteo> getListProductsCounts(String wheresql, ConexionJde conexionJde) {
        String sql = " SELECT  " +
                " P.BODEGA, " +
                " P.UBICACION, " +
                " P.CODIGO, " +
                " NVL(P.CANTIDAD,0)/100 CANTIDAD, " +
                " P.DESCRIPCION || P.DESCRIPCION2 AS DESCRIPCION, " +
                " NVL(P.COSTO_UNITARIO,0)/10000  COSTO_UNITARIO, " +
                " P.FAMILIA,  " +
                " P.NUMERO_CORTO, " +
                " C.OBSERVACION, " +
                " NVL(C.CONTEO1,0)/1000 CONTEO1, " +
                " NVL(C.DIFERENCIA1,0)/1000 DIFERENCIA1, " +
                " NVL(C.CONTEO2,0)/1000 CONTEO2, " +
                " NVL(C.DIFERENCIA2,0)/1000 DIFERENCIA2, " +
                " NVL(C.CONTEO3,0)/1000 CONTEO3, " +
                " NVL(C.DIFERENCIA3,0)/1000 DIFERENCIA3, " +
                " C.AUDITORIA, " +
                " C.GRUPO ," +
                " C.GRUPOC1, "+
                " C.GRUPOC2, "+
                " C.GRUPOC3, " +
                " C.OBSERVACIONC1, "+
                " C.OBSERVACIONC2, "+
                " C.OBSERVACIONC3 "+

                " FROM JDE_TO_OPEN_PRODUCTO P, JDE_TO_OPEN_CONTEO C "
                + wheresql;
        ArrayList<Conteo> productArrayList = new ArrayList<Conteo>();
        Statement stmt;
        try
        {
            stmt = conexionJde.getConexionOpenMotorec().getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs != null) {
                Conteo conteo;
                while (rs.next() == true)
                {
                    conteo = new Conteo();

                    conteo = new Conteo();
                    conteo.setBodega(Tools.cleanString(rs.getString("BODEGA")));
                    conteo.setUbicacion(Tools.cleanString(rs.getString("UBICACION")));

                    conteo.setCodigo(Tools.cleanString(rs.getString("CODIGO")));
                    conteo.setCantidad(Tools.cleanString(rs.getString("CANTIDAD")));

                    conteo.setDescripcion(Tools.cleanString(rs.getString("DESCRIPCION")));

                    conteo.setGrupo(Tools.cleanString(rs.getString("GRUPO")));
                    conteo.setAuditoria(Tools.cleanString(rs.getString("AUDITORIA")));

                    conteo.setConteo1(Tools.cleanString(rs.getString("CONTEO1")));
                    conteo.setDiferencia1(Tools.cleanString(rs.getString("DIFERENCIA1")));

                    conteo.setConteo2(Tools.cleanString(rs.getString("CONTEO2")));
                    conteo.setDiferencia2(Tools.cleanString(rs.getString("DIFERENCIA2")));

                    conteo.setConteo3(Tools.cleanString(rs.getString("CONTEO3")));
                    conteo.setDiferencia3(Tools.cleanString(rs.getString("DIFERENCIA3")));

                    conteo.setCostounitario(Tools.cleanString(rs.getString("COSTO_UNITARIO")));
                    conteo.setFamilia(Tools.cleanString(rs.getString("FAMILIA")));

                    conteo.setObservacion(Tools.cleanString(rs.getString("OBSERVACION")));


                    conteo.setgrupoc1(Tools.cleanString(rs.getString("GRUPOC1")));
                    conteo.setgrupoc2(Tools.cleanString(rs.getString("GRUPOC2")));
                    conteo.setgrupoc3(Tools.cleanString(rs.getString("GRUPOC3")));


                    conteo.setObservacion1(Tools.cleanString(rs.getString("OBSERVACIONC1")));
                    conteo.setObservacion2(Tools.cleanString(rs.getString("OBSERVACIONC2")));
                    conteo.setObservacion3(Tools.cleanString(rs.getString("OBSERVACIONC3")));

                    productArrayList.add(conteo);
                }

            }
        } catch (SQLException e) {
            productArrayList.add(new Conteo());
        }
        finally {
            return productArrayList;
        }

    }


    public String CountsSaveDAO(Conteo conteo, ConexionJde conexionMotorec) {
        Statement statement = null;
        int resultado = 0;
        String salida = "ERROR";
        Connection connection = conexionMotorec.getConexionOpenMotorec().getCon();
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                resultado += conteo.generarInsertConteo(connection);
                resultado += conteo.generarUpdateConteo(connection);
                connection.commit();
                salida = resultado > 0 ? "OK" : "ERROR";


            } catch (SQLException e) {e.printStackTrace();}
            finally {
                return salida;
            }
        }
        return salida;
    }

    public ArrayList<Conteo> ProductGetAllByTypeSearchBo(Conteo conteo, int typeSearch, ConexionJde conexionMotorec) {
        return getListProductFromOpen(conteo.getSqlByTypeSearch(typeSearch), conexionMotorec);
    }

    public String ItemSaveDAO(Conteo conteo, ConexionJde conexionMotorec) {
        Statement statement = null;
        int resultado = 0;
        String salida = "ERROR";
        Connection connection = conexionMotorec.getConexionOpenMotorec().getCon();
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                resultado += conteo.generarInsertItem(connection);
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
