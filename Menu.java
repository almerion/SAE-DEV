import java.util.Scanner;

public class Menu {
    public static void mouvement(char[][] niveau,int [] coordonnees){
        char direction;
        int[] ProchaineCase = new int[2];
        System.arraycopy(coordonnees,0,ProchaineCase,0,2);



        // TODO : toutes les variables déclarées à foutre avant les while

        Scanner sc =new Scanner(System.in);
        do {
            direction = sc.nextLine().charAt(0);

            System.out.println();

            while (direction != 'z' && direction != 'q' && direction != 's' && direction != 'd' && direction != 'Z' && direction != 'Q' && direction != 'S' && direction != 'D') {

                System.out.println("Mauvaise commande choisie, il faut tapez z pour monter, q pour aller à gauche, s pour descendre, d pour aller à droite");

                direction = sc.nextLine().charAt(0);

            }
            // Regarde si l'endroit ou le joueur veut se déplacer est bloqué par un mur/ par la bordure ou non
            if (MethodePrincipale.PresenceMurOuBordure(niveau,direction,coordonnees))
                System.out.println("pas possible de bouger à cet endroit");
        }
        // TODO : pas juste présence mais si caillou ou bordure et traiter les pierres à casser/déplacer
        while (MethodePrincipale.PresenceMurOuBordure(niveau,direction,coordonnees));
        if (MethodePrincipale.VerifVictoire(niveau,direction,coordonnees))
            System.out.println("GG je suppose");
        // TODO variable boolean victoire
        else
            MethodePrincipale.Mouvement(niveau,direction,coordonnees);


    }
}
