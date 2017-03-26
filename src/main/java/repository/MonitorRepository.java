package repository;

import model.monitoria.Monitor;

/**
 * Created by Dayvson on 12/03/2017.
 */
public class MonitorRepository extends RepositoryBase<Monitor> {
    public MonitorRepository() {
        super(Monitor.class);
    }
}
