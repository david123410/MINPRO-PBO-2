/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
final public class Atmint {
    private static List<Atmint> adminList = new ArrayList<>();
    private final String id;
    private final String nama;
    private final String password;
    
    public Atmint(String id,String nama,String password){
        this.id = id;
        this.nama = nama;
        this.password = password;
    }
    
    public static void addAdmin(Atmint admin) {
        adminList.add(admin);
    }
    
    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public String getPassword() {
        return password;
    }
    public boolean cekadmin(String nama, String password) {
        for (Atmint admin : adminList) {
            if (admin.getNama().equalsIgnoreCase(nama) && admin.getPassword().equals(password)) {
                return true; 
            }
        }
        return false;
    }
}
