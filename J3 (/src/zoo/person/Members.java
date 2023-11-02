package zoo.person;

import java.time.LocalDate;

public class Members extends People {
    private LocalDate mitgliedSeit;
    private int mitgliedNum;
    public Members() {
        super();
    }

    public Members(String telefonnummer, LocalDate mitgliedSeitit, int mitgliedNum) {
        super(telefonnummer);
        this.mitgliedSeit = mitgliedSeitit;
        this.mitgliedNum = mitgliedNum;
    }
}

