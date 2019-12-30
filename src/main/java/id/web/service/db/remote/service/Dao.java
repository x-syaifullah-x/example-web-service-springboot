package id.web.service.db.remote.service;

import id.web.service.db.remote.entity.Entity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Dao extends PagingAndSortingRepository<Entity, Integer> {

}
