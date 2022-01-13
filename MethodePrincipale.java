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



    public static boolean PresenceMurOuBordure (char [][] niveau, int[] ProchaineCase){
        return (ProchaineCase[0] == -1 || ProchaineCase[0] == niveau.length || ProchaineCase[1] == -1 || ProchaineCase[1] == niveau.length || niveau[ProchaineCase[0]][ProchaineCase[1]] == 'M');
    }


    public static boolean PresenceRocherNonDeplacable(char [][] niveau, char direction , int [] ProchaineCase){

        boolean PresenceRocherNonDeplacable = false;

        if (niveau[ProchaineCase[0]][ProchaineCase[1]] == 'R'){
            if (direction == 'z')
                PresenceRocherNonDeplacable = (ProchaineCase[0]-1 < 0 || niveau[ProchaineCase[0] - 1][ProchaineCase[1]] != '.');
            else if (direction == 'd')
                PresenceRocherNonDeplacable = (ProchaineCase[1]+1 > niveau.length-1 || niveau[ProchaineCase[0]][ProchaineCase[1] + 1] != '.');
            else if (direction == 's')
                PresenceRocherNonDeplacable = (ProchaineCase[0]+1 > niveau.length-1||niveau[ProchaineCase[0] + 1][ProchaineCase[1]] != '.');
            else
                PresenceRocherNonDeplacable = (ProchaineCase[1]-1 < 0 || niveau[ProchaineCase[0]][ProchaineCase[1] - 1] != '.');

        }

        return PresenceRocherNonDeplacable;
    }
    public static void Mouvement(char [] [] niveau , char direction, int[] coordonneesJoueur){
        if(direction == 'q'){
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1] -1] = 'P';
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1]] = '.';
            coordonneesJoueur[1] -=1;
        }
        else if(direction == 'z'){
            niveau[coordonneesJoueur[0]-1][coordonneesJoueur[1]] = 'P';
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1]] = '.';
            coordonneesJoueur[0] -=1;
        }
        else if (direction == 'd'){
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1]+1] = 'P';
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1]] = '.';
            coordonneesJoueur[1] +=1;
        }
        else{
            niveau[coordonneesJoueur[0]+1][coordonneesJoueur[1]] = 'P';
            niveau[coordonneesJoueur[0]][coordonneesJoueur[1]] = '.';
            coordonneesJoueur[0] +=1;
        }
    }

    public static boolean DeplacementGarde(char[][]niveau, int[] garde){//on aurait pu utiliser prochaine case mais pas fait pcq non
        int[] prochaineCase=new int[2];
        prochaineCase[0]=garde[0]+garde[2];
        prochaineCase[1]=garde[1]+garde[3];
        if(PresenceMurOuBordure(niveau,prochaineCase)){
            if(garde[2]==-1)
                garde[2]=1;
            else if(garde[3]==-1)
                garde[3]=1;
            else if(garde[2]==1)
                garde[2]=-1;
            else if(garde[3]==1)
                garde[3]=-1;

        }

        else {
            niveau[prochaineCase[0]][prochaineCase[1]] = 'G';
            niveau[garde[0]][garde[1]] = '.';
            garde[0] += garde[2];
            garde[1] += garde[3];
        }
        if(niveau[prochaineCase[0]][prochaineCase[1]]=='P') {
            return true;
        }
        return false;
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
        if (direction == 'd')
            ProchaineCase[1] += 1;
        else if (direction == 'q')
            ProchaineCase[1] -= 1;
        else if (direction == 'z')
            ProchaineCase[0] -= 1;
        else
            ProchaineCase[0] += 1;

    }


}