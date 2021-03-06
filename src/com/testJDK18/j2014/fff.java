package com.testJDK18.j2014;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class fff {

  public static void main(String[] args) throws Exception{
    List<Dish> menu =
        Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                       new Dish("beef", false, 700, Dish.Type.MEAT),
                       new Dish("chicken", false, 400, Dish.Type.MEAT),
                       new Dish("rice", true, 350, Dish.Type.OTHER),
                       new Dish("pizza", true, 550, Dish.Type.OTHER),
                       new Dish("prawns", false, 400, Dish.Type.FISH),
                       new Dish("salmon", false, 450, Dish.Type.FISH));
    List<Integer> numbers = Arrays.asList(3,4,5,1,2);

    Arrays.stream(numbers.toArray()).forEach(System.out::println);
    // max and OptionalInt
    OptionalInt maxCalories = menu.stream()                                                      
                                  .mapToInt(Dish::getCalories)
                                  .max();
    System.out.println("Number of calories:" + maxCalories);


  }

}



