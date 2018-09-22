package mva.api.taller.bodega.models;


import org.springframework.http.server.reactive.ChannelSendOperator;

import javax.tools.Tool;
import java.util.ArrayList;

public class Conteo
{
    private String observacion;
    private String conteocode;
    private String  bodega;
    private String  ubicacion;
    private String  codigo;
    private String  cantidad;
    private String  grupo;
    private String  descripcion;
    private String  auditoria;
    private String  conteo1;
    private String  diferencia1;
    private String  conteo2;
    private String  diferencia2;
    private String  conteo3;
    private String  diferencia3;
    private String costounitario;
    private String familia;

    public Conteo(String conteocode, String bodega, String ubicacion, String codigo, String cantidad, String grupo, String descripcion, String auditoria, String conteo1, String diferencia1, String conteo2, String diferencia2, String conteo3, String diferencia3, String costounitario, String familia, String observacion) {
        this.conteocode = conteocode;
        this.bodega = bodega;
        this.ubicacion = ubicacion;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.grupo = grupo;
        this.descripcion = descripcion;
        this.auditoria = auditoria;
        this.conteo1 = conteo1;
        this.diferencia1 = diferencia1;
        this.conteo2 = conteo2;
        this.diferencia2 = diferencia2;
        this.conteo3 = conteo3;
        this.diferencia3 = diferencia3;
        this.costounitario = costounitario;
        this.familia = familia;
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getCostounitario() {
        return costounitario;
    }

    public void setCostounitario(String costounitario) {
        this.costounitario = costounitario;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getConteocode() {
        return conteocode;
    }

    public void setConteocode(String conteocode) {
        this.conteocode = conteocode;
    }

    public Conteo() {}

    public String getBodega() {
        return bodega;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(String auditoria) {
        this.auditoria = auditoria;
    }

    public String getConteo1() {
        return conteo1;
    }

    public void setConteo1(String conteo1) {
        this.conteo1 = conteo1;
    }


    public void calculeDiferencias(){
        if(this.cantidad != null && this.cantidad.trim().isEmpty()==false && this.conteo1 != null && this.conteo1.trim().isEmpty()==false){
            this.diferencia1 =  "" + (Integer.parseInt(Tools.formatNumberToJDE(this.conteo1,3, Tools.SIGNO_DECIMAL))- Integer.parseInt(Tools.formatNumberToJDE(this.cantidad,3, Tools.SIGNO_DECIMAL)));
        }
    }

    public String getDiferencia1() {
        return diferencia1;
    }

    public void setDiferencia1(String diferencia1) {
        this.diferencia1 = diferencia1;
    }

    public String getConteo2() {
        return conteo2;
    }

    public void setConteo2(String conteo2) {
        this.conteo2 = conteo2;
    }

    public String getDiferencia2() {
        return diferencia2;
    }

    public void setDiferencia2(String diferencia2) {
        this.diferencia2 = diferencia2;
    }

    public String getConteo3() {
        return conteo3;
    }

    public void setConteo3(String conteo3) {
        this.conteo3 = conteo3;
    }

    public String getDiferencia3() {
        return diferencia3;
    }

    public void setDiferencia3(String diferencia3) {
        this.diferencia3 = diferencia3;
    }

    public String generarInsertConteo()
    {
        String sql = " INSERT INTO JDE_TO_OPEN_CONTEO(BODEGA ," +
                    "  UBICACION," +
                    "  CODIGO," +
                    "  DESCRIPCION," +
                    "  CANTIDAD," +
                    "  GRUPO," +
                    "  AUDITORIA, " +
                    "  FAMILIA, " +
                    "  COSTO_UNITARIO," +
                    "  OBSERVACION " +
                    ") VALUES (" +
                    "'" + this.bodega +"'," +
                    "'" + this.ubicacion +"'," +
                    "'" + this.codigo +"'," +
                    "'" + this.descripcion +"'," +
                    "'" + Tools.formatNumberToJDE(this.cantidad,3, Tools.SIGNO_DECIMAL) +"'," +
                    "'" + this.grupo +"'," +
                    "'" + this.auditoria +"'," +
                    "'" + this.familia +"'," +
                    "'" + Tools.formatNumberToJDE(this.costounitario,3, Tools.SIGNO_DECIMAL) +"'," +
                    "'" + this.observacion +"'" +
                    ")";
        return sql;
    }

    public String generarUpdateConteo()
    {
        String set = sqlSetConteo();

        String sql = "" ;
        if(set!=null && set.trim().isEmpty()==false) {
            sql = " UPDATE JDE_TO_OPEN_CONTEO " + set + " WHERE  TRIM(UPPER(BODEGA)) = '"+this.bodega.trim().toUpperCase()+"' AND " +
                    "  TRIM(UPPER(UBICACION)) = '"+this.ubicacion.toUpperCase()+"' AND " +
                    "  TRIM(UPPER(CODIGO)) = '"+this.codigo.toUpperCase()+"' AND " +
                    "  TRIM(UPPER(DESCRIPCION)) = '"+this.descripcion.toUpperCase()+"' AND " +
                    "  TRIM(UPPER(AUDITORIA)) = '"+this.auditoria.toUpperCase()+"'";
        }

        return sql;
    }


    private String sqlSetConteo(){
        String result = "";
        if(this.conteocode == null || this.conteocode.isEmpty()==true){return result;}
        if(this.conteocode.toUpperCase().compareToIgnoreCase("C001")==0)
        {
            result = " SET CONTEO1 = '" + Tools.formatNumberToJDE(this.conteo1,3, Tools.SIGNO_DECIMAL) + "'," +
                     " DIFERENCIA1 = '" + this.diferencia1 + "'," +
                     " OBSERVACION = '" + this.observacion + "'";
        }
        else
            {
                if(this.conteocode.toUpperCase().compareToIgnoreCase("C002")==0)
                {
                    result = " SET CONTEO2 = '" + Tools.formatNumberToJDE(this.conteo1 ,3, Tools.SIGNO_DECIMAL)+ "'," +
                             " DIFERENCIA2 = '" +  this.diferencia1 + "'";
                }
                else
                    {
                        if(this.conteocode.toUpperCase().compareToIgnoreCase( "C003")==0)
                        {
                            result = " SET CONTEO3 = '" + Tools.formatNumberToJDE(this.conteo1,3, Tools.SIGNO_DECIMAL) + "'," +
                                     " DIFERENCIA3 = '" + this.diferencia1 + "'";
                        }
                    }
            }
            return result;
    }





}
