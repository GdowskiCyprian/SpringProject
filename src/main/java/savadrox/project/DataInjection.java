package savadrox.project;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import savadrox.project.Repositories.RepositoryEngine;
import savadrox.project.Repositories.RepositoryPojazdElektryczny;
import savadrox.project.Repositories.RepositoryPojazdSpalinowy;
import savadrox.project.models.Engine;
import savadrox.project.models.PojazdElektryczny;
import savadrox.project.models.PojazdSpalinowy;

@Component
public class DataInjection implements ApplicationListener<ContextRefreshedEvent> {

    public RepositoryPojazdElektryczny repositoryPojazdElektryczny;
    public RepositoryPojazdSpalinowy repositoryPojazdSpalinowy;
    public RepositoryEngine repositoryEngine;
    public DataInjection(RepositoryEngine repositoryEngine, RepositoryPojazdElektryczny repositoryPojazdElektryczny, RepositoryPojazdSpalinowy repositoryPojazdSpalinowy) {
        this.repositoryEngine = repositoryEngine;
        this.repositoryPojazdElektryczny = repositoryPojazdElektryczny;
        this.repositoryPojazdSpalinowy = repositoryPojazdSpalinowy;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Engine engine = new Engine("M54B25", 2495,192);
        repositoryEngine.save(engine);
        PojazdElektryczny tesla = new PojazdElektryczny("tesla",4,200, 600,500);
        PojazdSpalinowy BMW = new PojazdSpalinowy("BMW",4,240,"RWD","LPG", engine);
        PojazdElektryczny leaf = new PojazdElektryczny("leaf",4,200,500,500);
        PojazdElektryczny kona = new PojazdElektryczny("kona",4,250,300,100);
        repositoryPojazdElektryczny.save(tesla);
        repositoryPojazdElektryczny.save(leaf);
        repositoryPojazdElektryczny.save(kona);
        repositoryPojazdSpalinowy.save(BMW);
    }
}
