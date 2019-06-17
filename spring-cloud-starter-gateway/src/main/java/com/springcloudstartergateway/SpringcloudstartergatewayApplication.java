package com.springcloudstartergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@SpringBootApplication
@RestController
public class SpringcloudstartergatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudstartergatewayApplication.class, args);
    }

   //lamda形式
    /* @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World").addRequestParameter("zhang","121"))
                        .uri("http://httpbin.org:80"))
                .build();
    }*/
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        /**
         * p -> p
         *  .path("/get")
         *  .filters(f -> f.addRequestHeader("Hello", "World").addRequestParameter("zhang","121"))
         *  .uri("http://httpbin.org:80")
         */
        return builder.routes()
                .route(new Function<PredicateSpec, Route.AsyncBuilder>() {
                    @Override
                    public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
                        Route.AsyncBuilder uri = predicateSpec.path("/get").filters(new Function<GatewayFilterSpec, UriSpec>() {
                            @Override
                            public UriSpec apply(GatewayFilterSpec gatewayFilterSpec) {
                                return gatewayFilterSpec.addRequestHeader("Hello", "World").addRequestParameter("zhang", "121");
                                //return null;
                            }
                        }).uri("http://httpbin.org:80");
                        return uri;
                    }
                })
                .build();
    }
   /*@Bean
   public RouteLocator myRoutes(RouteLocatorBuilder builder) {
       String httpUri = "http://httpbin.org:80";
       return builder.routes()
               .route(p -> p
                       .path("/get")
                       .filters(f -> f.addRequestHeader("Hello", "World"))
                       .uri(httpUri))
               .route(p -> p
                       .host("*.hystrix.com")
                       .filters(f -> f
                               .hystrix(config -> config
                                       .setName("mycmd")
                                       .setFallbackUri("forward:/fallback")))
                       .uri(httpUri))
               .build();
   }
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
*/
}
