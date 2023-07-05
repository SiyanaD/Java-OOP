package p05Тelephony;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Browsable,Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers =numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        //The functionality of the browser should print on the console the site in the format:
        //"Browsing: {site}!" (pay attention to the exclamation mark when printing URLs)
        //If there is a number in the input of the URLs, print: "Invalid URL!" and continue printing the rest of the
        //URLs

        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[\\d]+");
        for (String url : urls) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()){
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
            else {
                sb.append(String.format("Browsing: %s!",url)).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        //The functionality of calling phones is printing on the console the number which is being called in the format:
        //"Calling... {number}"
        //If there is a character different from a digit in a number, print: "Invalid number!" and continue to the
        //next number.

        //паттерн който да проверява в даден стринг дали има цифра.
        Pattern pattern = Pattern.compile("[\\D+]");

        for (String number : numbers) {
            Matcher matcher = pattern.matcher(number);
            //ако намери не нещо различно от цифра в себе си
            if (matcher.find()){
                sb.append("Invalid number!");
                sb.append(System.lineSeparator());
            }
            else {
                sb.append(String.format("Calling... %s",number)).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
