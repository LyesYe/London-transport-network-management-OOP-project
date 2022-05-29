import java.util.*;

public class Ligne {
    private String numligne;

    private final MoyTransport.MoyType TRANS ;

    private Station station_depart, station_arrive;

    private ArrayList<Station> station_inter;  //& collection des station intermedaire
    private ArrayList<Troncon> troncon;         //& collection des tronçon d'une ligne

    private ArrayList<Navette> navette = new ArrayList<>();     //& collction des navette d'une Ligne

    private static ArrayList<Station> Coorespandance = new ArrayList<Station>();        //& un array static pour sauvgarder tout les station de coorespandance

    //private static HashSet<String> Coorespandance = new HashSet<>();




    // liens moyens de transport

    //+ Constructor

    public Ligne(String numligne, MoyTransport.MoyType TRANS, Station station_depart, Station station_arrive, ArrayList<Station> station_inter, ArrayList<Troncon> troncon) {
        this.numligne = numligne;
        this.TRANS = TRANS;
        this.station_depart = station_depart;
        this.station_arrive = station_arrive;
        this.station_inter = station_inter;
        this.troncon = troncon;
    }


    //& Num

    public String getNumligne() {
        return numligne;

    }

    public void setNumligne(String numligne) {
        this.numligne = numligne;
    }

    //& stat-dep

    public Station getStation_depart() {
        return station_depart;
    }

    public void setStation_depart(Station station_depart) {
        this.station_depart = station_depart;

    }

    public void setStationDepartNOM(String nom){this.station_depart.setNom(nom);}

    public void setStation_departttt(Station station_depart) {
        this.station_depart = station_depart;
        this.station_inter.add(0,station_depart);


    }

    //& stat-arrive

    public Station getStation_arrive() {
        return station_arrive;
    }

    public void setStation_arrive(Station station_arrive) {
        this.station_arrive = station_arrive;
    }

    public void setStationArriveNOM(String nom){this.station_arrive.setNom(nom);}


    public void setStation_arrivettt(Station station_arrive) {
        this.station_arrive = station_depart;
        this.station_inter.add(station_inter.size(),station_arrive);

    }

    //& stationInter array

    public ArrayList<Station> getStation_inter() {
        return station_inter;
    }

    public void setStation_inter(ArrayList station_inter) {
        this.station_inter = station_inter;
    }


    public void setStation_interttt(Station s,int p) {
        this.station_inter.add(p,s);
    }

    //& tronçon array

    public ArrayList<Troncon> getTroncon() {
        return troncon;
    }

    public void setTroncon(ArrayList troncon) {
        this.troncon = troncon;
    }

    //& trans

    public MoyTransport.MoyType getTRANS() {
        return TRANS;
    }

    public ArrayList<Navette> getNavette() {
        return navette;
    }


    //& Navette

    public void setNavette(ArrayList<Navette> navette) {
        this.navette = navette;
    }

    public void setNavette(Navette navette) {
        this.navette.add(navette) ;
        Navette.setNavNumARRAY(navette.getNumero());
    }

    public void DelNavette(Navette navette){ this.getNavette().remove(navette);}


    //& Array station Coorespandance

    static ArrayList<Station> getCoorespandance() {
        return Coorespandance;
    }

    static void setCoorespandance(Station s) {
            Coorespandance.add(s);
    }
//
//    public static HashSet<String> getCoorespandance() {
//        return Coorespandance;
//    }
//
//    public static void setCoorespandance(String s ) {
//        Coorespandance.add(s);
//    }


    //& Tostring

    @Override
    public String toString() {
        return "Ligne{" +
                "numligne='" + numligne + '\'' +
                ", station_depart=" + station_depart +
                ", station_arrive=" + station_arrive +
                ", station_inter=" + station_inter +
                ", troncon=" + troncon +
                //", nbrstatinter=" + nbrstatinter +
                '}';
    }

    //& methode qui affiche la list des station/Tronçon en forme A--B--C

