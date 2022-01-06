import java.util.Scanner;

public class Menu {

    private final static char QUITTER = ' ';
    public static void menu(){
        char[][] niveau = new char[10][10];
        int[] coordonneesJoueur = new int[2];
        char direction = 'b';
        int numNiveau = 1;
        int tours;
        boolean victoire;
        int[] coordonneesPic = new int[2];
        boolean picPresent = false;
        int[] ProchaineCase = new int[2];
        Scanner sc = new Scanner(System.in);


        // TODO: ajouter dans le while un "&& numNiv < Le max num niv " quand tous les lvl seront faits
        while (direction != QUITTER) {

            tours = Niveaux.MiseEnPlaceNiveau(niveau,numNiveau,coordonneesJoueur);
            victoire = false;
            System.arraycopy(coordonneesJoueur,0,ProchaineCase,0,2);

            while (tours > 0 && !victoire && direction != QUITTER) {

                MethodePrincipale.afficherTableau(niveau);
                System.out.println("Nombre de tours restants : " + tours);
                do {

                    if (MethodePrincipale.PresenceMurOuBordure(niveau,ProchaineCase)||MethodePrincipale.PresenceRocherNonDeplacable(niveau, direction, ProchaineCase)) {
                        System.out.println("\u001B[31maction impossible ! \u001B[0m");
                        System.arraycopy(coordonneesJoueur,0,ProchaineCase,0,2);
                        MethodePrincipale.afficherTableau(niveau);
                    }
                    //TODO : passer direction en simple char je pense (sera plus simple + pas d'erreur quand il est vide)
                    direction = Character.toLowerCase(sc.nextLine().charAt(0));
                    System.out.println();

                    while (direction != 'z' && direction != 'q' && direction != 's' && direction != 'd' && direction != QUITTER) {

                        System.out.println("\u001B[31mMauvaise commande choisie, il faut tapez z pour monter, q pour aller à gauche, s pour descendre, d pour aller à droite \u001B[0m");

                        direction = Character.toLowerCase(sc.nextLine().charAt(0));

                    }
                    MethodePrincipale.CalculProchaineCase(direction,ProchaineCase);
                    // Regarde si l'endroit ou le joueur veut se déplacer est bloqué par un mur/ par la bordure ou non

                }

                while (MethodePrincipale.PresenceMurOuBordure(niveau,ProchaineCase) || MethodePrincipale.PresenceRocherNonDeplacable(niveau, direction, ProchaineCase));





                if (niveau[ProchaineCase[0]][ProchaineCase[1]] == 'V') {
                    System.out.println("GG je suppose");
                    victoire = true;
                    numNiveau ++;
                }

                else if (niveau[ProchaineCase[0]][ProchaineCase[1]]=='R') {
                    MethodePrincipale.MouvementRocher(niveau, direction, ProchaineCase);
                    System.arraycopy(coordonneesJoueur,0,ProchaineCase,0,2);
                }

                else if (niveau[ProchaineCase[0]][ProchaineCase[1]]=='^'){
                    tours --;
                    MethodePrincipale.Mouvement(niveau, direction, coordonneesJoueur);
                    if(picPresent){
                        niveau[coordonneesPic[0]][coordonneesPic[1]]='^';
                        picPresent=false;
                    }
                    System.arraycopy(coordonneesJoueur,0,coordonneesPic,0,2);
                    picPresent =true;
                    System.out.println("\u001B[31mOOooooof \u001B[33m(-1 tour)\u001B[0m");

                }

                else {
                    MethodePrincipale.Mouvement(niveau, direction, coordonneesJoueur);
                    if(picPresent){
                        niveau[coordonneesPic[0]][coordonneesPic[1]]='^';
                        picPresent=false;
                    }
                }

                tours --;
            }
            System.out.println("\u001B[34mBienvenue au niveau " + numNiveau + "\u001B[0m");


        }
        System.out.println("Au Revoir !");
    }
}
