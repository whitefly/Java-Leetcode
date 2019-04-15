import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;

class Question implements Comparable<Question> {
    int id;
    String kind;
    String name;
    String ref_position;
    static int prefixSize = createSheet.COMMON_PREFIX.length();

    public Question(String name, String folder) {
        int first = name.indexOf('_');
        int last = name.lastIndexOf('.');

        this.id = Integer.valueOf(name.substring(prefixSize, first));
        this.kind = folder;
        this.name = name.substring(first + 1, last).replace('_', ' ');
        this.ref_position = String.format("src/%s/%s", folder, name);
    }

    @Override
    public int compareTo(Question o) {
        return this.id - o.id;
    }

}

class TestQuestion implements Comparable<TestQuestion> {
    int testWeek; //第几个周
    int innerId; //竞赛4题中的哪一题
    String kind;
    String name;
    String ref_position;


    static int prefixSize = createSheet.TEST_PREFIX.length();

    public TestQuestion(String name, String folder) {
        int first = name.indexOf('_');
        int second = name.indexOf("_", first + 1);
        int last = name.lastIndexOf('.');

        this.testWeek = Integer.valueOf(name.substring(prefixSize, first));
        this.innerId = Integer.valueOf(name.substring(first + 1, second));
        this.kind = folder;
        this.name = name.substring(second + 1, last).replace('_', ' ');
        this.ref_position = String.format("src/%s/%s", folder, name);
    }


    @Override
    public int compareTo(TestQuestion o) {
        return 0;
    }
}

public class createSheet {
    static final String TEST_PREFIX = "C"; //竞赛题的前缀contest
    static final String COMMON_PREFIX = "Q"; //普通题的前缀question

    public static void main(String[] args) throws IOException {
        /**
         *  用来遍历文件夹,自动生成刷题表格
         */
        //含有题号的普通题
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<TestQuestion> testQuestions = new ArrayList<>();


        //添加文件实例
        Path path = Paths.get("src");
        Files.walkFileTree(path, new FileVisitor<Path>() {
            // 访问一个节点之前、之中、之后、失败应该做什么

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                //根据题目前缀加入不同的存储容器
                String file_name = file.getFileName().toString();
                String folder = file.getParent().getFileName().toString();
                if (file_name.endsWith("java") && !folder.equals("src")) {
                    if (file_name.startsWith(COMMON_PREFIX)) {
                        Question question = new Question(file_name, folder);
                        questions.add(question);
                    } else if (file_name.startsWith(TEST_PREFIX)) {
                        TestQuestion testQuestion = new TestQuestion(file_name, folder);
                        testQuestions.add(testQuestion);
                    }
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });

        //按id排序
        Collections.sort(questions);
        Collections.sort(testQuestions);


        // 生成markdown格式的字符串
        StringBuilder result = new StringBuilder();
        result.append("# java的刷题本\n" +
                "\n" +
                "之前用java写过项目,但是太久不使用,有点生疏\n" +
                "<br>日常需求\n" +
                "1. 使用大数据工具来搭建集群和处理数据\n" +
                "2. 编写简单的大数据平台\n" +
                "\n" +
                "所以决定继续用java刷一下leetcode,\n" +
                "<br>快速熟悉一遍java\n" +
                "预期时间1个月,每天5题左右\n" +
                "\n");

        result.append(String.format("Java已刷题目 :<font color=red>%s</font>\n\n", questions.size()));


        //插入表格表格
        result.append("| 题号 | Title |java|类别|\n" +
                "| ------------- | ------------- |---|---|\n");
        for (Question q : questions) {
            result.append(String.format("| %d | %s | [答案链接](%s) | %s |\n",
                    q.id,
                    q.name,
                    q.ref_position,
                    q.kind));
        }

        result.append("\n\n\n");
        //插入竞赛题的行
        result.append("|竞赛周| 题号(1-4) | Title |java|类别|\n" +
                "|-----| ------------- | ------------- |---|---|\n");
        for (TestQuestion testQuestion : testQuestions) {
            result.append(String.format("| %d | %d | %s | [答案链接](%s) | %s |\n",
                    testQuestion.testWeek,
                    testQuestion.innerId,
                    testQuestion.name,
                    testQuestion.ref_position,
                    testQuestion.kind));
        }

        //写入README.md
        FileWriter fw = new FileWriter(new File("README.md"), false);
        fw.write(result.toString());
        fw.close();
    }
}
