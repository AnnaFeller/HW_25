package HW;

import java.io.File;

public class Delete {

    public static void main(String[] args) {

        File folder = new File(System.getProperty("user.home") + "\\testFolder");        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("Папка создана");
        }
        deleteDir(folder);
        System.out.println("до " + folder.exists());
        deleteDir(folder);
        System.out.println("после " + folder.exists());
    }
    public static void deleteDir(File dir) {


        if (dir == null || !dir.exists()) return;

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteDir(file);
                }
            }
        }
        dir.delete();

    }
    //Метод удаляет папку и всё внутри неё и папка удалится только если она пустая.
    //Код не раьотал , потому что проверка ьыла закоментированна и модет возникнуть ошибка NullPointerException
    // и попытка удалить несуществующий файл

}
