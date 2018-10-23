package mva.api.taller.bodega.controller;


import mva.api.taller.bodega.interfaces.InterfaceLogin;
import mva.api.taller.bodega.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Locale;

@Controller
@RequestMapping("/Login")
public class ControllerMenu {
    @Autowired
    private InterfaceLogin serviceLogin;

    @GetMapping("/Inicio/aud")
    public String Inicio(Locale locale, Model model) {
        return "Login2";
    }

    @GetMapping("/Menu/aud")
    public String Menu(Locale locale, Model model) {
        return "Menu_Principal";
    }

    @PostMapping("/Inicio/{userL}/{passL}")
    public ResponseEntity<Collection<Usuario>> ProductGetAllByTypeSearch(@PathVariable String userL, @PathVariable String passL) {
        Usuario user = new Usuario();
        Collection<Usuario> UserCollection = this.serviceLogin.UserTypeSearch(user, userL, passL);
        return new ResponseEntity<Collection<Usuario>>(UserCollection, HttpStatus.OK);
    }
}