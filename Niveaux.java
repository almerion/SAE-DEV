public class Niveaux {

    final static char[][] niveau1 ={
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','^','^','.'},
            {'.','.','.','.','.','.','R','.','.','P'},
            {'.','.','.','M','M','M','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'}
    } ;

    public static int MiseEnPlaceNiveau(char[][] copieNiveau, int numNiveau, int[] coordonnees){
        int tours = 0;
        switch (numNiveau) {
            case 1 :
                for (int ligne = 0; ligne < niveau1.length; ligne++) {
                    System.arraycopy(niveau1[ligne], 0, copieNiveau[ligne], 0, niveau1[ligne].length);
                }
                coordonnees[0] = 4;
                coordonnees[1] = 9;
                tours = 100;
                break;
            default:
                System.out.println("Bruh erreur zeubi le swich il a le sida ");
                break;
        }
        return tours;
    }
}
