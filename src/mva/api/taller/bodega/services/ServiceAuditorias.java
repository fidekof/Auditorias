package mva.api.taller.bodega.services;

import mva.api.taller.bodega.bo.BoAuditorias;
import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.interfaces.InterfaceAuditorias;
import mva.api.taller.bodega.models.Conteo;
import mva.api.taller.bodega.models.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ServiceAuditorias implements InterfaceAuditorias {
    @Override
    public Collection<Conteo> ProductsGet(Conteo product, int typeSearch) {
        return (new BoAuditorias()).ProductsGetAllByBodegaBO(product,(new ConexionJde()),typeSearch);
    }

    @Override
    public Collection<Conteo> ProductsGetByUbicaciones(Conteo productI, Conteo productF, int typeSearch) {
        return (new BoAuditorias()).ProductsGetAllByUbicacionBO(productI, productF, (new ConexionJde()),typeSearch);
    }

    @Override
    public Collection<Conteo> CountGet(Conteo count, int typeSearch) {
        return (new BoAuditorias()).getCountLisBO(count,(new ConexionJde()),typeSearch);

    }

    @Override
    public String CountsSave(Conteo conteo) {
        return (new BoAuditorias()).CountsSaveBO(conteo,  (new ConexionJde()));
    }

    @Override
    public Collection<Conteo> ProductGetAllByTypeSearch(Conteo conteo, int typesearch) {
        return (new BoAuditorias()).ProductGetAllByTypeSearchBo(conteo, typesearch,  (new ConexionJde()));
    }


}
