/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minpro1;

import A.Atmint;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements CRUD {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Ruangan> daftarRuangan = new ArrayList<>();
    public static void main(String[] args) {
        Atmint admin = new Atmint("A1", "atmint", "passwordril");
        Atmint.addAdmin(admin);
        daftarRuangan.add (new Ruang_Event("Ruang Seminar 1", "Tersedia", 100,"Sempro",true));
        daftarRuangan.add (new Ruang_Event("Ruang Seminar 2", "Tidak Tersedia", 150,"Rapat",false));
        daftarRuangan.add  (new Ruang_Event("Aula 1", "Tersedia", 500,"Seminar",true));
        daftarRuangan.add (new Ruang_Olahraga("Ruang Gym", "Tersedia", 50, "Fitness"));
        
        Main alamak = new Main();


        while (true) {
            System.out.println("Masukkan Nama Admin: ");
            String inputNama = Main.scanner.nextLine();

            if (inputNama.equalsIgnoreCase("atmint")) {
                System.out.println("Masukkan password Admin: ");
                String inputPw = scanner.nextLine();

                if (inputPw.equalsIgnoreCase("passwordril")) {
                    System.out.println("Selamat datang atmint");

                    boolean run = true;
                    while (run) {
                        System.out.println("Silahkan pilih menu");
                        System.out.println("1. Menambahkan Ruangan");
                        System.out.println("2. Melihat Daftar Ruangan");
                        System.out.println("3. Menghapus Ruangan");
                        System.out.println("4. Mengubah Informasi Ruangan");
                        System.out.println("5. Keluar");

                        String pilihan = scanner.nextLine();
                        int pilihanAngka;

                        try {
                            pilihanAngka = Integer.parseInt(pilihan);
                        } catch (NumberFormatException e) {
                            System.out.println("Input tidak valid. Harap masukkan angka.");
                            continue; 
                        }

                        switch (pilihanAngka) {
                            case 1:
                                alamak.create();
                                break;
                            case 2:
                                alamak.read();
                                break;
                            case 3:
                                alamak.delete();
                                break;
                            case 4:
                                alamak.update();
                                break;
                            case 5:
                                run = false;
                                System.out.println("Terimakasih sudah menggunakan program");
                                break;
                            default:
                                System.out.println("Pilihan menu tidak tersedia");
                        }
                    }
                    break;
                } else {
                    System.out.println("Password salah");
                }
            } else {
                System.out.println("Nama Admin Tidak Terdaftar");
            }
        }
    }

    @Override
    public void create() {
        System.out.println("Masukkan Tipe Ruangan (Event / Olahraga): ");
        String createTipe = scanner.nextLine();
        System.out.println("Silahkan masukkan nama ruangan: ");
        String createRuangan = scanner.nextLine();
        System.out.println("Masukkan Status Ruangan (Tersedia atau Tidak Tersedia): ");
        String createStatus = scanner.nextLine();
        System.out.println("Masukkan kapasitas ruangan: ");
        int createKapasitas;

        try {
            createKapasitas = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input kapasitas tidak valid. Harap masukkan angka.");
            return;
        }
        if (createTipe.equals("event")){
            System.out.println("Masukkan Jenis Acara : ");
            String createJacara = scanner.nextLine();
           
            System.out.println("Masukkan Apakah Ada Panggung ? Y/T : ");
            boolean adapanggung;
            try {
                adapanggung = Boolean.parseBoolean(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan 'true' atau 'false'.");
                return;
            }
            Ruang_Event ruangEventBaru = new Ruang_Event(createRuangan, createStatus , createKapasitas, createJacara, adapanggung);
            daftarRuangan.add(ruangEventBaru);
            System.out.println("Ruangan event berhasil ditambahkan.");
        } 
        else if (createTipe.equals("olahraga")){
            System.out.println("Masukkan Jenis Olahraga : ");
            String createJolahraga = scanner.nextLine();       
        
            Ruang_Olahraga ruangOlahragaBaru = new Ruang_Olahraga(createRuangan, createStatus , createKapasitas, createJolahraga);
            daftarRuangan.add(ruangOlahragaBaru);
            System.out.println("Ruangan event berhasil ditambahkan.");
        }        
    }

    @Override
    public void read() {
        System.out.println("Melihat Daftar Ruangan");
        for (Ruangan ruangan : daftarRuangan) {
            if (ruangan != null) {
                System.out.println("Nama: " + ruangan.Nama() + ", Status: " + ruangan.Status() + ", Kapasitas: " + ruangan.Kapasitas());

                if (ruangan instanceof Ruang_Event ruang_Event) {
                    ruang_Event.showInfo();
                }

                if (ruangan instanceof Ruang_Olahraga ruang_Olahraga) {
                    ruang_Olahraga.showInfo();
                }

                System.out.println();
            }
        }
    }

    @Override
    public void update() {
        read();
        System.out.println("Masukkan ruangan keberapa yang mau diupdate: ");
        try {
            int pilihupdate = Integer.parseInt(scanner.nextLine());
            if (pilihupdate < 1 || pilihupdate > daftarRuangan.size()) {
                System.out.println("Ruangan tidak ditemukan");
                return;
            }

            Ruangan ruangan = daftarRuangan.get(pilihupdate - 1);

            System.out.println("Mengubah nama ruangan : " + ruangan.Nama());
            System.out.println("Masukkan nama baru : ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                ruangan.setNama(newName);
            }

            System.out.println("Masukkan status baru : ");
            String newStatus = scanner.nextLine();
            if (!newStatus.isEmpty()) {
                ruangan.setStatus(newStatus);
            }

            System.out.println("Masukkan kapasitas baru : ");
            String newCapacityInput = scanner.nextLine();
            if (!newCapacityInput.isEmpty()) {
                try {
                    int newCapacity = Integer.parseInt(newCapacityInput);
                    ruangan.setKapasitas(newCapacity);
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid");
                }
            }
            
            if (ruangan instanceof Ruang_Event ruangEvent) {
                System.out.println("Masukkan Jenis Acara Baru :  ");
                String newJenisAcara = scanner.nextLine();
            if (!newJenisAcara.isEmpty()) {
                ruangEvent.setJenisAcara(newJenisAcara);
                }
            }

        if (ruangan instanceof Ruang_Olahraga ruangOlahraga) {
            System.out.println("Masukkan Jenis Olahraga Baru : ");
            String newjenisolahraga = scanner.nextLine();
            if (!newjenisolahraga.isEmpty()) {
                ruangOlahraga.setjenisolahraga(newjenisolahraga);
            }
        }

            System.out.println("Ruangan berhasil diperbarui.");
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid.");
        }
    }

    @Override
    public void delete() {
        System.out.println("Masukkan ruangan keberapa yang mau dihapus: ");
        int pilihhapus;

        try {
            pilihhapus = Integer.parseInt(scanner.nextLine());
            if (pilihhapus < 1 || pilihhapus > daftarRuangan.size()) {
                System.out.println("Ruangan tidak ditemukan");
                return;
            }
            daftarRuangan.remove(pilihhapus - 1);
            System.out.println("Ruangan berhasil dihapus");
        } catch (NumberFormatException e) {
            System.out.println("Ruangan tidak ada");
        }

    }
}

