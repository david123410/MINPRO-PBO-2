/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minpro1;

/**
 *
 * @author david
 */
public class Ruang_Event extends Ruangan {
    private String jenisacara;
    private boolean adapanggung;
    
    public Ruang_Event(String ruang, String statusruangan, int kapasitasruang,String jenisacara,boolean adapanggung) {
        super(ruang, statusruangan, kapasitasruang);
        this.jenisacara = jenisacara;
        this.adapanggung = adapanggung;
    }
    public String getjenisacara() {
        return jenisacara;
    }

    public void setJenisAcara(String jenisacara) {
        this.jenisacara = jenisacara;
    }

    public boolean isadapanggung() {
        return adapanggung;
    }

    public void setadapanggung(boolean adapanggung) {
        this.adapanggung = adapanggung;
    }
    public void showInfo() {
        System.out.println("Jenis Event : " + jenisacara);
        System.out.println("Ada Panggung : " + adapanggung);
    }
}
