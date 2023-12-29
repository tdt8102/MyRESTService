package hunre.it.MyRESTService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/monhoc")
public class MonHocController {
	@Autowired
    private MonHocRepository monHocRepository;

    @GetMapping("/")
    public List<MonHoc> getAllMonHoc() {
        return monHocRepository.findAll();
    }

    @GetMapping("/{id}")
    public MonHoc getMonHocById(@PathVariable Long id) {
        return monHocRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public MonHoc createMonHoc(@RequestBody MonHoc monHoc) {
        return monHocRepository.save(monHoc);
    }

    @PutMapping("/{id}")
    public MonHoc updateMonHoc(@PathVariable Long id, @RequestBody MonHoc updatedMonHoc) {
        updatedMonHoc.setId(id);
        return monHocRepository.save(updatedMonHoc);
    }

    @DeleteMapping("/{id}")
    public void deleteMonHoc(@PathVariable Long id) {
        monHocRepository.deleteById(id);
    }

}
