import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMethodes {
    @Test
    public void TestMurOuBordure(){
        char [][] test1 = {
                {'.','M','.'},
                {'M','P','M'},
                {'.','M','.'}
        };
        int[] coordonneesTest1 = {1,1};

        char [][] test2 = {
                {'M','.','M'},
                {'.','P','.'},
                {'M','.','M'}
        };
        int[] coordonneesTest2 = {1,1};

        char [][] test3 = {
                {'.','P','.'},
                {'.','.','.'},
                {'.','.','.'}
        };
        int[] coordonneesTest3 = {0,1};

        char [][] test4 = {
                {'.','.','.'},
                {'.','.','P'},
                {'.','.','.'}
        };
        int[] coordonneesTest4 = {1,2};

        char [][] test5 = {
                {'.','.','.'},
                {'.','.','.'},
                {'.','P','.'}
        };
        int[] coordonneesTest5 = {2,1};

        char [][] test6 = {
                {'.', '.','.'},
                {'P', '.','.'},
                {'.', '.','.'}
        };
        int[] coordonneesTest6 = {1,0};

        // test sur les murs
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test1,'z',coordonneesTest1));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test1,'s',coordonneesTest1));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test1,'q',coordonneesTest1));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test1,'d',coordonneesTest1));

        // test déplacement normal
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test2,'z',coordonneesTest2));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test2,'s',coordonneesTest2));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test2,'q',coordonneesTest2));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test2,'d',coordonneesTest2));

        // test déplacements sur bordure haut
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test3,'z',coordonneesTest3));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test3,'s',coordonneesTest3));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test3,'q',coordonneesTest3));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test3,'d',coordonneesTest3));

        // test déplacements sur bordure droite
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test4,'z',coordonneesTest4));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test4,'s',coordonneesTest4));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test4,'q',coordonneesTest4));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test4,'d',coordonneesTest4));

        // test déplacements sur bordure bas
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test5,'z',coordonneesTest5));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test5,'s',coordonneesTest5));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test5,'q',coordonneesTest5));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test5,'d',coordonneesTest5));

        // test déplacements sur bordure gauche
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test6,'z',coordonneesTest6));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test6,'s',coordonneesTest6));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test6,'q',coordonneesTest6));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test6,'d',coordonneesTest6));

    }

    @Test
    public void TestPresenceRocherNonDeplacable(){
        char [][] test1 = {
                {'.','.','.'},
                {'.','P','.'},
                {'.','.','.'}
        };
        int[] coordonneesTest1 = {1,1};

        char [][] test2 = {
                {'.','R','.'},
                {'R','P','R'},
                {'.','R','.'}
        };
        int[] coordonneesTest2 = {1,1};

        char [][] test3 = {
                {'.','.','.'},
                {'.','R','P'},
                {'.','.','.'}
        };
        int[] coordonneesTest3 = {1,2};

        char [][] test4 = {
                {'.','.','.'},
                {'R','.','.'},
                {'P','.','.'}
        };
        int[] coordonneesTest4 = {2,0};

        char [][] test5 = {
                {'P','.','.'},
                {'R','.','.'},
                {'.','.','.'}
        };
        int[] coordonneesTest5 = {0,0};

        char [][] test6 = {
                {'.','.','.'},
                {'P','R','.'},
                {'.','.','.'}
        };
        int[] coordonneesTest6 = {1,0};

        char [][] test7 = {
                {'.','.','.'},
                {'P','R','M'},
                {'.','.','.'}
        };
        int[] coordonneesTest7 = {1,0};

        char [][] test8 = {
                {'.','P','.'},
                {'.','R','.'},
                {'.','M','.'}
        };
        int[] coordonneesTest8 = {0,1};

        char [][] test9 = {
                {'.','.','.'},
                {'M','R','P'},
                {'.','.','.'}
        };
        int[] coordonneesTest9 = {1,2};

        char [][] test10 = {
                {'.','M','.'},
                {'.','R','.'},
                {'.','P','.'}
        };
        int[] coordonneesTest10 = {2,1};

        char [][] test11 = {
                {'.','.','.'},
                {'P','R','^'},
                {'.','.','.'}
        };
        int[] coordonneesTest11 = {1,0};

        char [][] test12 = {
                {'.','P','.'},
                {'.','R','.'},
                {'.','^','.'}
        };
        int[] coordonneesTest12 = {0,1};

        char [][] test13 = {
                {'.','.','.'},
                {'^','R','P'},
                {'.','.','.'}
        };
        int[] coordonneesTest13 = {1,2};

        char [][] test14 = {
                {'.','^','.'},
                {'.','R','.'},
                {'.','P','.'}
        };
        int[] coordonneesTest14 = {2,1};

        // test sans rochers ('R')
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test1,'z',coordonneesTest1));
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test1,'s',coordonneesTest1));
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test1,'q',coordonneesTest1));
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test1,'d',coordonneesTest1));

        // test avec rocher non déplaçable à cause de la bordure
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test2,'z',coordonneesTest2));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test2,'s',coordonneesTest2));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test2,'q',coordonneesTest2));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test2,'d',coordonneesTest2));

        // test avec rocher non déplaçable à cause d'un mur
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test7,'d',coordonneesTest7));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test8,'s',coordonneesTest8));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test9,'q',coordonneesTest9));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test10,'z',coordonneesTest10));

        // test avec rocher non déplaçable à cause de pics
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test11,'d',coordonneesTest11));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test12,'s',coordonneesTest12));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test13,'q',coordonneesTest13));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test14,'z',coordonneesTest14));

        // test avec rocher déplaçable vers la gauche
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test3,'q',coordonneesTest3));
        // test avec rocher déplaçable vers le haut
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test4,'z',coordonneesTest4));
        // test avec rocher déplaçable vers le bas
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test5,'s',coordonneesTest5));
        // test avec rocher déplaçable vers la droite
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test6,'d',coordonneesTest6));
    }

    @Test
    public void TestMouvement(){
        // Les sorties de carte, présence de mur/rocher sont des cas à apart traités par d'autres méthodes
        // ici seuls les mouvements vers les cases vides ou en présence de pics sont traités
        char [][] test1 = {
                {'.','.','.'},
                {'.','P','.'},
                {'.','.','.'}
        };
        int[] coordonneesTest1 = {1,1};
        char [][] test2 = {
                {'.','.','.'},
                {'.','P','.'},
                {'.','.','.'}
        };
        int[] coordonneesTest2 = {1,1};
        char [][] test3 = {
                {'.','.','.'},
                {'.','P','.'},
                {'.','.','.'}
        };
        int[] coordonneesTest3 = {1,1};
        char [][] test4 = {
                {'.','.','.'},
                {'.','P','.'},
                {'.','.','.'}
        };
        int[] coordonneesTest4 = {1,1};

        char [][] resultTest1 = {
                {'.','.','.'},
                {'P','.','.'},
                {'.','.','.'}
        };
        int[] resultCoordonneesTest1 = {1,0};

        char [][] resultTest2 = {
                {'.','.','.'},
                {'.','.','P'},
                {'.','.','.'}
        };
        int[] resultCoordonneesTest2 = {1,2};

        char [][] resultTest3 = {
                {'.','P','.'},
                {'.','.','.'},
                {'.','.','.'}
        };
        int[] resultCoordonneesTest3 = {0,1};

        char [][] resultTest4 = {
                {'.','.','.'},
                {'.','.','.'},
                {'.','P','.'}
        };
        int[] resultCoordonneesTest4 = {2,1};


        //test mouvement vers la gauche
        MethodePrincipale.Mouvement(test1,'q',coordonneesTest1);

        assertArrayEquals(resultCoordonneesTest1,coordonneesTest1);
        assertArrayEquals(resultTest1,test1);

        //test mouvement vers la droite
        MethodePrincipale.Mouvement(test2,'d',coordonneesTest2);

        assertArrayEquals(resultCoordonneesTest2,coordonneesTest2);
        assertArrayEquals(resultTest2,test2);

        //test mouvement vers le haut
        MethodePrincipale.Mouvement(test3,'z',coordonneesTest3);

        assertArrayEquals(resultCoordonneesTest3,coordonneesTest3);
        assertArrayEquals(resultTest3,test3);

        //test mouvement vers le bas
        MethodePrincipale.Mouvement(test4,'s',coordonneesTest4);

        assertArrayEquals(resultCoordonneesTest4,coordonneesTest4);
        assertArrayEquals(resultTest4,test4);



    }

    @Test
    public void TestMouvementRocher(){
        // Seul le mouvement du rocher sera traité, les cas ou il n'est pas possible est traité dans une autre methode
        char [][] test1 = {
                {'.','.','.'},
                {'.','R','.'},
                {'.','P','.'}
        };
        int[] coordonneesTest1 = {2,1};
        int[] ProchaineCase1 = {1,1};

        char [][] test2 = {
                {'.','.','.'},
                {'.','R','P'},
                {'.','.','.'}
        };
        int[] coordonneesTest2 = {1,2};
        int[] ProchaineCase2 = {1,1};

        char [][] test3 = {
                {'.','P','.'},
                {'.','R','.'},
                {'.','.','.'}
        };
        int[] coordonneesTest3 = {0,1};
        int[] ProchaineCase3 = {1,1};

        char [][] test4 = {
                {'.','.','.'},
                {'P','R','.'},
                {'.','.','.'}
        };
        int[] coordonneesTest4 = {1,0};
        int[] ProchaineCase4 = {1,1};

        char [][] resultTest1 = {
                {'.','R','.'},
                {'.','.','.'},
                {'.','P','.'}
        };
        int[] resultCoordonneesTest1 = {2,1};
        char [][] resultTest2 = {
                {'.','.','.'},
                {'R','.','P'},
                {'.','.','.'}
        };
        int[] resultCoordonneesTest2 = {1,2};
        char [][] resultTest3 = {
                {'.','P','.'},
                {'.','.','.'},
                {'.','R','.'}
        };
        int[] resultCoordonneesTest3 = {0,1};
        char [][] resultTest4 = {
                {'.','.','.'},
                {'P','.','R'},
                {'.','.','.'}
        };
        int[] resultCoordonneesTest4 = {1,0};

        //Test mouvement rocher vers le haut
        MethodePrincipale.MouvementRocher(test1,'z',ProchaineCase1);
        assertArrayEquals(resultTest1,test1);
        assertArrayEquals(resultCoordonneesTest1,coordonneesTest1);

        //Test mouvement rocher vers la gauche
        MethodePrincipale.MouvementRocher(test2,'q',ProchaineCase2);
        assertArrayEquals(resultTest2,test2);
        assertArrayEquals(resultCoordonneesTest2,coordonneesTest2);

        //Test mouvement rocher vers le bas
        MethodePrincipale.MouvementRocher(test3,'s',ProchaineCase3);
        assertArrayEquals(resultTest3,test3);
        assertArrayEquals(resultCoordonneesTest3,coordonneesTest3);

        //Test mouvement rocher vers la droite
        MethodePrincipale.MouvementRocher(test4,'d',ProchaineCase4);
        assertArrayEquals(resultTest4,test4);
        assertArrayEquals(resultCoordonneesTest4,coordonneesTest4);



    }

    @Test
    public void TestProchaineCase(){
        //Les cas ou les mouvements ne sont pas faisables sont traités dans une autre méthode
        //On ne fait que vérifier si les calculs se font bien ici
        int[] tests = {0,5};
        int[] resultTest1 = {0,4};
        int[] resultTest2 = {0,5};
        int[] resultTest3 = {1,5};
        int[] resultTest4 = {0,5};

        //Test vers la gauche
        MethodePrincipale.CalculProchaineCase('q',tests);
        assertArrayEquals(resultTest1,tests);
        //Test vers la droite
        MethodePrincipale.CalculProchaineCase('d',tests);
        assertArrayEquals(resultTest2,tests);
        //Test vers le bas
        MethodePrincipale.CalculProchaineCase('s',tests);
        assertArrayEquals(resultTest3,tests);
        //Test vers le haut
        MethodePrincipale.CalculProchaineCase('z',tests);
        assertArrayEquals(resultTest4,tests);
    }




}
