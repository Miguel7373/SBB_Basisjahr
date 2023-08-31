package labs_J1;

public class aufgabe5 {
    public static void main(String[] args) {
        String poem = """
                Ein Ninja leise wie der Wind,
                Seine Waffen stets geschwind.
                "Shurikens" fliegen, scharf und schnell,
                Klingen funkeln, furchterregend hell.


                "Nunchakus" wirbeln im Tanz,
                Mit jedem Schlag, im Vorteil er ganz.
                Seine Waffen, geheim und klug,
                Begleiten ihn bei jedem Zug.""";

        var items = poem.split(" ");

        System.out.println("This receipt has " + items.length);
        for (String item : items) {
            String CAPS = poem.toUpperCase();
            System.out.println(CAPS);
        }
        String Punkt = poem.replace(" ",".");
        System.out.println(Punkt);
        int textlength = poem.indexOf("\"");
        System.out.println(textlength + " Zeichen lang.");
        StringBuilder builder = new StringBuilder(poem);
        for (int i = 0 ; i <= 10; i++) {
            builder.deleteCharAt(60);
        }
        System.out.println(builder);
    }
}

