import java.io.FileWriter;

public class ClassGenerator {
    ClassGenerator(String name) {
        generateClass(name);
    }

    private String createClassName(String name) {
        StringBuilder className = new StringBuilder();
        for (String s : name.split(" ")) {
            className.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
        }
        return className.toString();
    }

    private void generateClass(String name) {
        try {
            String className = createClassName(name) ;
            String classContent = generateClassContent(name, className);
            className += ".java";
            String path = "F:\\DSA\\java\\";
            try (FileWriter file = new FileWriter(path + className)) {

                file.write(classContent);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String generateClassContent(String name, String className) {
        return "/*\n" +
                "*Problem Name : " + name + "\n"+
                "*\n" +
                "*Problem Link : \n" +
                "*\n" +
                "*Problem Statement : \n" +
                "*\n" +
                "* Approach 1 \n" +
                "*--------------\n" +
                "*TC = O() SC = O()\n" +
                "*/\n" + "public class " + className + "{\n" +
                "}" ;
    }
}
