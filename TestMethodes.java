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

        char [][] test2 = {
                {'M','.','M'},
                {'.','P','.'},
                {'M','.','M'}
        };

        char [][] test3 = {
                {'.','.','.'},
                {'.','.','.'},
                {'.','.','.'}
        };

        int[] ProchaineCaseHaut = {0,1};
        int[] ProchaineCaseGauche = {1,0};
        int[] ProchaineCaseDroite = {1,2};
        int[] ProchaineCaseBas = {2,1};
        int[] BordureHaut = {-1,0};
        int[] BordureGauche = {0,-1};
        int[] BordureDroite = {0,3};
        int[] BordureBas = {3,0};

        // test sur les murs
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test1,ProchaineCaseHaut));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test1,ProchaineCaseBas));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test1,ProchaineCaseGauche));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test1,ProchaineCaseDroite));

        // test déplacement normal
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test2,ProchaineCaseHaut));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test2,ProchaineCaseBas));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test2,ProchaineCaseGauche));
        assertFalse(MethodePrincipale.PresenceMurOuBordure(test2,ProchaineCaseDroite));

        // test déplacements sur bordure
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test3,BordureBas));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test3,BordureDroite));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test3,BordureGauche));
        assertTrue(MethodePrincipale.PresenceMurOuBordure(test3,BordureHaut));
    }

    @Test
    public void TestPresenceRocherNonDeplacable(){
        char [][] test1 = {
                {'.','.','.'},
                {'.','P','.'},
                {'.','.','.'}
        };

        char [][] test2 = {
                {'.','R','.'},
                {'R','P','R'},
                {'.','R','.'}
        };

        char [][] test3 = {
                {'.','.','.'},
                {'.','R','P'},
                {'.','.','.'}
        };

        char [][] test4 = {
                {'.','.','.'},
                {'R','.','.'},
                {'P','.','.'}
        };

        char [][] test5 = {
                {'P','.','.'},
                {'R','.','.'},
                {'.','.','.'}
        };

        char [][] test6 = {
                {'.','.','.'},
                {'P','R','.'},
                {'.','.','.'}
        };

        char [][] test7 = {
                {'.','.','.'},
                {'P','R','M'},
                {'.','.','.'}
        };

        char [][] test8 = {
                {'.','P','.'},
                {'.','R','.'},
                {'.','M','.'}
        };

        char [][] test9 = {
                {'.','.','.'},
                {'M','R','P'},
                {'.','.','.'}
        };

        char [][] test10 = {
                {'.','M','.'},
                {'.','R','.'},
                {'.','P','.'}
        };

        char [][] test11 = {
                {'.','.','.'},
                {'P','R','^'},
                {'.','.','.'}
        };

        char [][] test12 = {
                {'.','P','.'},
                {'.','R','.'},
                {'.','^','.'}
        };

        char [][] test13 = {
                {'.','.','.'},
                {'^','R','P'},
                {'.','.','.'}
        };

        char [][] test14 = {
                {'.','^','.'},
                {'.','R','.'},
                {'.','P','.'}
        };



        int[] ProchaineCaseHaut = {0,1};

        int[] ProchaineCaseGauche = {1,0};
        int[] ProchaineCaseMilieu = {1,1};
        int[] ProchaineCaseDroite = {1,2};

        int[] ProchaineCaseBas = {2,1};




        // test sans rochers ('R')
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test1,'z',ProchaineCaseHaut));
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test1,'s',ProchaineCaseBas));
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test1,'q',ProchaineCaseGauche));
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test1,'d',ProchaineCaseDroite));
        // test avec rocher non déplaçable à cause de la bordure
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test2,'z',ProchaineCaseHaut));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test2,'s',ProchaineCaseBas));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test2,'q',ProchaineCaseGauche));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test2,'d',ProchaineCaseDroite));

        // test avec rocher non déplaçable à cause d'un mur
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test7,'d',ProchaineCaseMilieu));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test8,'s',ProchaineCaseMilieu));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test9,'q',ProchaineCaseMilieu));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test10,'z',ProchaineCaseMilieu));

        // test avec rocher non déplaçable à cause de pics
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test11,'d',ProchaineCaseMilieu));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test12,'s',ProchaineCaseMilieu));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test13,'q',ProchaineCaseMilieu));
        assertTrue(MethodePrincipale.PresenceRocherNonDeplacable(test14,'z',ProchaineCaseMilieu));

        // test avec rocher déplaçable vers la gauche
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test3,'q',ProchaineCaseMilieu));
        // test avec rocher déplaçable vers le haut
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test4,'z',ProchaineCaseMilieu));
        // test avec rocher déplaçable vers le bas
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test5,'s',ProchaineCaseMilieu));
        // test avec rocher déplaçable vers la droite
        assertFalse(MethodePrincipale.PresenceRocherNonDeplacable(test6,'d',ProchaineCaseMilieu));
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

        int[] ProchaineCaseGauche = {1,0};
        int[] ProchaineCaseDroite = {1,2};
        int[] ProchaineCaseBas = {2,1};
        int[] ProchaineCaseHaut = {0,1};
        //test mouvement vers la gauche
        MethodePrincipale.Mouvement(test1,coordonneesTest1,ProchaineCaseGauche);

        assertArrayEquals(resultCoordonneesTest1,coordonneesTest1);
        assertArrayEquals(resultTest1,test1);

        //test mouvement vers la droite
        MethodePrincipale.Mouvement(test2,coordonneesTest2,ProchaineCaseDroite);

        assertArrayEquals(resultCoordonneesTest2,coordonneesTest2);
        assertArrayEquals(resultTest2,test2);

        //test mouvement vers le haut
        MethodePrincipale.Mouvement(test3,coordonneesTest3,ProchaineCaseHaut);

        assertArrayEquals(resultCoordonneesTest3,coordonneesTest3);
        assertArrayEquals(resultTest3,test3);

        //test mouvement vers le bas
        MethodePrincipale.Mouvement(test4,coordonneesTest4,ProchaineCaseBas);

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
    @Test
    public void TestDeplacementGarde() {
        char [][] test = {
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','G','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
        };
        int[] coordonneesGarde= {2,2};
        int[] coordonneesTest= {2,2};
        int[] directionTest1={0,1};
        int[] directionTest2={1,0};
        int[] directionTest3={0,-1};
        int[] directionTest4={-1,0};
        int compteur=0;

        char [][] resultTest1 = {
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','G','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
        };

        char [][] resultTest2 = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', 'G', '.', '.'},
                {'.', '.', '.', '.', '.'}

        };


        char [][] resultTest3 = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', 'G', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };

        char [][] resultTest4 = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', 'G', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };





        char [][] resultTest5 = {
                {'.','.','.','.','.'},
                {'.','.','.','.','.'},
                {'.','.','.','.','G'},
                {'.','.','.','.','.'},
                {'.','.','.','.','.'}
        };


        char [][] resultTest6 = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', 'G', '.', '.'}

        };


        char [][] resultTest7 = {
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'G', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };


        char [][] resultTest8_9 = {
                {'.', '.', 'G', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'}
        };






        //Test mouvement garde vers la droite de 1
        testMouvementGarde(test,coordonneesTest,directionTest1,resultTest1,coordonneesGarde,1);

        //Test mouvement garde vers le bas de 1
        testMouvementGarde(test,coordonneesTest,directionTest2,resultTest2,coordonneesGarde,1);


        //Test mouvement garde vers la gauche de 1
        testMouvementGarde(test,coordonneesTest,directionTest3,resultTest3,coordonneesGarde,1);


        //Test mouvement garde vers le haut de 1
        testMouvementGarde(test,coordonneesTest,directionTest4,resultTest4,coordonneesGarde,1);






        //Test mouvement garde vers la droite de 2
        testMouvementGarde(test,coordonneesTest,directionTest1,resultTest5,coordonneesGarde,2);

        //Test mouvement garde vers le bas de 2
        testMouvementGarde(test,coordonneesTest,directionTest2,resultTest6,coordonneesGarde,2);


        //Test mouvement garde vers la gauche de 2
        testMouvementGarde(test,coordonneesTest,directionTest3,resultTest7,coordonneesGarde,2);


        //Test mouvement garde vers le haut de 2
        testMouvementGarde(test,coordonneesTest,directionTest4,resultTest8_9,coordonneesGarde,2);

        //Test mouvement garde vers le haut de 2
        //testMouvementGarde(test,coordonneesTest,directionTest4,resultTest8_9,coordonneesGarde,3);
/*
        //Test mouvement garde vers le haut de 3. On s'attends à ce qu'il s'arrête devant la bordure du niveau
        while(compteur<3) {
            MethodePrincipale.DeplacementGarde(test, coordonneesTest, directionTest4);
            compteur++;
        }

        assertArrayEquals(resultTest8_9,test);
        coordonneesTest[0]=coordonneesGarde[0];
        coordonneesTest[1]=coordonneesGarde[1];
        test[coordonneesTest[0]+(directionTest4[0]*compteur)][coordonneesTest[1]+(directionTest4[1]*compteur)] = '.';
        test[coordonneesGarde[0]][coordonneesGarde[1]] = 'G';
        compteur=0;
*/

    }

    public static void testMouvementGarde(char[][] tableauTest, int[] coordonneesTest, int[] directionTest, char[][] resultTest,int[] coordonneesGarde, int mouvement) {
        int i;
        for(i = 0; i < mouvement; i++){
            MethodePrincipale.DeplacementGarde(tableauTest, coordonneesTest, directionTest);
        }
        assertArrayEquals(resultTest, tableauTest);
        coordonneesTest[0] = coordonneesGarde[0];
        coordonneesTest[1] = coordonneesGarde[1];
        tableauTest[coordonneesTest[0] + (directionTest[0] * i)][coordonneesTest[1] + (directionTest[1] * i)] = '.';
        tableauTest[coordonneesGarde[0]][coordonneesGarde[1]] = 'G';
    }
}
