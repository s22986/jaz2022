package pl.s22986.pjwstk.jaz_s22986nbp.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.s22986.pjwstk.jaz_s22986nbp.Entity.NbpEntity;
import pl.s22986.pjwstk.jaz_s22986nbp.Service.NbpService;

@RestController
public class NbpRestController {
    final NbpService nbpService;

    public NbpRestController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    /**
     * Endpoint zapisuje srednia cene zlota w podanym zakresie czasu uwzgledniajac podana walute
     * @param waluta Waluta w formacie trzy literowym
     * @param startDate Data pocztakowa
     * @param endDate Data koncowa
     * @return zwracany jest obiekt NbpEntity
     */
    @GetMapping("/zloto/{waluta}/{startDate}/{endDate}")
    public ResponseEntity<String> zloto(@PathVariable String waluta, @PathVariable String startDate,
                                           @PathVariable String endDate) throws JsonProcessingException {
        return ResponseEntity.ok(nbpService.obliczZloto(waluta, startDate, endDate));
    }

    /**
     * Endpoint pobiera z bazy obiekt o podanym id
     * @param id id elementu w bazie
     * @return zwracany jest obiekt NbpEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id){
        return ResponseEntity.ok(nbpService.getID(id));
    }
}
