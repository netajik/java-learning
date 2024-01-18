
package java11features;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * Java11Feature
 */
public class Java11Feature {

    public static void main(String[] args) throws IOException {
        stringFeatures();
        fileFeatures();
        collectionsFeatures();
        notPredicateFeature();
    }

    /**
     * Java 11 adds a few new methods to the String class: isBlank, lines, strip,
     * stripLeading, stripTrailing, and repeat.
     */
    static void stringFeatures() {
        String multiLineString = "Baeldung helps \n \n developers \n explore Java.";
        List<String> lines = multiLineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .toList();
        lines.forEach(System.out::println);
    }

    /**
     * The new readString and writeString static methods from the Files class
     * @throws IOException 
     */
    static void fileFeatures() throws IOException {
        var tempdir = Files.createTempDirectory("tempdir");
        Path path = Files.createTempFile(tempdir, "hello", ".txt");
        Files.writeString(path,"\nHello World\n");
        String str = Files.readString(path);
        System.out.println(str);
    }

    /**
     * The java.util.Collection interface contains a new default toArray method 
     * which takes an IntFunction argument. This makes it easier to create an 
     * array of the right type from a collection:
     */
    static void collectionsFeatures() {
        
        List<String> list = List.of("java","springboot");
        String[] arr = list.toArray(String[]::new);
        for(String str: arr) {
            System.out.println(str);
        }
    }

    /**
     * A static not method has been added to the Predicate interface. 
     * We can use it to negate an existing predicate, much like the negate method.
     */
    static void notPredicateFeature() {
        List<String> list = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List<String> listWithoutBlanks = list.stream().filter(Predicate.not(String::isBlank)).toList();
        System.out.println("\n"+listWithoutBlanks);
    }
}