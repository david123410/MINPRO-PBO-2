/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minpro1;

/**
 *
 * @author david
 */
public abstract class Ruangan {
    protected String nama;
    protected String status;
    protected int kapasitas;

    public Ruangan(String nama, String status, int kapasitas) {
        this.nama = nama;
        this.status = status;
        this.kapasitas = kapasitas;
    }

    public String Nama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String Status() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int Kapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public abstract void showInfo();
}
