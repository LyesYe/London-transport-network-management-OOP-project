
public class Cord {
    private double longitude, latitude;

    //+Constructeur

    public Cord(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude= latitude;
    }

    //+ Getters

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    //+ Setters

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    //+ ToString

    @Override
    public String toString() {
        return "coo_spat{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    //+ Affiche

    public void affiche(){
        System.out.println(this.toString());
    }


    //+ Methode qui transforme du degree au radian

    static double deg2rad(double deg) {
          return (deg * Math.PI / 180.0);
    }


    //+methode qui calcule a distance entre 2 point GPS

    static double dist(Cord S1,Cord S2){

    //& calcule du kilometrage

    final int r = 6371; //& earth radius

    //& utilisation de  Haversine formula
    double diffLongitude = S2.longitude - S1.longitude;
    double diffLatitude = S2.latitude - S1.latitude;
    double x = Math.sqrt( Math.sin( deg2rad( diffLatitude / 2 ) )  * Math.sin( deg2rad( diffLatitude / 2 ) )
            + Math.cos( deg2rad( S2.latitude ) ) * Math.cos( deg2rad( S1.latitude ) )
            * Math.sin( deg2rad( diffLongitude / 2 ) ) * Math.sin( deg2rad( diffLongitude / 2 ) ) );

    double distance = 2 * r * Math.asin(x);

    return distance;
    }

}
