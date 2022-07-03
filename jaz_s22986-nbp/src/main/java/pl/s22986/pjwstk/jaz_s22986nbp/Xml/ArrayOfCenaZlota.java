package pl.s22986.pjwstk.jaz_s22986nbp.Xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfCenaZlota {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CenaZlota> CenaZlota = new ArrayList<>();

    public List<pl.s22986.pjwstk.jaz_s22986nbp.Xml.CenaZlota> getCenaZlota() {
        return CenaZlota;
    }

    public void setCenaZlota(List<pl.s22986.pjwstk.jaz_s22986nbp.Xml.CenaZlota> cenaZlota) {
        CenaZlota = cenaZlota;
    }

    public float getCenaZlotaSrednia(float walutaCena) {
        List<CenaZlota> cenaZlotaList = getCenaZlota();
        int elementy = cenaZlotaList.size();
        float suma = 0;

        for(int i=0; i<=elementy-1; i++) {
            suma += Float.parseFloat(cenaZlotaList.get(i).getCena());
        }

        return (suma/elementy)*walutaCena;
    }
}
