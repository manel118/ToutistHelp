package com.example.touristhelp;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class HomeFeed extends AppCompatActivity {
private RecyclerView touristicPlaces ;
private SearchView searchview ;
public  TouristDataBase db ;
   private ArrayList<PlaceModel> places = new ArrayList<>() ;
   private RecycleviewAdapter adapter ;
   private ArrayList<PlaceModel> searchList ;
   private ArrayList<Images> images;
   private ArrayList PLace1images;
   private final int numberOfPlaces=13 ;



//هذا الملف تع الصفحة الثانية لي فيها جميع الأماكن

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_feed);
        setTitle("Home Feed");
        touristicPlaces = findViewById(R.id.touristplaces);
        searchview = findViewById(R.id.searchv);


//هنا القائمة لي تحطو فيها المعلومات تع الأماكن ومنهم الصورة الأولى اللي تظهر مع الأول
// طلعو التصاور تع جميع الأماكن في البروجي وحددو id تع البلاسة في constructeur
        //like that : R.id.NomDePhoto
        places = new ArrayList<PlaceModel>();
        places.add(new PlaceModel("Benshkaw","medea","Algeria","forest",R.drawable.benshkaw1,5,"se situe  à 19 km, au sud de la commune de Médéa, dépendant de la commune de ben chikao, un merveilleux site avec des infrastructures touristiques, de loisirs et de jeunesses. une auberge de jeunesse d’une capacité de 100 lits,  un  microclimat exceptionnel. Le site s’étend sur une superficie de 12 ha, situé sur le mont de Benchicao, qui culmine à 1248 mètres d’altitude une vue global profitant et panoramiques imprenables sur les vastes champs de vignes."));
        places.add(new PlaceModel("Qamra","M'sila","Algeria","chutes",R.drawable.ain_errich,5,"Les cascades de Qamra, ou la Fiancée de Boukhail, comme on les appelle, ne sont pas seulement des estuaires d'eau cachés par les rochers des montagnes de la chaîne des Awlad Nayel qui s'étendent le long de la bande de l'Atlas saharien, elles font partie de l'histoire de la région. et un aspect de son identité, il a reçu ce nom en raison de sa beauté et de l'intimité de ses vues reflétant le clair de lune.La magie des montagnes et de leurs cascades a attiré les gens et a contribué à la construction du village, qui a été fondé au bord d'une vallée toujours coulante, puisant son eau à un ensemble de sources fraîches proches, ce qui a donné à la région sa spécificité agricole, car la les terres voisines sont considérées comme un paradis pour les arbres fruitiers tels que la grenade et l'abricotier, et sont également considérées comme l'une des zones de production les plus importantes.Pour les meilleurs types de figues à l'échelle nationale.\\n\"+\n" +
                "        \"La région se caractérise par une variété de reliefs montagneux et une belle nature vierge, où Qumra a été témoin de la présence de l'homme depuis l'Antiquité, comme en témoignent un groupe de dessins préhistoriques.Il y a aussi un ancien fort romain, qui était une extension de la ligne «lims» que les Romains ont construite pour défendre le nord contre les attaques des tribus du sud, et en raison du terrain difficile, la région était une forteresse imprenable pour les moudjahidines pendant la révolution de libération, alors qu'un groupe de batailles majeures se déroulait lieu là, dont le plus important était la bataille de « al-Safra », « al-Toumiyat » et « le centre de réunion » et d'autres stations qui ont fait des championnats et des gloires Martyrs devoir. \n"));
        places.add(new PlaceModel("Beni Add","Tlemcen","Algeria","grotte",R.drawable.beni_add,5,"La Grotte des Ain Beni Add est une grotte qui se situe au parc national de Tlemcen qui est à environ 10 kilomètres de la ville de Tlemcen. Cette grotte a environ 65 000 ans et a été ouverte en juillet 2006.\n" +
                "Cette grotte garde des températures trés fraiches tout au long de l'année. Leurs profondeur est de 57 mètres et révèle des trésors et des architectures admirables.\n" +
                "Selon certaines sources, ces grottes aboutissaient à Ghar Boumaza (40 kilomètres plus loin), un système hydrologique souterrain qui constitue, selon des spécialistes, le plus grand réseau caverneux souterrain connu en Algérie. Elle a été utilisé par les moudjahidine comme refuge durant la guerre de Libération nationale et une fois au courant de ce passage, l'armée coloniale bloqua le chemin, précise-t-on.\n"));
        places.add(new PlaceModel("Bordj Zemoura","Bordj Bou Arreridj","Algeria","Tour",R.drawable.borj_zemoura,5,"Bordj Zemoura ou Zemoura (en berbère : ⴱⵓⵔⴵ ⵣⵎⵎⵓⵔⴰ, en arabe زمورة ou برج زمورة) est une commune algérienne de la wilaya de Bordj Bou Arreridj, située à 30 km nord-est de Bordj-Bou-Arreridj. Elle est surnommée « la ville de la montagne dominante »2, c'est un site touristique et religieux important.\n" +
                "Zemmoura était un passage important pour les caravanes venant du Sud, de M'sila et Bou Saâda, pour remonter vers la vallée de la Soummam et le port de Béjaïa2.\n"));
        places.add(new PlaceModel("Ziama mansouria","Jijel","Algeria","vallée",R.drawable.mansouriah,5,"Oued Ziama est un ruisseau. Oued Ziama est située à proximité de la localité Khankhoun et de la petite ville Ziama Mansouriah\n" +
                "Tassili : Le parc culturel du Tassili (anciennement parc national du Tassili jusqu'à 20111), est un parc national algérien, situé près de la ville de Djanet, dans la wilaya de Illizi, dans le Sud de l'Algérie2. Couvrant une superficie de 138 000 km2, il est le premier parc d'Algérie par la taille. Le parc englobe une grande partie du massif du Tassili n'Ajjer, l'erg Admer et la Tadrart Rouge3.\n" +
                "Il est classé depuis 1982 au patrimoine mondial4 et réserve de biosphère depuis 1986 par l'UNESCO5,6. Il est, par le nombre de ses gravures rupestres, le premier site à l'échelle mondiale.\n" +
                "Le climat du parc culturel du Tassili est désertique et très sec. Les pluies sont extrêmement irrégulières. Il présente des hivers assez froids, et des étés relativement chauds. Le mois de juin est le mois le plus chaud de l'année alors que le mois de janvier est le plus froid. Les vents sont généralement faibles à modérés.\n"));
        places.add(new PlaceModel("Tassili","Illizi","Algeria","montagnes",R.drawable.tassili,5,"Ce haut plateau aride se trouve à plus de 1 000 mètres d'altitude et s'étend sur 50 à 60 km d'est en ouest et 800 km du nord au sud, soit une superficie de près de 120 000 km2. Sur toute sa surface se dressent des formations rocheuses créées par l'érosion, émergeant des dunes de sable, qui évoquent de loin les ruines de villes antiques.\n" +
                "\n" +
                "Le tassili n’Ajjer culmine à 2 158 mètres d'altitude à l'Adrar Afao et émerge en hautes falaises à 1 500 mètres en moyenne au-dessus des ergs de Mourzouq et d'Oubari à l'est et d'Admer dans le Ténéré au sud1. Au nord, ce haut plateau se perd dans les dunes d'Issaouane et de Bourharet.\n" +
                "\n" +
                "Le relief du tassili n’Ajjer est particulièrement tourmenté : les immenses plaines rocheuses qui laissent parfois la place à des « forêts » de monolithes sont creusées d’akbas (trous dans les escarpements qui ne sont accessibles qu'à pied ou à dos de dromadaire) et de multiples failles et canyons recelant parfois une guelta alimentée par les rares et violents orages qui ravinent le désert tous les deux ou trois ans1.\n" +
                "\n" +
                "Le massif est habité par les Touaregs du groupe Kel Ajjer. Sa ville principale est Djanet, une petite oasis située en bordure occidentale de la région."));
        places.add(new PlaceModel("Fort de Santa-Cruz","Oran","Algeria","Monumant",R.drawable.sant1,4,"Le fort de Santa-Cruz est un fort situé à Oran, en Algérie. Érigé par les Espagnols entre 1577 et 1604. Le fort a été théâtre de combats sanglants opposant Ottomans et Maures vassaux aux Espagnols. Ce fort se situe sur la crête du massif de l'Aïdour. Sa situation en faisait alors un point stratégique."));
        places.add(new PlaceModel("Tikechda","Bouira","Algeria","mountains",R.drawable.tikejda2,4,"Tikjda offre le plus beau point de vue sur les sommets phares du Djurdjura : la Pyramide de Tamgout Amghor Lalla Khlidja (plus connue sous Lalla Khedidja, 2 308 m), et Acquerru Timedwin, vertigineuse montagne nue aux paysages lunaires et piquetée sur sa crête de nombreux bassins naturels ou de profonds « trous » où se nichent eau et glaces dites « éternelles » (d'où son nom de Timedwin), alimentant les innombrables sources qui coulent continuellement de part et d'autre de ses versants."));
        places.add(new PlaceModel("El-Hoggar","Tamenrasset","Algeria","Montagne",R.drawable.hogar3,10,"e massif du Hoggar se trouve tout au Sud de l’Algérie, proche de la frontière avec le Niger et du tropique du Cancer, qui traverse d’ailleurs cette superbe étendue désertique. Situé sur la terre des Touaregs Kel Ahaggar, ce paysage est certainement l’un des plus époustouflants entre déserts, montagnes se dressant à pic, plateaux vertigineux et oasis accueillantes qui permettent aux voyageurs de se reposer. Un lieu hors du monde, et hors du temps, qui reflète parfaitement toutes les richesses cachées de l’Algérie."));
        places.add(new PlaceModel("L'Îles des Princes","Istanbul","Turquie","Ile",R.drawable.princes3,10,"Pendant les mois d'été, les îles sont des destinations populaires pour des excursions d'une journée. Comme les véhicules motorisés terrestres y sont interdits (à l'exception des services publics locaux), le seul transport pour les personnes est la charrette, généralement du type phaéton, tirée par des chevaux, des ânes ou des mules. Les quatre principales îles de l'archipel (la « Grande » Büyükada, celle « des Selliers » Heybeliada, celle « du Détroit » Burgazada et celle « du Henné » Kınalıada) sont accessibles par ferry depuis la côte européenne (à partir d'Istanbul - Sirkeci/Eminönü et Kabataş/Yenikapı) et depuis la côte anatolienne (à partir de Bostancı et Kartal). Seule l'« île de la Nacre » Sedef Adası est préservée du tourisme de masse, n'étant pas desservie par les lignes de transports régulières. Des pèlerinages multiconfessionnels ont lieu sur les îles et la gastronomie y mêle les influences du Levant, de la Turquie, de la Grèce, de la Russie, du judaïsme et de l'Occident6"));
        places.add(new PlaceModel("La mosquée Ketchaoua","Algeria","Algeria","Monument",R.drawable.kechawa2,5,"La mosquée Ketchaoua est une mosquée historique faisant partie du patrimoine classé de la basse casbah d'Alger.elle a été construit en 1436. Au 19ème siècle, en 1832, a été fixé pour le culte catholique pendant la période coloniale sous le nom de la cathédrale San Phillip.En 1962, elle redevient une mosquée. En 1992, elle est classée, avec l'ensemble de la casbah d'Alger, au patrimoine mondial par l'UNESCO"));
        places.add(new PlaceModel("Jardin d'essai du Hamma","Algeria","Algeria","Monument",R.drawable.hamma3,5,"Le jardin d'essai du Hamma, situé dans le quartier du Belouizdad à Alger, est un jardin luxuriant, qui s'étend sur une superficie de 32 hectares.\n" +
                "\n" +
                "Créé en 1832, il est considéré comme l'un des jardins d'essai et d'acclimatation les plus importants au monde\n" +
                "L'aile ouest du jardin est occupée par le jardin français. Il est séparé de l'ancien jardin situé plus à l'est par l'allée des platanes, perpendiculaire à la route comme l'allée des dragonniers et l'allée des ficus, coupées elles-mêmes de nombreuses allées parallèles à la route dont les deux principales sont l'allée des bambous et l'allée des palmiers. Une allée circulaire au sud-est, l'allée des cocos, contourne le jardin anglais doté d'un petit lac avec plantes aquatiques. Plusieurs sculptures en pierre d'Émile Gaudissard ornent les allées."));
        places.add(new PlaceModel("Le grande mosquée ","Algeria","Algeria","foret",R.drawable.gm5,5,"La Grande Mosquée d'Alger est dotée d'une salle de prière d'une superficie de 20 000 m24, pouvant accueillir 120 000 fidèles. La nef centrale de cette salle est entourée de colonnades, à l'est se trouve le mihrab, réalisé en marbre blanc, la salle est surmontée d'une coupole d'un diamètre de 50 mètres, culminant à une hauteur de 70 mètres. Le minaret est le plus haut minaret du monde, d'une hauteur de 265 mètres avec une plateforme d'observation au sommet pour que les visiteurs profitent de la vue panoramique sur la baie d'Alger."));
        places.add(new PlaceModel("Mémorial du Martyr ","Algeria","Algeria","Monument",R.drawable.mar2,5,"Le mémorial du Martyr, sanctuaire du Martyr ou Maqam Echahid est un monument aux morts surplombant la ville d'Alger, érigé en 1982 à l'occasion du 20e anniversaire de l'indépendance de l'Algérie (5 juillet 1962), en mémoire des chahids, les combattants de la guerre d'indépendance algérienne morts pour la libération du pays."));

        //كل بلاسة عندها 5 صور حطو الصور كلها في القائمة 5 ب5 معناها تع كل بلاسة يجو بالترتيب

        images = new ArrayList<>();
        //تع المكان 1
        images.add(new Images(R.drawable.benshkaw1));
        images.add(new Images(R.drawable.benshkaw2));
        images.add(new Images(R.drawable.benshkaw3));
        images.add(new Images(R.drawable.benshkaw4));
        images.add(new Images(R.drawable.benshkaw5));
        //تع المكان الثاني ....
        images.add(new Images(R.drawable.ain_errich));
        images.add(new Images(R.drawable.ain_errich2));
        images.add(new Images(R.drawable.ain_errich3));
        images.add(new Images(R.drawable.ain_errich4));
        images.add(new Images(R.drawable.ain_errich5));
        //المكان الثالث
        images.add(new Images(R.drawable.beni_add1));
        images.add(new Images(R.drawable.beni_add2));
        images.add(new Images(R.drawable.beni_add3));
        images.add(new Images(R.drawable.beni_add4));
        images.add(new Images(R.drawable.beni_add5));
        //المكان الرابع
        images.add(new Images(R.drawable.borj_zemoura1));
        images.add(new Images(R.drawable.borj_zemoura2));
        images.add(new Images(R.drawable.borj_zemoura3));
        images.add(new Images(R.drawable.borj_zemoura4));
        images.add(new Images(R.drawable.borj_zemoura5));
        //المكان الخامس
        images.add(new Images(R.drawable.mansouriah1));
        images.add(new Images(R.drawable.mansouriah2));
        images.add(new Images(R.drawable.mansouriah3));
        images.add(new Images(R.drawable.mansouriah4));
        images.add(new Images(R.drawable.mansouriah5));
        //المكان السادس
        images.add(new Images(R.drawable.tassili1));
        images.add(new Images(R.drawable.tassili2));
        images.add(new Images(R.drawable.tassili3));
        images.add(new Images(R.drawable.tassili4));
        images.add(new Images(R.drawable.tassili5));
