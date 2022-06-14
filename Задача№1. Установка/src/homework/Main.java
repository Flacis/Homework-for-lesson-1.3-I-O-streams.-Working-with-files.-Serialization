package homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File src = new File("E://Games//src");
        File res = new File("E://Games//res");
        File saveGames = new File("E://Games//savegames");
        File temp = new File("E://Games//temp");
        File main = new File(src, "main");
        File test = new File(src, "test");
        File Main = new File(main, "Main.java");
        File Utils = new File(main, "Utils.java");
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        File tempTxt = new File(temp, "temp.txt");
        StringBuilder log = new StringBuilder();

        if (src.mkdir()) {
            log.append("Добавлена папка ").append(src.getName()).append("\n");
        }
        if (res.mkdir()) {
            log.append("Добавлена папка ").append(res.getName()).append("\n");
        }
        if (saveGames.mkdir()) {
            log.append("Добавлена папка ").append(saveGames.getName()).append("\n");
        }
        if (temp.mkdir()) {
            log.append("Добавлена папка ").append(temp.getName()).append("\n");
        }
        if (main.mkdir()) {
            log.append("Добавлена папка ").append(main.getName()).append("\n");
        }
        if (test.mkdir()) {
            log.append("Добавлена папка ").append(test.getName()).append("\n");
        }
        try {
            if (Main.createNewFile()) {
                log.append("Добавлен файл ").append(Main.getName()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (Utils.createNewFile()) {
                log.append("Добавлен файл ").append(Utils.getName()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (drawables.mkdir()) {
            log.append("Добавлена папка ").append(drawables.getName()).append("\n");
        }
        if (vectors.mkdir()) {
            log.append("Добавлена папка ").append(vectors.getName()).append("\n");
        }
        if (icons.mkdir()) {
            log.append("Добавлена папка ").append(icons.getName()).append("\n");
        }
        try {
            if (tempTxt.createNewFile()) {
                log.append("Добавлен файл ").append(tempTxt.getName()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("E://Games//temp//temp.txt", true)) {
            writer.write(String.valueOf(log));
            System.out.println("Выполнено");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







