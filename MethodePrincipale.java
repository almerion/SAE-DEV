public class MethodePrincipale {
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
        int ligne =0 , colonne;
        while (ligne < niveau.length && !trouve){
            colonne =0;
            while (colonne < niveau[ligne].length && !trouve){
                if (niveau[ligne][colonne] == 'P'){
                    coordonnees[0] = ligne;
                    coordonnees[1] = colonne;
                    trouve = true;

                }
                colonne++;
            }
            ligne++;
        }
    }


    public static boolean PresenceObstacleOuBordure (char [][] niveau, char direction , int[] coordonnees){
        return ((direction == 'q' || direction == 'Q') && (coordonnees[1] - 1 == -1 || niveau[coordonnees[0]][coordonnees[1] - 1] != '*')) || ((direction == 's' || direction == 'S') && (coordonnees[0] + 1 == 10 || niveau[coordonnees[0] + 1][coordonnees[1]] != '*')) || ((direction == 'd' || direction == 'D') && (coordonnees[1] + 1 == 10 || niveau[coordonnees[0]][coordonnees[1] + 1] != '*')) || ((direction == 'z' || direction == 'Z') && (coordonnees[0] - 1 == -1 || niveau[coordonnees[0] - 1][coordonnees[1]] != '*'));

    }

    public static void Mouvement(char [] [] niveau , char direction, int[] coordonnees){
        if(direction == 'q'|| direction=='Q'){
            niveau[coordonnees[0]][coordonnees[1] -1] = niveau[coordonnees[0]][coordonnees[1]];
            niveau[coordonnees[0]][coordonnees[1]] = '*';
            coordonnees[1] -=1;
        }
        else if(direction == 'z'|| direction=='Z'){
            niveau[coordonnees[0]-1][coordonnees[1]] = niveau[coordonnees[0]][coordonnees[1]];
            niveau[coordonnees[0]][coordonnees[1]] = '*';
            coordonnees[0] -=1;
        }
        else if (direction == 'd' || direction=='D'){
            niveau[coordonnees[0]][coordonnees[1]+1] = niveau[coordonnees[0]][coordonnees[1]];
            niveau[coordonnees[0]][coordonnees[1]] = '*';
            coordonnees[1] +=1;
        }
        else if (direction == 's' || direction=='S'){
            niveau[coordonnees[0]+1][coordonnees[1]] = niveau[coordonnees[0]][coordonnees[1]];
            niveau[coordonnees[0]][coordonnees[1]] = '*';
            coordonnees[0] +=1;
        }
    }

}