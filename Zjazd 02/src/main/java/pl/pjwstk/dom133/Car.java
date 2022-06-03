package pl.pjwstk.dom133;

public class Car {
    private String model;
    private int rok;
    private int iloscDrzwi;

    public Car(String model, int rok, int ilosc_drzwi) {
        this.model = model;
        this.rok = rok;
        this.iloscDrzwi = ilosc_drzwi;
    }

    public String getModel() {
        return model;
    }

    public int getRok() {
        return rok;
    }

    public int getIloscDrzwi() {
        return iloscDrzwi;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public void setIloscDrzwi(int iloscDrzwi) {
        this.iloscDrzwi = iloscDrzwi;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", rok=" + rok +
                ", iloscDrzwi=" + iloscDrzwi +
                '}';
    }
}
