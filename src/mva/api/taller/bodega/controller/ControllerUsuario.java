package mva.api.taller.bodega.controller;


import mva.api.taller.bodega.interfaces.InterfaceUsuario;
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
@RequestMapping("/Usuario")
public class ControllerUsuario {
    @Autowired
    private InterfaceUsuario serviceUsuario;

    @GetMapping("/Registro/aud")
    public String Inicio(Locale locale, Model model) {
        return "User_All";
    }

    @GetMapping("/Registro/audx")
    public String Rrgistro(Locale locale, Model model) {
        return "Regitro_user";
    }

    @GetMapping("/Mantenimiento/aud")
    public String Menu(Locale locale, Model model) {
        return "Menu_Principal";
    }

    @PostMapping("/ConsultaJDE/{cedula}")
    public ResponseEntity<Collection<Usuario>> ConsultUserGet(@PathVariable String cedula) {
        Usuario user = new Usuario();
        Collection<Usuario> UserCollection = this.serviceUsuario.ConsUserGet(user, cedula);
        return new ResponseEntity<Collection<Usuario>>(UserCollection, HttpStatus.OK);
    }

    @GetMapping("/Add/User/{cedula}/{longname}/{codjde}/{codPerf}")
    public ResponseEntity<String> SaveUserC(@PathVariable String cedula, @PathVariable String longname, @PathVariable String codjde, @PathVariable String codPerf) {
        String respuesta = "ERROR";
        String descPerf = "Administrador";
        respuesta = this.serviceUsuario.SaveUser(cedula, longname, codjde, codPerf, descPerf);
        return new ResponseEntity<String>(respuesta, HttpStatus.OK);
    }

    @PostMapping("/Update/{cedula}/{long_name}/{codjde}/{codPerf}/{descPerf}")
    public ResponseEntity<String> UpdateUser(@PathVariable String cedula, @PathVariable String longname, @PathVariable String codjde, @PathVariable String codPerf, @PathVariable String descPerf) {
        String respuesta = "ERROR";
        respuesta = this.serviceUsuario.UpdateUser(cedula, longname, codjde, codPerf, descPerf);
        return new ResponseEntity<String>(respuesta, HttpStatus.OK);
    }

    @PostMapping("/Delete/{cedula}")
    public ResponseEntity<String> DeleteUser(@PathVariable String cedula) {
        String respuesta = "ERROR";
        respuesta = this.serviceUsuario.DeleteUser(cedula);
        return new ResponseEntity<String>(respuesta, HttpStatus.OK);
    }

    @PostMapping("/Consulta/{cedula}")
    public ResponseEntity<Collection<Usuario>> ConsultUser(@PathVariable String cedula) {
        Usuario user = new Usuario();
        Collection<Usuario> UserCollection = this.serviceUsuario.ConsUserGet(user, cedula);
        return new ResponseEntity<Collection<Usuario>>(UserCollection, HttpStatus.OK);
    }

    @PostMapping("/ConsultaALL")
    public ResponseEntity<Collection<Usuario>> ConsultUserALL() {
        Usuario user = new Usuario();
        Collection<Usuario> UserCollection = this.serviceUsuario.ConsALLUser();
        return new ResponseEntity<Collection<Usuario>>(UserCollection, HttpStatus.OK);
    }

    @PostMapping("/Guardar/{cedula}/{lastname}/{codperf}/{codjde}/{descperf}")
    public ResponseEntity<Collection<Usuario>> Guardar(@PathVariable String cedula, @PathVariable String lastname, @PathVariable String codperf, @PathVariable String codjde, @PathVariable String descperf) {
        Usuario user = new Usuario();
        Collection<Usuario> UserCollection = this.serviceUsuario.ConsALLUser();
        return new ResponseEntity<Collection<Usuario>>(UserCollection, HttpStatus.OK);
    }
}