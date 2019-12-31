package id.web.service.controler;

import id.web.service.db.remote.entity.Entity;
import id.web.service.db.remote.service.Dao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class ApiController {

    private Dao dao;

    public ApiController(Dao dao) {
        this.dao = dao;
    }

    @GetMapping("/api/list")
    @ResponseBody
    public Map<String, Iterable<Entity>> dataList() {
        Map<String, Iterable<Entity>> data = new LinkedHashMap<>();
        data.put("test", dao.findAll());
        return data;
    }

    @GetMapping("/api/page")
    @ResponseBody
    public Page<Entity> allPage(Pageable page) {
        return dao.findAll(page);
    }

    @PostMapping("/api/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid Entity entity) {
        dao.save(entity);
    }

    @DeleteMapping("/api/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteData(@PathVariable(name = "id") Entity entity) {
        if (entity != null) {
            dao.delete(entity);
        }
    }

    @PutMapping("/api/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateData(@PathVariable("id") Integer id, @RequestBody @Valid Entity input) {
        Optional<Entity> data = dao.findById(id);
        if (data.isPresent()) {
            BeanUtils.copyProperties(input, data.get());
            data.get().setId(id);
            dao.save(data.get());
        } else {
            System.out.println("not found");
        }
    }

    @GetMapping("/api/find/{id}")
    @ResponseBody
    public Optional<Entity> searchById(@PathVariable(name = "id") Integer id) {
        return dao.findById(id).isPresent() ? dao.findById(id) : Optional.empty();
    }
}
