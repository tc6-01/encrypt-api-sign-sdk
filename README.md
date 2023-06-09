# encrypt-api-sign-sdk

## BAPI Client 简单介绍
实现客户端API签名加密

简单的模拟了接口调用的过程

其中内置的api在`com.beeran.bapiclient.client.BAPIClient`中
> getUsernameByPost 实现将用户传入的Key与密钥进行签名后添加进请求头中
> 
> getHeaderMap 实现用户的Key与密钥封装---使用HashMap进行保存
> 
> 另外两个方法，用于测试是否可以正常进行网络请求，并未进行加密

加密代码在`com.beeran.baiclient.Utils.SignUtils`中
> getSign 实现将用户信息与密钥一同进行加密


## usage 用法简介

引入依赖
```xml
<dependency>
    <groupId>com.BeerAn</groupId>
    <artifactId>BAPI-CLIENT</artifactId>
    <version>0.0.1</version>
</dependency>
```
在yml配置文件中添加配置
```yml
bapi:
  client:
    # 使用的key与密钥
    access-key: xxxxx
    secret-key: xxxxx
```
在相关代码中进行调用
```java

/**
 * 调用开发者名字接口
 */
@RestController
@RequestMapping("/")
public class NameController {
    @Resource
    private BAPIClient bapiClient;
    @PostMapping("/UserName")
    String getUserNameByPost(@RequestBody User user){
        String usernameByPost = bapiClient.getUsernameByPost(user);
        return "PostJson 你的名字是" + usernameByPost;
    }
}
```

用来进行模拟用户调用接口的API