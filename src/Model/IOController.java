package Model;

import Model.Graph.DirectedGraph;
import Model.Graph.DirectedEdge;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author piotrbladek
 */
public class IOController {

    public void loadData(String args[], Delivery dy, Car cr, Parcel[] parcels, Map mp, int[] prio, DirectedGraph graph){
        for (int i=0; i<args.length; i++){
            switch(args[i]){
                case "-s":
                        try{
                            dy.setNumberCars(Integer.parseInt(args[i+1]));
                            i++;
                        } catch(Exception e){
                            System.out.println("Źle podane parametry.");
                        }
                        break;
                case "-l":
                        try{
                            cr.setLoad(Integer.parseInt(args[i+1]));
                            i++;
                        } catch(Exception e){
                            System.out.println("Źle podane parametry.");
                        }
                        break;
                case "-z":
                         try{
                            pz = new File(args[i+1]);
                            i++;
                        } catch(Exception e){
                            System.out.println("Źle podane parametry.");
                        }
                        break;
                case "-m":
                     try{
                            pm = new File(args[i+1]);
                            i++;
                        } catch(Exception e){
                            System.out.println("Źle podane parametry.");
                        }
                        break;
                case "-h":
                        System.out.println("Program wywołamy pisząc w konsoli (dla ułatwienia będę posługiwał się notacją Unix/Linux):\n"+
                                            "./delivery [opcje] ...\n"+
                                            "gdzie dopuszczalne opcje to:\n"+
                                            "-s: liczba samochodów dostawczych\n"+
                                            "-l: maksymalna liczba paczek w jednym samochodzie\n"+
                                            "-z: nazwa pliku z listą zleceń do obsłużenia\n"+
                                            "-h: pomoc\n"+
                                            "-m: nazwa pliku z mapą miast i połączeniami\n");
                        break;
            }
        }
        loadPz(parcels);
        loadPm(mp,prio,graph);
     }
    public void loadPz(Parcel[] parcels){
        try{
            Scanner in = new Scanner(pz);
            String z = in.nextLine();
            int i=0;
            while(in.hasNext()){
                z = in.nextLine();
                parcels[i] = new Parcel(5, 1, "laptop", 40);
                i++;
            }
        }catch(FileNotFoundException e){}
    }
     public void loadPm(Map mp, int[] prio, DirectedGraph graph){
        try{
            Scanner in = new Scanner(pz);
            String text = in.nextLine();
            int i=0;
            text = in.nextLine();
            while(!text.equals("#połączenia")){
                mp.setCites(text, i);
                i++;
            }  
            int t,u,w;
            i =0;
            graph = new DirectedGraph(1000);
            while(in.hasNext()){
                t = in.nextInt(); u = in.nextInt(); w = in.nextInt();
                mp.setMapa(t-1, u-1); 
                prio[i] = w;
                graph.addEdge(new DirectedEdge(t, u, w));
                i++;
            }  
        }catch(FileNotFoundException e){}
    }
    private File pz;
    private File pm;
}
