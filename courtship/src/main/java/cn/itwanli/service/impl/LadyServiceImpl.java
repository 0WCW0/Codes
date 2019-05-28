package cn.itwanli.service.impl;

import cn.itwanli.dao.LadyDao;
import cn.itwanli.pojo.Lady;
import cn.itwanli.service.LadyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LadyServiceImpl implements LadyService {
    @Autowired
    private LadyDao ladyDao;

    public void setLadyDao(LadyDao ladyDao) {
        this.ladyDao = ladyDao;
    }

    @Override
    public int doAddL(Lady lady) {
        return this.ladyDao.doAddL(lady);
    }

    @Override
    public int doDelL(int lid) {
        return this.ladyDao.doDelL(lid);
    }

    @Override
    public int doUpdL(Lady lady) {
        return this.ladyDao.doUpdL(lady);
    }

    @Override
    public Lady selByIdL(int lid) {
        return this.ladyDao.selByIdL(lid);
    }

    @Override
    public List<Lady> selByAllL() {
        return this.ladyDao.selByAllL();
    }

    @Override
    public List<Lady> selByLikeL(String lname) {
        return this.ladyDao.selByLikeL(lname);
    }

    @Override
    public List<Lady> showlist(int startIndex) {
        return this.ladyDao.showlist(startIndex);
    }

    @Override
    public int pagecount() {
        return this.ladyDao.pagecount();
    }
}
