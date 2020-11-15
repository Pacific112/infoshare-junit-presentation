package pl.infoshare.junit5._5_extensions._1_tempdir;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class TempDirTest {

    @TempDir
    Path path;

    @Test
    void name() throws IOException {
        var createdFile = Files.createFile(path.resolve("example.txt"));
        System.out.println(createdFile);

        Files.write(createdFile, "Maciek".getBytes());
        System.out.println();
    }
}
