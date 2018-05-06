package com.example.testingcouchbaseframework;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class AddAmTypeHandler {

	private final AddAmTypeRepository addAmTypeRepository;

//	@Autowired
	public AddAmTypeHandler(AddAmTypeRepository addAmTypeRepository) {
		this.addAmTypeRepository = addAmTypeRepository;
	}

	public Mono<ServerResponse> allOrQuery(ServerRequest serverRequest) {

		Optional<String> queryParameters = serverRequest.queryParam("theParam");

		if (serverRequest.queryParams().size() == 0) {
			return ServerResponse.ok().body(this.addAmTypeRepository.findAll(), AddAmType.class);

		}

		if (serverRequest.queryParams().size() == 1 && queryParameters.isPresent()) {
			return this.addAmTypeRepository.findByAddAmTypeCd(queryParameters.get())
					.flatMap(addAmType -> ServerResponse.ok().body(Mono.just(addAmType), AddAmType.class))
					.switchIfEmpty(ServerResponse.notFound().build());
		}

		return ServerResponse.badRequest().build();
	}

	public Mono<ServerResponse> get(ServerRequest serverRequest) {
		return this.addAmTypeRepository.findById(serverRequest.pathVariable("id"))
				.flatMap(addAmType -> ServerResponse.ok().body(Mono.just(addAmType), AddAmType.class))
				.switchIfEmpty(ServerResponse.notFound().build())

		;

	}
}
