// 一个配置项，可以配置跨域之类的，这个也没想好怎么写，先等着
// 这边写得不是很熟悉，有些地方会报错，日后再说
//package springCloud.config;
//
//import springCloud.utils.LoginFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    /**
//     * web安全配置
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .cors().configurationSource(corsConfiguration()).and();// 配置 CorsFilter 配置信息
////                .addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);//继承UsernamePasswordAuthenticationFilter，替换原来的UsernamePasswordAuthenticationFilter
//
//    }
//
//    /**
//     * Cors 的配置信息 配置+路径
//     */
//    CorsConfigurationSource corsConfiguration() {
//        // Cors配置类
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(false); // 是否返回时生成凭证
//        corsConfiguration.setAllowedHeaders(Arrays.asList("*")); // 允许请求携带哪些请求头信息
//        corsConfiguration.setAllowedMethods(Arrays.asList("*")); // 允许哪些类型的请求方法
//        corsConfiguration.setAllowedOrigins(Arrays.asList("*")); // 允许哪些域可以进行方法
//        corsConfiguration.setMaxAge(3600L); // 设置预检的最大的时长
//        corsConfiguration.setExposedHeaders(Collections.emptyList()); // 设置返回暴露的响应头信息
//
//        // 设置注册URL 配置类
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//
//        return source;
//    }
//
//    @Bean
//    LoginFilter loginFilter() throws Exception {
//        LoginFilter loginFilter = new LoginFilter();
//        //设置认证成功返回
////        loginFilter.setAuthenticationSuccessHandler(new MyAuthenticationSuccessHandler());
//        //设置认证失败返回
////        loginFilter.setAuthenticationFailureHandler(new MyAuthenticationFailureHandler());
//        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
//        loginFilter.setAuthenticationManager(authenticationManagerBean());
////        loginFilter.setRememberMeServices(myPersistentTokenBasedRememberMeServices());
//        loginFilter.setFilterProcessesUrl("/login");
//        return loginFilter;
//    }
//}