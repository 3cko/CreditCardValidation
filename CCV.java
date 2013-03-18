import java.util.Scanner;


public class CCV
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a credit card number as a long integer: ");
        long number = input.nextLong();
        String valid = (isValid(number)) ? "valid" : "invalid";
        String formatted = String.format("%d is %s", number, valid);
        System.out.println(formatted);
    }

    public static boolean isValid(long number)
    {
        // convert to string and check length
        int [] valid = {4, 5, 6, 37};
        if (getSize(number) < 13 || getSize(number) > 16)
        {
            return false;
        } else { 
        
            for (int x = 0; x < valid.length; x++)
            {
                if (prefixMatched(number, valid[x]))
                {
                    int even = sumOfDoubleEvenPlace(number);
                    int odd = sumOfOddPlace(number);

                    int total = even + odd;
                    if (total % 10 == 0) return true;
                    return false;
                }
            }
        }
        return false;
    }

    public static int sumOfDoubleEvenPlace(long number)
    {
        int total = 0;
        for (int x = Long.toString(number).length(); x > 0; x--)
        {
            if (x % 2 == 0)
            {
                String digit = Long.toString(number).substring(x - 2, x - 1);
                total += getDigit(Integer.parseInt(digit));
            }
        }
        return total;
    }

    public static int getDigit(int number)
    {
        number *= 2;

        if (Integer.toString(number).length() == 2)
        {
            int d1 = Integer.parseInt(Integer.toString(
                                                number).substring(0, 1));
            int d2 = Integer.parseInt(Integer.toString(
                                                number).substring(1, 2));
            return d1 + d2;
        }
        return number;
    }

    public static int sumOfOddPlace(long number)
    {
        int total = 0;
        for (int x = Long.toString(number).length(); x > 0; x--)
        {
            if (x % 2 == 0)
            {
                total += Integer.parseInt(Long.toString(
                                                 number).substring(x - 1, x));
            }
        }
        return total;
    }

    public static boolean prefixMatched(long number, int d)
    {
        if (getPrefix(number, 1) == d) return true;
        if (getPrefix(number, 2) == d) return true;
        return false;
    }

    public static int getSize(long d)
    {
        int length = Long.toString(d).length();
        return length;
    }

    public static int getPrefix(long number, int k)
    {
        String prefix = Long.toString(number).substring(0, k);
        return Integer.parseInt(prefix);
    }

}
