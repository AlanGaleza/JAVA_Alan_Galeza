package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

//TEST METOD KLASY CALCULATOR
        Calculator calculator = new Calculator();
        final Integer result1 = 10;
    //ADD
        System.out.println("Test 1 Calculator - add");

        calculator.add(5, 5);

        if (result1.equals(calculator.getAdds())) {
            System.out.println("Adding test PASSED");
        }else{
            System.out.println("Adding test FAILED");
        }
     //SUBSTRACT
        System.out.println("Test 2 Calculator - substract");

        calculator.subtract(20,10);

        if (result1.equals(calculator.getSubstraction())){
            System.out.println("Substraction test PASSED");
        }else{
            System.out.println("Substracion test FAILED");
        }
    }
}
