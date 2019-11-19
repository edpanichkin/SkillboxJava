public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
    }

    public static int sumDigits(Integer number)
    {
        String str = Integer.toString(number);
        var sum = 0;
        for (int i = 0; i < str.length(); i++)
        {
            sum += Character.getNumericValue(str.charAt(i));
        }
        return sum;
    }
}
