package cn.itwanli.service;

import cn.itwanli.pojo.Boy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoyService {
    int doAddB(Boy boy);
    int doDelB(int bid);
    int doUpdB(Boy boy);

    Boy selByIdB(int bid);
    List<Boy> selByAllB();
    List<Boy> selByLikeB(String bname);

    List<Boy> showlist(int startIndex);
    int pagecount();
}
