public class Niveaux {

    final static char[][] niveau1 ={
            {'*','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','*','*','*','*','*','*'},
            {'*','*','*','*','*','V','*','*','*','*'},
            {'*','*','*','*','*','P','M','*','*','*'},
            {'*','*','*','*','*','M','M','*','*','*'},
            {'*','*','*','M','*','*','*','*','*','*'},
            {'*','*','*','*','*','*','M','*','*','*'},
            {'*','*','*','*','M','*','*','*','*','*'},
            {'*','*','*','*','*','M','*','*','*','*'}
    } ;

    public static int CopieNiveau(char[][] tR, int numNiveau, int[] coordonnees){
        int tours = 0;
        switch (numNiveau) {
            case 1 :
                for (int ligne = 0; ligne < niveau1.length; ligne++) {
                    System.arraycopy(niveau1[ligne], 0, tR[ligne], 0, niveau1[ligne].length);
                }
                coordonnees[0] = 4;
                coordonnees[1] = 5;
                tours = 100;
                break;
            default:
                System.out.println("Bruh erreur zeubi le swich il a le sida ");
        }
        return tours;
    }
}
