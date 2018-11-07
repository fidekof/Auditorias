package mva.api.taller.bodega.dao;

import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.models.Conteo;
import mva.api.taller.bodega.models.Tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoInventario {

    public ArrayList<Conteo> BuscarConteosPorTipoConteoGrupoDao(Conteo conteo, int tipoBusqueda, ConexionJde conexionMotorec) {
        return obtenerListaDeConteosPoRGrupo(conteo.obtenerSqlPorTipoDeBusqueda(tipoBusqueda), conexionMotorec);
    }


    private ArrayList<Conteo> obtenerListaDeConteosPoRGrupo(String sql, ConexionJde conexionJde) {

        ArrayList<Conteo> productArrayList = new ArrayList<Conteo>();
        Statement stmt;
        try {
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


                    conteo.generarConteoFinal();
                    productArrayList.add(conteo);
                }

            }
        } catch (SQLException e) {
            productArrayList.add(new Conteo());
        } finally {
            return productArrayList;
        }

    }


}
