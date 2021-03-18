package xyz.destroyyerq.crypter.files;

import lombok.Getter;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Files
{
    private final File sourceDirectory;
    private final List<File> filesList;

    public Files(String sourceDirectoryName) {
        this.sourceDirectory = new File(sourceDirectoryName);
        this.filesList = new CopyOnWriteArrayList<>();
    }

    public void load() {
        try {
            if(!this.sourceDirectory.exists()) {
                this.sourceDirectory.mkdir();
                this.sourceDirectory.createNewFile();
            }

            Arrays.stream(this.sourceDirectory.list()).forEach(file -> this.filesList.add(new File(this.sourceDirectory.getPath() + "/" + file)));

            if(this.filesList.size() == 0) {
                System.out.println("Error -> No file was found in the directory");
                System.exit(0);
            }


        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }
}
