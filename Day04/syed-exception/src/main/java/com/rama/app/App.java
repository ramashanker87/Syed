package org.example;

import java.util.Scanner;


public class
{
    public static void validate(int age) throws SyedException{
        if (age != 23){
            throw new SyedException("This is not correct age");
        }
        else{
            System.out.println("Yes it is correct");
        }



    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Syed's age: ");
        int a = sc.nextInt();
        try{
            validate(a);
        } catch(SyedException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Invalid Input");
        }
    }
}