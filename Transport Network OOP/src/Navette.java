import java.util.ArrayList;
import java.util.Scanner;

public class Navette extends MoyTransport {

    private int numero;
    private String Marque;
    private int Annee;
    private Ligne ligne;

    private static ArrayList<Integer> NavNumARRAY = new ArrayList<Integer>();       //& array globale des numero de navette pour eviter les redondance


    public Navette(MoyType type, int numero, String marque, int annee, Ligne ligne)
    {
        super(type);
        this.numero = numero;
        Marque = marque;
        Annee = annee;
        this.ligne = ligne;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public int getAnnee() {
        return Annee;
    }

    public void setAnnee(int annee) {
        Annee = annee;
    }

    public Ligne getLigne() {
        return ligne;
    }

    public void setLigne(Ligne ligne) {
        this.ligne = ligne;
    }


    public static ArrayList<Integer> getNavNumARRAY() {
        return NavNumARRAY;
    }

    public static void setNavNumARRAY(Integer n ) {
        NavNumARRAY.add(n);
    }



    @Override
    public String toString() {
        return  numero+"" ;
//                ", Marque='" + Marque + '\'' +
//                ", Annee=" + Annee +
//                ", ligne=" + ligne.getNumligne() +

    }


    //! methode ui affiche les navette

    static void affichenav(ArrayList<ArrayList<Ligne>> Lignes){
        System.out.println("\n Affichage De Toutes Les Navette \n");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i <4;i++)
        {
            if(!Lignes.get(i).isEmpty())
            {
                System.out.println("\n═▇▇▇┣ Les Navette Du Type ' "+Prog.MOYt(Prog.getTypeFromID(Lignes.get(i).get(0).getNumligne())).name()+" ' : \n");
            }

            for (int j = 0; j <Lignes.get(i).size();j++)
            {
                System.out.print(" || Ligne "+Lignes.get(i).get(j).getNumligne()+" -> ");
                if(Lignes.get(i).get(j).getNavette().isEmpty())
                {
                    System.out.print("[ Acune navette ]");
                }else
                {
                    System.out.print(Lignes.get(i).get(j).getNavette());
                }
            }
            System.out.print("\n");
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }



}
