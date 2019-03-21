package com.kodillapatterns2.aop.calculator;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    /**
     * @Before - zdarzenie występuje każdorazowo przed wywołaniem metody
     * @AfterReturning - zdarzenie występuje po zwróceniu wartości przez metodę w sytuacji gdy zakończyła się bez błędu
     * @AfterThrowing - zdarzenie występujące po tym jak metoda rzuci wyjątkiem
     * @After - występuje zawsze po zakończeniu wykonywania metody bez względu na to czy wykonanie zakończyło się pomyślnie, czy też rzuciło wyjątek
     * @Around - specjalne zdarzenie "otaczające" wywołanie metody - omówimy je dokładniej nieco dalej
     *
     * Definiujemy więc tutaj zwany punkt przecięcia (ang. pointcut). Punkty przecięcia definiuje się przy pomocy tak
     * zwanych wyrażeń przecięcia AspectJ. Podstawowe wyrażenie przecięcia ma następującą strukturę:
     *
     * <expression>([<method_scope>] <return_type>
     * <qualified_class_name>.<method>(<parameters>))
     *
     * Na przykład:
     * execution(* *(..)) - dla każdej metody każdej klasy
     * execution(public * com.kodilla.myClass.myMethod(java.lang.String)) - dla każdej publicznej metody o nazwie myMethod w klasie myClass (bez względu na typ zwracanego wyniku), przyjmującej jeden argument typu String
     * execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..)) - metody factorial() klasy Calculator.
     */

    @Before("execution(* com.kodillapatterns2.aop.calculator.Calculator.factorial(..))" +
    "&& args(theNumber) && target(object)")
    public void logEvent(BigDecimal theNumber, Object object) { // wyrażenie args(...), które pozwala przekazać do wskazanej zmiennej argumenty jakich użyto do wywołania metody, na której załączany jest aspekt.
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + theNumber);
    }

    /**
     * Adnotacja @Around przyjmuje takie same argumenty jak adnotacja @Before. Inna jest jednak konstrukcja samej metody:     *
     * Metoda aspektu musi zwracać obiekt
     * Metoda aspektu przyjmuje parametr ProceedingJoinPoint proceedingJoinPoint
     *
     *  proceedingJoinPoint reprezentuje "uchwyt" do przechwyconej metody. Obiekt ten posiada metodę proceed(), która powoduje uruchomienie przechwyconej metody.
     *  Wynik jej wywołania należy zwrócić przy pomocy return.
     *
     *
     */

    @Around("execution(* com.kodillapatterns2.aop.calculator.Calculator.factorial(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try{
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed: " + (end - begin) + "[ms]");
        } catch(Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }

        return result;
    }



}
