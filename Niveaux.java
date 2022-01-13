public class Niveaux {

    final static char[][] niveau1 ={
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','V','.','.','.','.','P'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'}
    } ;
    final static char[][] niveau2 ={
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','M','.','.'},
            {'.','.','.','.','V','.','.','M','.','P'},
            {'.','.','.','.','.','.','.','M','.','.'},
            {'.','.','.','.','.','.','.','M','.','.'},
            {'.','.','.','.','.','.','.','M','.','.'},
            {'.','.','.','.','.','.','.','M','.','.'},
            {'.','.','.','.','.','.','.','M','.','.'}
    } ;
    final static char[][] niveau3 ={
            {'.','.','.','.','.','.','M','.','.','.'},
            {'.','.','.','.','.','.','M','.','.','.'},
            {'.','.','.','.','.','.','M','.','.','.'},
            {'.','.','.','.','.','.','M','.','.','.'},
            {'.','.','.','V','M','.','.','R','.','P'},
            {'.','.','.','.','.','.','M','.','.','.'},
            {'.','.','.','.','.','.','M','.','.','.'},
            {'.','.','.','.','.','.','M','.','.','.'},
            {'.','.','.','.','.','.','M','.','.','.'},
            {'.','.','.','.','.','.','M','.','.','.'}
    } ;

    final static char[][] niveau4 ={
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','V','^','^','R','^','^','P'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'}
    } ;
    final static char[][] niveau5 = {
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','M','.','.','G','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','V','^','.','.','.','.','P'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','M','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'},
            {'.','.','.','.','.','M','.','.','.','.'}
    } ;
    final static char[][] niveau6 ={
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','M','.','.','.','.','.','.','.'},
            {'.','.','.','R','^','R','.','M','^','M'},
            {'.','M','.','^','M','V','M','M','^','M'},
            {'.','M','^','M','M','M','M','.','.','.'},
            {'M','.','.','R','.','.','.','.','.','.'},
            {'.','M','.','M','.','P','.','.','.','.'}
    } ;

    public static boolean PresenceGarde(int numNiveau){
        return (numNiveau == 5);
    }



    public static int MiseEnPlaceNiveau(char[][] copieNiveau, int numNiveau, int[] coordonnees, int[] garde){
        int tours = 0;
        switch (numNiveau) {
            case 1 :
                for (int ligne = 0; ligne < niveau1.length; ligne++) {
                    System.arraycopy(niveau1[ligne], 0, copieNiveau[ligne], 0, niveau1[ligne].length);
                }
                coordonnees[0] = 4;
                coordonnees[1] = 9;
                tours = 10;
                break;

            case 2 :
                for (int ligne = 0; ligne < niveau2.length; ligne++) {
                    System.arraycopy(niveau2[ligne], 0, copieNiveau[ligne], 0, niveau2[ligne].length);
                }
                coordonnees[0] = 4;
                coordonnees[1] = 9;
                tours = 9;
                break;
            case 3 :
                for (int ligne = 0; ligne < niveau3.length; ligne++) {
                    System.arraycopy(niveau3[ligne], 0, copieNiveau[ligne], 0, niveau3[ligne].length);
                }
                coordonnees[0] = 4;
                coordonnees[1] = 9;
                tours = 11;
                break;
            case 4 :
                for (int ligne = 0; ligne < niveau4.length; ligne++) {
                    System.arraycopy(niveau4[ligne], 0, copieNiveau[ligne], 0, niveau4[ligne].length);
                }
                coordonnees[0] = 4;
                coordonnees[1] = 9;
                tours = 11;
                break;
            case 5 :
                for (int ligne = 0; ligne < niveau5.length; ligne++) {
                    System.arraycopy(niveau5[ligne], 0, copieNiveau[ligne], 0, niveau5[ligne].length);
                }
                coordonnees[0] = 4;
                coordonnees[1] = 9;
                garde[0]=2;
                garde[1]=4;
                garde[2]=1;
                garde[3]=0;
                tours = 16;
                break;
            case 6 :
                for (int ligne = 0; ligne < niveau6.length; ligne++) {
                    System.arraycopy(niveau6[ligne], 0, copieNiveau[ligne], 0, niveau6[ligne].length);
                }
                coordonnees[0] = 9;
                coordonnees[1] = 5;
                tours = 18;
                break;
            default:
                System.out.println("Bruh erreur zeubi le swich il a le sida ");
                return -1;
        }
        return tours;
    }
}
