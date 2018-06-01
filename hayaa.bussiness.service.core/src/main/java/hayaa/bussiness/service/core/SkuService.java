package hayaa.bussiness.service.core;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.bussiness.service.ISkuService;
import hayaa.bussiness.service.model.Sku;
import hayaa.bussiness.service.model.SkuSearchPamater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("skuService")
public class SkuService implements ISkuService {
    @Autowired
    private SkuMapper skuMapper;

    @Override
    public FunctionResult<Sku> Create(Sku info) {
        FunctionResult<Sku> r = new FunctionResult<Sku>();
        skuMapper.insert(info);
        if (info.getSkuId() > 0) {
            r.setData(info);
        }
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> UpdateByID(Sku info) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        r.setData(skuMapper.update(info));
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> DeleteByID(List<Integer> list) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        String ids = list.toString().replace("[", "").replace("]", "");
        r.setData(skuMapper.delete(ids));
        return r;
    }

    @Override
    public GridPager<Sku> GetPager(GridPagerPamater<SkuSearchPamater> gridPagerPamater) {
        PageHelper.orderBy("SkuId desc");
        Page pageInfo = PageHelper.startPage(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        List<Sku> dalResult = skuMapper.getList(gridPagerPamater.getSearchPamater());
        GridPager<Sku> r = new GridPager<>(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        r.setData(dalResult);
        r.setTotal((int) pageInfo.getTotal());
        return r;
    }

    @Override
    public FunctionResult<Sku> Get(int id) {
        FunctionResult<Sku> r = new FunctionResult<Sku>();
        r.setData(skuMapper.get(id));
        return r;
    }

    @Override
    public FunctionListResult<Sku> GetList(SkuSearchPamater searchPamater) {
        FunctionListResult<Sku> r = new FunctionListResult<Sku>();
        r.setData(skuMapper.getList(searchPamater));
        return r;
    }
}