package zoo;
import zoo.animals.aquatic_animals.*;
import zoo.animals.birds.*;
import zoo.animals.land_animals.*;
import zoo.animals.reptiles.*;
import zoo.enclosures.*;
import zoo.person.*;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {

        Aquatic_animals whitetip_reef_shark = new Whitetip_reef_shark("fdf", 20);
        Birds albatrosse = new Albatrosse("fdf", 100);
        Land_animals africanElephant = new African_elephant("fad", 3);
        Reptiles frilledLizard = new Frilled_lizard("ff", 42);
        Enclosure aquarium = new Aquarium(1, 20.1, 20, 5, Aquarium.WaterType.fresh_Water,whitetip_reef_shark);
        Enclosure terrain = new Terrain(2, 100.2, 16,11.5,true,africanElephant);
        Enclosure cage = new Cage(3, 10, 12, 30,albatrosse);
        Enclosure terrarium = new Terrarium(4, 5, 36, 20, 2,frilledLizard);
        People john = new Employees("12345",123,"Zopfleger",cage);
        People joel = new Employees("12345",123,"Zopfleger",terrain);
        People timo = new Employees("12345",123,"Zopfleger",terrarium);
        People nevio = new Employees("12345",123,"Zopfleger",aquarium);
        People marc = new Members("123234", LocalDate.of(2022, 5, 2),1);
        System.out.println("hallo");
    }
}
//if(animal instanceof Terrarium){
//System.out.println("is ter");
//}
//
//
//
//
//Employees beinhaltet zuteilungsbereich
//Enclosure beinhatet animal