public class Jeux {
    public static void main(String[] args) {


    char[][] t= new char[10][10];
    PremierNiveau.niveaux(t);
    MéthodePrincipale.afficherTableau(t);
    int coordonnees[] = {0,0};
    MéthodePrincipale.ChercherPerso(t,coordonnees);
    System.out.println(coordonnees[0]);
    System.out.println(coordonnees[1]);
    }
}
