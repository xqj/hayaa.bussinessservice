package hayaa.bussiness.service.core;

import Hayaa.ConfigSeed.ConfigTool;

class ConfigHelper extends ConfigTool<BussinessConfig, BussinessConfigRoot> {
    public static ConfigHelper getInstance() {
        return _instance;
    }

    private static ConfigHelper _instance = new ConfigHelper();

    private ConfigHelper() {
        super(DefineTable.BussinessServiceComponentID, BussinessConfig.class, BussinessConfigRoot.class);
    }
}
