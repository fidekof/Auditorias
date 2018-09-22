package mva.api.taller.bodega.models;

public class Auditoria {
    String auditoriaCode;
    String name;
    String date;
    String bodega;


    public String getAuditoriaCode() {
        return auditoriaCode;
    }

    public void setAuditoriaCode(String auditoriaCode) {
        this.auditoriaCode = auditoriaCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }
}
