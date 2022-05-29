

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {


    //& Declaration D'une liste de Liste de lignes (une grande liste contenat 4 listes chacune contient
    //& des ligne du meme Type De Moyen de trans)

     static ArrayList<ArrayList<Ligne>> Lignes = new ArrayList<>();


    public static void affiche () {

        int choix,choix1,choix2,choix3;


        Scanner sc = new Scanner(System.in);

        System.out.println("                                               ‖                                 ");
        System.out.println("                                     --------------------                        ");
        System.out.println("                                     | Projet TP de POO |                        ");
        System.out.println("                                     --------------------                        ");

        do {
            System.out.println("                                                                                 ");
            System.out.println("                                  | Que voulez vous faire ? |                     ");
            System.out.println("                                                                                  ");

            System.out.println("                     -----------------------------------------------------");
            System.out.println("                     |                                                   |");
            System.out.println("                     |      1. Faire une requete de mise a jour          |");
            System.out.println("                     |                                                   |");
            System.out.println("                     |      2. Faire une Requêtes d’interrogation        |");
            System.out.println("                     |                                                   |");
            System.out.println("                     |      3. Quitter                                   |");
            System.out.println("                     |                                                   |");
            System.out.println("                     -----------------------------------------------------");

            do {
                System.out.print("\n Veuillez introduire un numero: ");

                choix = sc.nextInt();

                System.out.println("\n");
            }while(choix<1 && choix>3);



            switch (choix) {
                case 1: {

                    do {
                        System.out.println("\t\t\t     Les operations de mise a jour possible :");

                        System.out.println("                     ------------------------------------------------");
                        System.out.println("                     | 1. Modification                              |");
                        System.out.println("                     |                                              |");
                        System.out.println("                     | 2. Ajout                                     |");
                        System.out.println("                     |                                              |");
                        System.out.println("                     | 3. Suppression                               |");
                        System.out.println("                     |                                              |");
                        System.out.println("                     | 4.-- Revenir au menu précédent --            |");
                        System.out.println("                     ------------------------------------------------");

                        do {
                            System.out.println("\n Veuillez introduire un numero: ");
                            choix1 = sc.nextInt();
                        }while (choix1<1 && choix1>4);

                        switch (choix1) {
                            case 1: {
                                do {
                                    System.out.println("\t\t\t     vous voulez faire des modification de :");

                                    System.out.println("                     ---------------------------------------");
                                    System.out.println("                     | 1. Ligne                            |");
                                    System.out.println("                     |                                     |");
                                    System.out.println("                     | 2. Station                          |");
                                    System.out.println("                     |                                     |");
                                    System.out.println("                     | 3. Navette                          |");
                                    System.out.println("                     |                                     |");
                                    System.out.println("                     | 4. -- Revenir au menu précédent --  |");
                                    System.out.println("                     ---------------------------------------");

                                    do {
                                        System.out.print("\n Veuillez introduire un numero: ");
                                        choix2 = sc.nextInt();
                                    }while(choix2<1 && choix2>4);

                                    switch (choix2) {
                                        case 1 -> {
                                            System.out.println("\n\t\t\t     Modication d'une ligne  :\n");

                                            Station.afficheTouteStation(Lignes);

                                            Prog.ModLigne(Lignes);

                                            break;

                                        }
                                        case 2 -> {
                                            System.out.println("\n\t\t\t     Modication d'une station  :\n");

                                            Station.afficheTouteStation(Lignes);

                                            Prog.ModifStat(Menu.Lignes); //++++++++++++++++

                                            System.out.print("\n");
                                            break;

                                        }

                                        case 3 -> {
                                            System.out.println("\n\t\t\t     Modication d'une navette  :\n");

                                            Navette.affichenav(Lignes);

                                            Prog.ModifNavette(Menu.Lignes);    //++++++++++++++++

                                            Navette.affichenav(Lignes);

                                            break;

                                        }

                                    }
                                }while(choix2!=4);
                                break;
                            }


                            case 2: {
                                do {
                                    System.out.println("\t\t\t\t\t       vous voulez faire l'ajout de :");

                                    System.out.println("                     ---------------------------------------");
                                    System.out.println("                     | 1. Ligne                            |");
                                    System.out.println("                     |                                     |");
                                    System.out.println("                     | 2. Station                          |");
                                    System.out.println("                     |                                     |");
                                    System.out.println("                     | 3. Tronçon,                         |");
                                    System.out.println("                     |                                     |");
                                    System.out.println("                     | 4. -- Revenir au menu précédent --  |");
                                    System.out.println("                     |                                     |");
                                    System.out.println("                     ---------------------------------------");

                                    do {
                                        System.out.print("\n Veuillez introduire un numero: ");
                                        choix2 = sc.nextInt();
                                    }while (choix2<1 && choix2>4);


                                    switch (choix2) {
                                        case 1 -> {
                                            System.out.println("\n\t\t\t     Ajout d'une ligne  :\n");

                                            Prog.CreatLigne(Menu.Lignes);   //+++++++++

                                            break;
                                        }
                                        case 2 -> {
                                            System.out.println("\n\t\t\t     Ajout d'une station  :\n");

                                            Prog.affichLignes(Lignes);

                                            Prog.ajoutStat(Menu.Lignes);    //+++++

                                            break;
                                        }

                                        case 3 -> {

                                            Navette.affichenav(Lignes);

                                            System.out.println("\t\t\t     Ajout d'une navette  :");

                                            Prog.addNav(Lignes);            //++++

                                            break;
                                        }
                                    }
                                }while(choix2!=4);
                                break;
                            }

                            case 3: {
                                do {
                                    System.out.println("\t\t\t     vous voulez faire la suppression de :");

                                    System.out.println("                     ---------------------------------------");
                                    System.out.println("                     | 1. Ligne                            |");
                                    System.out.println("                     |                                     |");
                                    System.out.println("                     | 2. Station                          |");
                                    System.out.println("                     |                                     |");
                                    System.out.println("                     | 3. Navette                          |");
                                    System.out.println("                     |                                     |");
                                    System.out.println("                     | 4. -- Revenir au menu précédent --  |");
                                    System.out.println("                     ---------------------------------------");

                                    do {
                                        System.out.print("\n Veuillez introduire un numero: ");
                                        choix2 = sc.nextInt();
                                    }while (choix2<1 && choix2>4);


                                    switch (choix2) {
                                        case 1 -> {
                                            System.out.println("\n\t\t\t     Suppresion d'une ligne  :\n");

                                            Prog.affichLignes(Lignes);

                                            Prog.SupLigne(Menu.Lignes);     //+++++++++

                                            Prog.affichLignes(Lignes);

                                            break;
                                        }
                                        case 2 -> {
                                            System.out.println("\t\t\t     Suppresion d'une station  :");

                                            Prog.SupStat(Menu.Lignes);          //++++++

                                            break;
                                        }

                                        case 3 -> {
                                            System.out.println("\t\t\t     Suppresion d'une navette  :");

                                            Navette.affichenav(Lignes);

                                            Prog.SupNav(Menu.Lignes);       //+++++

                                            Navette.affichenav(Lignes);

                                            break;
                                        }
                                    }
                                } while (choix2!=4);
                                break;
                            }
                        }
                    }while(choix1!=4);
                    break;
                }


                case 2: {
                    do {
                        System.out.println("\t\t\t\t\t\t\t\t\t\uD83D\uDCCC Les requetes d'interrogation possible");

                        System.out.println("                     ------------------------------------------------------------------");
                        System.out.println("                     | 1.        Affichage de toutes les lignes de transport          |");
                        System.out.println("                     |                                                                |");
                        System.out.println("                     | 2.        Affichage du chemin sur une ligne donnée             |");
                        System.out.println("                     |                                                                |");
                        System.out.println("                     | 3.        Chercher toutes les lignes qui passent               |");
                        System.out.println("                     |                    une station donnée                          |");
                        System.out.println("                     |                                                                |");
                        System.out.println("                     | 4.        Affichage des stations de correspondance             |");
                        System.out.println("                     |                                                                |");
                        System.out.println("                     | 5.        Affichage La ligne empruntée par le plus             |");
                        System.out.println("                     |                     grand nombre de voyageurs                  |");
                        System.out.println("                     |                                                                |");
                        System.out.println("                     | 6.        Affichage La durée estimée pour aller d’un           |");
                        System.out.println("                     |                      point A à un point B                      |");
                        System.out.println("                     |                                                                |");
                        System.out.println("                     | 7.        Construction de chemin pour aller d’un point         |");
                        System.out.println("                     |                      A à un point B                            |");
                        System.out.println("                     |                                                                |");
                        System.out.println("                     | 8.             -- Revenir au menu précédent --                 |");
                        System.out.println("                     |                                                                |");
                        System.out.println("                     ------------------------------------------------------------------");

                        do {
                            System.out.print("\n Veuillez introduire un numero: ");
                            choix3 = sc.nextInt();
                        }while(choix3<1 && choix3>9);


                        switch (choix3) {
                            case 1 -> {
                                //System.out.println(" Affichage de toutes les lignes de transport :");

                                Intero.qst1(Menu.Lignes);
                                System.out.println("\n");

                                break;
                            }
                            case 2 -> {
                                //System.out.println("Affichage du chemin sur une ligne donnée :");

                                Intero.qst2(Menu.Lignes);
                                System.out.println("\n");

                                break;
                            }
                            case 3 -> {
                                //System.out.println("Les lignes qui passent par la station donnée :");

                                Intero.qst3(Menu.Lignes);
                                System.out.println("\n\n");

                                break;
                            }
                            case 4 -> {
                                //System.out.println("Affichage des stations de correspondance :");

                                Intero.qst4(Menu.Lignes);

                                break;
                            }
                            case 5 -> {
                                //System.out.println("La ligne empruntée par le plus grand nombre de voyageurs :");

                                Intero.qst5(Menu.Lignes);

                                break;
                            }
                            case 6 -> {
                               // System.out.println("La durée estimée pour aller du point A au point B :");

                                Intero.qst6(Menu.Lignes);

                                break;
                            }
                            case 7 -> {
                                //System.out.println(" Construction de chemin pour aller du point A au point B :");

                                Intero.qst7(Menu.Lignes);

                                break;
                            }
//                            case 8 -> {
//                                System.out.println("le chemin optimal en durée pour aller du point A vers le point B : ");
//
//                                break;
//                            }
                        }
                    }while(choix3!=8);
                    break;
                }

                case 3: {
                    System.out.println("\t\t\t\t\t\t\t    ═▇▇▇┣ Bonne journée à vous ┣▇▇▇═");
                    break;
                }
            }
        }while(choix!=3);
    }

}
