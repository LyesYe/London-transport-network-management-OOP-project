import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        //& Array[0]=bus    Array[1]=train    Array[2]=tramway     Array[3]=metro

        for (int i = 0; i <4;i++)
        {
            Menu.Lignes.add(new ArrayList<>());
        }

        Remplissage.Lines(Menu.Lignes);

        Prog.PRINC(Menu.Lignes);


        Menu.affiche();
    }
}
