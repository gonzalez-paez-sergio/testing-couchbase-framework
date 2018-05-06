package com.example.testingcouchbaseframework;

import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

import reactor.core.publisher.Mono;

@ViewIndexed(designDoc = "addAmType", viewName = "all")
public interface AddAmTypeRepository extends ReactiveCouchbaseRepository<AddAmType, String> {

	Mono<AddAmType> findByAddAmTypeCd(String addAmTypeCd);

}
