/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


//KELOMPOK 1
//IF-42-01
//APLIKASI KLASEMEN BOLA

// FARHAN ANAS - 1301183427
// SYAMSUL RIZAL - 1301184064
// GILANG RAMADHAN - 1301184376

public class Team {
    private String nama;
    private int MP = 0;
    private int W = 0;
    private int D = 0;
    private int L = 0;
    private int GF = 0;
    private int GA = 0;
    private int GD = 0;
    private int poin = 0;

    public Team(String nama) {
        this.nama = nama;
    }

    Team(String nama, int MP, int W, int D, int L, int GF, int GA, int GD, int poin) {
        setNama(nama);
        setMP(MP);
        setW(W);
        setD(D);
        setL(L);
        setGF(GF);
        setGA(GA);
        setGD(GD);
        setPoin(poin);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getW() {
        return W;
    }

    public void setW(int W) {
        this.W = W;
    }

    public int getD() {
        return D;
    }

    public void setD(int D) {
        this.D = D;
    }

    public int getL() {
        return L;
    }

    public void setL(int L) {
        this.L = L;
    }

    public int getGF() {
        return GF;
    }

    public void setGF(int GF) {
        this.GF = GF;
    }

    public int getGA() {
        return GA;
    }

    public void setGA(int GA) {
        this.GA = GA;
    }

    public int getGD() {
        return GD;
    }

    public void setGD(int GD) {
        this.GD = GD;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }   
}