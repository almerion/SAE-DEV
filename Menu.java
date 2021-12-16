import java.util.Scanner;

public class Menu {
    public void mouvement(char[][] t,int [] coordonnées){
        String direction;

            Scanner sc=new Scanner(System.in);

            direction = sc.nextLine();

            System.out.println();

            while (direction!="z" || direction!="q" || direction!="s" || direction!="d");{

                direction = sc.nextLine();

                System.out.println("Mauvais commande choisi il faut tapez z pour monter, q pour aller à gauche, s pour descendre, d pour aller à droite");
            }

            if(direction == "z"|| direction=="Z"){
                if(t[coordonnées[0]][coordonnées[1]+1]=='r'){

                }
                if(t[coordonnées[0]][coordonnées[1]+1]=='m'){//max à faire (taille maximum de largeur)
                    System.out.println("impossible de montez");
                }
                t[coordonnées[0]][coordonnées[1]]=t[coordonnées[0]][coordonnées[1]+1];
            }
            else if(direction == "q"|| direction=="Q"){
                t[coordonnées[0]][coordonnées[1]]=t[coordonnées[0]-1][coordonnées[1]];
            }
            else if (direction == "s" || direction=="S"){
                t[coordonnées[0]][coordonnées[1]]=t[coordonnées[0]][coordonnées[1]-1];
            }
            else if (direction == "d" || direction=="D"){
                t[coordonnées[0]][coordonnées[1]]=t[coordonnées[0]+1][coordonnées[1]];
            }




    }
}
