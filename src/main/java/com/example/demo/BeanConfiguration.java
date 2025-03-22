package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class BeanConfiguration {

    @Bean
    public B createBBean()
    {
        return new B("B's first bean");
    }

  @Bean
    public B createAnotherBBean()
    {
        return new B("B's second bean");
    }

    @Bean
public C createCBean(A a, @Qualifier("createBBean") B b)
{
    return new C(a,b,10);
}
}
