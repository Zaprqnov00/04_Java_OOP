package T4_Interfaces.Exercices.Telephony_05;

import java.util.List;

public class Smartphone implements Callable,Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public void browse() {
        List<String> urls = this.urls;
        StringBuilder stringBuilder = new StringBuilder();
        for (String url :urls) {
            boolean haveDigit = true;
            for (int i = 0; i < url.length(); i++) {
                char symbol = url.charAt(i);
                if (Character.isDigit(symbol)){
                   haveDigit = false;
                   break;
                }
            }
            if (haveDigit){
                stringBuilder.append("Browsing: ").append(url).append("!").append("\n");
            }else {
                stringBuilder.append("Invalid URL!").append("\n");
            }
        }
        System.out.print(stringBuilder);
    }

    @Override
    public void call() {
        List<String> numbers = this.numbers;
        StringBuilder stringBuilder = new StringBuilder();
        for (String number :numbers) {
            boolean haveLetter = true;
            for (int i = 0; i < number.length(); i++) {
                char symbol = number.charAt(i);
                if (Character.isLetter(symbol)){
                    haveLetter = false;
                    break;
                }
            }
            if (haveLetter){
                stringBuilder.append("Calling... ").append(number).append("\n");
            }else {
                stringBuilder.append("Invalid number!").append("\n");
            }
        }
        System.out.print(stringBuilder);
    }

}
