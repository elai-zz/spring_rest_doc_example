package hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by estella on 5/30/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
public class HelloControllerTest {

    private MockMvc mockMVC;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() throws Exception {
        this.mockMVC = MockMvcBuilders.standaloneSetup(context).build();
    }

    @Test
    public void TestNormalGreeting() throws Exception {
        this.mockMVC.perform(get("/greeting"))
                .andExpect(status().isOk());

    }
}
