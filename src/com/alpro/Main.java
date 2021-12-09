package com.alpro;

import java.util.Scanner;

class Interpolation {

    public int search(int[] array, int value) {
        int low = 0;
        int high = array.length-1;
        while (value >= array[low] && value <= array[high] && low <= high){
            int hitungan = low+(high-low)*(value-array[low])/(array[high] - array[low]);
            System.out.println("probe : "+hitungan);
            if (array[hitungan] == value){
                return hitungan;
            }else if (array[hitungan] < value){
                low = hitungan+1;
            }else {
                low = hitungan-1;
            }
        }
        return -1;
    }
}

class Binary {

    public int search(int[] array, int value) {
        int high = array.length-1;
        int low = 0;
        int mid = (low + high)/2;
        while( low <= high ){
            if ( array[mid] == value ){
                return mid;
            }else if ( array[mid] < value ){
                low = mid + 1;
            }else{
                low = mid - 1;
            }
            mid = (low + high)/2;
        }
        return -1;
    }
}

public class Main {

    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void hasilBin(int resultBin, String s) {
        if (resultBin != -1) {
            System.out.println(s + resultBin);
        } else {
            System.out.println("data tida ketemu");
        }
    }

    public static void hasilInter(int result, String s) {
        if (result != -1) {
            System.out.println(s + result);
        } else {
            System.out.println("data tida ketemu");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        int value;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        while (index < array.length) {
            System.out.print("Msukan angka kedalam array : ");
            array[index] = scanner.nextInt();
            index++;
        }
        sort(array);
        System.out.println("Hasil pengurutan : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(array[i]+" ");
        }

        System.out.print("\nMasukan angka yang dicari : ");
        value = scanner.nextInt();
        Interpolation interpolation = new Interpolation();
        Binary binary = new Binary();
        int resultBin = binary.search(array, value);
        int result = interpolation.search(array, value);
        hasilInter(result, "Hasil interpolasi search ditemukan di index ke-");
        hasilBin(resultBin, "Hasil binary search ditemukan di index ke-");
    }
}
