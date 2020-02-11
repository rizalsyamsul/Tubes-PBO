/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;


//KELOMPOK 1
//IF-42-01
//APLIKASI KLASEMEN BOLA

// FARHAN ANAS - 1301183427
// SYAMSUL RIZAL - 1301184064
// GILANG RAMADHAN - 1301184376

public class ControllerWelcome implements ActionListener {
    private Welcome w;
    private AddTeam team;
    private ShowTable tab;

    public ControllerWelcome() {
        w = new Welcome();
        w.addActionListener((ActionListener) this);
        w.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if  (source.equals(w.getADD_TEAM())) {
            w.setVisible(false);
            new ControllerTeam();
        }else if  (source.equals(w.getSHOW_TABLE())) {
            w.setVisible(false);
            new ControllerTable();
        }else if  (source.equals(w.getADD_MATCH())) {
            w.setVisible(false);
            new ControllerMatch();
        }   
    }
}
