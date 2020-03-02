package savadrox.project.Repositories;

import org.springframework.data.repository.CrudRepository;
import savadrox.project.models.Engine;

public interface RepositoryEngine extends CrudRepository<Engine,Integer> {
}
