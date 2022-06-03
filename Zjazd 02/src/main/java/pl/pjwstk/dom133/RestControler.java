package pl.pjwstk.dom133;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControler {

    /*@GetMapping("test/hello")
    ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }*/

    @GetMapping("test/model")
    ResponseEntity<Car> carModel() {
        Car car = new Car("Tesla X", 2018, 2);
        return ResponseEntity.ok(car);
    }

    @GetMapping("test/hello/{value}")
    ResponseEntity<String> someValuePath(@PathVariable String value) {
        return ResponseEntity.ok(value);
    }

    @GetMapping("test/hello")
    ResponseEntity<String> someValueRequest(@RequestParam String reqParam) {
        return ResponseEntity.ok(reqParam);
    }

    @PostMapping("test/model")
    ResponseEntity<Car> carModelPost(@RequestParam String model, @RequestParam int rok, @RequestParam int ilosc_drzwi) {
        Car car = new Car(model, rok, ilosc_drzwi);
        return ResponseEntity.ok(car);
    }

}
