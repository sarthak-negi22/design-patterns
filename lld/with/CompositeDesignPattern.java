import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void showDetails();
}

class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File details: "+ name + ", " + size);
    }
}

class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name ) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder details: "+name);
        for(FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

public class CompositeDesignPattern {
    public static void main(String[] args) {
        File file1 = new File("abc.text", 125);
        File file2 = new File("xyz.jpeg", 225);
        Folder subFolder = new Folder("Lucas");
        subFolder.addComponent(file1);  
        subFolder.addComponent(file2);

        Folder root = new Folder("Root");
        root.addComponent(subFolder);       // treating file and folder as uniform, hence collectively adding them as "component"

        File file3 = new File("Root file", 624);
        root.addComponent(file3);

        root.showDetails();

    }
}
