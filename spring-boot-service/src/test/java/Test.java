import com.alibaba.dubbo.common.json.JSON;
import com.hy.ServiceSpringBootApplication;
import com.hy.service.api.ServiceItemService;
import com.hy.service.dto.SvcServiceItemDTO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceSpringBootApplication.class)
public class Test {

    @Autowired
    private ServiceItemService serviceItemService;

    @org.junit.Test
    public void test() throws IOException {
        SvcServiceItemDTO svcServiceItemPO = serviceItemService.getSvcServiceItemPO(1);
        System.out.println(JSON.json(svcServiceItemPO));

    }
}
