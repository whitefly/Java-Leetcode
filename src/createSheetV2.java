import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class createSheetV2 extends SimpleFileVisitor<Path> {
    private final static String README_NAME = "README.md";
    private final static String SCAN = "src";
    private List<String> prefixes = new ArrayList<>();
    private Pattern pattern;
    private final Map<String, List<BaseQuestion>> map = new TreeMap<>();
    private static String preface = "# Java的刷题本\n";

    private static Map<String, String> letter2Name = new HashMap<>();

    static {
        letter2Name.put("Q", "普通");
        letter2Name.put("O", "剑指offer");
    }


    static class BaseQuestion {
        String type; //题目种类(普通,竞赛)
        int id; //
        String name; //题目名字
        String ref; //题目相对位置

    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isDirectory()) return FileVisitResult.CONTINUE;

//        String absolutePath = file.getAbsolutePath();
//        BaseQuestion parse = parse(absolutePath);
        return FileVisitResult.CONTINUE;
    }


    private boolean checkJavaFile(String name) {
        return name.endsWith(".java");
    }

    private boolean checkRightName(String name) {
        return pattern.matcher(name).find();
    }

    private BaseQuestion parse(String fullPath) {
        if (checkJavaFile(fullPath)) return null;

        String[] split = fullPath.split("/");
        if (split.length < 3) {
            System.out.println("文件名无法解析:" + fullPath);
            return null;
        }
        String shortName = split[split.length - 1];
        if (checkRightName(shortName)) return null;

        String parent = split[split.length - 2];
        String[] analysis = analysis(shortName);
        String type = analysis[0];
        String num = analysis[1];

//        return parseQuestion(type, num, parent);
        return null;
    }

    private BaseQuestion parseQuestion(String type, String num, String name, String folder) {
        return null;
    }

    private String[] analysis(String shortName) {
        Matcher matcher = pattern.matcher(shortName);
        String type = matcher.group(1);
        String num = matcher.group(2);
        return new String[]{type, num};
    }


    private void init() {
        //拼凑正确命名需要的正则字符
        StringBuilder sb = new StringBuilder();
        if (!prefixes.isEmpty()) {
            sb.append("([");
            for (String prefix : prefixes) sb.append(prefix).append("|");
            sb.append("])");
            sb.append("(\\d{1,4})");
            pattern = Pattern.compile(sb.toString());
        }
    }


    public void start() throws IOException {
        init();
        Path path = Paths.get(SCAN);
        Files.walkFileTree(path, this);

        StringBuilder result = new StringBuilder();
        result.append(preface);
        int count = map.values().stream().mapToInt(List::size).sum();
        result.append(String.format("Java已刷题目 :<font color=red>%s</font>\n\n", count));


        for (Map.Entry<String, List<BaseQuestion>> item : map.entrySet()) {

        }
        //生成markdown格式的字符串
        //插入表格表格
        result.append("| 题号 | Title |Java|类别|\n" +
                "| ------------- | ------------- |---|---|\n");


    }

    public static void main(String[] args) {
        createSheetV2 createSheetV2 = new createSheetV2();
        createSheetV2.init();
    }
}
