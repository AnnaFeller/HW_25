package files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileAppl {
    public static void main(String[] args) throws IOException, URISyntaxException {

        File f1 = new File("file1.txt");
        System.out.println(f1.exists());
        System.out.println(f1.createNewFile());
        System.out.println(f1.exists());
//EXIST - have this file or no
        File d1 = new File("dir1");
        System.out.println(d1.mkdir());
        //сощлать деректорию
        File dd =new File("dir/dir11/dir22");
        System.out.println(dd.mkdirs());
        //дерево из деректорий
        File f2 = new File(dd,"file2.txt");
    f2.createNewFile();
    File dd1 = new File("dir"+File.separator+"dir11"+File.separator+"dir22"+File.separator+"dir33");
    dd1.mkdir();
    //delete
        System.out.println(dd.delete());
//		System.out.println(d1.delete());
//		System.out.println(dd1.delete());

        System.out.println(f2.delete());

        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getParent());
//		System.out.println(tt1.getParent());
        System.out.println(f1.length());
        System.out.println(f1.canRead());
        System.out.println(f1.canWrite());
        System.out.println(f1.setWritable(false,true));
        System.out.println(f1.canWrite());
        System.out.println(f1.getTotalSpace());
        System.out.println(f1.getFreeSpace());
        Path p1 = dd1.toPath();
        System.out.println(p1);
        File ff = p1.toFile();
        System.out.println(ff);
        //Paths Files
        Path p2 = Paths.get("foo", "boo","voo");
        System.out.println(p2);
        System.out.println(p2.getParent());
        if(!Files.exists(p2))
            Files.createDirectories(p2);
        Path fp1 = Paths.get("tmp.txt");
        Path fp2 = Paths.get(new URI("file:///C:/myProject/tmp.txt"));
//		Files.createFile(fp2);
//		Files.createFile(fp1);
        Files.writeString(fp1, "Hello");
        Files.writeString(fp1, " ", StandardOpenOption.APPEND);
        Files.writeString(fp1, "group", StandardOpenOption.APPEND);
        Files.writeString(fp1, "\nHello", StandardOpenOption.APPEND);
        Files.writeString(fp1, " ", StandardOpenOption.APPEND);
        Files.writeString(fp1, "group", StandardOpenOption.APPEND);
        List<String> list = Files.readAllLines(fp1);
        System.out.println(list);
        Files.lines(fp1).forEach(System.out::println);
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
}

