/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author piotrbladek
 */
public class Map {
    public Map(){
        cites = new String[1000];
        mapa = new int[1000][1000];
    }

    public int[][] getMapa() {
        return mapa;
    }

    public void setMapa(int x, int y) {
        this.mapa[x][y] = 1;
    }
    public void makeMap(){
        
    }
    public String[] getCites() {
        return cites;
    }

    public void setCites(String ci, int i) {
        this.cites[i] = ci;
    }
    private int[][] mapa;
    private String[] cites;

}
