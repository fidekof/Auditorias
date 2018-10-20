package mva.api.taller.bodega.bo;

import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.dao.DaoAuditorias;
import mva.api.taller.bodega.models.Conteo;

import java.util.ArrayList;
import java.util.Collection;

public class BoAuditorias
{
    public ArrayList<Conteo> ProductsGetAllByBodegaBO(Conteo product, ConexionJde conexionMotorec, int typeSearch) {
        ArrayList<Conteo> productArrayList = new ArrayList<Conteo>();
        if (conexionMotorec != null) {
            try {
                DaoAuditorias daoAuditorias = new DaoAuditorias();
                productArrayList = daoAuditorias.ProductsGetAllByBodegaDAO(product,conexionMotorec, typeSearch);
            } catch (Exception e) {
                return productArrayList;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return productArrayList;
    }


    public ArrayList<Conteo> getCountLisBO(Conteo product, ConexionJde conexionMotorec, int typeSearch) {
        ArrayList<Conteo> productArrayList = new ArrayList<Conteo>();
        if (conexionMotorec != null) {
            try {
                DaoAuditorias daoAuditorias = new DaoAuditorias();
                productArrayList = daoAuditorias.getCountListDao(product,conexionMotorec, typeSearch);
            } catch (Exception e) {
                return productArrayList;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return productArrayList;
    }

    public ArrayList<Conteo> ProductsGetAllByUbicacionBO(Conteo productI, Conteo productF, ConexionJde conexionMotorec, int typeSearch) {
        ArrayList<Conteo> productArrayList = new ArrayList<Conteo>();
        if (conexionMotorec != null) {
            try {
                DaoAuditorias daoAuditorias = new DaoAuditorias();
                productArrayList = daoAuditorias.ProductsGetAllByUbicacionDAO(productI, productF,  conexionMotorec, typeSearch);
            } catch (Exception e) {
                return productArrayList;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return productArrayList;
    }

    public String CountsSaveBO(Conteo conteo, ConexionJde conexionMotorec)
    {
        String result = "ERROR";
        if (conexionMotorec != null) {
            try {
                DaoAuditorias daoAuditorias = new DaoAuditorias();
                result = daoAuditorias.CountsSaveDAO(conteo, conexionMotorec);
            } catch (Exception e) {
                return result;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return result;
    }

    public Collection<Conteo> ProductGetAllByTypeSearchBo(Conteo conteo, int typeSearch,  ConexionJde conexionMotorec)
    {
        ArrayList<Conteo> productArrayList = new ArrayList<Conteo>();
        if (conexionMotorec != null) {
            try {
                DaoAuditorias daoAuditorias = new DaoAuditorias();
                productArrayList = daoAuditorias.ProductGetAllByTypeSearchBo( conteo,  typeSearch,   conexionMotorec);
            } catch (Exception e) {
                return productArrayList;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return productArrayList;
    }

    public String ItemSaveBO(Conteo conteo, ConexionJde conexionMotorec) {
        String result = "ERROR";
        if (conexionMotorec != null) {
            try {
                DaoAuditorias daoAuditorias = new DaoAuditorias();
                result = daoAuditorias.ItemSaveDAO(conteo, conexionMotorec);
            } catch (Exception e) {
                return result;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return result;
    }

    public Collection<Conteo> searchResumenCountsBo(Conteo conteo, int typesearch, ConexionJde conexionMotorec) {
        ArrayList<Conteo> productArrayList = new ArrayList<Conteo>();
        if (conexionMotorec != null) {
            try {
                DaoAuditorias daoAuditorias = new DaoAuditorias();
                productArrayList = daoAuditorias.searchResumenCountsBo(conteo, typesearch, conexionMotorec);
            } catch (Exception e) {
                return productArrayList;
            } finally {
                conexionMotorec.desconectarJD();
            }
        }
        return productArrayList;
    }
}
