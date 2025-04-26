import java.util.ArrayList;
import java.util.List;

class File {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void showDetails() {
        System.out.println("File Details: "+ name +", "+ size);
    }
} 

class Folder {
    private String name;
    private List<File> files = new ArrayList<>();
    private List<Folder> subFolders = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addSubFolder(Folder subFolder) {
        subFolders.add(subFolder);
    }

    public void showDetails() {
        System.out.println("Folder details: "+name);
        for(File file : files) {
            file.showDetails();
        }

        for(Folder subFolder : subFolders) {
            subFolder.showDetails();
        }
    }
}

public class CompositeDesignProblem {
    public static void main(String[] args) {
        File file1 = new File("docs", 45);
        File file2 = new File("texts", 25);
        Folder subFolder = new Folder("LucaS");
        subFolder.addFile(file1);
        subFolder.addFile(file2);

        Folder rootFolder = new Folder("Root");
        File file3 = new File("Demo", 65);
        rootFolder.addSubFolder(subFolder);
        rootFolder.addFile(file3);      // unlike B/B+ trees, folders are just created in the form of jagged list, which is a contradiction 

        rootFolder.showDetails();
    }
}
