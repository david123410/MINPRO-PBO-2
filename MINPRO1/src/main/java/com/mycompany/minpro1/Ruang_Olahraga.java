/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minpro1;

/**
 *
 * @author david
 */
public class Ruang_Olahraga extends Ruangan {
    private String jenisolahraga;


    public Ruang_Olahraga(String ruang, String statusruangan, int kapasitasruang,String jenisolahraga) {
        super(ruang, statusruangan, kapasitasruang);
        this.jenisolahraga = jenisolahraga; 
    }
    
     public String getjenisolahraga() {
        return jenisolahraga;
    }
    public void setjenisolahraga(String jenisolahraga) {
        this.jenisolahraga = jenisolahraga;
    }
    public void showInfo() {
    System.out.println("Jenis Olahraga: " + jenisolahraga);
    }
}
