package roleplay.items;

public abstract class Items {
    int weight;
    String Designation;
    int prise;

    public Items(int weight, String designation,int prise) {
        this.weight = weight;
        this.Designation = designation;
        this.prise = prise;
    }

    public String getDesignation() {
        return Designation;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }
}
