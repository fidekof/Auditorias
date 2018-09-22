package mva.api.taller.bodega.interfaces;

import mva.api.taller.bodega.models.Conteo;
import mva.api.taller.bodega.models.Product;

import java.util.Collection;

public interface InterfaceAuditorias {
    public Collection<Conteo> ProductsGet(Conteo product, int typeSeaarch);
    public Collection<Conteo> ProductsGetByUbicaciones(Conteo productI, Conteo productF, int typeSearch);
    public Collection<Conteo> CountGet(Conteo count, int typeSeaarch);
    String CountsSave(Conteo conteo);
}

