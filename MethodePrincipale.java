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

    
//    public static void ChercherPerso(char[][] niveau, int[] coordonnees){
//        boolean trouve = false;
//        int ligne =0 , colonne;
//        while (ligne < niveau.length && !trouve){
//            colonne =0;
//            while (colonne < niveau[ligne].length && !trouve){
//                if (niveau[ligne][colonne] == 'P'){
//                    coordonnees[0] = ligne;
//                    coordonnees[1] = colonne;
//                    trouve = true;
//
//                }
//                colonne++;
//            }
//            ligne++;
//        }
//    }
//


    public static boolean PresenceMurOuBordure (char [][] niveau, char direction , int[] coordonneesJoueur){
        return ((direction == 'q' || direction == 'Q') && (coordonneesJoueur[1] - 1 == -1 || niveau[coordonneesJoueur[0]][coordonneesJoueur[1] - 1] == 'M')) || ((direction == 's' || direction == 'S') && (coordonneesJoueur[0] + 1 == 10 || niveau[coordonneesJoueur[0] + 1][coordonneesJoueur[1]] == 'M')) || ((direction == 'd' || direction == 'D') && (coordonneesJoueur[1] + 1 == 10 || niveau[coordonneesJoueur[0]][coordonneesJoueur[1] + 1] == 'M')) || ((direction == 'z' || direction == 'Z') && (coordonneesJoueur[0] - 1 == -1 || niveau[coordonneesJoueur[0] - 1][coordonneesJoueur[1]] == 'M'));
    }
    public static boolean PresenceRocher (char [][] niveau, char direction , int[] coordonneesJoueur){
        if ((direction == 'q' || direction == 'Q') && niveau[coordonneesJoueur[0]][coordonneesJoueur[1] - 1] == 'R'){
            return (coordonneesJoueur[1]-2 <0||niveau[coordonneesJoueur[0]][coordonneesJoueur[1] - 2] != '.');
        }
        else if((direction == 's' || direction == 'S') && niveau[coordonneesJoueur[0] + 1][coordonneesJoueur[1]] == 'R'){
            return (coordonneesJoueur[0]+2 >9||niveau[coordonneesJoueur[0] + 2][coordonneesJoueur[1]] != '.');
        }
        else if((direction == 'd' || direction ==  'D') && niveau[coordonneesJoueur[0]][coordonneesJoueur[1] + 1] == 'R'){
            return (coordonneesJoueur[1]+2 >9||niveau[coordonneesJoueur[0]][coordonneesJoueur[1] + 2] != '.');
        }
        else if((direction == 'z' || direction == 'Z') &&  niveau[coordonneesJoueur[0] - 1][coordonneesJoueur[1]] == 'R'){
            return (coordonneesJoueur[0]-2<0||niveau[coordonneesJoueur[0] - 2][coordonneesJoueur[1]] != '.');

        }
        else{
            return false;
        }
    }
    public static void Mouvement(char [] [] niveau , char direction, int[] coordonneesJoueur){
        if(direction == 'q'|| direction=='Q'){
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1] -1] = niveau[coordonneesJoueur[0]][coordonneesJoueur[1]];
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1]] = '.';
            coordonneesJoueur[1] -=1;
        }
        else if(direction == 'z'|| direction=='Z'){
            niveau[coordonneesJoueur[0]-1][coordonneesJoueur[1]] = niveau[coordonneesJoueur[0]][coordonneesJoueur[1]];
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1]] = '.';
            coordonneesJoueur[0] -=1;
        }
        else if (direction == 'd' || direction=='D'){
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1]+1] = niveau[coordonneesJoueur[0]][coordonneesJoueur[1]];
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1]] = '.';
            coordonneesJoueur[1] +=1;
        }
        else if (direction == 's' || direction=='S'){
            niveau[coordonneesJoueur[0]+1][coordonneesJoueur[1]] = niveau[coordonneesJoueur[0]][coordonneesJoueur[1]];
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1]] = '.';
            coordonneesJoueur[0] +=1;
        }
    }
    public static void MouvementRocher(char [] [] niveau , char direction, int[] ProchaineCase){
        niveau[ProchaineCase[0]][ProchaineCase[1]]='.';
        CalculProchaineCase(direction,ProchaineCase);
        niveau[ProchaineCase[0]][ProchaineCase[1]]='R';
    }

//  Variable ProchaineCase permet d'éviter ça et les autres cas qui se ressamblent

//    public static boolean VerifVictoire(char [][] niveau, char direction, int[] coordonnees){
//        return (direction == 'q' || direction == 'Q') && niveau[coordonnees[0]][coordonnees[1] - 1] == 'V' || ((direction == 's' || direction == 'S') && niveau[coordonnees[0] + 1][coordonnees[1]] == 'V') || ((direction == 'd' || direction == 'D') && niveau[coordonnees[0]][coordonnees[1] + 1] == 'V') || ((direction == 'z' || direction == 'Z') && niveau[coordonnees[0] - 1][coordonnees[1]] == 'V');
//    }


    public static void CalculProchaineCase(char direction, int[] ProchaineCase){
        if (direction == 'd' || direction == 'D')
            ProchaineCase[1] += 1;
        else if (direction == 'q' || direction == 'Q')
            ProchaineCase[1] -= 1;
        else if (direction == 'z' || direction == 'Z')
            ProchaineCase[0] -= 1;
        else
            ProchaineCase[0] += 1;

    }


}