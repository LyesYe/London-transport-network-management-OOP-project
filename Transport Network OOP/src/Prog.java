import java.util.ArrayList;
import java.util.Scanner;

public class Prog {

    //...........................................................................................................................................

    static int iline = 0;     //& represente une variable static : on l'utilise plus tard afin de recuperer la position de la ligne dans le array
    static String idline = "";        //& represente une variable static : on l'utilise plus tard afin de recuperer le id d'une ligne
    static int idStation = 0;         //& represente une variable static : on l'utilise plus tard comme compteur pour code d estation afin d'eviter les redondance
    static ArrayList<Station> ToutStat = new ArrayList<Station>();


//...........................................................................................................................................


    //+ Methode qui affiche toute les lignes

    static void affichLignes(ArrayList<ArrayList<Ligne>> Lignes) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (ArrayList<Ligne> TL : Lignes) {
            if (!TL.isEmpty()) {
                System.out.println("------------------------------------------------------------- Les Lignes De " + MOYt(getTypeFromID(TL.get(0).getNumligne())).name() + " " + MOYt(getTypeFromID(TL.get(0).getNumligne())).getEmoji() + " --------------------------------------------------------------------------------- ");
            }

            for (Ligne L : TL) {
                if (L.getTroncon().isEmpty()) {
                    System.out.println("Acune Ligne");
                } else {
                    L.affichelist();
                }
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


    }

    //! -------------------------- Methode qui cree et ajoute une ligne --------------------------

    static void CreatLigne(ArrayList<ArrayList<Ligne>> Lignes) {
        Scanner scan = new Scanner(System.in);

        //& id represente le numero de la ligne

        String id;
        int ar = 0;
        int wh = 0;

        MoyTransport.MoyType type;

        do //& Verifier si le id de la lignes existe deja
        {
            System.out.println("\t- Introduction Du ID unique de la ligne -\n");

            do   //& un do while pour eviter les erreur sur le type de MoyTrans
            {

                System.out.print("Precissez le Type de la Ligne : ");

                id = scan.next().toLowerCase();


                //& switch case pour determiner le type De MoyTrans

                //!   wh= compteur pour le do while |  ar = pour determiner le type choisis

                switch (id) {
                    case "bus" -> {
                        id = String.valueOf(id.charAt(0)).toUpperCase();
                        wh = 0;
                        ar = 0;
                    }
                    case "train" -> {
                        id = String.valueOf(id.charAt(0)).toUpperCase();
                        wh = 0;
                        ar = 1;
                    }
                    case "tramway" -> {
                        id = id.substring(0, 2).toUpperCase();
                        ar = 2;
                    }
                    case "metro" -> {
                        id = String.valueOf(id.charAt(0)).toUpperCase();
                        wh = 0;
                        ar = 3;
                    }
                    default -> {
                        System.out.println("\t⚠️ !_! MoyenTransport inccorect !_! ⚠️");
                        wh = 1;
                    }
                }
            } while (wh == 1);

            System.out.print("Insere le numero de la ligne :");

            type = MOYt(id);

            //& faire une concatenation entre La premier lettre du type et le numero introduit (format B001)

            //& le format sert a introduire des zero au debut de l'id de la ligne

            id += String.format("%03d", scan.nextInt());

        } while (Ligne.VerifID(id, Lignes, ar));


        ArrayList<Station> ARstat = new ArrayList<>();
        ArrayList<Troncon> ARtronc = new ArrayList<>();

        //& Remplissage de la liste des station

        char ch = 'm';
        int cpt = 0;
        System.out.println("\n\t- Introduction Des Station -\n");
        do {
            if (ch == 'N' && cpt <= 2) {
                System.out.println("\t!!!!! Il faut minimum 2 station !!!!!");
            }
            Station s;
            do {
                int n = 1;
                s = Station.CreatStat(n + 1, id);
                if (s.DupSt(ARstat)) {
                    System.out.println("\t!_! Station existe Deja !! introduisez une autre !_!");

                }
            } while (s.DupSt(ARstat));
            ARstat.add(s);
            cpt++;

            System.out.println("\t- Voulez Vous Rajouter une autre station : (Y/N) -");
            ch = scan.next().toUpperCase().charAt(0);

        } while (ch == 'Y' || cpt < 2);

        //& Remplissage de la liste des Tronçon


        Troncon.StatToTronc(ARstat, ARtronc);


//        ARstat.remove(0);ARstat.remove(ARstat.size()-1);


        //& Creation de la Lignes


        Ligne l1 = new Ligne(id, type, ARtronc.get(0).getStation_debut(), ARtronc.get(ARtronc.size() - 1).getStation_fin(), ARstat, ARtronc);


        System.out.println("\t\t-= Ligne '" + id + "' Cree ✔️=-\n");

        boolean b = false;

        //& Ajout des Navette

        do {
            System.out.println("\n\t- Voulez vous rajouter des navette a cette ligne ? (Y/N) -");
            String res = scan.next();

            if (res.equalsIgnoreCase("y")) {
                l1.CreatNav();
            } else {
                b = true;
            }
        } while (!b);

        System.out.println("\t\t \uD83D\uDCCC Ajout Ligne Terminee");

        Lignes.get(ar).add(l1);

    }


    //! -------------------------- Methode qui cree et ajoute une Station ---------------------------------------------

    static void ajoutStat(ArrayList<ArrayList<Ligne>> Lignes) {
        Scanner scan = new Scanner(System.in);
        //System.out.println("\t- Ajout D'une Station -");
        int ar = 4;
        String id;
        do {

            System.out.print("Veuillez choisir une ligne : ");

            //& determiner la ligne + le type du moy de trans
            id = scan.next().toUpperCase();


            switch (getTypeFromID(id)) {
                case "B" -> ar = 0;

                case "T" -> ar = 1;

                case "TR" -> ar = 2;

                case "M" -> ar = 3;

                default -> System.out.println("\t⚠️ !! Ligne choisis inexistente !! ⚠️");

            }

        } while (ar == 4);

        Ligne l1 = null;

        //& retourner la ligne choisis

        for (int i = 0; i < Lignes.get(ar).size(); i++) {
            if (Lignes.get(ar).get(i).getNumligne().equalsIgnoreCase(id)) {
                l1 = Lignes.get(ar).get(i);
            }
        }

        //& re-afficher la ligne
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        if (l1 != null) {
            l1.affichelist();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.print("Choisisez une position (1:represente ajout au debut ) : ");

        int p = scan.nextInt();


        Station s = Station.CreatStat(p, id);

//        s.setNline(id);

        //& Ajouter la station

        if (p <= 1) {
            l1.setStation_departttt(s);
        } else {
            if (p > l1.getStation_inter().size()) {
                l1.setStation_arrivettt(s);
            } else {
                l1.setStation_interttt(s, p - 1);
            }
        }

        //& ire les tronçon

        ArrayList<Troncon> ARtronc = new ArrayList<>();

        Troncon.StatToTronc(l1.getStation_inter(), l1.getTroncon());

        for (int i = 0; i < l1.getStation_inter().size() - 1; i++) {

            //&   random etat will change each time u add station

            ARtronc.add(new Troncon(i + 1, l1.getStation_inter().get(i), l1.getStation_inter().get(i + 1), Cord.dist(l1.getStation_inter().get(i).getCordonee(), l1.getStation_inter().get(i + 1).getCordonee()), Troncon.etatRand()));
        }

        l1.setTroncon(ARtronc);

        System.out.println("\t\tStation Ajoutee ✔️");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        l1.affichelist();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


    }


    //+   methode qui retourn le Type de moy a partire d'un string abreviation

    static MoyTransport.MoyType MOYt(String s) {
        switch (s) {
            case "B" -> {
                return MoyTransport.MoyType.BUS;
            }

            case "M" -> {
                return MoyTransport.MoyType.METRO;
            }

            case "T" -> {
                return MoyTransport.MoyType.TRAIN;
            }

            case "TR" -> {
                return MoyTransport.MoyType.TRAMWAY;
            }

            default -> System.out.println("error!!!!");

        }
        return null;
    }


    //+   methode qui retourn l'abrevation du type


    static String getTypeFromID(String s) {
        StringBuilder id = new StringBuilder();

        //& retourner que les character de type lettre

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                id.append(s.charAt(i));
            }
        }
        return id.toString();
    }

