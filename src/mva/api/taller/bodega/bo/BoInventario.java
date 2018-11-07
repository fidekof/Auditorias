package mva.api.taller.bodega.bo;

import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.dao.DaoInventario;
import mva.api.taller.bodega.models.Conteo;

import java.util.ArrayList;
import java.util.Collection;

public class BoInventario {
    public Collection<Conteo> BuscarConteosPorTipoConteoGrupoDao(Conteo conteo, int tipoBusqueda, ConexionJde conexionMotorec) {
        ArrayList<Conteo> productArrayList = new ArrayList<Conteo>();
        if (conexionMotorec != null) {
            try {
                DaoInventario daoInventario = new DaoInventario();
                productArrayList = daoInventario.BuscarConteosPorTipoConteoGrupoDao(conteo, tipoBusqueda, conexionMotorec);
            } catch (Exception e) {
                return productArrayList;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return productArrayList;
    }
}
