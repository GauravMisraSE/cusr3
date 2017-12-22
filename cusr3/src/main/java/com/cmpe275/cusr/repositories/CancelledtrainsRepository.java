package com.cmpe275.cusr.repositories;

import com.cmpe275.cusr.model.Cancelledtrains;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CancelledtrainsRepository extends CrudRepository<Cancelledtrains, Long> {

}
