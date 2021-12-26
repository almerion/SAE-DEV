public class Jeux {
    public static void main(String[] args) {


        char[][] t = new char[10][10];
        int[] coordonnees = {0, 0};
        Niveaux.CopieNiveau(t,1, coordonnees);
        MethodePrincipale.afficherTableau(t);
        System.out.println(coordonnees[0]);
        System.out.println(coordonnees[1]);

        while (true) {
            Menu.mouvement(t, coordonnees);
            MethodePrincipale.afficherTableau(t);
        }
        // TODO : while dans le while pour changer de niveau ( while tours > 0 while !victoire) et entre les deux victoire qui est reset et changement de niveau
    }
}
