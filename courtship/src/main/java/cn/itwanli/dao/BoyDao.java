package cn.itwanli.dao;

import cn.itwanli.pojo.Boy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoyDao {
    int doAddB(Boy boy);
    int doDelB(int bid);
    int doUpdB(Boy boy);

    Boy selByIdB(int bid);
    List<Boy> selByAllB();
    List<Boy> selByLikeB(String bname);

    List<Boy> showlist(int startIndex);
    int pagecount();
}