    //+ methode retourne type from id

    static MoyTransport.MoyType getTransFromId(String id) {
        return MOYt(getTypeFromID(id));
    }


    //! -------------------------- methode qui supprime une ligne -----------------------

    static void SupLigne(ArrayList<ArrayList<Ligne>> Lignes) {

        System.out.print("Veuillez Ecrire Le ID De La Ligne A Supprimer : ");
        Scanner scan = new Scanner(System.in);

        Prog.idline = "";
        Prog.iline = 0;

        //& Trouver la ligne a l'aide de la methode LignePosition

        int ar = Ligne.LignePosition(Lignes/*,i,id*/);

        //& la supprimer a l'aide de la methode remove

        Lignes.get(ar).remove(Prog.iline);


        System.out.println("\t\t Ligne Supprimer ✔️");

    }

    //! -------------------------- methode qui supprime une Station ----------------------

    static void SupStat(ArrayList<ArrayList<Ligne>> Lignes) {
        Scanner scan = new Scanner(System.in);
        //System.out.println("\t- Suppression D'une Station -");

        Prog.idline = "";
        Prog.iline = 0;

        System.out.print("Veuillez choisir une Ligne : ");
        int ar = Ligne.LignePosition(Lignes /*, i, id*/);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Lignes.get(ar).get(Prog.iline).affichelist();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.print("Choisissez une station (par nom) : ");

        String s = scan.nextLine();

        //& Suppression de la dtation de la array list des station
        Lignes.get(ar).get(Prog.iline).getStation_inter().removeIf(c -> s.equalsIgnoreCase(c.getNom()));

        //& re enumerer les numero des station par ordre
        Lignes.get(ar).get(Prog.iline).ReenumStat();


        ArrayList<Troncon> ARtronc = new ArrayList<>();

        //& afin de re lier les tronçon j'ai decider de les recree a partir de la array list des station
        Troncon.StatToTronc(Lignes.get(ar).get(Prog.iline).getStation_inter(), ARtronc);

        Lignes.get(ar).get(Prog.iline).setTroncon(ARtronc);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        //System.out.println( Lignes.get(ar).get(Prog.iline).getStation_inter());

        System.out.println("\t\t Station Supprimer ✔️");

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Lignes.get(ar).get(Prog.iline).affichelist();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


    }