//7
        images.add(new Images(R.drawable.snata5));
        images.add(new Images(R.drawable.sant3));
        images.add(new Images(R.drawable.sant1));
        images.add(new Images(R.drawable.sant2));
        images.add(new Images(R.drawable.santa6));


//8
        images.add(new Images(R.drawable.jourjoura1));
        images.add(new Images(R.drawable.jourjoura2));
        images.add(new Images(R.drawable.tikejda));
        images.add(new Images(R.drawable.jourjoura4));
        images.add(new Images(R.drawable.joutjoura5));
//9
        images.add(new Images(R.drawable.hogar1));
        images.add(new Images(R.drawable.hogar2));
        images.add(new Images(R.drawable.hoga4));
        images.add(new Images(R.drawable.hogar5));
        images.add(new Images(R.drawable.hogar6));
//10
        images.add((new Images(R.drawable.kachawa3)));
        images.add((new Images(R.drawable.princes1)));
        images.add((new Images(R.drawable.princes4)));
        images.add((new Images(R.drawable.princes2)));
        images.add((new Images(R.drawable.princes5)));
        //11
        images.add(new Images(R.drawable.ketchaoua));
        images.add(new Images(R.drawable.kechawa));
        images.add(new Images(R.drawable.kachawa3));
        images.add(new Images(R.drawable.kechawaaa));
        images.add(new Images(R.drawable.kachawaa));



        //12
        images.add(new Images(R.drawable.hamma1));
        images.add(new Images(R.drawable.hamma2));
        images.add(new Images(R.drawable.hamma6));
        images.add(new Images(R.drawable.hamma4));
        images.add(new Images(R.drawable.hamma5));
        //13
        images.add(new Images(R.drawable.gm));
        images.add(new Images(R.drawable.gm2));
        images.add(new Images(R.drawable.gm3));
        images.add(new Images(R.drawable.gm4));
        images.add(new Images(R.drawable.gm6));
