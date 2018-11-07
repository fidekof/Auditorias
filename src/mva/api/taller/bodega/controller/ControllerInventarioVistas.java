package mva.api.taller.bodega.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/inventario_vistas")
public class ControllerInventarioVistas {

    @GetMapping("/auditoria/conteos/{bodega}/{auditoria}/{conteo}/{grupo}")
    public String ResumenConteosNA(Locale locale, Model model,
                                   @PathVariable String bodega,
                                   @PathVariable String auditoria,
                                   @PathVariable String conteo,
                                   @PathVariable String grupo) {
        model.addAttribute("bodega", bodega);
        model.addAttribute("auditoria", auditoria);
        model.addAttribute("conteo", conteo);
        model.addAttribute("grupo", grupo);
        return "conteos_usuarios";
    }
}
