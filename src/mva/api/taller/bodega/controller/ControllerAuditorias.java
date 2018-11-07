package mva.api.taller.bodega.controller;


import mva.api.taller.bodega.dao.DaoAuditorias;
import mva.api.taller.bodega.interfaces.InterfaceAuditorias;
import mva.api.taller.bodega.models.Conteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/product")
public class ControllerAuditorias {
    @Autowired
    private InterfaceAuditorias serviceAuditorias;

    @GetMapping("/byBodega/{bodega}")
    public ResponseEntity<Collection<Conteo>> ProductsGetAllByBodega(@PathVariable String bodega, @PathVariable String auditoria) {
        Conteo product = new Conteo();
        product.setBodega(bodega);
        Collection<Conteo> productCollection = this.serviceAuditorias.ProductsGet(product, DaoAuditorias.ALL_BY_BODEGA);
        return new ResponseEntity<Collection<Conteo>>(productCollection, HttpStatus.OK);
    }


    @GetMapping("/byBodega/{bodega}/{auditoria}")
    public ResponseEntity<Collection<Conteo>> ProductsGetAllByBodegaAndAuditoria(@PathVariable String bodega, @PathVariable String auditoria) {
        Conteo product = new Conteo();
        product.setBodega(bodega);
        product.setAuditoria(auditoria.replace("*", ""));
        Collection<Conteo> productCollection = this.serviceAuditorias.CountGet(product, DaoAuditorias.ALL_BY_BODEGA);
        return new ResponseEntity<Collection<Conteo>>(productCollection, HttpStatus.OK);
    }


    @GetMapping("/byBodegaAndUbicacion/{bodega}/{ubici}/{ubicf}/{auditoria}")
    public ResponseEntity<Collection<Conteo>> ProductsGetAllByBodegaAndUbi(@PathVariable String bodega, @PathVariable String ubici, @PathVariable String ubicf, @PathVariable String auditoria) {
        Conteo productI = new Conteo();
        productI.setAuditoria(auditoria);
        productI.setBodega(bodega);
        productI.setUbicacion(ubici);
        Conteo productF = new Conteo();
        productF.setUbicacion(ubicf);
        Collection<Conteo> productCollection = this.serviceAuditorias.ProductsGetByUbicaciones(productI, productF, DaoAuditorias.ALL_BY_BODEGA_AND_UBICACIONES);
        return new ResponseEntity<Collection<Conteo>>(productCollection, HttpStatus.OK);
    }


    @PostMapping("/buscar/ubicaciones/{typesearch}")
    public ResponseEntity<Collection<Conteo>> ObternerUbicacionMaestroPorBodega(@PathVariable int typesearch, @RequestBody Conteo conteo) {
        Collection<Conteo> productCollection = this.serviceAuditorias.ObternerUbicacionMaestroPorBodega(conteo, typesearch);
        return new ResponseEntity<Collection<Conteo>>(productCollection, HttpStatus.OK);
    }


    @PostMapping("/auditoria/{typesearch}")
    public ResponseEntity<Collection<Conteo>> ProductGetAllByTypeSearch(@PathVariable int typesearch, @RequestBody Conteo conteo) {
        Collection<Conteo> productCollection = this.serviceAuditorias.ProductGetAllByTypeSearch(conteo, typesearch);
        return new ResponseEntity<Collection<Conteo>>(productCollection, HttpStatus.OK);
    }


    @PostMapping("/resume_por_items/{typesearch}")
    public ResponseEntity<Collection<Conteo>> ObternerResumenPorItems(@PathVariable int typesearch, @RequestBody Conteo conteo) {
        Collection<Conteo> productCollection = this.serviceAuditorias.ObternerResumenPorItems(conteo, typesearch);
        return new ResponseEntity<Collection<Conteo>>(productCollection, HttpStatus.OK);
    }


    @GetMapping("/byBodegaAndCode/{bodega}/{productCode}/{auditoria}")
    public ResponseEntity<Collection<Conteo>> ProductsGetAllByBodega(@PathVariable String bodega, @PathVariable String productCode, @PathVariable String auditoria) {
        Conteo conteo = new Conteo();
        conteo.setBodega(bodega);
        conteo.setCodigo(productCode);
        conteo.setAuditoria(auditoria);
        Collection<Conteo> productCollection = this.serviceAuditorias.ProductsGet(conteo, DaoAuditorias.ALL_BY_BODEGA_AND_PRODUCTCODE);
        return new ResponseEntity<Collection<Conteo>>(productCollection, HttpStatus.OK);
    }


    @GetMapping("/saveconteo/{codigoAuditoria}/{codigoGrupo}/{codConteo}/{bodega}/{ubicacion}/{itemcode}/{valorInicial}/{idValorContado}/{descripcion}")
    public ResponseEntity<String> SaveConteo(@PathVariable String codigoAuditoria, @PathVariable String codigoGrupo, @PathVariable String codConteo, @PathVariable String bodega, @PathVariable String ubicacion, @PathVariable String itemcode, @PathVariable String valorInicial, @PathVariable String idValorContado, @PathVariable String descripcion) {
        Collection<Conteo> productCollection = new ArrayList<Conteo>();
        Conteo conteo = new Conteo();
        conteo.setAuditoria(codigoAuditoria);
        conteo.setGrupo(codigoGrupo);
        conteo.setBodega(bodega);
        conteo.setUbicacion(ubicacion);
        conteo.setCodigo(itemcode);
        conteo.setConteocode(codConteo);
        conteo.setCantidad(valorInicial);
        conteo.setConteo1(idValorContado);
        conteo.setDescripcion(descripcion);
        conteo.calculeDiferencias();
        String respuesta = this.serviceAuditorias.CountsSave(conteo);
        return new ResponseEntity<String>(respuesta, HttpStatus.OK);
    }


    @PostMapping("/saveconteo/postmode")
    public ResponseEntity<String> SaveConteo(@RequestBody Conteo conteo) {
        String respuesta = "ERROR";
        if (conteo != null) {
            conteo.calculeDiferencias();
            respuesta = this.serviceAuditorias.CountsSave(conteo);
        }
        return new ResponseEntity<String>(respuesta, HttpStatus.OK);
    }


    @PostMapping("/saveitem/postmode")
    public ResponseEntity<String> SaveItem(@RequestBody Conteo conteo) {
        String respuesta = "ERROR";
        if (conteo != null) {
            respuesta = this.serviceAuditorias.ItemSave(conteo);
        }
        return new ResponseEntity<String>(respuesta, HttpStatus.OK);
    }


    @PostMapping("/resumen/{typesearch}")
    public ResponseEntity<Collection<Conteo>> searchResumenCounts(@PathVariable int typesearch, @RequestBody Conteo conteo) {
        Collection<Conteo> productCollection = this.serviceAuditorias.searchResumenCounts(conteo, typesearch);
        return new ResponseEntity<Collection<Conteo>>(productCollection, HttpStatus.OK);
    }

}
