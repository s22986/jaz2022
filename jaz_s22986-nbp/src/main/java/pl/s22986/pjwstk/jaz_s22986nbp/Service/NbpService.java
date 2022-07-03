package pl.s22986.pjwstk.jaz_s22986nbp.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.s22986.pjwstk.jaz_s22986nbp.Entity.NbpEntity;
import pl.s22986.pjwstk.jaz_s22986nbp.Repository.NbpRepository;
import pl.s22986.pjwstk.jaz_s22986nbp.Xml.ArrayOfCenaZlota;
import pl.s22986.pjwstk.jaz_s22986nbp.Xml.ExchangeRatesSeries;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class NbpService {
    final NbpRepository nbpRepository;


    public NbpService(NbpRepository nbpRepository) {
        this.nbpRepository = nbpRepository;
    }

    public String obliczZloto(String waluta, String startDate, String endDate) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        NbpEntity nbpEntity = new NbpEntity();
        RestTemplate restTemplate = new RestTemplate();
        float walutaCena = 1;
        float srCenaZlota = 0;

        waluta = waluta.toUpperCase();

        String nbpCenaZlota = "https://api.nbp.pl/api/cenyzlota/"+startDate+"/"+endDate+"?format=xml";
        String nbpWaluta = "https://api.nbp.pl/api/exchangerates/rates/A/"+waluta+"?format=xml";

        ResponseEntity<String> responseZloto = restTemplate.getForEntity(nbpCenaZlota, String.class);
        String zlotoXML = responseZloto.getBody();

        if(!waluta.equals("PLN")) {
            ResponseEntity<String> responseWaluta = restTemplate.getForEntity(nbpWaluta, String.class);
            String walutaXML = responseWaluta.getBody();
            ExchangeRatesSeries exchangeRatesSeries = xmlMapper.readValue(walutaXML, ExchangeRatesSeries.class);
            walutaCena = exchangeRatesSeries.getCurrencyCurse();
        }

        ArrayOfCenaZlota arrayOfCenaZlota = xmlMapper.readValue(zlotoXML, ArrayOfCenaZlota.class);

        srCenaZlota = arrayOfCenaZlota.getCenaZlotaSrednia(walutaCena);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        nbpEntity = new NbpEntity(waluta, startDate, endDate, srCenaZlota, String.valueOf(now));

        return nbpRepository.save(nbpEntity).toString();
    }

    public String getID(long id) {
        return nbpRepository.findById(id).get().toString();
    }
}
