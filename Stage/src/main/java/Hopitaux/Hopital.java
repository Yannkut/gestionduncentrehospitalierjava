package Hopitaux;

import java.util.ArrayList;

abstract public class Hopital {
	int id;
    String name;
    String ville;
    String pays;
    String directeur;
    ArrayList listh = new ArrayList();

    public String getName() {
        return name;
    }

    public void création() {
        System.out.println("Création " + name);
    }

    public void suppression() {
        System.out.println("suppression de  " + name);
    }

    public void modification() {
        System.out.println("modification " + name);
    }

    public void list() {
        System.out.println("Boxing " + name);
    }

    public String toString() {
        // code to display pizza name and ingredients
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----\n");
        display.append( name+ "\n");
        display.append( ville+ "\n");
        for (int i = 0; i < listh.size(); i++) {
            display.append((String) listh.get(i) + "\n");
        }
        return display.toString();
    }
}
