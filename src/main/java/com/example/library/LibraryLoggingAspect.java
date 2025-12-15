package com.example.library;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // Позначає цей клас як Аспект
@Component // Реєструє клас як Spring-бін
public class LibraryLoggingAspect {

    // ----------------------------------------------------------------------
    // 1. POINTCUTS (Мінімум 3)
    // ----------------------------------------------------------------------

    // Pointcut 1: Для будь-якого методу, що починається з 'show' у пакеті library
    @Pointcut("execution(* com.example.library.*.show*(..))")
    private void forShowMethods() {}

    // Pointcut 2: Для будь-якого методу в класі Book
    @Pointcut("execution(* com.example.library.Book.*(..))")
    private void forBookClass() {}

    // Pointcut 3: Для методів, які приймають аргумент типу Book
    @Pointcut("args(book, ..)")
    private void methodsAcceptingBook(Book book) {}

    // Об'єднання Pointcuts для демонстрації
    @Pointcut("forShowMethods() || forBookClass()")
    private void generalLibraryActivity() {}

    // ----------------------------------------------------------------------
    // 2. ADVICE METHODS (Мінімум 3)
    // ----------------------------------------------------------------------

    // Advice 1: @Before (Виконується перед методом)
    // Застосовується до generalLibraryActivity
    @Before("generalLibraryActivity()")
    public void beforeAnyLibraryOperation(JoinPoint joinPoint) {
        System.out.println("\n[AOP @Before] ===> LOG: Викликано метод: " + joinPoint.getSignature().toShortString());
    }

    // Advice 2: @AfterReturning (Виконується після успішного повернення)
    // Застосовується до методів у класі Author
    @AfterReturning(
            pointcut = "execution(* com.example.library.Author.toString(..))",
            returning = "result"
    )
    public void afterAuthorStringReturn(JoinPoint joinPoint, Object result) {
        System.out.println("[AOP @AfterReturning] ===> LOG: toString() методу Author успішно повернув: " + result);
    }

    // Advice 3: @AfterThrowing (Виконується після виклику винятку)
    // Застосовується до forBookClass, якщо виникне помилка
    @AfterThrowing(
            pointcut = "forBookClass()",
            throwing = "theExc"
    )
    public void afterBookError(JoinPoint joinPoint, Throwable theExc) {
        System.out.println("[AOP @AfterThrowing] ===> УВАГА: Виняток у методі Book: " + theExc.getMessage());
    }

    // Advice 4 (Додатковий, для демонстрації @Around): @Around
    @Around("forShowMethods()")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = null;
        try {
            // Виклик цільового методу (Library.showInfo())
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("[AOP @Around] ===> Обробка винятку: " + e.getMessage());
            throw e;
        }

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("[AOP @Around] ===> LOG: Час виконання методу " + proceedingJoinPoint.getSignature().toShortString() + " зайняв: " + duration + " мс.");

        return result;
    }
}