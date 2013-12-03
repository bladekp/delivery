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
public class Parcel {
    public Parcel(int tc, int no, String name, int pr){
        this.TargetCity = tc;
        this.name = name;
        this.number = no;
        this.priotity = pr;
    }
    
    public int getTargetCity() {
        return TargetCity;
    }

    public void setTargetCity(int TargetCity) {
        this.TargetCity = TargetCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPriotity() {
        return priotity;
    }

    public void setPriotity(int priotity) {
        this.priotity = priotity;
    }
    private int TargetCity;
    private String name;
    private int number;
    private int priotity;
}