    public void affichelist() {

        if(this == null ){
            System.out.println("Ligne inexistente !!");
        }else{
            int s = getTroncon().size();

            System.out.print("LIGNE '"+getNumligne()+"' : \n"/* -> From ["+this.TRANS.getHeureDebut()+" h] To ["+this.TRANS.getHeureFin()+" h]\t"*/);

            int r=0;

            for (int i = 0; i < s; i++) {

//                System.out.printf("\t%-22s\t", s.getNom());
                System.out.printf( "\t%-22s(%s)->",getTroncon().get(i).getStation_debut() ,getTroncon().get(i).getStation_debut().getCode()/*+getTroncon().get(i).getStation_debut().getTypestat()+ " - "*/);

                r++;
                if(r == 4){ System.out.print("\n"); r=0;}
            }
            System.out.println(getTroncon().get(s - 1).getStation_fin()+" ("+getTroncon().get(s-1).getStation_debut().getCode()+") " );
        }


    }

    //& affich liste 2

    public void affichelist2(){
        if(this == null ){
            System.out.println("Ligne inexistente !!");
        }else{

            System.out.println("LIGNE '"+getNumligne()+"' : "+getTRANS().name()+" | Station Depart -> "+getStation_depart()+" | Station Arrivee -> "+getStation_arrive());

        }

    }



    //& tostring

    public void affiche() {
        System.out.println(this.toString());
    }

    //& ajout station au array

    public void ajoutS(Station S1) {
        this.getStation_inter().add(S1);


    }


    //+ ajout Navette

    public void CreatNav()
    {
        System.out.println("Les Navette Deja Introduite : "+Navette.getNavNumARRAY());

        Scanner scan = new Scanner(System.in);
        boolean b;
        int num;
        //& introduction des information de l anvette
        do
        {
            System.out.print("intrduire le Numero de la navette : ");

            num = scan.nextInt();
//            System.out.println(Navette.getNavNumARRAY().contains(num));
            b= Navette.getNavNumARRAY().isEmpty() || !Navette.getNavNumARRAY().contains(num);
        }while(!b);

        System.out.print("la marque : ");
        String brand = scan.next();

        System.out.print("introduire  année de mise en circulation : ");

        int annee = scan.nextInt();

        //& cree la navette
        Navette nav =new Navette(Prog.MOYt(Prog.getTypeFromID(this.numligne)), num,  brand, annee,this);
        //& la rajouter au array list des navette de la ligne + le array global des navette
        this.setNavette(nav);
    }


    //+ methode qui retourne la position d ela ligne donner

    static int LignePosition (ArrayList<ArrayList<Ligne>> Lignes /*,Integer i , String id*/)
    {

        Scanner scan = new Scanner(System.in);

        int ar=5;
        boolean verif=false;

        do
        {
            do {
                //Prog.affichLignes(Lignes);


                //& determiner la ligne + le type du moy de trans
                        Prog.idline = scan.next().toUpperCase();


                switch (Prog.getTypeFromID(Prog.idline)) {
                    case "B" -> ar = 0;

                    case "T" -> ar = 1;

                    case "TR" -> ar = 2;

                    case "M" -> ar = 3;

                    default -> {
                        System.out.println("\t⚠️ !_! Ligne choisis inexistente !_! ⚠️");
                        ar = 5;
                    }

                }

            } while (ar == 5);


            //& retourner la ligne choisis


            do{

                if (Lignes.get(ar).get(Prog.iline).getNumligne().equalsIgnoreCase(Prog.idline)) {
                    verif = true;
                    //System.out.println(Prog.iline);

                    return ar;

                }
                Prog.iline ++;
            }while(Prog.iline < Lignes.get(ar).size());



        }while(!verif);

        return -1;

    }


    //+ Methode VerifID D'une line si il existe

    static Boolean VerifID(String id ,ArrayList<ArrayList<Ligne>> Lignes,int ar){
        for(int i = 0; i <Lignes.get(ar).size();i++){
            if(id.equals(Lignes.get(ar).get(i).getNumligne()))
            {
                System.out.println("Ligne Deja Introduite");
                return true;
            }
        }

        return false;
    }


    //+METHODE RETOURNE INDXE DE NAVETTE

    public int indxNav(int num){
        for (Navette n:this.navette){
            if (n.getNumero() == num) return navette.indexOf(n);

        }
        return 99;
    }

    //+ Re enumerer le numero de chaque statiion

    public void ReenumStat ()
    {
        //& re parcourir les station d'ue ligne afin de les recode par ordre
        int o =1;
        for (Station c : this.getStation_inter()) {
            c.setNumero(o);
            o++;
        }
    }



}
