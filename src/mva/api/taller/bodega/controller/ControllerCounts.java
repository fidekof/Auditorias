package mva.api.taller.bodega.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/counts")
public class ControllerCounts {
    @GetMapping("/index/aud")
    public String ResumenConteos(Locale locale, Model model) {
        return "counts";
    }

    @GetMapping("/index/noaud")
    public String ResumenConteosNA(Locale locale, Model model) {
        return "counts_no_auditor";
    }


    @GetMapping("/count/{bodega}/{numero}")
    public String ConteosPorBodega(Locale locale, Model model) {
        return "counts";
    }


    @GetMapping("resumen_conteo")
    public String ResumenConteo(Locale locale, Model model) {
        return "resumen_conteo";
    }


}