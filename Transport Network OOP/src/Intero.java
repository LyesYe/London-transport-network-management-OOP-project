import java.util.*;

public class Intero<A, B> {

    static ArrayList<Integer> codStat = new ArrayList<>() ;

    //! requette Affichage des ligne
    static void qst1(ArrayList<ArrayList<Ligne>> Lignes)
    {
        System.out.println("\t\t - Affichage de toutes les lignes de transport -");

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (ArrayList<Ligne> TL : Lignes)
        {
            for (Ligne  L : TL)
            {
                if(L.getTroncon().isEmpty())
                {
                    System.out.println("Acune Ligne");
                }else
                {
                    L.affichelist2();
                }
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    //! Reauette affichage Du chemain d'ue ligne donnee
    static void qst2(ArrayList<ArrayList<Ligne>> Lignes){
        qst1(Lignes);
        System.out.println("\t\t - Affichage du chemin sur une ligne donnée -");
        System.out.println("Veillez Introduire Une Ligne");
        Scanner scan = new Scanner(System.in);

        int i=0;

        Prog.idline="";
        Prog.iline=0;
        //& Lire et trouver la ligne
        int ar = Ligne.LignePosition(Lignes/*,i,id*/);
        //& afficher la ligne et ses stations
        Lignes.get(ar).get(Prog.iline).affichelist();

        //& fair un parcour dans le array des station Principale et afficher que les station aui appartienne a notre ligne
        System.out.print("\nLes Station Principale : ");
        for(Station s : Station.getArrayStatPrinc()){
            if (s.getNline().equalsIgnoreCase(Lignes.get(ar).get(Prog.iline).getNumligne()))
            {
                System.out.print(" - "+s.getNom());
            }

        }

    }

    //! CHercher toute les ligne qui passe par une station

    static void qst3(ArrayList<ArrayList<Ligne>> Lignes){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\t\t - Rechercher toutes les lignes qui passent par une station donnée -");

        Station.afficheTouteStation(Lignes);

        System.out.print("Veuiller Choisir Une Station (par numero) : ");

        int num = scan.nextInt();

        System.out.print("Les Lignes Qui Passe Par La Station "+num+" sont : ");

        //& Trouver les station qui ont le meme code (car meme code implique meme station)
        for(ArrayList<Ligne> A : Lignes)
        {
            for(Ligne L : A)
            {
                for (Station S : L.getStation_inter())
                {
                    if(S.getCode()==num)
                    {
                        System.out.print(S.getNline()+" - ");
                    }
                }
            }
        }


    }


    //! Coorespandance station

    static void qst4(ArrayList<ArrayList<Ligne>> Lignes){
        System.out.println("\n\t\t - Affichage Des Station De Correspondance - \n");

        //& affichage des Coorespandance deja introduit dans le array des correspandance par la methode StatPrinc


        int i = 0;
        for (Station s : Ligne.getCoorespandance() )
        {
            if(!codStat.contains(s.getCode()))
            {
                //& un string format pour un affichage plus claire

                System.out.printf("\t%-22s\t", s.getNom());

                //& evite rles repitition

                codStat.add(s.getCode());
            }
            i++;
            if(i % 5 == 0) System.out.print("\n");
        }
        System.out.println("\n");


    }



    //! Ligne empruntée par le plus grand nombre de voyageurs

    static void qst5(ArrayList<ArrayList<Ligne>> Lignes){

        Scanner scanner = new Scanner(System.in);

        System.out.println("\t\t - La Ligne empruntée par le plus grand ou minimum nombre de voyageurs - ");
        int ch = 0;
        do {
            System.out.println("\t1 - Maximum ");
            System.out.println("\t2 - Minimum ");
            ch = scanner.nextInt();

        }while(ch!=1 && ch!=2);

        int max =0 ;
        Ligne maxL = null;
        Ligne minL = null;
        int min =0 ;

        //& nbr de voyageur moyen du moy trans * le nbr des navette pour chaque ligne , et retourner le max et min ligne

        for (ArrayList<Ligne> TL : Lignes)
        {
            for (Ligne  L : TL)
            {
                if(max<L.getTRANS().getNbrVoy()*L.getNavette().size()){
                        max=L.getTRANS().getNbrVoy()*L.getNavette().size();
                        maxL=L;
                }

                if(min<L.getTRANS().getNbrVoy()*L.getNavette().size()){
                    min=L.getTRANS().getNbrVoy()*L.getNavette().size();
                    minL=L;
                }
            }
        }
        if (ch==1){
            System.out.println("La ligne "+maxL.getNumligne()+" : "+max+" voyageurs | Les navette dans cette ligne -> "+maxL.getNavette()+"\n");

        }else{
            System.out.println("La ligne "+minL.getNumligne()+" : "+min+" voyageurs | Les navette dans cette ligne -> "+minL.getNavette()+"\n");
        }

    }


    //! La durée estimée pour aller d’un point A à un point B

    static void qst6(ArrayList<ArrayList<Ligne>> Lignes){

        Scanner scan = new Scanner(System.in);

        System.out.println("\t\t - La durée estimée pour aller d’un point A à un point B -");
        Prog.idline="";
        Prog.iline=0;

        double DureeAB=0;

        int A;
        int B;

        Station.afficheTouteStation(Lignes);

        //& lire le code des deux station

        do{
            System.out.print("Veuiller Choisir La Station A Station (par numero) : ");

            A = scan.nextInt();

            System.out.print("Veuiller Choisir La Station B Station (par numero) : ");

            B = scan.nextInt();

        }while(A>Prog.idStation || B>Prog.idStation);

        //& apperler la methode qui calule durre entre deux code de station

        DureeAB=AdureB(Lignes,A,B);


    }

    //! Chemin de A a B

    static void qst7(ArrayList<ArrayList<Ligne>> Lignes){


        ArrayList<Station> cheminA = new ArrayList<Station>();  //& array pour construire  notre chemin
        ArrayList<Station> cor = new ArrayList<Station>();      //& Array pour les station correspandance de notre chemin

        Scanner scan = new Scanner(System.in);

        System.out.println("\t\t - Construction de chemin pour aller d’un point A à un point B -");

        Cord A;
        Cord B;

        Station.afficheTouteStation2(Lignes);

        //& recuerer les coordonee de depart et arriver

        System.out.print("\nVeuiller introduire les cordonnee GPS de la personne : ");

        A = new Cord(scan.nextDouble(),scan.nextDouble());



        System.out.print("Veuiller introduire les cordonnee GPS de ou la personne veut y'aller: ");

        B = new Cord(scan.nextDouble(),scan.nextDouble());

        System.out.println("\n \t\t- Le Chemin : -\n");


        Station SA = null;    MoyTransport.MoyType TA = null;
        Station SB = null;    MoyTransport.MoyType TB = null;
        double min = 9999;
        double min2 = 9999;


        //& parcourir toute les station afin de trouver les 2 station les plus proche au point GPS du debut et de fin

        //& pour faire ça , on trouve la minimum distance entre le point gps et une toute les station

        for(ArrayList<Ligne> ar : Lignes)
        {
            for(Ligne L : ar)
            {
                for (Station S : L.getStation_inter())
                {
                    if(Cord.dist(S.getCordonee(),A)<min)
                    {
                        SA=S;   min= Cord.dist(S.getCordonee(),A);

                    }
                    if(Cord.dist(S.getCordonee(),B)<min2)
                    {
                        SB=S;   min2= Cord.dist(S.getCordonee(),B);

                    }
                }
            }
        }

        //& Construire le chemin a apartire du array list ToutStat qui contion Toute les station de notre reseau

        int i=0;
        boolean test =false;
       do
        {

            //& trouver la station A

            if(Prog.ToutStat.get(i).equals(SA))
            {

                cheminA.add(Prog.ToutStat.get(i));
                test=true;
            }

            // & si on trouve A , on commence a rajouter les station a notre chemin

            if(test){
                cheminA.add(Prog.ToutStat.get(i));
            }

            //& on arrete la boucle qu'on on trouve B

            if(Prog.ToutStat.get(i).equals(SB)){
                cheminA.add(Prog.ToutStat.get(i));
                break;
            }

            //& reinstialiser le i pour faire un deuxieme tour (dans le cas ou A et Apres B)
            i++;
            if(i == Prog.ToutStat.size() - 1){
                i=0;
            }
        }while(i<Prog.ToutStat.size());

        codStat.clear();

       int r= 0;

       //& affichage du chemin

        for (Station s : cheminA )
        {
            if(!codStat.contains(s.getCode())) {
                if (Ligne.getCoorespandance().contains(s)) {
                    cor.add(s);
                }
                //& un string format pour un affichage plus claire

                System.out.printf("\t%-22s-->", s.getNom());

                //& evite rles repitition

                codStat.add(s.getCode());
            }
            r++;
            if(r == 5){ System.out.print("\n"); r=0;}
        }
        System.out.println("\n");

        //& affichage des station de coorespandance

        System.out.println("Station De Correspandance : "+cor);

        //& Calcule et affichage de la durree du chemin

        double DureeAB=AdureB(Lignes,SA.getCode(),SB.getCode());


    }



    //+ Duree A b

    static double AdureB(ArrayList<ArrayList<Ligne>> Lignes , int A , int B){

        double DureeAB =0;
        Station SA = null;    MoyTransport.MoyType TA = null;
        Station SB = null;    MoyTransport.MoyType TB = null;


        //& parcourir toute les station a fin de trouver la station A et B et son type de transport

        for(ArrayList<Ligne> ar : Lignes)
        {
            for(Ligne L : ar)
            {
                for (Station S : L.getStation_inter())
                {
                    if(S.getCode()==A)
                    {
                        SA=S;       TA=L.getTRANS();
                    }
                    if(S.getCode()==B)
                    {
                        SB=S;       TB=L.getTRANS();
                    }
                }
            }
        }

        //& Recuperer La ligne d'appartenenace de A , et commence a utiliser les tronçon pour calcule la durre

        //& Durree A--B == la somme des durre de chaque tronçon entre A et B

        if(SA.getNline().equalsIgnoreCase(SB.getNline())){
            for(ArrayList<Ligne> ar : Lignes)
            {
                for(Ligne L : ar)
                {
                    if(L.getNumligne().equalsIgnoreCase(SA.getNline()))
                    {
                        for (int i = Math.min(SA.getNumero(),SB.getNumero())-1 ; i<Math.max(SA.getNumero(),SB.getNumero())-1;i++)
                        {
                            DureeAB =+ L.getTroncon().get(i).dureeTronc(L.getTRANS());
                        }
                    }

                }
            }
            System.out.println("\nLa durre de la station "+SA+" a la station "+SB+" en utilisant un "+TA.name()+" est : "+ (int)DureeAB +" Minutes \n");
        }

        //& test si A et B different Ligne , faire la generation de durree par GPS localisation

        if(DureeAB==0){
            System.out.println("\n⚠ Station pas dans la meme ligne , La durree va etre genere par distance GPS ⚠\n");
            DureeAB= (Cord.dist(SA.getCordonee(),SB.getCordonee()) / (TA.getV()))*60;

            System.out.println("La durre de la station "+SA+" a la station "+SB+" en utilisant un "+TA.name()+" / "+TB.name()+" est : "+ (int)DureeAB +" Minutes\n");
        }

        return DureeAB;
    }

}
