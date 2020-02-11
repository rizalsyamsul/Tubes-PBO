/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.*;
import Controller.*;
import View.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


//KELOMPOK 1
//IF-42-01
//APLIKASI KLASEMEN BOLA

// FARHAN ANAS - 1301183427
// SYAMSUL RIZAL - 1301184064
// GILANG RAMADHAN - 1301184376

public class Database {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private ArrayList<Team> team = new ArrayList<>();

    public Database() {
        loadTeam();
    }
   
    public void connect(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbo_fix", "root", "");
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect(){
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean manipulate(String query){
        boolean cek = false;
        try {
            int rows = stmt.executeUpdate(query);
            if (rows > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }
    
    public void loadTeam() {
        connect();
        try {
            String query = "SELECT * FROM team";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                team.add(new Team(rs.getString("nama")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnect();
    }

    public void addTeam(Team t) {
        connect();
        String query = "INSERT INTO `team`(`nama`, `MP`, `W`, `D`, `L`, `GF`, `GA`, `GD`, `poin`) VALUES (";
        query += "'" + t.getNama() + "', ";
        query += t.getMP() + ", ";
        query += t.getW() + ", ";
        query += t.getD() + ", ";
        query += t.getL() + ", ";
        query += t.getGF() + ", ";
        query += t.getGA() + ", ";
        query += t.getGD() + ", ";
        query += t.getPoin();
        query += ")";
        if (manipulate(query)) team.add(t);
        disconnect();
    }
    
    public void deleteall(){
        connect();
        String query = "DELETE FROM `team`;";
        if (manipulate(query)) {
            team.clear();
            JOptionPane.showMessageDialog(null, "TABLE DELETED");
        }
        disconnect();        
    }   

    public ArrayList<Team> ListTeam(){
        ArrayList<Team> ListTeam = new ArrayList<>();
        connect();
        try{
            String query = "SELECT * FROM team ORDER BY `poin` DESC";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            Team team;
            while(rs.next()){
                team = new Team(rs.getString("nama"),rs.getInt("MP"),rs.getInt("W"),rs.getInt("D"),rs.getInt("L"),rs.getInt("GF"),rs.getInt("GA"),rs.getInt("GD"),rs.getInt("poin"));
                ListTeam.add(team);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        disconnect();
        return ListTeam;
    }
    
    public void setteambox(JComboBox<String> l) {    
        try {
            connect();
            String sql = "select * from team  ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String name = rs.getString("nama");
                l.addItem(name);               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        disconnect();
    }
        
    public void addMatch(String home, int x, String away, int y){
        connect();
        int s1 = x-y;
        int s2 = y-x;
        if (home != away){
            for (int i = 0; i < team.size(); i++) {
                if (team.get(i).getNama().equals(home)){
                    String query = "UPDATE team SET";
                    query += " MP= MP + 1,";
                    query += " GF= GF + " + x + ",";
                    query += " GA= GA + " + y + ",";
                    query += " GD= GD + " + s1 + ",";
                    if (x > y) {
                        query += " W= W + 1,";
                        query += " poin= poin + 3";
                    }else if (x == y){
                        query += " D= D + 1,";
                        query += " poin= poin + 1";
                    }else if (x < y){
                        query += " L= L + 1";
                    }
                    query += " WHERE nama='" + home + "';";
                    if (manipulate(query)) {
                        for (Team t : team) {
                            if (team.get(i).getNama().equals(t.getNama())){
                                t.setMP(t.getMP()+1);
                                t.setGF(t.getGF()+x);
                                t.setGA(t.getGA()+y);
                                t.setGD(t.getGD()+s1);
                                if (x > y) {
                                    t.setW(t.getW()+1);
                                    t.setPoin(t.getPoin()+3);
                                }else if (x == y){
                                    t.setD(t.getD()+1);
                                    t.setPoin(t.getPoin()+1);
                                }else if (x < y){
                                    t.setL(t.getL()+1);
                                }
                                break;
                            }
                        } 
                    }
                }
                if (team.get(i).getNama().equals(away)){
                    String query = "UPDATE team SET";
                    query += " MP= MP + 1,";
                    query += " GF= GF + " + y + ",";
                    query += " GA= GA + " + x + ",";
                    query += " GD= GD + " + s2 + ",";
                    if (x < y) {
                        query += " W= W + 1,";
                        query += " poin= poin + 3";
                    }else if (x == y){
                        query += " D= D + 1,";
                        query += " poin= poin + 1";
                    }else if (x > y){
                        query += " L= L + 1";
                    }
                    query += " WHERE nama='" + away + "';";
                    if (manipulate(query)) {
                        for (Team t : team) {
                            if (team.get(i).getNama().equals(t.getNama())){
                                t.setMP(t.getMP()+1);
                                t.setGF(t.getGF()+y);
                                t.setGA(t.getGA()+x);
                                t.setGD(t.getGD()+s2);
                                if (x < y) {
                                    t.setW(t.getW()+1);
                                    t.setPoin(t.getPoin()+3);
                                }else if (x == y){
                                    t.setD(t.getD()+1);
                                    t.setPoin(t.getPoin()+1);
                                }else if (x > y){
                                    t.setL(t.getL()+1);
                                }
                                break;
                            }
                        } 
                    }
                }
            }
        }
    }
}