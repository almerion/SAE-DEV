import java.util.Scanner;

public class Menu {
    public static void mouvement(char[][] t,int [] coordonnées){
        char direction;

        Scanner sc=new Scanner(System.in);

        direction = sc.nextLine().charAt(0);

        System.out.println();

        while (direction != 'z' && direction != 'q' && direction != 's' && direction != 'd'&& direction != 'Z' && direction != 'Q' && direction != 'S' && direction != 'D'){

            System.out.println("Mauvaise commande choisi il faut tapez z pour monter, q pour aller à gauche, s pour descendre, d pour aller à droite");

            direction = sc.nextLine().charAt(0);

        }
        MéthodePrincipale.Mouvement(t,direction,coordonnées);


    }
}
