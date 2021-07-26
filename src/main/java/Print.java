import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * #Summary:
 * #Author: Zarina_Bozhyk
 * #Author’s Email:
 * #Creation Date: 7/13/2021
 * #Comments:
 */
public class Print {
    void print(Object s) {
        if (s == null) {
            throw new NullPointerException("Exception: s is null!");
        }
        System.out.println("Inside method print: " + s);
    }

    public static void main(String[] args) throws Exception {
        Print print = new Print();
        List list = Arrays.asList("first step", null, "second step");

        for (Object s : list) {
            try {
                print.print(s);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                System.out.println("Exception was processed. Program continues");
            } finally {
                System.out.println("Inside bloсk finally");
            }
            System.out.println("Go program....");
            System.out.println("-----------------");
        }


    }}
