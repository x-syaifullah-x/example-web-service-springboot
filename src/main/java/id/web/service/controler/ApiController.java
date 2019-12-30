package id.web.service.controler;

import id.web.service.db.remote.entity.Entity;
import id.web.service.db.remote.service.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Controller
public class ApiController {

    private Dao dao;

    public ApiController(Dao dao) {
        this.dao = dao;
    }

    @GetMapping("/api/page")
    @ResponseBody
    public Page<Entity> dataPage(Pageable page) {
        return dao.findAll(page);
    }

    @PostMapping("/api/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid Entity entity) {
        dao.save(entity);
    }
}
