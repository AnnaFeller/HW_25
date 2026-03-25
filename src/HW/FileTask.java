package HW;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileTask {

    public static void main(String[] args) throws IOException {
        String filePath = "tmp.txt";
        System.out.println("lines " + countLines(filePath));
        System.out.println("words " + countWords(filePath));
        String folderPath = ".";
        System.out.println("longest " + longestFileName(folderPath).getName());
        listTxtFiles(folderPath);
        System.out.println("files " + countAllFiles(new File(folderPath)));
        System.out.println("folders " + countFolders(new File(folderPath)));
    }

    public static int countLines(String filePath) throws IOException {
        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.readLine() != null) {
                lines++;
            }
        }
        return lines;
    }

    public static int countWords(String filePath) throws IOException {
        int word = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] w = line.trim().split("\\s+");
                if (w.length == 1 && w[0].isEmpty()) continue;
                word += w.length;
            }
        }
        return word;
    }

    public static File longestFileName(String folderPath) {
        File folder  = new File(folderPath);

        File longer  = null;
        int maxLength = 0;
        for(File f: folder.listFiles()){
            if(f.isFile()&&f.getName().length()>maxLength){
                maxLength = f.getName().length();
                longer = f;
            }
        }
        return longer;
    }

    public static void listTxtFiles(String folderPath) {
    File folder = new File(folderPath);
    for(File f: folder.listFiles()){
        if(f.isFile()&& f.getName().endsWith(".txt")){
            System.out.println(f.getName());
        }
    }
    }

    public static int countAllFiles(File folder) {
    int count  = 0;
    for (File f : folder.listFiles()){
        if (f.isFile()){
            count++;
        }else if( f.isDirectory())count+= countAllFiles(f);
    }
    return count;
    }

    public static int countFolders(File folder) {
    int count = 0;
    for(File f :folder.listFiles()){
        if(f.isDirectory()) count+=1 +countFolders(f);
    }
    return count;
    }
    }
