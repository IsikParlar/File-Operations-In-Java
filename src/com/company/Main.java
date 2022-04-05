// Mustafa Işık Parlar - H5200024
// C:\\Medipol dosyası yokken .txt dosyasını C'ye oluşturmaya çalıştığımda java.io.FileNotFoundException (erişim engellendi) hatası aldım.
// O yüzden dosyayı masaüstüne oluşturdum.

// Medipol klasörü varken program çalışıyor ancak yokken sadece .txt dosyasını oluşturuyor. Diğer dosya işlemlerini yapmıyor.

package com.company;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void creatMedipolFile(String veri) {


        File f = new File("C:\\");
        if (f.exists() && f.isFile()) {

            try {
                File file = new File("C:\\Medipol/H5200024.txt");

                if (file.createNewFile()) {
                    System.out.println("File created");
                } else {
                    System.out.println("File already exists");
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        } else {


            try {
                File file = new File("C:\\Users/mparl/Desktop/H5200024.txt");

                if (file.createNewFile()) {
                    System.out.println("File created");
                } else {
                    System.out.println("File already exists");
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }


    public static void updateMedipolFile(String veri) {


        File file = new File("C:\\Medipol/H5200024.txt");

        try {
            FileOutputStream dosya = new FileOutputStream(file);
            dosya.write(veri.getBytes());
            dosya.flush();
            dosya.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteMedipolFile(String veri) {
        File file = new File("C:\\Medipol/H5200024.txt");

        if (!file.exists())
            try {
                throw new IllegalAccessException("File to be deleted not found! " + file.getAbsolutePath());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        else
            file.delete();
        System.out.println(file.getName() + "has been deleted successfully");


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**********************");
        String islemler =
                  "1. Creating .txt file\n"
                + "2. Printing student's number to .txt file\n"
                + "3. Deleting .txt file\n"
                + "Press q for quit.";

        System.out.println(islemler);
        System.out.println("**********************");
        while (true) {

            System.out.println("Choose Operation : ");
            String islem = scanner.nextLine();

            if (islem.equals("q")) {

                break;

            } else if (islem.equals("1")) {

                creatMedipolFile("");

            } else if (islem.equals("2")) {

                updateMedipolFile("Lorem ipsum");
                System.out.println("File created successfully");
            } else if (islem.equals("3")) {

                deleteMedipolFile("");

            } else {
                System.out.println("Wrong Operation");
            }

        }
    }

}
