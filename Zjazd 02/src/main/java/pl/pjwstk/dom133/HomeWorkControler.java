package pl.pjwstk.dom133;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homework")
public class HomeWorkControler {

    @GetMapping("/{id}")
    ResponseEntity<Integer> getOne(@PathVariable(value = "id", required = false) @RequestParam(value = "id", required = false) int id) {
        return ResponseEntity.ok(id);
    }
}
