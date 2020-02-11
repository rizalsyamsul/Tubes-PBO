/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
import Controller.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//KELOMPOK 1
//IF-42-01
//APLIKASI KLASEMEN BOLA

// FARHAN ANAS - 1301183427
// SYAMSUL RIZAL - 1301184064
// GILANG RAMADHAN - 1301184376

public class ControllerMatch implements ActionListener {
    private Welcome w;
    private AddMatch t;
    Database db;

    public ControllerMatch() {
        t = new AddMatch();
        t.addActionListener(this);
        t.setVisible(true);
        db = new Database();
        db.setteambox(t.getTeam1());
        db.setteambox(t.getTeam2());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(t.getAdd_data())) {
            db.addMatch(t.getTeam1().getSelectedItem().toString(), t.getScore1(), t.getTeam2().getSelectedItem().toString(), t.getScore2());
            t.getNotif().setText("DATA INPUT SUCCESS");
        }else if  (source.equals(t.getHome())) {
             t.setVisible(false);
             new ControllerWelcome();        
        }else if  (source.equals(t.getTable())) {
             t.setVisible(false);
             new ControllerTable();       
        }    
    }
}
