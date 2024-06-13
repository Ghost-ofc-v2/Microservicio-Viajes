package com.softgr5.microservicio.viajes.DTO;


public class Conductor {

    private String idConductor;
    private String marcaAuto;
    private String modeloAuto;
    private String placaAuto;
    private String colorAuto;

    public Conductor(String idConductor, String modeloAuto, String marcaAuto, String placaAuto, String colorAuto) {
        this.idConductor = idConductor;

        this.modeloAuto = modeloAuto;
        this.marcaAuto = marcaAuto;
        this.placaAuto = placaAuto;
        this.colorAuto = colorAuto;
    }

    public String getMarcaAuto() {
        return marcaAuto;
    }

    public void setMarcaAuto(String marcaAuto) {
        this.marcaAuto = marcaAuto;
    }

    public String getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(String idConductor) {
        this.idConductor = idConductor;
    }

    public String getModeloAuto() {
        return modeloAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    public String getPlacaAuto() {
        return placaAuto;
    }

    public void setPlacaAuto(String placaAuto) {
        this.placaAuto = placaAuto;
    }

    public String getColorAuto() {
        return colorAuto;
    }

    public void setColorAuto(String colorAuto) {
        this.colorAuto = colorAuto;
    }
}
