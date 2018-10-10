package mva.api.taller.bodega.interfaces;

import mva.api.taller.bodega.models.Conteo;

import java.util.Collection;

public interface InterfaceAuditorias {
    public Collection<Conteo> ProductsGet(Conteo product, int typeSeaarch);
    public Collection<Conteo> ProductsGetByUbicaciones(Conteo productI, Conteo productF, int typeSearch);
    public Collection<Conteo> CountGet(Conteo count, int typeSeaarch);
    String CountsSave(Conteo conteo);
    Collection<Conteo> ProductGetAllByTypeSearch(Conteo conteo, int typesearch);

    String ItemSave(Conteo conteo);
}

