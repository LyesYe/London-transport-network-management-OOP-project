import java.util.ArrayList;
import java.util.Random;

public class Troncon {

    private int numero;
    private Station station_debut, station_fin;
    private double kilometrage;
    public enum etat {Bon, moyen, degrade};
    private etat state;

    //+ Constructor

//    public Troncon(int numero, Station station_debut, Station station_fin, double kilometrage) {
//        this.numero = numero;
//        this.station_debut = station_debut;
//        this.station_fin = station_fin;
//        this.kilometrage = kilometrage;
//    }

    public Troncon(int numero, Station station_debut, Station station_fin, double kilometrage, etat state) {
        this.numero = numero;
        this.station_debut = station_debut;
        this.station_fin = station_fin;
        this.kilometrage = kilometrage;
        this.state = state;
    }


    //+ Num Getter & setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //+ stationDebut Getter & setters



    public Station getStation_debut() {
        return station_debut;
    }


    public void setStation_debut(Station station_debut) {
        this.station_debut = station_debut;
    }

    //+ stationFin Getter & setters


    public Station getStation_fin() {
        return station_fin;
    }

    public void setStation_fin(Station station_fin) {
        this.station_fin = station_fin;
    }

    //+ kilometrage Getter & setters


    public double getLongueur() {
        return kilometrage;
    }

    public void setLongueur(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    //+ Tostring

    @Override
    public String toString() {
        return "tronc{" +
                "numero=" + numero +
                ", station_debut=" + station_debut +
                ", station_fin=" + station_fin +
                ", kilometrage=" + kilometrage +
                '}';
    }

    //+affiche

    public void affiche(){
        System.out.println(this.toString());
    }

    //+methode qui fait la fusion de deux tronçon , en retournent un nuveau tronçn contenant statdebut de tronçon 1
    //+ et stat fin du 2eme tronçon

    public Troncon fusion(Troncon troncon2){
        Troncon troncon0 = null;

        troncon0.setNumero(this.getNumero()+troncon2.getNumero());
        troncon0.setStation_debut(this.getStation_debut());
        troncon0.setStation_fin(troncon2.getStation_fin());
        troncon0.setLongueur(Cord.dist(this.getStation_debut().getCordonee(),troncon2.getStation_fin().getCordonee()));

        return troncon0;
    }

    //+  methode qui genere aleatoirement un etat du tronçon

    static Troncon.etat etatRand ()
    {
        Random rand = new Random();
        int n = rand.nextInt(2);

        switch(n) {
            case 0 -> { return Troncon.etat.Bon; }

            case 1 -> { return Troncon.etat.moyen; }

            case 2 -> { return Troncon.etat.degrade;}

        }
        return null;
    }

    public etat getState() {
        return state;
    }

    public void setState(etat state) {
        this.state = state;
    }

    //+   methode qui transform array of station into array of troncon


    static void StatToTronc(ArrayList<Station> ARstat, ArrayList<Troncon> ARtronc){
        for(int i = 0;i<ARstat.size()-1;i++){
            ARtronc.add(new Troncon(i+1 ,ARstat.get(i),ARstat.get(i+1),Cord.dist(ARstat.get(i).getCordonee(),ARstat.get(i+1).getCordonee()), Troncon.etatRand() ));
        }
    }


    //+ Duree dans un tronçon

    public double dureeTronc (MoyTransport.MoyType M){

        double duree=0 ;

        //& durre = la distance / la vitesse , et la vitesse et final pour chaque moyen de transport , mais on fait rentrer
        //& en compte l'etat du tronçon qui reduit la vitesse

        switch(this.getState()) {
            case Bon -> { duree = this.kilometrage/ M.getV() ;}

            case moyen -> {duree = this.kilometrage/ ((M.getV()*50)/100) ;}

            case degrade -> { duree = this.kilometrage/ ((M.getV()*20)/100);}

        }


        return duree*60;
    }
}
