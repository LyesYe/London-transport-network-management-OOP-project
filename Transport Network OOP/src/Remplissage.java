
import java.util.ArrayList;


public class Remplissage {




    public static void Lines(ArrayList<ArrayList<Ligne>> Lignes) {

     System.out.println("\n\t\t\t\t\t\tRemplissage Auto ■■■■■■■■■■■□□□  NOW LOADING \n");



     ArrayList<Station> ARstat1;
     ArrayList<Troncon> ARtronc1;
     ArrayList<Navette> Navette;



           //+ Nos Station De Correspandance Et Principale
     //&  Liverpool street    M  M   T   B                 COR    PRINC   +
     //&  Holborn   M TR T                                 COR    PRINC   +
     //&  Kings Cross St Pancras    M TR T B               COR    PRINC   +
     //&  Arsenal  TR  T                                   COR    PRINC   +
     //&  Manor House TR T                                 COR    PRINC   +
     //&  Camden Town TR  T  B                             COR    PRINC   +
     //&  Caledonian Road  TR  T B                         COR    PRINC   +
     //&  Highbury et Islington   T  T                     COR            +
     //&  Bank Station     M B                             COR    PRINC   +
     //&  Aldgate            m   b                         cor   princ    +
     //&  Moorgate           m   b                         cor   princ    +





     //! PURPLE

     Station S1=new Station(1,"Aldgate",new Cord(51.514507203183285, -0.0754066082096013), Station.type.secondaire,"M002"); //+ 9
     Station S2=new Station(2,"Liverpool Street",new Cord(51.51761845369134, -0.08289533551057222), Station.type.secondaire,"M002"); //+ 1   principale + cor
     Station S3=new Station(3,"Moorgate",new Cord(51.518551453612794, -0.0880880922260932), Station.type.secondaire,"M002");//+ 10
     Station S4=new Station(4,"Barbican",new Cord(36.5,2.3), Station.type.secondaire,"M002");
     Station S5=new Station(5,"Kings Cross St Pancras",new Cord(51.53121714413155, -0.12448663504981482), Station.type.secondaire,"M002");  //+ 3 prin cor
     Station S6=new Station(6,"Euston Square",new Cord(51.52571824807274, -0.13504611201306935), Station.type.secondaire,"M002");
     Station S7=new Station(7,"Great Portland Street",new Cord(51.52376908069588, -0.1439054484247597), Station.type.secondaire,"M002");
     Station S8=new Station(8,"Regent's Park",new Cord(51.52369898921364, -0.1467003102289854), Station.type.secondaire,"M002");
     Station S9=new Station(9,"Baker Street",new Cord(51.5231481138491, -0.15686783130850346), Station.type.secondaire,"M002");
     Station S10=new Station(10,"St Johns Wood",new Cord(51.5347343419344, -0.17410794527051085), Station.type.secondaire,"M002");

     ARstat1 = new ArrayList<Station>();
     ARtronc1 = new ArrayList<Troncon>();
     Navette = new ArrayList<Navette>();

     ARstat1.add(S1);
     ARstat1.add(S2);
     ARstat1.add(S3);
     ARstat1.add(S4);
     ARstat1.add(S5);
     ARstat1.add(S6);
     ARstat1.add(S7);
     ARstat1.add(S8);
     ARstat1.add(S9);
     ARstat1.add(S10);




     Troncon.StatToTronc(ARstat1,ARtronc1);

     Ligne L1 = new Ligne("M002",MoyTransport.MoyType.METRO,S1,S10,ARstat1,ARtronc1) ;


     Navette N1 = new Navette(MoyTransport.MoyType.METRO,1,"SNTF",2010,L1);
     Navette N2 = new Navette(MoyTransport.MoyType.METRO,2,"SNTF",2000,L1);

     Navette.add(N1);
     Navette.add(N2);

     L1.setNavette(Navette);

     Lignes.get(3).add(L1);




//51.52553473897908, -0.03363797320702808



     //! RED

     S1=new Station(1,"Stratford",new Cord(51.541504481752476, -0.003170858971949685), Station.type.secondaire,"M004");
     S2=new Station(2,"Mile End Station",new Cord(1.2,5.3), Station.type.secondaire,"M004");
     S3=new Station(3,"Bethnal Green",new Cord(51.52740303830562, -0.0554949964568669), Station.type.secondaire,"M004");
     S4=new Station(4,"Liverpool Street",new Cord(51.51761845369134, -0.08289533551057222), Station.type.secondaire,"M004");  //+ 1   principale + cor
     S5=new Station(5,"Bank Station",new Cord(51.2,-0.6), Station.type.secondaire,"M004");
     S6=new Station(6,"St Pauls",new Cord(51.515014171783164, -0.09755797246710529), Station.type.secondaire,"M004");
     S7=new Station(7,"Chancery Lane",new Cord(51.518290503892665, -0.11148666298733613), Station.type.secondaire,"M004");
     S8=new Station(8,"Holborn",new Cord(51.5180403023938, -0.11993794908422285), Station.type.secondaire,"M004");  //+  2  prin  cor
     S9=new Station(9,"Tottenham Court Road",new Cord(51.51685064632793, -0.12995204056557394), Station.type.secondaire,"M004");
     S10=new Station(10,"Oxford Circus Underground Station",new Cord(51.51566095919602, -0.14166549251865643), Station.type.secondaire,"M004");

     ARstat1 = new ArrayList<Station>();
     ARtronc1 = new ArrayList<Troncon>();

     ARstat1.add(S1);
     ARstat1.add(S2);
     ARstat1.add(S3);
     ARstat1.add(S4);
     ARstat1.add(S5);
     ARstat1.add(S6);
     ARstat1.add(S7);
     ARstat1.add(S8);
     ARstat1.add(S9);
     ARstat1.add(S10);



     Troncon.StatToTronc(ARstat1,ARtronc1);

     L1 = new Ligne("M004",MoyTransport.MoyType.METRO,S1,S10,ARstat1,ARtronc1);
     Lignes.get(3).add(L1);


//........................................................................................................................................................................................................





     //! blue

     S1=new Station(1,"Leicester Square",new Cord(51.51249172805462, -0.128535176174612), Station.type.secondaire,"TR014");
     S2=new Station(2,"Covent Garden",new Cord(51.51404077198716, -0.12450113275555201), Station.type.secondaire,"TR014");
     S3=new Station(3,"Holborn",new Cord(51.5180403023938, -0.11993794908422285), Station.type.secondaire,"TR014");//+  2  prin  cor
     S4=new Station(4,"Russell Square",new Cord(51.52362764715915, -0.1242436408829699), Station.type.secondaire,"TR014");
     S5=new Station(5,"Kings Cross St Pancras",new Cord(51.531637415908754, -0.12441530220826744), Station.type.secondaire,"TR014");  //+ prin cor 3
     S6=new Station(6,"Caledonian Road",new Cord(51.54912051430216, -0.11819257761053763), Station.type.secondaire,"TR014");//+ 7
     S7=new Station(7,"Arsenal",new Cord(51.55907353703215, -0.10583295829083991), Station.type.secondaire,"TR014"); //+ 4
     S8=new Station(8,"Manor House",new Cord(51.57121167534303, -0.09583368318318809), Station.type.secondaire,"TR014");//+ 5
     S9=new Station(9,"Turnpike Lane",new Cord(51.59102588933298, -0.10312929157627864), Station.type.secondaire,"TR014");
     S10=new Station(10,"Bounds Green",new Cord(51.60779321592325, -0.12471570953528666), Station.type.secondaire,"TR014");

     ARstat1 = new ArrayList<Station>();
     ARtronc1 = new ArrayList<Troncon>();

     ARstat1.add(S1);
     ARstat1.add(S2);
     ARstat1.add(S3);
     ARstat1.add(S4);
     ARstat1.add(S5);
     ARstat1.add(S6);
     ARstat1.add(S7);
     ARstat1.add(S8);
     ARstat1.add(S9);
     ARstat1.add(S10);

     Troncon.StatToTronc(ARstat1,ARtronc1);

     Ligne L2 = new Ligne("TR014",MoyTransport.MoyType.TRAMWAY,S1,S10,ARstat1,ARtronc1);
     Lignes.get(2).add(L2);



     //! black

     S1=new Station(8,"Edgware",new Cord(51.613924337518775, -0.27553395050249024), Station.type.secondaire,"TR016");
     S2=new Station(7,"Colindale",new Cord(121.2,11.5), Station.type.secondaire,"TR016");
     S3=new Station(5,"Golders Green",new Cord(21.2,1.5), Station.type.secondaire,"TR016");
     S4=new Station(6,"Hendon Central",new Cord(51.58340657832146, -0.22695270378987306), Station.type.secondaire,"TR016");
     S5=new Station(4,"Camden Town",new Cord(51.53985720850962, -0.14278825503793544), Station.type.secondaire,"TR016"); //+ cor 6
     S6=new Station(3,"Mornington Crescent",new Cord(51.53479091115035, -0.13878554093446846), Station.type.secondaire,"TR016");
     S7=new Station(2,"Warren Street",new Cord(51.52499278034553, -0.1381418109602981), Station.type.secondaire,"TR016");
     S8=new Station(1,"Holborn",new Cord(51.51829706833978, -0.11999935046720628), Station.type.secondaire,"TR016");  //+  2  prin  cor
     S9=new Station(9,"Denmark Street",new Cord(51.51493405918271, -0.12995412660993338), Station.type.secondaire,"TR016");
     S10=new Station(10,"Leicester Square",new Cord(51.51196910079776, -0.12813338286871095), Station.type.secondaire,"TR016");


     ARstat1 = new ArrayList<Station>();
     ARtronc1 = new ArrayList<Troncon>();

     ARstat1.add(S1);
     ARstat1.add(S2);
     ARstat1.add(S3);
     ARstat1.add(S4);
     ARstat1.add(S5);
     ARstat1.add(S6);
     ARstat1.add(S7);
     ARstat1.add(S8);
     ARstat1.add(S9);
     ARstat1.add(S10);

     Troncon.StatToTronc(ARstat1,ARtronc1);

     L1 = new Ligne("TR016",MoyTransport.MoyType.TRAMWAY,S1,S10,ARstat1,ARtronc1);


     Navette = new ArrayList<Navette>();

     Navette N3 = new Navette(MoyTransport.MoyType.TRAMWAY,3,"toyota",2015,L1);
     Navette N4 = new Navette(MoyTransport.MoyType.TRAMWAY,4,"SNTF",2009,L1);

     Navette.add(N3);
     Navette.add(N4);


     L1.setNavette(Navette);

     Lignes.get(2).add(L1);






//........................................................................................................................................................................................................


     //! blue claire

     S1=new Station(1,"Euston Square",new Cord(5.6,8.9), Station.type.secondaire,"T009");
     S2=new Station(2,"Kings Cross St Pancras",new Cord(51.531637415908754, -0.12441530220826744), Station.type.secondaire,"T009");
     S3=new Station(3,"Highbury et Islington",new Cord(51.546320867018316, -0.10460490610151914), Station.type.secondaire,"T009"); //+9
     S4=new Station(4,"Drayton Park",new Cord(51.5528543812456, -0.10558470626370192), Station.type.secondaire,"T009");
     S5=new Station(5,"Arsenal",new Cord(51.55907353703215, -0.10583295829083991), Station.type.secondaire,"T009"); //+ 4
     S6=new Station(6,"Manor House",new Cord(51.57121167534303, -0.09583368318318809), Station.type.secondaire,"T009");//+ 5
     S7=new Station(7,"Seven Sisters",new Cord(51.58415590600626, -0.07224431420874912), Station.type.secondaire,"T009");
     S8=new Station(8,"Tottenham Hale",new Cord(51.58857056387768, -0.06048105735511863), Station.type.secondaire,"T009");
     S9=new Station(9,"Blackhorse Road",new Cord(51.59102588933298, -0.10312929157627867), Station.type.secondaire,"T009");
     S10=new Station(10,"Walthamstow Central",new Cord(51.583244573221066, -0.019850518629048398), Station.type.secondaire,"T009");

     ARstat1 = new ArrayList<Station>();
     ARtronc1 = new ArrayList<Troncon>();


     ARstat1.add(S1);
     ARstat1.add(S2);
     ARstat1.add(S3);
     ARstat1.add(S4);
     ARstat1.add(S5);
     ARstat1.add(S6);
     ARstat1.add(S7);
     ARstat1.add(S8);
     ARstat1.add(S9);
     ARstat1.add(S10);

     Troncon.StatToTronc(ARstat1,ARtronc1);

     L1 = new Ligne("T009",MoyTransport.MoyType.TRAIN,S1,S10,ARstat1,ARtronc1);

     Lignes.get(1).add(L1);



     //! ORANGE

     S1=new Station(1,"Kentish Town West",new Cord(51.54722602430063, -0.14686737876784672), Station.type.secondaire,"T003");
     S2=new Station(2,"Camden Town",new Cord(51.53985720850962, -0.14278825503793544), Station.type.secondaire,"T003"); //+ cor 6
     S3=new Station(3,"Caledonian Road",new Cord(51.54912051430216, -0.11819257761053763), Station.type.secondaire,"T003");//+ 7
     S4=new Station(4,"Highbury et Islington",new Cord(51.546320867018316, -0.10460490610151914), Station.type.secondaire,"T003"); //+9
     S5=new Station(5,"Canonbury",new Cord(51.54983490834754, -0.09226713713261321), Station.type.secondaire,"T003");
     S6=new Station(6,"Dalston Kingsland",new Cord(51.54931613461307, -0.07486370276155221), Station.type.secondaire,"T003");
     S7=new Station(7,"Haggerston",new Cord(51.53955481734815, -0.07552318625298887), Station.type.secondaire,"T003");
     S8=new Station(8,"SDC",new Cord(51.524160930860994, -0.07579408108757046), Station.type.secondaire,"T003");
     S9=new Station(9,"Whitechapel Station",new Cord(51.519947783715665, -0.061254043379910625), Station.type.secondaire,"T003");
     S10=new Station(10,"Liverpool Street",new Cord(51.51761845369134, -0.08289533551057222), Station.type.secondaire,"T003"); //+ corr 1 / meme moy


     ARstat1 = new ArrayList<Station>();
     ARtronc1 = new ArrayList<Troncon>();

     ARstat1.add(S1);
     ARstat1.add(S2);
     ARstat1.add(S3);
     ARstat1.add(S4);
     ARstat1.add(S5);
     ARstat1.add(S6);
     ARstat1.add(S7);
     ARstat1.add(S8);
     ARstat1.add(S9);
     ARstat1.add(S10);

     Troncon.StatToTronc(ARstat1,ARtronc1);

     L1 = new Ligne("T003",MoyTransport.MoyType.TRAIN,S1,S10,ARstat1,ARtronc1);




     Navette = new ArrayList<Navette>();

     Navette N5 = new Navette(MoyTransport.MoyType.TRAIN,5,"chevrelait",2017,L1);
     Navette N6 = new Navette(MoyTransport.MoyType.TRAIN,6,"SNTF",2021,L1);


     Navette.add(N5);
     Navette.add(N6);

     L1.setNavette(Navette);

     Lignes.get(1).add(L1);


     //........................................................................................................................................................................................................



     S1=new Station(1,"Primrose Hill Road",new Cord(51.54461182574809, -0.163062410611731432), Station.type.secondaire,"B007");
     S2=new Station(2,"Chalk Farm",new Cord(51.54483829115482, -0.15450491517676876), Station.type.secondaire,"B007");
     S3=new Station(3,"Gibson",new Cord(51.54219612454664, -0.14594741841712894), Station.type.secondaire,"B007");
     S4=new Station(4,"Camden Town",new Cord(51.53985720850962, -0.14278825503793544), Station.type.secondaire,"B007"); //+ cor 6
     S5=new Station(5,"Camden Road",new Cord(51.54150094224345, -0.1391594395667396), Station.type.secondaire,"B007"); //+ 4
     S6=new Station(6,"Royal College",new Cord(51.535977631206876, -0.1338772934213984), Station.type.secondaire,"B007");//+ 5
     S7=new Station(7,"Randells Road",new Cord(51.53838017881084, -0.12257059782845486), Station.type.secondaire,"B007");
     S8=new Station(8,"Kings Cross St Pancras",new Cord(51.531637415908754, -0.12441530220826744), Station.type.secondaire,"B007");  //+ prin cor 3
     S9=new Station(9,"Story Street",new Cord(51.5407719227085, -0.11711113688218666), Station.type.secondaire,"B007");
     S10=new Station(10,"Caledonian Road",new Cord(51.542676387785136, -0.11706010165357099), Station.type.secondaire,"B007");


     ARstat1 = new ArrayList<Station>();
     ARtronc1 = new ArrayList<Troncon>();

     ARstat1.add(S1);
     ARstat1.add(S2);
     ARstat1.add(S3);
     ARstat1.add(S4);
     ARstat1.add(S5);
     ARstat1.add(S6);
     ARstat1.add(S7);
     ARstat1.add(S8);
     ARstat1.add(S9);
     ARstat1.add(S10);

     Troncon.StatToTronc(ARstat1,ARtronc1);

     L1 = new Ligne("B007",MoyTransport.MoyType.BUS,S1,S10,ARstat1,ARtronc1);


     Lignes.get(0).add(L1);



     S1=new Station(1,"London Bridge Bus",new Cord(51.50535747116079, -0.08709757819710587), Station.type.secondaire,"B019");
     S2=new Station(2,"Monument",new Cord(51.50966499835303, -0.08727472284361827), Station.type.secondaire,"B019");
     S3=new Station(3,"King William Street",new Cord(51.51152567840529, -0.08722045920899608), Station.type.secondaire,"B019");
     S4=new Station(4,"Bank Station",new Cord(51.2,-0.6), Station.type.secondaire,"B019");
     S5=new Station(5,"Canonbury",new Cord(51.51338542215389, -0.08765476142661825), Station.type.secondaire,"B019");
     S6=new Station(6,"Bishopsgate",new Cord(51.513498732688774, -0.08504502855830093), Station.type.secondaire,"B019");
     S7=new Station(7,"Stop A",new Cord(51.51466775135466, -0.07855185257379713), Station.type.secondaire,"B019");
     S8=new Station(8,"Aldgate",new Cord(51.514507203183285, -0.0754066082096013), Station.type.secondaire,"B019"); //+ 9
     S9=new Station(9,"Liverpool Street",new Cord(51.51761845369134, -0.08289533551057222), Station.type.secondaire,"B019"); //+ corr 1 / meme moy
     S10=new Station(10,"Moorgate",new Cord(51.518551453612794, -0.0880880922260932), Station.type.secondaire,"B019");//+ 10

     ARstat1 = new ArrayList<Station>();
     ARtronc1 = new ArrayList<Troncon>();


     ARstat1.add(S1);
     ARstat1.add(S2);
     ARstat1.add(S3);
     ARstat1.add(S4);
     ARstat1.add(S5);
     ARstat1.add(S6);
     ARstat1.add(S7);
     ARstat1.add(S8);
     ARstat1.add(S9);
     ARstat1.add(S10);


     Troncon.StatToTronc(ARstat1,ARtronc1);

     L1 = new Ligne("B019",MoyTransport.MoyType.BUS,S1,S10,ARstat1,ARtronc1);



     Navette = new ArrayList<Navette>();

     Navette N7 = new Navette(MoyTransport.MoyType.BUS,7,"chevrelait",2017,L1);
     Navette N8 = new Navette(MoyTransport.MoyType.BUS,8,"SNTF",2021,L1);


     Navette.add(N5);
     Navette.add(N6);

     L1.setNavette(Navette);


     Lignes.get(0).add(L1);


     //& generer les id unique des station

     for (ArrayList<Ligne> TL : Lignes)
     {
      for (Ligne  L : TL)
      {
       for(Station st : L.getStation_inter() )
       {
        Prog.ToutStat.add(st);
        st.setCode(Prog.idStation+1);
        Prog.idStation++;
       }
      }
     }

     System.out.println("\t\t\t\t\t\t\t   \uD83D\uDCE1 Remplissage automatique fait \uD83D\uDCE1 \n");

    }
}
