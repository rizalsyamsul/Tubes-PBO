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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


//KELOMPOK 1
//IF-42-01
//APLIKASI KLASEMEN BOLA

// FARHAN ANAS - 1301183427
// SYAMSUL RIZAL - 1301184064
// GILANG RAMADHAN - 1301184376

public class ControllerTable extends MouseAdapter implements ActionListener{
    private Welcome w;
    private ShowTable t;
    private Database db;

    public ControllerTable() {
        t = new ShowTable();
        t.addActionListener(this);
        t.setVisible(true);
        //nambahin load table
        db = new Database();
        loadTeam();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(t.getADD_DATA())) {
             t.setVisible(false);
             new ControllerMatch();
        }else if  (source.equals(t.getHome())) {
             t.setVisible(false);
             new ControllerWelcome();           
        }else if  (source.equals(t.getReset())) {
             db.deleteall();
             loadTeam();
            
             
            
        }
    
    }
    
   public void loadTeam(){
        DefaultTableModel model = (DefaultTableModel) t.getKlasemen().getModel();
        ArrayList<Team> team = db.ListTeam();
        Object[] row = new Object[9];
        for (int i = 0; i < team.size(); i++) {
           row[0] = team.get(i).getNama();
           row[1] = team.get(i).getMP();
           row[2] = team.get(i).getW();
           row[3] = team.get(i).getD();
           row[4] = team.get(i).getL();
           row[5] = team.get(i).getGF();
           row[6] = team.get(i).getGA();
           row[7] = team.get(i).getGD();
           row[8] = team.get(i).getPoin();
           model.addRow(row);
           
       }
        
    }
   
   
}
