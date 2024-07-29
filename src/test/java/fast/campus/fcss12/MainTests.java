package fast.campus.fcss12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class MainTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloPost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/hello"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testHelloPostWithCsrf() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/hello")
                        .with(csrf()))
                .andExpect(status().isOk());
    }
}
