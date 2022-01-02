import java.util.Scanner;

public class Menu {
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
        while (direction != ' ') {

            tours = Niveaux.MiseEnPlaceNiveau(niveau,numNiveau,coordonneesJoueur);
            victoire = false;
            System.arraycopy(coordonneesJoueur,0,ProchaineCase,0,2);

            while (tours > 0 && !victoire && direction != ' ') {

                MethodePrincipale.afficherTableau(niveau);
                if(picPresent)
                    System.out.println("OOooooof");
                System.out.println("Nombre de tours restants : " + tours);
                do {
                    direction = sc.nextLine().charAt(0);

                    System.out.println();

                    while (direction != 'z' && direction != 'q' && direction != 's' && direction != 'd' && direction != 'Z' && direction != 'Q' && direction != 'S' && direction != 'D' && direction != ' ') {

                        System.out.println("Mauvaise commande choisie, il faut tapez z pour monter, q pour aller à gauche, s pour descendre, d pour aller à droite");

                        direction = sc.nextLine().charAt(0);

                    }
                    // Regarde si l'endroit ou le joueur veut se déplacer est bloqué par un mur/ par la bordure ou non
                    if (MethodePrincipale.PresenceMurOuBordure(niveau, direction, coordonneesJoueur)||MethodePrincipale.PresenceRocherNonDeplacable(niveau, direction, coordonneesJoueur)) {
                        System.out.println("action impossible !");
                        MethodePrincipale.afficherTableau(niveau);
                    }

                }

                while (MethodePrincipale.PresenceMurOuBordure(niveau, direction, coordonneesJoueur)||MethodePrincipale.PresenceRocherNonDeplacable(niveau, direction, coordonneesJoueur));


                MethodePrincipale.CalculProchaineCase(direction,ProchaineCase);



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
            System.out.println("Bienvenue au niveau " + numNiveau);


        }
        System.out.println("Au Revoir !");
    }
}
