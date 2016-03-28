package com.javarush.test.xAttempts.ZipArch;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by ������� on 05.11.2015.
 */
public class FAadder
{
    public static void main(String[] args) {

        try {
            FileOutputStream fos = new FileOutputStream("c:/javaidea/archive.zip");
            ZipOutputStream zos = new ZipOutputStream(fos);

            String file1Name = "c:/javaidea/result.txt";
            String file2Name = "c:/javaidea/try.txt";
            String file3Name = "c:/javaidea/";
            String file4Name = "folder/file4.txt";
            String file5Name = "f1/f2/f3/file5.txt";

            addToZipFile(file1Name, zos);
            addToZipFile(file2Name, zos);
            //addToZipFile(file3Name, zos);
            //addToZipFile(file4Name, zos);
            //addToZipFile(file5Name, zos);

            zos.close();
            fos.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

        System.out.println("Writing '" + fileName + "' to zip file");

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            System.out.println(length);
            zos.write(bytes, 0, length);
        }

        zos.closeEntry();
        fis.close();
    }
}
