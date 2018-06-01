package hayaa.bussiness.service.core;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.bussiness.service.ICustomPersonService;
import hayaa.bussiness.service.model.CustomPerson;
import hayaa.bussiness.service.model.CustomPersonSearchPamater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customPersonService")
public class CustomPersonService implements ICustomPersonService {
    @Autowired
    private CustomPersonMapper customPersonMapper;

    @Override
    public FunctionResult<CustomPerson> Create(CustomPerson info) {
        FunctionResult<CustomPerson> r = new FunctionResult<CustomPerson>();
        customPersonMapper.insert(info);
        if (info.getCustomPersonId() > 0) {
            r.setData(info);
        }
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> UpdateByID(CustomPerson info) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        r.setData(customPersonMapper.update(info));
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> DeleteByID(List<Integer> list) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        String ids = list.toString().replace("[", "").replace("]", "");
        r.setData(customPersonMapper.delete(ids));
        return r;
    }

    @Override
    public GridPager<CustomPerson> GetPager(GridPagerPamater<CustomPersonSearchPamater> gridPagerPamater) {
        PageHelper.orderBy("CustomPersonId desc");
        Page pageInfo = PageHelper.startPage(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        List<CustomPerson> dalResult = customPersonMapper.getList(gridPagerPamater.getSearchPamater());
        GridPager<CustomPerson> r = new GridPager<>(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        r.setData(dalResult);
        r.setTotal((int) pageInfo.getTotal());
        return r;
    }

    @Override
    public FunctionResult<CustomPerson> Get(int id) {
        FunctionResult<CustomPerson> r = new FunctionResult<CustomPerson>();
        r.setData(customPersonMapper.get(id));
        return r;
    }

    @Override
    public FunctionListResult<CustomPerson> GetList(CustomPersonSearchPamater searchPamater) {
        FunctionListResult<CustomPerson> r = new FunctionListResult<CustomPerson>();
        r.setData(customPersonMapper.getList(searchPamater));
        return r;
    }
}