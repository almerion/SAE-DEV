import java.util.Scanner;

public class Menu {

    private final static char QUITTER = ' ';
    private final static char RESSAYER = 'r';
    public static void menu(){
        boolean perdre=false;
        char[][] niveau = new char[10][10];
        int[] coordonneesJoueur = new int[2];
        char direction = 'b';
        int numNiveau = 1;
        int tours;
        boolean victoire;
        int[] garde=new int[4];
        int[] coordonneesPic = new int[2];
        boolean picPresent = false;
        int[] ProchaineCase = new int[2];
        Scanner sc = new Scanner(System.in);


        while (direction != QUITTER && numNiveau != 7) {

            tours = Niveaux.MiseEnPlaceNiveau(niveau,numNiveau,coordonneesJoueur,garde);
            victoire = false;
            System.arraycopy(coordonneesJoueur,0,ProchaineCase,0,2);

            while (tours > 0 && !victoire && direction != QUITTER && direction != RESSAYER && !perdre) {

                MethodePrincipale.afficherTableau(niveau);
                System.out.println("Nombre de tours restants : " + tours);
                do {

                    if (MethodePrincipale.PresenceMurOuBordure(niveau,ProchaineCase)||MethodePrincipale.PresenceRocherNonDeplacable(niveau, direction, ProchaineCase)) {
                        System.out.println("\u001B[31maction impossible ! \u001B[0m");
                        System.arraycopy(coordonneesJoueur,0,ProchaineCase,0,2);
                        MethodePrincipale.afficherTableau(niveau);
                    }
                    String input;
                    input= sc.nextLine();
                    if(input.length()!=0)
                        direction = Character.toLowerCase(input.charAt(0));
                    else{
                        direction = 'm';
                    }
                    System.out.println();

                    while (input.length()==0 && direction != 'z' && direction != 'q' && direction != 's' && direction != 'd' && direction != QUITTER&& direction != RESSAYER) {

                        System.out.println("\u001B[31mMauvaise commande choisie, il faut tapez z pour monter, q pour aller à gauche, s pour descendre, d pour aller à droite \u001B[0m");
                        input= sc.nextLine();
                        if(input.length()!=0)
                            direction = Character.toLowerCase(input.charAt(0));
                        else {
                            direction='m';
                        }

                    }
                    if (direction != QUITTER && direction != RESSAYER)
                        MethodePrincipale.CalculProchaineCase(direction,ProchaineCase);

                }

                while (direction != QUITTER && direction != RESSAYER && (MethodePrincipale.PresenceMurOuBordure(niveau,ProchaineCase) || MethodePrincipale.PresenceRocherNonDeplacable(niveau, direction, ProchaineCase)));



                if (direction != QUITTER && direction != RESSAYER) {


                    if (niveau[ProchaineCase[0]][ProchaineCase[1]] == 'V') {
                        System.out.println("\u001B[35mVous avez réussi le niveau " + numNiveau + "\u001B[0m");
                        victoire = true;
                        numNiveau++;
                    } else if (niveau[ProchaineCase[0]][ProchaineCase[1]] == 'R') {
                        MethodePrincipale.MouvementRocher(niveau, direction, ProchaineCase);
                        System.arraycopy(coordonneesJoueur, 0, ProchaineCase, 0, 2);
                    } else if (niveau[ProchaineCase[0]][ProchaineCase[1]] == '^') {
                        tours--;
                        MethodePrincipale.Mouvement(niveau, coordonneesJoueur,ProchaineCase);
                        if (picPresent) {
                            niveau[coordonneesPic[0]][coordonneesPic[1]] = '^';
                            picPresent = false;
                        }
                        System.arraycopy(coordonneesJoueur, 0, coordonneesPic, 0, 2);
                        picPresent = true;
                        System.out.println("\u001B[31mOOooooof \u001B[33m(-1 tour)\u001B[0m");

                    } else {
                        MethodePrincipale.Mouvement(niveau, coordonneesJoueur,ProchaineCase);
                        if (picPresent) {
                            niveau[coordonneesPic[0]][coordonneesPic[1]] = '^';
                            picPresent = false;
                        }
                    }

                    if (Niveaux.PresenceGarde(numNiveau)) {
                        perdre = MethodePrincipale.DeplacementGarde(niveau, garde);
                    }



                    tours--;
                }
            }
            if (niveau[ProchaineCase[0]][ProchaineCase[1]] == 'V' && numNiveau != 7)
                System.out.println("\u001B[34mBienvenue au niveau " + numNiveau + "\u001B[0m");

            else if (numNiveau == 7)
                System.out.println("\u001B[33mVous avez fini le jeu, Merci d'avoir joué \u001B[0m");

            else if (tours <= 0)
                System.out.println("\u001B[31mVous n'avez plus de tours, veuillez réessayer ! \u001B[0m");

            else  if (direction == 'r') {
                System.out.println("\u001B[33mRechargement du niveau ...\u001B[0m");
                direction = 'b';
            }

            else if (perdre)
                System.out.println("\u001B[31mLe garde t'as trouvé, réessayez le niveau \u001B[0m");

            perdre=false;


        }
        System.out.println("\u001B[36mAu Revoir ! \u001B[0m");    }
}
