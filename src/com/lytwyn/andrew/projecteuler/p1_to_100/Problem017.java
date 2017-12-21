package com.lytwyn.andrew.projecteuler.p1_to_100;

/**
 * Created by andrew on 12/15/2017.
 */
public class Problem017
{
    private static final String ONE = "one";
    private static final String TWO = "two";
    private static final String THREE = "three";
    private static final String FOUR = "four";
    private static final String FIVE = "five";
    private static final String SIX = "six";
    private static final String SEVEN = "seven";
    private static final String EIGHT = "eight";
    private static final String NINE = "nine";
    private static final String TEN = "ten";
    private static final String ELEVEN = "eleven";
    private static final String TWELVE = "twelve";
    private static final String THIRTEEN = "thirteen";
    private static final String FOURTEEN = "fourteen";
    private static final String FIFTEEN = "fifteen";
    private static final String SIXTEEN = "sixteen";
    private static final String SEVENTEEN = "seventeen";
    private static final String EIGHTEEN = "eighteen";
    private static final String NINETEEN = "nineteen";
    private static final String TWENTY = "twenty";
    private static final String THIRTY = "thirty";
    private static final String FORTY = "forty";
    private static final String FIFTY = "fifty";
    private static final String SIXTY = "sixty";
    private static final String SEVENTY = "seventy";
    private static final String EIGHTY = "eighty";
    private static final String NINETY = "ninety";
    private static final String HUNDRED = "hundred";
    private static final String THOUSAND = "thousand";

    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 1000; ++i)
        {
            System.out.println(getWord(i));
            sb.append(getWord(i));
        }

        System.out.println(sb.length());
    }

    private static String getWord(int num)
    {
        if (num <= 20) return getOneToTwenty(num, false);
        StringBuilder result = new StringBuilder();

        String s = Integer.toString(num);

        for (int i = 0; i < s.length(); ++i)
        {
            String current = "";
            int power = s.length() - i;

            switch (power)
            {
                case 4:
                    current = getThousand(num);
                    break;
                case 3:
                    current = getHundred(num);
                    break;
                case 2:
                    current = getTen(num);
                    break;
                case 1:
                    if (s.length() >= 2 && s.charAt(s.length() - 2) != '1')
                    {
                        int n = Integer.valueOf(s.substring(s.length() - 2));
                        if (num >= 100 && (n <= 9 && n >= 1)) current += "and";
                        current += getOneToTwenty(num, false);
                    }
                    break;
            }
            result.append(current);
        }
        return result.toString();
    }

    private static String getThousand(int num)
    {
        StringBuilder result = new StringBuilder();
        int div = num / 1000;
        result.append(getOneToTwenty(div, false)).append(THOUSAND);
        return result.toString();
    }

    private static String getHundred(int num)
    {
        String n = Integer.toString(num);
        int hundreds = Integer.valueOf(n.substring(n.length() - 3));

        int div = hundreds / 100;
        if (div != 0)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(getOneToTwenty(div, false)).append(HUNDRED);
            return sb.toString();
        }
        return "";
    }

    private static String getTen(int num)
    {
        String n = Integer.toString(num);
        int tens = Integer.valueOf(n.substring(n.length() - 2));
        int div = tens / 10;

        if (div != 0)
        {
            if (div == 1)
            {
                div = (div * 10) + Integer.valueOf(n.substring(n.length() - 1));
                return getOneToTwenty(div, true, num);
            } else
            {
                switch (div)
                {
                    case 2:
                        return (num > 100) ? "and" + TWENTY : TWENTY;
                    case 3:
                        return (num > 100) ? "and" + THIRTY : THIRTY;
                    case 4:
                        return (num > 100) ? "and" + FORTY : FORTY;
                    case 5:
                        return (num > 100) ? "and" + FIFTY : FIFTY;
                    case 6:
                        return (num > 100) ? "and" + SIXTY : SIXTY;
                    case 7:
                        return (num > 100) ? "and" + SEVENTY : SEVENTY;
                    case 8:
                        return (num > 100) ? "and" + EIGHTY : EIGHTY;
                    case 9:
                        return (num > 100) ? "and" + NINETY : NINETY;
                }
            }
        }
        return "";
    }

    private static String getOneToTwenty(int div, boolean previous, int... num)
    {
        String n = Integer.toString(div);

        int index = (previous || (div <= 20 && div >= 10)) ? 2 : 1;

        div = Integer.valueOf(n.substring(n.length() - index));

        StringBuilder sb = new StringBuilder();

        if (num.length != 0 && num[0] >= 100)
        {
            sb.append("and");
        }

        switch (div)
        {
            case 1:
                sb.append(ONE);
                break;
            case 2:
                sb.append(TWO);
                break;
            case 3:
                sb.append(THREE);
                break;
            case 4:
                sb.append(FOUR);
                break;
            case 5:
                sb.append(FIVE);
                break;
            case 6:
                sb.append(SIX);
                break;
            case 7:
                sb.append(SEVEN);
                break;
            case 8:
                sb.append(EIGHT);
                break;
            case 9:
                sb.append(NINE);
                break;
            case 10:
                sb.append(TEN);
                break;
            case 11:
                sb.append(ELEVEN);
                break;
            case 12:
                sb.append(TWELVE);
                break;
            case 13:
                sb.append(THIRTEEN);
                break;
            case 14:
                sb.append(FOURTEEN);
                break;
            case 15:
                sb.append(FIFTEEN);
                break;
            case 16:
                sb.append(SIXTEEN);
                break;
            case 17:
                sb.append(SEVENTEEN);
                break;
            case 18:
                sb.append(EIGHTEEN);
                break;
            case 19:
                sb.append(NINETEEN);
                break;
            case 20:
                sb.append(TWENTY);
                break;
        }

        return sb.toString();
    }
}
