import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Station {
    private int numero;
    private int code;
    private String nom;
    private Cord cordonee;
    private String Nline;
    private Ligne line;


    private static ArrayList<Station> ArrayStatPrinc = new ArrayList<Station>();        //& array static de toute les station principal du reseau

    //private static HashSet<Station> ArrayStatPrinc = new HashSet<Station>();



    // implementer la classe ligne

    public enum type{principale, secondaire};

    private type typestat;

    //+ Constructor

    public Station(int numero, String nom, Cord cordonee, type typestat,String s) {
        this.numero = numero;
        this.nom = nom;
        this.cordonee = cordonee;
        this.typestat = typestat;
        this.Nline=s;
    }

    public Station (){};

    //+ Num Getter & setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //+ nom Getter & setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //+ code unique

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    //+ cord Getter & setters

    public Cord getCordonee() {
        return cordonee;
    }

    public void setCordonee(Cord cordonee) {
        this.cordonee = cordonee;
    }

    //+ station Getter & setters

    public type getStation() {
        return typestat;
    }

    public void setStation(type typestat) {
        this.typestat = typestat;
    }

    //+ Type Getter & setters

    public type getTypestat() {
        return typestat;
    }

    public void setTypestat(type typestat) {
        this.typestat = typestat;
    }

    //+ array station princ

    static ArrayList<Station> getArrayStatPrinc() {
        return ArrayStatPrinc;
    }

    static void setArrayStatPrinc(Station s) {
        ArrayStatPrinc.add(s);
    }

//    public static HashSet<Station> getArrayStatPrinc() {
//        return ArrayStatPrinc;
//    }
//
//    public static void setArrayStatPrinc(Station s) {
//        ArrayStatPrinc.add(s);
//    }



    //+ array lignes de la sattion

//    public ArrayList<Ligne> getArrayListligne() {
//        return ArrayListligne;
//    }
//
//    public void setArrayListligne(Ligne l) {
//        ArrayListligne.add(l);
//    }



    //+ Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;
        Station station = (Station) o;
        return Objects.equals(cordonee, station.cordonee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cordonee);
    }


    //+ To string

    @Override
    public String toString() {
        return " "+nom+" "/*"->"+this.code+" | "*/;
    }

    public String getNline() {
        return Nline;
    }

    public void setNline(String nline) {
        Nline = nline;
    }

    public Ligne getLine() {
        return line;
    }

    public void setLine(Ligne line) {
        this.line = line;
    }


    //+ affiche

    public void affiche(){
        System.out.println(this.toString());
    }




    //+ method qui test si 2 station on les meme coordonner(egale)

    public boolean equals(Station S2) {
        if (this.cordonee.getLatitude()== S2.cordonee.getLatitude() && this.cordonee.getLongitude()== S2.cordonee.getLongitude())
        {
            return true;

        } else

            return false;
    }

    //+ Methode qui test si une station est dupliquer pandant la creation de ligne

    public boolean DupSt(ArrayList<Station> Ars)
    {
        for(int i = 0; i <Ars.size();i++)
        {
            if(this.equals(Ars.get(i)))
            {
                return true;
            }
        }
        return false;
    }


    //+ Methode Creation D'une Station

    static Station CreatStat(int num,String id){

        Scanner scan = new Scanner(System.in);

        //& recuperer les coordonnee

        System.out.print("Saisisez ses Coordonee GPS : ");
        Cord cord = new Cord(scan.nextDouble(),scan.nextDouble());

        //& appele a la methode qui verifie si , les coordonne sont deja introduit , si oui le nom va etre afecter automatiquement (2 station meme coord == meme nom)

        String nom = Prog.StatEQcord(Menu.Lignes,cord);
        System.out.println(nom);

        if(nom==null){
            scan.nextLine();
            System.out.print("Saisisez le nom de la station : ");
            nom = scan.nextLine();
        }else{
            System.out.println("Station existe deja dans une autre Ligne , son Nom va etre affecter automatiquement ✔️");
        }

        //& creation de la station

        Station s = new Station(num , nom , cord , Station.type.secondaire,id);

        //& rajouter son code dans un array list Static afin d'eviter Les les redondance

        s.setCode(Prog.idStation+1);
        Prog.idStation++;

        //& methode statPrinc qui verifi si cette station existe deja , si oui elle lui affecter coorespandance ou principal

        Prog.statPrinc(Menu.Lignes,s);

        //& rajouter la station au Array list general de toute les station de notre reseau

        Prog.ToutStat.add(s);

        return s;
    }


    //! Afficher toute les station

    static void afficheTouteStation(ArrayList<ArrayList<Ligne>> Lignes){
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
                    if(L == null )
                    {
                        System.out.println("Ligne inexistente !!");
                    }else
                    {

                        System.out.print("LIGNE '"+L.getNumligne()+"' :");
                        for(Station s : L.getStation_inter())
                        {
                            System.out.print(s+"("+s.getCode()+") - ");
                        }
                        System.out.print("\n");

                    }
                }
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


    }

    static void afficheTouteStation2(ArrayList<ArrayList<Ligne>> Lignes){
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
                    if(L == null )
                    {
                        System.out.println("Ligne inexistente !!");
                    }else
                    {

                        System.out.print("LIGNE '"+L.getNumligne()+"' :");
                        for(Station s : L.getStation_inter())
                        {
                            System.out.print(s+"("+(float)s.getCordonee().getLatitude()+"-"+(float)s.getCordonee().getLatitude()+") - ");
                        }
                        System.out.print("\n");

                    }
                }
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


    }

}
