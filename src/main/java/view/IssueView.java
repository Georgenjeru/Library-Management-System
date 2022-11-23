package view;




import com.bean.IssueBeanI;
import com.model.Issue;

import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("IssueView")
public class IssueView implements Serializable {
    @EJB
    private IssueBeanI issueBean;

    public List<Issue> getList() throws Exception {
        return issueBean.getList();
    }

}


