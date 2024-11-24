
import java.util.Scanner;
public class Main
{
    public static void main(String[] Args){
        Scanner input = new Scanner(System.in);

        System.out.println("Ввдите первое число: ");
        float num1 = input.nextFloat();

        System.out.println("Ввдите второе число: ");
        float num2 = input.nextFloat();

        float result1 = num1+num2;
        float result2 = num1-num2;
        float result3 = num1*num2;
        float result4 = num1/num2;

        System.out.println("Результат сложения: "+result1 +"\n Результат вычитания: " + result2 + "\n Результат умножения: "+result3+"\n Результат деления: "+result4);
    }

}
