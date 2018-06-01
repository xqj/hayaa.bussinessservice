package hayaa.bussiness.service.core;

import java.util.Map;

public class DataConfig {
    private Map<String, Object> DbConfig = null;

    public DataConfig() {
        DbConfig = ConfigHelper.getInstance().getDataConfig(DefineTable.DatabaseName);
    }

    public Map<String, Object> getConfig() {
        return DbConfig;
    }
}
