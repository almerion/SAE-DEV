import java.util.Scanner;

public class Menu {
    public static void mouvement(char[][] t,int [] coordonnees){
        char direction;

        Scanner sc=new Scanner(System.in);

        direction = sc.nextLine().charAt(0);

        System.out.println();

        while (direction != 'z' && direction != 'q' && direction != 's' && direction != 'd'&& direction != 'Z' && direction != 'Q' && direction != 'S' && direction != 'D'){

            System.out.println("Mauvaise commande choisie, il faut tapez z pour monter, q pour aller à gauche, s pour descendre, d pour aller à droite");

            direction = sc.nextLine().charAt(0);

        }
        // Regarde si l'endroit ou le joueur veut se déplacer est vide (*) ou non
        if (((direction == 'q' || direction == 'Q') && t[coordonnees[0]][coordonnees[1] - 1] != '*') || ((direction == 's' || direction == 'S') && t[coordonnees[0] + 1][coordonnees[1]] != '*') || ((direction == 'd' || direction == 'D') && t[coordonnees[0]][coordonnees[1] + 1] != '*') || ((direction == 'z' || direction == 'Z') && t[coordonnees[0] - 1][coordonnees[1]] != '*'))
            System.out.println("kkk c'est good");
        else
            MethodePrincipale.Mouvement(t,direction,coordonnees);


    }
}
