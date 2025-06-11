package com.example.sqlite;

public class onomaModal {

    private int id;
    private String onoma;
    private String eponymo;
    public int getId() {return id;}
    public void setId(int id){
        this.id = id;
    }
    public String getOnona() {return onoma;}
    public void setOnona (String onoma) {
        this.onoma = onoma;
    }

    public String getEponymo() {return eponymo;}
    public void getEponomy(String eponymo) {
        this.eponymo = eponymo;
    }
    public onomaModal(int id,
                      String onoma,
                      String eponymo) {
        this.id = id;
        this.onoma = onoma;
        this.eponymo = eponymo;
    }


}
