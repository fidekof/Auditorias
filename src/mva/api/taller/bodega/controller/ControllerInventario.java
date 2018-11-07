package mva.api.taller.bodega.controller;


import mva.api.taller.bodega.interfaces.InterfaceInventario;
import mva.api.taller.bodega.models.Conteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/inventario")
public class ControllerInventario {


    @Autowired
    private InterfaceInventario serviceInventario;

    @PostMapping("/auditoria/{typesearch}")
    public ResponseEntity<Collection<Conteo>> ProductGetAllByTypeSearch(@PathVariable int typesearch, @RequestBody Conteo conteo) {
        Collection<Conteo> productCollection = this.serviceInventario.BuscarConteosPorTipoConteoGrupo(conteo, typesearch);
        return new ResponseEntity<Collection<Conteo>>(productCollection, HttpStatus.OK);
    }
}
