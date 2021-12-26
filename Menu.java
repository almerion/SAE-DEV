import java.util.Scanner;

public class Menu {
    public static void menu(){
        char[][] niveau = new char[10][10];
        int[] coordonnees = new int[2];
        char direction = 'b';
        int numNiveau = 1;
        int tours;
        boolean victoire = false;
        int[] ProchaineCase = new int[2];
        Scanner sc = new Scanner(System.in);
        System.arraycopy(coordonnees,0,ProchaineCase,0,2);


        // TODO: ajouter dans le while un "&& numNiv < Le max num niv " quand tous les lvl seront faits
        while (direction != ' ') {
            tours = Niveaux.CopieNiveau(niveau,numNiveau,coordonnees);
            while (tours > 0 && !victoire && direction != ' ') {
                MethodePrincipale.afficherTableau(niveau);
                System.out.println("Nombre de tours restants : " + tours);
                do {
                    direction = sc.nextLine().charAt(0);

                    System.out.println();

                    while (direction != 'z' && direction != 'q' && direction != 's' && direction != 'd' && direction != 'Z' && direction != 'Q' && direction != 'S' && direction != 'D' && direction != ' ') {

                        System.out.println("Mauvaise commande choisie, il faut tapez z pour monter, q pour aller à gauche, s pour descendre, d pour aller à droite");

                        direction = sc.nextLine().charAt(0);

                    }
                    // Regarde si l'endroit ou le joueur veut se déplacer est bloqué par un mur/ par la bordure ou non
                    if (MethodePrincipale.PresenceMurOuBordure(niveau, direction, coordonnees))
                        System.out.println("pas possible de bouger à cet endroit");
                }

                while (MethodePrincipale.PresenceMurOuBordure(niveau, direction, coordonnees));
                if (MethodePrincipale.VerifVictoire(niveau, direction, coordonnees)) {
                    System.out.println("GG je suppose");
                    victoire = true;
                    numNiveau ++;
                }
                else
                    MethodePrincipale.Mouvement(niveau, direction, coordonnees);
                tours --;
            }


        }
    }
}
