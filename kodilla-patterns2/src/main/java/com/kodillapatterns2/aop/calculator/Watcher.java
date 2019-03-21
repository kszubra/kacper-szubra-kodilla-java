package com.kodillapatterns2.aop.calculator;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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

    @Before("execution(* com.kodillapatterns2.aop.calculator.Calculator.factorial(..))")
    public void logEvent() {
        LOGGER.info("Logging the event");
    }
}
