package com.kodillapatterns2.aop.facade;

import com.kodillapatterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before("execution(* com.kodillapatterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(orderDto, id) && target(object)")
    public void logEvent(OrderDto orderDto, Long id, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args[ orderDto: " + orderDto.hashCode() + ", user id: " + id + " ]" );
    }
}
