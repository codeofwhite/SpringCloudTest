// 是一个Login的一个过滤器，还没想好怎么写
//package springCloud.utils;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
///**
// * @author 独照
// * @version 1.0
// * @date 2020/11/17 13:50
// */
//public class LoginFilter extends UsernamePasswordAuthenticationFilter {
//
//    Logger logger = LoggerFactory.getLogger(LoginFilter.class);
//
//
////    @Autowired
////    private RedisCache redisCache;
////    redis工具类
//
//    /**
//     * @param request
//     * @param response
//     * @return
//     * @throws AuthenticationException
//     * @describe 重写attemptAuthentication方法, 应为前端使用axios发送ajax请求, 通过fastJson 读取request流中的登录信息，
//     * 后续步骤同其父类类似，因为实现了RememberMe功能，而在后面的AbstractRememberMeServices中是通过request.getParameter(parameter)获取记住我参数，
//     * 而我们在后端不好对request的parameter进行手动添加参数，因此我们使用request.setAttribute("remember-me",rememberMe);进行传参，后面通过重写AbstractRememberMeServices
//     * 的rememberMeRequested(HttpServletRequest request, String parameter)方法来接收参数
//     */
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        if (!request.getMethod().equals("POST")) {//请求不为Post方式
//            throw new AuthenticationServiceException(
//                    "Authentication method not supported: " + request.getMethod());
//        }
////        if(request.getContentType()==null){//使用PostMan发送表单登录时会出现空指针异常
////            throw new LoginMethodException();
////        }
//        logger.error("request.getContentType()--->" + request.getContentType());
//        logger.error("类型比较:" + request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE));
//        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE) || request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_UTF8_VALUE)) {
//            //如果是Json数据格式请求登录
//            String jsonData = getJsonParam(request);
//            JSONObject jsonObject = JSON.parseObject(jsonData);
////            String verifyCodeKey = jsonObject.getString("uuid");//获取前端传来的uuid
////            if (verifyCodeKey == null) {
////                verifyCodeKey = "";
////            }
////            String verifyCodeValue = (String) redisUtil.get(verifyCodeKey);//得到存储在redis中的验证码
////            String verifyCodeOfUser = jsonObject.getString("captcha");//用户传来的验证码
////            if (verifyCodeOfUser == null) {
////                verifyCodeOfUser = "";
////            }
////            checkVerifyCode(verifyCodeOfUser, verifyCodeValue);//校验验证是否正确
//            String username = jsonObject.getString("username");//获取用户名
//            String password = jsonObject.getString("password");//密码
//            String rememberMe = jsonObject.getString("rememberMe");//记住我
//            username = username.trim();
//            request.setAttribute("remember-me", rememberMe);//设置ememberMe
//            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
//            setDetails(request, authRequest);
//            return this.getAuthenticationManager().authenticate(authRequest);
////        }else{
//////            throw new LoginMethodException();//禁止使用非application/json格式的登录方式
////        }
//        }
//        return null;
//    }
//
//
////    public void checkVerifyCode(String verifyCodeOfUser, String verifyCodeOfRedis){
////        if(StringUtils.isEmpty(verifyCodeOfRedis)){
////            throw new VerifyCodeTimeOutException();
////        }else if(!verifyCodeOfRedis.equalsIgnoreCase(verifyCodeOfUser)){
////            throw new VerifyCodeException();
////        }
////    }
//
//    /**
//     * 获取HttpServletRequest中的Json数据
//     *
//     * @param request
//     * @return
//     */
//    private String getJsonParam(HttpServletRequest request) {
//        String jsonParam = "";
//        ServletInputStream inputStream = null;
//        try {
//            int contentLength = request.getContentLength();
//            if (!(contentLength < 0)) {
//                byte[] buffer = new byte[contentLength];
//                inputStream = request.getInputStream();
//                for (int i = 0; i < contentLength; ) {
//                    int len = inputStream.read(buffer, i, contentLength);
//                    if (len == -1) {
//                        break;
//                    }
//                    i += len;
//                }
//                jsonParam = new String(buffer, "utf-8");
//            }
//        } catch (IOException e) {
//            logger.error("参数转换成json异常g{}", e);
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    logger.error("参数转换成json异常s{}", e);
//                }
//            }
//        }
//        return jsonParam;
//    }
//}
//