import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Bootstrap extends Job {
    @Override
    public void doJob() throws Exception {
        // if (User.count() == 0 && Play.mode.isDev()) {
        // Fixtures.deleteAllModels();
        // Fixtures.loadModels("auth-data.yml");
        // Fixtures.loadModels("init-data.yml");
        // }
    }
}
