package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.reflect.Field;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws NoSuchFieldException {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) throws NoSuchFieldException {
        if (c==null) return false;
        if (c.isAnnotationPresent(PrepareMyTest.class)){
          PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
         String[] arr = prepareMyTest.fullyQualifiedNames();
            System.out.println(Arrays.toString(arr));
            return true;
        }else
        return false;
    }

    public static boolean printValues(Class c) {
        if (c==null) return false;
        if (c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            Class[] arr = prepareMyTest.value();
            for (Class cl : arr){
                System.out.print(cl.getSimpleName()+"; ");
            }
            return true;
        }else
            return false;
    }
}
