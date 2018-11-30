import com.ccb.mahm.core.dao.UserMapper;
import com.ccb.mahm.core.service.UserService;
import com.ccb.mahm.web.config.ProviderApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ProviderApplication.class})// 指定启动类
@AutoConfigureMockMvc  //测试接口用
public class ProviderApplicationTest {


    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        // 构造MockMvc
        mvc = MockMvcBuilders.webAppContextSetup(context).build();

    }
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;





    @Test
    public void testSerivce(){
        System.out.println(userService.findAllUser(1,10));

    }
    @Test
    public void testMapper(){
        System.out.println(userMapper.selectUsers());
             //简单验证结果集是否正确
        Assert.assertEquals(0, userMapper.selectUsers().size());
    }

    @Test
    public void testContorller() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/all"))
                .andExpect(status().isOk())// 判断接收到的状态是否是200（静态导入）
                .andDo(print());// 打印请求和响应的详情

    }



}
