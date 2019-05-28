package cn.itwanli.dao;

import cn.itwanli.pojo.Lady;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LadyDao {
    int doAddL(Lady lady);
    int doDelL(int lid);
    int doUpdL(Lady lady);

    Lady selByIdL(int lid);
    List<Lady> selByAllL();
    List<Lady> selByLikeL(String lname);

    List<Lady> showlist(int startIndex);
    int pagecount();
}
