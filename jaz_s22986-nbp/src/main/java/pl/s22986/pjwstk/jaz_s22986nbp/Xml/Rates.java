package pl.s22986.pjwstk.jaz_s22986nbp.Xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class Rates {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Rate> Rate = new ArrayList<>();

    public List<pl.s22986.pjwstk.jaz_s22986nbp.Xml.Rate> getRate() {
        return Rate;
    }

    public void setRate(List<pl.s22986.pjwstk.jaz_s22986nbp.Xml.Rate> rate) {
        Rate = rate;
    }
}
