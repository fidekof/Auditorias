package mva.api.taller.bodega.services;

import mva.api.taller.bodega.bo.BoInventario;
import mva.api.taller.bodega.conexion.ConexionJde;
import mva.api.taller.bodega.interfaces.InterfaceInventario;
import mva.api.taller.bodega.models.Conteo;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ServiceInventario implements InterfaceInventario {
    @Override
    public Collection<Conteo> BuscarConteosPorTipoConteoGrupo(Conteo conteo, int typesearch) {
        return (new BoInventario()).BuscarConteosPorTipoConteoGrupoDao(conteo, typesearch, (new ConexionJde()));
    }
}
