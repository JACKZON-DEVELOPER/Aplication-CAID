package edu.titanes.caid.model;

public class PictureHouse {
    private String pictureImgH;
    private String tituloH;
    private String precioH;

    public PictureHouse(String pictureImgH, String tituloH, String precioH) {
        this.pictureImgH = pictureImgH;
        this.tituloH = tituloH;
        this.precioH = precioH;
    }

    public String getPictureImgH() {
        return pictureImgH;
    }

    public void setPictureImgH(String pictureImgH) {
        this.pictureImgH = pictureImgH;
    }

    public String getTituloH() {
        return tituloH;
    }

    public void setTituloH(String tituloH) {
        this.tituloH = tituloH;
    }

    public String getPrecioH() {
        return precioH;
    }

    public void setPrecioH(String precioH) {
        this.precioH = precioH;
    }
}
