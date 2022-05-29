import java.time.*;

public class MoyTransport {

    //& declaration d'un type enum afin de representer les different moyen de transport

    public enum MoyType{BUS(LocalTime.of(6,0),LocalTime.of(20,30),60 ,"\uD83D\uDE8C",30) ,
                        METRO(LocalTime.of(5,0),LocalTime.of(23, 0),200,"Ⓜ️",50) ,
                        TRAMWAY(LocalTime.of(5,30),LocalTime.of(22, 0),150,"\uD83D\uDE8A",15) ,
                        TRAIN(LocalTime.of(6,0),LocalTime.of(21,0),300,"\uD83D\uDE82",90) ;

        private final LocalTime heureDebut ;
        private final LocalTime heureFin;
        private final int nbrVoy;
        private final String emoji;
        private final int v;

        //& constructeur

        MoyType(LocalTime heureDebut, LocalTime heureFin, int nbrVoy, String emoji, int v) {
            this.heureDebut = heureDebut;
            this.heureFin = heureFin;
            this.nbrVoy = nbrVoy;
            this.emoji= emoji;
            this.v = v;
        }

        public int getNbrVoy() { return nbrVoy; }

        public LocalTime getHeureDebut() {
            return heureDebut;
        }

        public LocalTime getHeureFin() {
            return heureFin;
        }

        public String getEmoji() {
            return emoji;
        }

        public int getV() {
            return v;
        }

        @Override
        public String toString() {
            return "MoyType{" +
                    "heureDebut=" + heureDebut +
                    ", heureFin=" + heureFin +
                    ", nbrVoy=" + nbrVoy +
                    '}';
        }

    }

    private MoyType type;




    public MoyType getType() {
        return type;
    }
    public void setType(MoyType type) {
        this.type = type;
    }


    public MoyTransport(MoyType type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "MoyTransport{" +
                "type=" + type +
                '}';
    }

    public void affiche(){
        System.out.println(toString());
    }
}
