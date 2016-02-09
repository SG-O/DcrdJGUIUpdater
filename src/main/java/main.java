/*
 * Copyright (c) 2016.
 * This work by Joerg Bayer is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 * Permissions beyond the scope of this license may be available at https://www.sg-o.de.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * DcrdUpdater: Created by Joerg Bayer(admin@sg-o.de) on 09.02.2016.
 */
public class main {
    public static void main(String[] args) {
        File old = new File("DecredJWallet.jar");
        File neF = new File("DecredJWallet.jar.update");
        Path oldP = old.toPath();
        Path newP = neF.toPath();
        System.out.println(oldP);
        System.out.println(newP);
        if (old.exists()) {
            if (!old.isFile()) {
                System.out.println("File error 0");
                System.exit(1);
            }
        }
        if (!neF.exists()) {
            System.out.println("File error 1");
            System.exit(1);
        }
        if (!neF.isFile()) {
            System.out.println("File error 2");
            System.exit(1);
        }
        int n = 0;
        while (!old.canWrite() && old.exists()) {
            n++;
            if (n > 200) {
                System.out.println("Repalce error 0");
                System.exit(1);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (neF.exists()) {
            try {
                Files.move(newP, oldP, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.move(newP, oldP);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
