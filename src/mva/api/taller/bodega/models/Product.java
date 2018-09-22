package mva.api.taller.bodega.models;

public class Product {
    String bodega;
    String ubicacion;
    String numeroCorto;
    String cantidad;
    String descripcion;
    String productCode;

    public Product() {
    }

    public Product(String bodega, String ubicacion, String numeroCorto, String cantidad, String descripcion, String productCode) {
        this.bodega = bodega;
        this.ubicacion = ubicacion;
        this.numeroCorto = numeroCorto;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.productCode = productCode;
    }

    public String getBodega() {
        return bodega;
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

    public String getNumeroCorto() {
        return numeroCorto;
    }

    public void setNumeroCorto(String numeroCorto) {
        this.numeroCorto = numeroCorto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }


}