    //+  modifier num ligne

    //+ Une methode qui determine les station principla et correspandance , et les met dans un array list (separement)

    static void statPrinc(ArrayList<ArrayList<Ligne>> Lignes, Station S1) {
        //& TESTER SI la station introduite est principale ou non (2 station QUI ONT DIFFERNT MOY TRANS ET MEME COORDONNE SONT PRINSUPALE)
        for (ArrayList<Ligne> TL : Lignes) {
            for (Ligne L : TL) {
                for (Station st : L.getStation_inter()) {
                    //& test egalité des coordonnee + test si cest pas la meme station
                    if (st.equals(S1) && st.getNline() != S1.getNline()) {
                        //& test si il ont different moyene de transport (pour determiner si Principale ou non)
                        if (getTransFromId(st.getNline()).equals(getTransFromId(S1.getNline()))) {
                            //System.out.println(st);
                            //& ajouter la station au hashset des coorrespandance
                            if (!Ligne.getCoorespandance().contains(st)) Ligne.setCoorespandance(st);
//                            cor=true;
                            st.setCode(S1.getCode());

                        } else {

                            //& ajouter la station au hashset des coorrespandance + array des principale

                            st.setTypestat(Station.type.principale);
                            S1.setTypestat(Station.type.principale);
                            //System.out.println(S1.getNom()+"=="+st.getNom());
                            st.setCode(S1.getCode());
                            Station.setArrayStatPrinc(S1);
                            if (!Ligne.getCoorespandance().contains(S1)) Ligne.setCoorespandance(S1);
                        }
                    }
                }
            }
        }
    }


