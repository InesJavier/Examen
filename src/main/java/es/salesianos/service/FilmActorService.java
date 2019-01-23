package es.salesianos.service;

import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;

public class FilmActorService {
	
FilmActorRepository repository = new FilmActorRepository();
	
	public void insert(FilmActor filmActor) {
		repository.insert(filmActor);;
	}

}
