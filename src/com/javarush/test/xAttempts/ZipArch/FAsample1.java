package com.javarush.test.xAttempts.ZipArch;

import java.io.*;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by ������� on 05.11.2015.
 */
public class FAsample1
{
    final static int BUFFER = 2048;
    private static Logger log = Logger.getLogger(FAsample1.class.getSimpleName());

    public static boolean createZipArchive(String srcFolder)
    {
        try
        {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(new File(srcFolder + ".zip"));
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte data[] = new byte[BUFFER];

            File subDir = new File(srcFolder);
            String[] subdirList = subDir.list();
            for(String sd: subdirList) {
                File f = new File(srcFolder + "/" + sd);
                if(f.isDirectory()) {
                    String[] files = f.list();
                    for(int i = 0; i < files.length; i++) {
                        System.out.println("Adding: " + files[i]);
                        FileInputStream fi = new FileInputStream(srcFolder + "/" + sd  + "/" + files[i]);
                        origin = new BufferedInputStream(fi, BUFFER);
                        ZipEntry entry = new ZipEntry(sd + "/" + files[i]);
                        out.putNextEntry(entry);
                        int count;
                        while((count = origin.read(data, 0, BUFFER)) != -1) {
                            out.write(data, 0, count);
                            out.flush();
                        }
                    }
                }
                else {
                    FileInputStream fi = new FileInputStream(f);
                    origin = new BufferedInputStream(fi, BUFFER);
                    ZipEntry entry = new ZipEntry(sd);
                    out.putNextEntry(entry);
                    int count;
                    while((count = origin.read(data, 0, BUFFER)) != -1) {
                        out.write(data, 0, count);
                        out.flush();
                    }
                }
            }
        } catch(Exception e) {
            log.info("createZipArchive threw exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}
