package ru.mirea.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Класс Word, который имеет 2 поля: само слово, количество гласных в слове*/
class Word implements Comparable<Word>{
    private String str;
    private int countOfVowels;

    public Word() {
    }

    public Word(String str, int countOfVowels) {
        this.str = str;
        this.countOfVowels = countOfVowels;
    }

    public String getStr() {
        return str;
    }

    public int getCountOfVowels() {
        return countOfVowels;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setCountOfVowels(int countOfVowels) {
        this.countOfVowels = countOfVowels;
    }

    @Override
    public String toString() {
        return "Word{" +
                "str='" + str + '\'' +
                ", countOfVowels=" + countOfVowels +
                '}';
    }

    @Override
    public int compareTo(Word o) {
        return o.getCountOfVowels() - this.getCountOfVowels();
    }
}



public class App {
    public static List<Character> vowels = Arrays.asList('а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё');

    public static Word calcCountVowels(String str) {
        String word = str;
        StringBuilder newWord = new StringBuilder(word);
        int count = 0;

        for (char i:word.toLowerCase().toCharArray()) {
            if (vowels.contains(i)&count==0) {
                newWord.setCharAt(word.indexOf(i), Character.toUpperCase(i));
                word = newWord.toString();
            }
            if (vowels.contains(i)) {
                count++;
            }
            if (vowels.indexOf(i)!=vowels.lastIndexOf(i)) {
                count++;
            }
        }
        return new Word(word, count);
    }

    public static int getSumOfVowels(List<Word> words){
        int sum = 0;

        for (Word i:words) {
            sum+=i.getCountOfVowels();
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Введите ваше предложение на русском языке: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        String[] arr = str.split(" "); /*Массив слов*/
        List<Word> words = new ArrayList<>();
        for (String i:arr) {
            words.add(calcCountVowels(i));
        }
        
        System.out.println("Количество гласных в предложении: " + getSumOfVowels(words));

        Collections.sort(words);
        System.out.println("Отсортированное предложение по количеству гласных, где каждая первая гласная в слове заглавная: ");
        for (Word i:words) {
            System.out.print(i.getStr() + " ");
        }
    }
}
