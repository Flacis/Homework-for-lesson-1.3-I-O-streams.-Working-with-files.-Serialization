package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        GameProgress one = new GameProgress(100, 1, 3, 1.1);
        GameProgress two = new GameProgress(86, 5, 10, 10.3);
        GameProgress three = new GameProgress(99, 3, 5, 4.3);

        saveGame(one, two, three);
        zipFiles();
        File delete = new File("E:\\Games\\savegames\\save.dat");
        delete.delete();

    }

    private static void saveGame(GameProgress one, GameProgress two, GameProgress three) {
        try (FileOutputStream fos = new FileOutputStream("E:\\Games\\savegames\\save.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(one);
            oos.writeObject(two);
            oos.writeObject(three);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void zipFiles() {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("E:\\Games\\savegames\\zip.zip"));
             FileInputStream fis = new FileInputStream("E:\\Games\\savegames\\save.dat")) {
            ZipEntry entry = new ZipEntry("save.dat");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}