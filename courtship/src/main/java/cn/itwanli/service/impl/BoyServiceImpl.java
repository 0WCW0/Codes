package cn.itwanli.service.impl;

import cn.itwanli.dao.BoyDao;
import cn.itwanli.pojo.Boy;
import cn.itwanli.service.BoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoyServiceImpl implements BoyService {
    @Autowired
    private BoyDao boyDao;

    public void setBoyDao(BoyDao boyDao) {
        this.boyDao = boyDao;
    }

    @Override
    public int doAddB(Boy boy) {
        return this.boyDao.doAddB(boy);
    }

    @Override
    public int doDelB(int bid) {
        return this.boyDao.doDelB(bid);
    }

    @Override
    public int doUpdB(Boy boy) {
        return this.boyDao.doUpdB(boy);
    }

    @Override
    public Boy selByIdB(int bid) {
        return this.boyDao.selByIdB(bid);
    }

    @Override
    public List<Boy> selByAllB() {
        return this.boyDao.selByAllB();
    }

    @Override
    public List<Boy> selByLikeB(String bname) {
        return this.boyDao.selByLikeB(bname);
    }

    @Override
    public List<Boy> showlist(int startIndex) {
        return this.boyDao.showlist(startIndex);
    }

    @Override
    public int pagecount() {
        return this.boyDao.pagecount();
    }
}
