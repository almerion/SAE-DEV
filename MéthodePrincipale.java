public class MéthodePrincipale {
    public static void afficherTableau(char[][] t) {


        for (int ligne = 0 ; ligne < t.length ; ligne++) {
            for (int colonne = 0; colonne < t[ligne].length; colonne++) {

                System.out.print(t[ligne][colonne] + "\t");

            }
            System.out.println();
        }
        System.out.println();
    }

    public static void ChercherPerso(char[][] niveau, int[] coordonnees){
        boolean trouve = false;
        int ligne =0 , colonne = 0;
        while (ligne < niveau.length && !trouve){
            while (colonne < niveau[ligne].length && !trouve){
                if (niveau[ligne][colonne] == 'P'){
                    coordonnees[0] = ligne;
                    coordonnees[1] = colonne;
                    trouve = true;

                }
            }
        }
    }

}