//14
        images.add(new Images(R.drawable.mar2));
        images.add(new Images(R.drawable.mar3));
        images.add(new Images(R.drawable.mart));
        images.add(new Images(R.drawable.mar4));
        images.add(new Images(R.drawable.mar));






        //هنا نحطو لكل مكان الصور تاوعو
        //تأكدو بلي كل مكان عندو بالضبط 5 صور غير الصورة اللي تبان مع الأول
    fillImages();


        //the recycleveiw managing to view all places
        touristicPlaces.setLayoutManager(new LinearLayoutManager(HomeFeed.this));
        adapter = new RecycleviewAdapter(this,places);
       adapter.setPlaces(places);
        touristicPlaces.setAdapter(adapter);

// هنا الإعدادات تع البحث
    searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
       //this is the method of research
            searchList =new ArrayList<>();
            for(int a =0 ;a<places.size(); a++){
                if(places.get(a).getName().toUpperCase().contains(query.toUpperCase())){
                    searchList.add(places.get(a));
                }
            }
            touristicPlaces.setLayoutManager(new LinearLayoutManager(HomeFeed.this));
            adapter.setPlaces(searchList);
            touristicPlaces.setAdapter(adapter);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    });
    //هنا الإعدادات تع البحث عند ضغط علامة x
    searchview.setOnCloseListener(new SearchView.OnCloseListener() {
        @Override
        public boolean onClose() {
            touristicPlaces.setLayoutManager(new LinearLayoutManager(HomeFeed.this));
            adapter.setPlaces(places);
            touristicPlaces.setAdapter(adapter);
            return true;
        }
    });
    }

    public void fillImages(){
        int j=0 ;
        for(int i=0;i<numberOfPlaces;i++){
            while(j<(i+1)*5){
                places.get(i).addImages(images.get(j));
                j++;
            }

        }
    }
}