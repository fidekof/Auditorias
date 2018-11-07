package mva.api.taller.bodega.conexion;

import conexion.conexiones;

public class ConexionJde {
    conexiones conex;

    public conexiones ConectarJd(String server, String usuario, String clave, String puerto, String sid) {
        this.conex = new conexiones();
        this.conex.setUsuario(usuario);
        this.conex.setBaseDatos(sid);
        this.conex.setClave(clave);
        this.conex.setPuerto(puerto);
        this.conex.setServer(server);
        this.conex.conectarOracle();
        return conex;
        //DATA SOURCE=172.18.0.208:1521/e1rdspd;PERSIST SECURITY INFO=True;USER ID=MAVESAWS
    }

    public conexiones getConex() {
        return conex;
    }

    public void setConex(conexiones conex) {
        this.conex = conex;
    }

    public conexiones ConectarSipecom(String server, String usuario, String clave, String puerto, String sid) {
        this.conex = new conexiones();
        this.conex.setUsuario(usuario);
        this.conex.setBaseDatos(sid);
        this.conex.setClave(clave);
        this.conex.setPuerto(puerto);
        this.conex.setServer(server);
        this.conex.conectarSqlServer();
        return conex;
    }


    public conexiones ConectarEvolution() {
        this.conex = new conexiones();
        this.conex.setUsuario("desarrollo");
        this.conex.setBaseDatos("hra_prod");
        this.conex.setClave("Des@rrollo2018");
        this.conex.setPuerto("1433");
        this.conex.setServer("pr-evolution");
        this.conex.conectarSqlServer();
        return conex;

    }


    public conexiones getConexionJde() {
        //conexion a Jd
        // e1rdsnp.cgkxhcjwqkes.us-west-2.rds.amazonaws.com
        return this.ConectarJd("172.18.0.208", "BIUSER", "MavesaBI", "1521", "e1rdspd");
    }


    public conexiones getConexionOpen() {// conexion a openside
        return this.ConectarJd("130.130.130.121", "openside", "r3ces10nmavesa", "1521", "mavopen");
    }


    public conexiones getConexionOpenMotorec() {// conexion a openside
        return this.ConectarJd("130.130.130.11", "openside", "openside", "1521", "motopen");
    }

    public conexiones getConexionSipecom() {// conexion a sipecom
        /*
        apfsqlpuerto=1433
        apfsqlserver=ap-facturacion
        apfsqlusuario=fidekof
        apfsqlclave=Df3a0b95
        apfsqlbaseDatos=SIPE_ComprobanteElectronico
        */
        return this.ConectarSipecom("ap-facturacion", "fidekof", "Df3a0b95", "1433", "SIPE_ComprobanteElectronico");
    }


    public void desconectarJD() {
        this.conex.cerrarConexion();
    }

}
