
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob
 */
public class PolyA extends SingleLinkedList<String> {
    Scanner kb = new Scanner(System.in);
    
    private String poly;
    
    private void initialization() {
        System.out.println("Please enter a polynomial:");
        poly = kb.nextLine();
        
        String unit = "";
        
        for(int i = 0; i < poly.length(); i++) {
            if(poly.charAt(i) != '+' && poly.charAt(i) != '-') {
                unit = unit + poly.charAt(i);
            }
            else if(poly.charAt(i) == '-') {
                this.add(unit);
                unit = "";
                unit = unit + poly.charAt(i);
            }
            else {
                this.add(unit);
                unit = "";
            }
        }
        
        this.add(unit);
    }
    
    private PolyA add(PolyA a) {
        PolyA sum = new PolyA();
        
        
        
        return sum;
    }
    
    public static void main(String[] args) {
        PolyA a = new PolyA();
        PolyA b = new PolyA();
        PolyA c = new PolyA();
        a.initialization();
        b.initialization();
        //c = a.add(b);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        //System.out.println(c);
    }
}
