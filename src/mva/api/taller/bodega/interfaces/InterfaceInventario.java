package mva.api.taller.bodega.interfaces;

import mva.api.taller.bodega.models.Conteo;

import java.util.Collection;

public interface InterfaceInventario {
    Collection<Conteo> BuscarConteosPorTipoConteoGrupo(Conteo conteo, int typesearch);
}