    static String StatEQcord(ArrayList<ArrayList<Ligne>> Lignes, Cord c) {
        //& TESTER SI les Coordonee existe deja , elle returne le nom de la station qui lui egae , pour l'affecter a notre nouvelle station

        for (ArrayList<Ligne> TL : Lignes) {
            for (Ligne L : TL) {
                for (Station st : L.getStation_inter()) {

                    if (st.getCordonee().getLongitude() == c.getLongitude() && st.getCordonee().getLatitude() == c.getLatitude()) {
                        return st.getNom();
                    }
                }
            }
        }
        return null;

    }

    //! add navette

    static void addNav(ArrayList<ArrayList<Ligne>> Lignes) {
        Scanner scan = new Scanner(System.in);
        //System.out.println("\t- Ajout Des Navettes -");

//        int i=0;
//        String id ="";

        Prog.idline = "";
        Prog.iline = 0;

        //& Chercher la ligne
        System.out.print("Veuillez Choisir une Ligne : ");
        int ar = Ligne.LignePosition(Lignes /*, i, id*/);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(Lignes.get(ar).get(Prog.iline).getNavette());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        boolean b = true;

        //& Demander  de rajouter une navette jusqua N
        while (b) {

            //& cree la navette
            Lignes.get(ar).get(Prog.iline).CreatNav();

            System.out.println("\t\t- Voulez vous rajouter des navette a cette ligne ? (Y/N)");
            String res = scan.next();

            b = res.equalsIgnoreCase("y");
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Les Navette De Cette Ligne : " + Lignes.get(ar).get(Prog.iline).getNavette());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

//        System.out.println(Lignes.get(ar).get(Prog.iline).getNavette());

        System.out.println("\t\tNavettes Ajoutee ✔️");
    }


    //! SuppNavette

    static void SupNav(ArrayList<ArrayList<Ligne>> Lignes) {
        //System.out.println("\t- Suppression Des Navette -");
        Scanner scan = new Scanner(System.in);

//        int i=0;
//        String id ="";

        Prog.idline = "";
        Prog.iline = 0;

        int ar;
        char ch = 0;

        //& Demander  de supprimer une navette jusqua N

        do {
            System.out.print("Veuillez Choisir une Ligne : ");
            ar = Ligne.LignePosition(Lignes /*, i, id*/);
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Les Navette De Cette Ligne : " + Lignes.get(ar).get(Prog.iline).getNavette());
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ch = 'N';

            if (Lignes.get(ar).get(Prog.iline).getNavette().isEmpty()) {
                System.out.println("Acune Navette dans cette ligne , Voulez vous choisir une auatre ligne ?");
                ch = scan.next().toUpperCase().charAt(0);
                if (ch == 'N') {
                    ch = 'Y';
                    break;
                }
            }

        } while (ch == 'Y' || Lignes.get(ar).get(Prog.iline).getNavette().isEmpty());


        if (ch != 'Y') {
            System.out.print("Veulliez Choisir une Navette : ");

            int s = scan.nextInt();
            //& supprimer la navette a laide de la methode remove if
            Lignes.get(ar).get(Prog.iline).getNavette().removeIf(c -> s == (c.getNumero()));

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Les Navette De Cette Ligne : " + Lignes.get(ar).get(Prog.iline).getNavette());
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\t\tNavettes Supprimer ✔️");
        }


    }


    //! modif navette

    static void ModifNavette(ArrayList<ArrayList<Ligne>> Lignes) {
        Scanner scan = new Scanner(System.in);
        // System.out.println("\t- Modification De Navtte -");
//        int i=0;
//        String id ="";


        Prog.idline = "";
        Prog.iline = 0;
        System.out.print("Veuillez Choisir une Ligne : ");

        int ar = Ligne.LignePosition(Lignes /*, i, id*/);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Les Navette De Cette Ligne : " + Lignes.get(ar).get(Prog.iline).getNavette());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int b;
        int nv;

        do {
            System.out.print("veuillez choisir une navette : ");
            nv = scan.nextInt();

//            int finalNv = nv;
//            Optional<Navette> n = Lignes.get(ar).get(i).getNavette().stream()
//A                    .filter(p -> p.getNumero()== finalNv)
//A                   .findAny();
//
//            System.out.println(n);

            //& chercher la navette a laide de la methode indxnav qui retourne l'indexe de la navette dans le array des navette dans al ligne
            b = Lignes.get(ar).get(Prog.iline).indxNav(nv);
            //System.out.println(b);

        } while (b == 99);

        int s;

        System.out.println("\t\t 1 - Modification Du Num");
        System.out.println("\t\t 2 - Modification De La Marque\n");
        do {
            s = scan.nextInt();
        } while (s < 1 && s > 2);


        switch (s) {
            case 1 -> {
                int num;
                System.out.print("Nouveau Numero de la navette : ");
                num = scan.nextInt();

                //& faire un set pour modifier l'ancien numero avec le nouveau
                Lignes.get(ar).get(Prog.iline).getNavette().get(Lignes.get(ar).get(Prog.iline).indxNav(nv)).setNumero(num);

            }
            case 2 -> {
                String marque;
                System.out.print("Nouvelle Marque de la navette : ");
                marque = scan.next();

                //& faire un set pour modifier l'ancien numero avec le nouveau
                Lignes.get(ar).get(Prog.iline).getNavette().get(Lignes.get(ar).get(Prog.iline).indxNav(nv)).setMarque(marque);
            }

        }

        System.out.println("\t\tNavettes Modifier ✔️");


    }


    //! ----------- Modifier Ligne---------------


    static void ModLigne(ArrayList<ArrayList<Ligne>> Lignes)
    {
        Scanner scan = new Scanner(System.in);
        Prog.idline = "";
        Prog.iline = 0;
        System.out.print("Veuillez Choisir une Ligne : ");

        int ar = Ligne.LignePosition(Lignes /*, i, id*/);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Lignes.get(ar).get(Prog.iline).affichelist();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int s;

        System.out.println("\t\t 1 - Modification De la station de depart");
        System.out.println("\t\t 2 - Modification De La station d'arrivee\n");
        System.out.println("\t\t 2 - Modification Des Navette\n");

        do {
            s = scan.nextInt();
        } while (s < 1 && s > 3);


        switch (s)
        {
            case 1 ->
            {

                int ch;
                //& Demander le type de modification

                System.out.println("\t\t 1 - Modification Du Nom De La Station");
                System.out.println("\t\t 2 - Modification Des Coordonee\n");
                do {
                    ch = scan.nextInt();
                } while (ch < 1 && ch > 2);


                scan.nextLine();

                switch (ch)
                {
                    case 1 ->
                    {
                        String nom;
                        System.out.print("Nouveau Nom de la Station : ");
                        nom = scan.nextLine();


                        //& traiter le cas station debut , car on cahnge l'attribut stat debut , le array , et le array des station
                        Lignes.get(ar).get(Prog.iline).getStation_inter().get(0).setNom(nom);
                        Lignes.get(ar).get(Prog.iline).getTroncon().get(0).getStation_debut().setNom(nom);
                        Lignes.get(ar).get(Prog.iline).setStationDepartNOM(nom);




                    }

                    case 2 ->
                    {
                        System.out.print("Nouvelle Coordonee de la Station : ");
                        Cord co = new Cord(scan.nextDouble(), scan.nextDouble());

                        //& traiter le cas station debut , car on cahnge l'attribut stat debut , le array , et le array des station

                        Lignes.get(ar).get(Prog.iline).getStation_inter().get(0).setCordonee(co);
                        Lignes.get(ar).get(Prog.iline).getTroncon().get(0).getStation_debut().setCordonee(co);
                        Lignes.get(ar).get(Prog.iline).getStation_depart().setCordonee(co);



                    }

                }

                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                Lignes.get(ar).get(Prog.iline).affichelist();
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


                System.out.println("\t\tStation depart Modifer ✔️");

            }



            case 2 ->
            {

                int ch;
                //& Demander le type de modification

                System.out.println("\t\t 1 - Modification Du Nom De La Station");
                System.out.println("\t\t 2 - Modification Des Coordonee\n");
                do
                {
                    ch=scan.nextInt();
                }while (ch<1 && ch>2);


                scan.nextLine();

                switch (ch)
                {
                    case 1 -> {
                        String nom;
                        System.out.print("Nouveau Nom de la Station : ");
                        nom = scan.nextLine();


                        //& traiter le cas station fin , car on cahnge l'attribut stat fin , le array , et le array des station

                        Lignes.get(ar).get(Prog.iline).getStation_inter().get(Lignes.get(ar).get(Prog.iline).getStation_inter().size()-1).setNom(nom);
                        Lignes.get(ar).get(Prog.iline).getTroncon().get(Lignes.get(ar).get(Prog.iline).getStation_inter().size()-2).getStation_fin().setNom(nom);
                        Lignes.get(ar).get(Prog.iline).setStationArriveNOM(nom);


                    }

                    case 2 -> {
                        System.out.print("Nouvelle Coordonee de la Station : ");
                        Cord co = new Cord(scan.nextDouble(),scan.nextDouble());


                        //& traiter le cas station fin , car on cahnge l'attribut stat fin , le array , et le array des station

                        Lignes.get(ar).get(Prog.iline).getStation_inter().get(Lignes.get(ar).get(Prog.iline).getStation_inter().size()).setCordonee(co);
                        Lignes.get(ar).get(Prog.iline).getTroncon().get(  Lignes.get(ar).get(Prog.iline).getStation_inter().size()-2  ).getStation_fin().setCordonee(co);
                        Lignes.get(ar).get(Prog.iline).getStation_arrive().setCordonee(co);


                    }

                }

                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    Lignes.get(ar).get(Prog.iline).affichelist();
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


                    System.out.println("\t\tStation Modifer ✔️");

            }

            case 3 ->
            {

                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Les Navette De Cette Ligne : " + Lignes.get(ar).get(Prog.iline).getNavette());
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


                int b;
                int nv;

                do {
                    System.out.print("veuillez choisir une navette : ");
                    nv = scan.nextInt();


                    //& chercher la navette a laide de la methode indxnav qui retourne l'indexe de la navette dans le array des navette dans al ligne
                    b = Lignes.get(ar).get(Prog.iline).indxNav(nv);


                } while (b == 99);

                int cs = 0;

                System.out.println("\t\t 1 - Modification Du Num");
                System.out.println("\t\t 2 - Modification De La Marque\n");
                do {
                    s = scan.nextInt();
                } while (cs < 1 && cs > 2);


                switch (cs) {
                    case 1 -> {
                        int num;
                        System.out.print("Nouveau Numero de la navette : ");
                        num = scan.nextInt();

                        //& faire un set pour modifier l'ancien numero avec le nouveau
                        Lignes.get(ar).get(Prog.iline).getNavette().get(Lignes.get(ar).get(Prog.iline).indxNav(nv)).setNumero(num);

                    }
                    case 2 -> {
                        String marque;
                        System.out.print("Nouvelle Marque de la navette : ");
                        marque = scan.next();

                        //& faire un set pour modifier l'ancien numero avec le nouveau
                        Lignes.get(ar).get(Prog.iline).getNavette().get(Lignes.get(ar).get(Prog.iline).indxNav(nv)).setMarque(marque);
                    }

                }

                System.out.println("\t\tNavettes Modifier ✔️");

            }

        }





    }



    //! Modifier Station
    static void ModifStat(ArrayList<ArrayList<Ligne>> Lignes)
    {
        Scanner scan = new Scanner(System.in);

//        int i=0;
//        String id ="";

        Prog.idline="";
        Prog.iline=0;
        //& Rechercher la ligne

        System.out.print("Veuillez Choisir une Ligne : ");
        int ar = Ligne.LignePosition ( Lignes /*, i, id*/);

//        Lignes.get(ar).get(Prog.iline).getStation_inter().size();

        System.out.print("Choisissez une station (par nom) : ");

        String s = scan.nextLine();
        int k;
        //& chercher la station dans le array des station de la ligne
        for ( k = 0; k <Lignes.get(ar).get(Prog.iline).getStation_inter().size();k++){
            if( Lignes.get(ar).get(Prog.iline).getStation_inter().get(k).getNom().equalsIgnoreCase(s)){
                System.out.println(k);
                break;
            }
        }
//        System.out.println("Station "+Lignes.get(ar).get(i).getStation_inter().get(k).getNom()+" Choisis . . .");

//        System.out.println(k);


        int ch;
        //& Demander le type de modification

        System.out.println("\t\t 1 - Modification Du Nom De La Station");
        System.out.println("\t\t 2 - Modification Des Coordonee\n");
        do
        {
            ch=scan.nextInt();
        }while (ch<1 && ch>2);


        scan.nextLine();

        switch (ch)
        {
            case 1 -> {
                String nom;
                System.out.print("Nouveau Nom de la Station : ");
                nom = scan.nextLine();

                if(k==0){
                    //& traiter le cas station debut , car on cahnge l'attribut stat debut , le array , et le array des station
                    Lignes.get(ar).get(Prog.iline).getStation_inter().get(k).setNom(nom);
                    Lignes.get(ar).get(Prog.iline).getTroncon().get(k).getStation_debut().setNom(nom);
                    Lignes.get(ar).get(Prog.iline).setStationDepartNOM(nom);

                }else{
                    if(k==Lignes.get(ar).get(Prog.iline).getStation_inter().size()-1){

                        //& traiter le cas station fin , car on cahnge l'attribut stat fin , le array , et le array des station

                        Lignes.get(ar).get(Prog.iline).getStation_inter().get(k).setNom(nom);
                        Lignes.get(ar).get(Prog.iline).getTroncon().get(k-1).getStation_fin().setNom(nom);
                        Lignes.get(ar).get(Prog.iline).setStationArriveNOM(nom);


                    }
                    else{
                        //& traiter le cas station inter , c , le array , et le array des station

                        Lignes.get(ar).get(Prog.iline).getStation_inter().get(k).setNom(nom);
                        Lignes.get(ar).get(Prog.iline).getTroncon().get(k).getStation_debut().setNom(nom);
                        System.out.println("middle");
                        System.out.println(Lignes.get(ar).get(Prog.iline).getTroncon().get(k).getStation_debut().getNom());
                    }
                }


                }
            case 2 -> {
                System.out.print("Nouvelle Coordonee de la Station : ");
                Cord co = new Cord(scan.nextDouble(),scan.nextDouble());
                if(k==0){
                    //& traiter le cas station debut , car on cahnge l'attribut stat debut , le array , et le array des station

                    Lignes.get(ar).get(Prog.iline).getStation_inter().get(k).setCordonee(co);
                    Lignes.get(ar).get(Prog.iline).getTroncon().get(k).getStation_debut().setCordonee(co);
                    Lignes.get(ar).get(Prog.iline).getStation_depart().setCordonee(co);



                }else{
                    if(k==Lignes.get(ar).get(Prog.iline).getStation_inter().size()-1){
                        //& traiter le cas station fin , car on cahnge l'attribut stat fin , le array , et le array des station

                        Lignes.get(ar).get(Prog.iline).getStation_inter().get(k).setCordonee(co);
                        Lignes.get(ar).get(Prog.iline).getTroncon().get(k-1).getStation_fin().setCordonee(co);
                        Lignes.get(ar).get(Prog.iline).getStation_arrive().setCordonee(co);


                    }
                    else{
                        //& traiter le cas station debut , car on cahnge l'attribut stat debut , le array , et le array des station

                        Lignes.get(ar).get(Prog.iline).getStation_inter().get(k).setCordonee(co);
                        Lignes.get(ar).get(Prog.iline).getTroncon().get(k).getStation_debut().setCordonee(co);

//                        System.out.println(Lignes.get(ar).get(Prog.iline).getTroncon().get(k).getStation_debut().getNom());
                    }
            }

                    }

        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Lignes.get(ar).get(Prog.iline).affichelist();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


        System.out.println("\t\tStation Modifer ✔️");

    }


    //! Station princ

    static void PRINC(ArrayList<ArrayList<Ligne>> Lignes){

        //& faire un parcour de chaque station , et tester si elle est principale ou non (2 station QUI ONT DIFFERNT MOY TRANS ET MEME COORDONNE SONT PRINSUPALE)
        for (ArrayList<Ligne> TL : Lignes)
        {
            for (Ligne  L : TL)
            {
                for(Station st : L.getStation_inter() )
                {
                    statPrinc(Lignes , st );

                }
            }
        }
    }
}
