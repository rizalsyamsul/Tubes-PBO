/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import View.*;
import Controller.*;
import Model.*;


//KELOMPOK 1
//IF-42-01
//APLIKASI KLASEMEN BOLA

// FARHAN ANAS - 1301183427
// SYAMSUL RIZAL - 1301184064
// GILANG RAMADHAN - 1301184376

public class ControllerTeam implements  ActionListener {
    private Welcome w;
    private AddTeam t;
    Database db;

    public ControllerTeam() {
        t = new AddTeam();
        t.addActionListener(this);
        t.setVisible(true);
        db = new Database();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(t.getAdd_team())) {
            Team team = new Team(t.getTeam_name());
            db.addTeam(team);
            t.getNotif().setText("DATA INPUT SUCCESS");          
        }else if  (source.equals(t.getHome())) {
             t.setVisible(false);
             new ControllerWelcome();                     
        }    
    }  
}
