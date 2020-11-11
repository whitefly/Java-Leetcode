import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class createSheetV2 extends SimpleFileVisitor<Path> {
    private final static String README_NAME = "README.md";
    private final static String SCAN = "src";
    private static final Pattern pattern;
    private static final String preface = "# Java的刷题本";
    private static final Map<String, String> letter2Name = new HashMap<>(); //存放 O->剑指offer 字母到

    private final Map<String, List<BaseQuestion>> map = new TreeMap<>(Collections.reverseOrder());
    StringBuilder result = new StringBuilder();


    static {
        letter2Name.put("Q", "LeetCode");
        letter2Name.put("O", "剑指offer");

        //正则生成
        String join = String.join("|", letter2Name.keySet());
        String pat = String.format("([%s])(\\d{1,5})_(\\S*)\\.java", join);
        System.out.println("筛选文件正则表达式:  " + pat);
        pattern = Pattern.compile(pat);
    }


    static class BaseQuestion {
        String type; //题目种类(普通,竞赛)
        int id; //
        String name; //题目名字
        String ref; //题目相对位置
        String kind; //题目类型

        public BaseQuestion(String type, int id, String name, String ref, String parent) {
            this.type = type;
            this.id = id;
            this.name = name;
            this.ref = ref;
            this.kind = parent;
        }
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (attrs.isDirectory()) return FileVisitResult.CONTINUE;

        String absPath = file.toAbsolutePath().toString();
        BaseQuestion question = parse(absPath);

        if (question != null) {
            String type = question.type;
            map.compute(type, (k, v) -> {
                if (v == null) v = new ArrayList<>();
                v.add(question);
                return v;
            });
        }
        return FileVisitResult.CONTINUE;
    }


    private boolean checkJavaFile(String name) {
        return name.endsWith(".java");
    }


    private BaseQuestion parse(String fullPath) {
        if (!checkJavaFile(fullPath)) return null;

        String[] split = fullPath.split("/");
        if (split.length < 3) {
            System.out.println("文件名无法解析:" + fullPath);
            return null;
        }
        String parent = split[split.length - 2];
        String fullFileName = split[split.length - 1];
        Matcher m = pattern.matcher(fullFileName);
        if (!m.find()) return null;

        String type = m.group(1);
        int num = Integer.parseInt(m.group(2));
        String caseName = m.group(3).replace("_", " ");
        String ref = String.format("src/%s/%s", parent, fullFileName);

        //创建Question对象
        return new BaseQuestion(type, num, caseName, ref, parent);
    }

    private void fillReadMe() {
        //添加序言
        addPreface();

        for (Map.Entry<String, List<BaseQuestion>> item : map.entrySet()) {
            //对集合排序
            List<BaseQuestion> list = item.getValue();
            list.sort(Comparator.comparingInt(x -> x.id));

            //生成md格式
            result.append(String.format("题库:%s  已刷:%d\n\n\n", letter2Name.get(item.getKey()), list.size()));
            result.append(getSheetHeader());
            list.forEach(x -> result.append(getSheetRow(x)));
            result.append("\n\n\n");
            System.out.println(letter2Name.get(item.getKey()) + "题: 填充完毕");
        }
    }

    private void addPreface() {
        result.append(preface).append("\n\n");
    }

    private void scan() throws IOException {
        Path path = Paths.get(SCAN);
        Files.walkFileTree(path, this);
    }

    private String getSheetHeader() {
        return "| 题号 | Title |java|类别|\n" + "| ------------- | ------------- |---|---|\n";
    }

    private String getSheetRow(BaseQuestion q) {
        return String.format("| %d | %s | [答案链接](%s) | %s |\n", q.id, q.name, q.ref, q.kind);
    }

    public void save() {
        try (FileWriter fileWriter = new FileWriter(new File(README_NAME))) {
            fileWriter.write(result.toString());
        } catch (IOException e) {
            System.out.println("readme写入失败");
            e.printStackTrace();
        }
        System.out.println("readme.md 生成success");
    }

    public void start() throws IOException {
        //扫描文件
        scan();

        //生成README.md
        fillReadMe();

        //写
        save();
    }

    public static void main(String[] args) throws IOException {
        createSheetV2 v2 = new createSheetV2();
        v2.start();
    }
}
