package goku.restful.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import goku.restful.dto.UserRegisterRequest;
import goku.restful.dto.WebResponse;
import goku.restful.repository.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
      @Autowired
      private MockMvc mockMvc;

      @Autowired
      private UserRepository userRepository;

      @Autowired
      private ObjectMapper objectMapper;

      @BeforeEach
      void setUp() {
            userRepository.deleteAll();
      }

      @Test
      void testRegisterSuccess() throws Exception {
            UserRegisterRequest request = new UserRegisterRequest();
            request.setEmail("test@gmail.com");
            request.setPassword("rahasia");
            request.setUsername("test");

            mockMvc.perform(post("/api/users/register")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                        .andExpectAll(
                                    status().isOk())
                        .andDo(result -> {
                              WebResponse<String> response = objectMapper.readValue(
                                          result.getResponse().getContentAsString(),
                                          new TypeReference<WebResponse<String>>() {
                                          });
                              assertEquals("OK!", response.getData());
                        });
      }
}
