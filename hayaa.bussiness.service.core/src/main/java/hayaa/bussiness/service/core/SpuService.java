package hayaa.bussiness.service.core;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.bussiness.service.ISpuService;
import hayaa.bussiness.service.model.Spu;
import hayaa.bussiness.service.model.SpuSearchPamater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("spuService")
public class SpuService implements ISpuService {
    @Autowired
    private SpuMapper spuMapper;

    @Override
    public FunctionResult<Spu> Create(Spu info) {
        FunctionResult<Spu> r = new FunctionResult<Spu>();
        spuMapper.insert(info);
        if (info.getSpuId() > 0) {
            r.setData(info);
        }
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> UpdateByID(Spu info) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        r.setData(spuMapper.update(info));
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> DeleteByID(List<Integer> list) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        String ids = list.toString().replace("[", "").replace("]", "");
        r.setData(spuMapper.delete(ids));
        return r;
    }

    @Override
    public GridPager<Spu> GetPager(GridPagerPamater<SpuSearchPamater> gridPagerPamater) {
        PageHelper.orderBy("SpuId desc");
        Page pageInfo = PageHelper.startPage(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        List<Spu> dalResult = spuMapper.getList(gridPagerPamater.getSearchPamater());
        GridPager<Spu> r = new GridPager<>(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        r.setData(dalResult);
        r.setTotal((int) pageInfo.getTotal());
        return r;
    }

    @Override
    public FunctionResult<Spu> Get(int id) {
        FunctionResult<Spu> r = new FunctionResult<Spu>();
        r.setData(spuMapper.get(id));
        return r;
    }

    @Override
    public FunctionListResult<Spu> GetList(SpuSearchPamater searchPamater) {
        FunctionListResult<Spu> r = new FunctionListResult<Spu>();
        r.setData(spuMapper.getList(searchPamater));
        return r;
    }
}