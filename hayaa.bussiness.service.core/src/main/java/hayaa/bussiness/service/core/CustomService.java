package hayaa.bussiness.service.core;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.bussiness.service.ICustomService;
import hayaa.bussiness.service.model.Custom;
import hayaa.bussiness.service.model.CustomSearchPamater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customService")
public class CustomService implements ICustomService {
    @Autowired
    private CustomMapper customMapper;

    @Override
    public FunctionResult<Custom> Create(Custom info) {
        FunctionResult<Custom> r = new FunctionResult<Custom>();
        customMapper.insert(info);
        if (info.getCustomId() > 0) {
            r.setData(info);
        }
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> UpdateByID(Custom info) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        r.setData(customMapper.update(info));
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> DeleteByID(List<Integer> list) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        String ids = list.toString().replace("[", "").replace("]", "");
        r.setData(customMapper.delete(ids));
        return r;
    }

    @Override
    public GridPager<Custom> GetPager(GridPagerPamater<CustomSearchPamater> gridPagerPamater) {
        PageHelper.orderBy("CustomId desc");
        Page pageInfo = PageHelper.startPage(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        List<Custom> dalResult = customMapper.getList(gridPagerPamater.getSearchPamater());
        GridPager<Custom> r = new GridPager<>(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        r.setData(dalResult);
        r.setTotal((int) pageInfo.getTotal());
        return r;
    }

    @Override
    public FunctionResult<Custom> Get(int id) {
        FunctionResult<Custom> r = new FunctionResult<Custom>();
        r.setData(customMapper.get(id));
        return r;
    }

    @Override
    public FunctionListResult<Custom> GetList(CustomSearchPamater searchPamater) {
        FunctionListResult<Custom> r = new FunctionListResult<Custom>();
        r.setData(customMapper.getList(searchPamater));
        return r;
    }
}