package cn.itwanli.service;

import cn.itwanli.pojo.Lady;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LadyService {
    int doAddL(Lady lady);
    int doDelL(int lid);
    int doUpdL(Lady lady);

    Lady selByIdL(int lid);
    List<Lady> selByAllL();
    List<Lady> selByLikeL(String lname);

    List<Lady> showlist(int startIndex);
    int pagecount();
}
