package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileText = fileText("C:\\идея\\HW8.txt");
        String[] words = fileText.split(" ");
        Arrays.sort(words);
        int wordsCounter = howMuchWords(words);
        System.out.println("Кількість слів в файлі : " + wordsCounter);
        System.out.println("Кількість унікальних слів в файлі :");
        System.out.println(m(words));
    }

    private static String fileText(String s) throws IOException {
        String temp = "";
        FileReader fileReader = new FileReader(s);
        char[] a = new char[10000];
        fileReader.read(a);
        for (char c : a) {
            temp = temp + c;
        }
        fileReader.close();
        return temp;
    }

    private static int howMuchWords(String[] strings) {
        int wordsCounter = 0;
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
            if (!strings[i].equals("")) {
                wordsCounter++;
            }
        }
        return wordsCounter;
    }

    private static boolean checkWords(String[] strings, String word) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    private static int howMuchThisWords(String[] strings, String s) {
        int counter = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(s)) {
                counter++;
            }
        }
        return counter;
    }

    private static String m(String[] strings) {
        int nen = -1;
        String temp = "";
        String[] words = new String[0];
        int[] wordsCount = new int[0];
        for (int i = 0; i < strings.length; i++) {
            if (!checkWords(words, strings[i])) {
                words = addCell(words);
                wordsCount = addCell(wordsCount);
                words[words.length - 1] = strings[i];
                wordsCount[wordsCount.length - 1] = howMuchThisWords(strings, strings[i]);
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                nen = i;
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (i != nen) {
                temp = temp + words[i] + " - " + wordsCount[i] + "\n";
            }
        }
        return temp;
    }

    private static String[] addCell(String[] strings) {
        String[] strings1 = new String[strings.length + 1];
        for (int i = 0; i < strings.length; i++) {
            strings1[i] = strings[i];
        }
        return strings1;
    }

    private static int[] addCell(int[] ints1) {
        int[] ints = new int[ints1.length + 1];
        for (int i = 0; i < ints1.length; i++) {
            ints[i] = ints1[i];
        }
        return ints;
    }
}
