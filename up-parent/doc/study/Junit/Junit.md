### Junit 使用

* 1.spring项目中
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/spring-context.xml")
public class MailServiceImplTest {
    @Autowired
    MailService mailService;
   
     @Test
     public void testMethod() throws Exception {
     
        }
    }
 ```
 * 2.springboot项目中
 ```
 //SpringJUnit支持，由此引入Spring-Test框架支持！
 @RunWith(SpringJUnit4ClassRunner.class) 
 // 指定我们SpringBoot工程的Application启动类
 @SpringApplicationConfiguration(classes = SpringBootSampleApplication.class)
 // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
 @WebAppConfiguration

 
 //对于controller的测试需要声明：
 private MockMvc mvc;  
 

  @Test  
     public void getGitHubEntityByUsername() throws Exception {  
         MvcResult result = mvc.perform(  
                 MockMvcRequestBuilders.get("/github/get/users/Datartisan")  
                         .accept(MediaType.APPLICATION_JSON))  
                         .andReturn();  
         int statusCode = result.getResponse().getStatus();  
         Assert.assertEquals(statusCode, 200);  
         String body = result.getResponse().getContentAsString();  
         System.out.println("body:"+body);  
     }  
       
     /** 
      * attention: 
      * Details：测试查询 
      * @author chhliu 
      * 创建时间：2016-12-7 下午3:41:49 
      * @throws Exception 
      * void 
      */  
     @Test  
     public void getGitHubEntityById() throws Exception {  
         MvcResult result = mvc.perform(  
                 MockMvcRequestBuilders.get("/github/get/user/721")  
                         .accept(MediaType.APPLICATION_JSON))  
                         .andReturn();  
         int statusCode = result.getResponse().getStatus();  
         Assert.assertEquals(statusCode, 200);  
         String body = result.getResponse().getContentAsString();  
         System.out.println("body:"+body);  
     }  
       
     /** 
      * attention: 
      * Details：测试分页查询 
      * @author chhliu 
      * 创建时间：2016-12-7 下午3:42:02 
      * @throws Exception 
      * void 
      */  
     @Test  
     public void getGitHubEntityPage() throws Exception {  
         MvcResult result = mvc.perform(  
                 MockMvcRequestBuilders.get("/github/get/users/page").param("pageOffset", "0")  
                         .param("pageSize", "10").param("orderColumn", "id").accept(MediaType.APPLICATION_JSON))  
                         .andReturn();  
         int statusCode = result.getResponse().getStatus();  
         Assert.assertEquals(statusCode, 200);  
         String body = result.getResponse().getContentAsString();  
         System.out.println("body:"+body);  
     }  
       
     /** 
      * attention: 
      * Details：测试插入，方式一，此方式需要controller中方法参数前没有@RequestBody 
      * @author chhliu 
      * 创建时间：2016-12-7 下午3:42:19 
      * @throws Exception 
      * void 
      */  
     @Test  
     public void postGithubEntity() throws Exception{  
         RequestBuilder request = MockMvcRequestBuilders.post("/github/post")  
                 .param("codeSnippet", "package")  
                 .param("codeUrl", "http://localhost:8080/code")  
                 .param("projectUrl", "http://localhost:8080")  
                 .param("userName", "chhliu")  
                 .param("sensitiveMessage", "love")  
                 .param("spriderSource", "CSDN")  
                 .contentType(MediaType.APPLICATION_JSON_UTF8);  
         MvcResult result = mvc.perform(request)  
                         .andReturn();  
         int statusCode = result.getResponse().getStatus();  
         Assert.assertEquals(statusCode, 200);  
         String body = result.getResponse().getContentAsString();  
         System.out.println("body:"+body);  
     }  
       
     /** 
      * attention: 
      * Details：测试插入，方式二，此方式需要controller中方法参数前加@RequestBody 
      * @author chhliu 
      * 创建时间：2016-12-7 下午3:42:19 
      * @throws Exception 
      * void 
      */  
     @Test  
     public void postGithubEntity1() throws Exception{  
         GitHubEntity entity = new GitHubEntity();  
         entity.setUserName("xyhg");  
         entity.setSpriderSource("ITeye");  
         entity.setCodeUrl("http://localhost:8080");  
         ObjectMapper mapper = new ObjectMapper();  
         MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/github/post")  
                         .contentType(MediaType.APPLICATION_JSON_UTF8)  
                         .content(mapper.writeValueAsString(entity)))  
                         .andExpect(MockMvcResultMatchers.status().isOk())  
                         .andReturn();  
         int statusCode = result.getResponse().getStatus();  
         Assert.assertEquals(statusCode, 200);  
         String body = result.getResponse().getContentAsString();  
         System.out.println("body:"+body);  
     }  
       
     /** 
      * attention: 
      * Details：测试更新和插入类似 
      * @author chhliu 
      * 创建时间：2016-12-7 下午3:42:32 
      * @throws Exception 
      * void 
      */  
     @Test  
     public void putGithubEntity() throws Exception{  
         RequestBuilder request = MockMvcRequestBuilders.put("/github/put")  
                 .param("id", "719")  
                 .param("codeSnippet", "import java.lang.exception")  
                 .param("codeUrl", "http://localhost:8080/code")  
                 .param("projectUrl", "http://localhost:8080")  
                 .param("userName", "xyh")  
                 .param("sensitiveMessage", "love")  
                 .param("spriderSource", "CSDN");  
         MvcResult result = mvc.perform(request)  
                         .andReturn();  
         int statusCode = result.getResponse().getStatus();  
         Assert.assertEquals(statusCode, 200);  
         String body = result.getResponse().getContentAsString();  
         System.out.println("body:"+body);  
     }  
       
     @Test  
     public void deleteGithubEntity() throws Exception{  
         RequestBuilder request = MockMvcRequestBuilders.delete("/github/delete/719");  
         MvcResult result = mvc.perform(request)  
                         .andReturn();  
         int statusCode = result.getResponse().getStatus();  
         Assert.assertEquals(statusCode, 200);  
         String body = result.getResponse().getContentAsString();  
         System.out.println("body:"+body);  
     }  
 
 
 
 
 
 
 
 
 
  ```