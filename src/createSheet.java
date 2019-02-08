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


    public Question(String name, String folder) {
        int first = name.indexOf('_');
        int last = name.lastIndexOf('.');

        this.id = Integer.valueOf(name.substring(1, first));
        this.kind = folder;
        this.name = name.substring(first + 1, last).replace('_', ' ');
        this.ref_position = String.format("src/%s/%s", folder, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef_position() {
        return ref_position;
    }

    public void setRef_position(String ref_position) {
        this.ref_position = ref_position;
    }

    @Override
    public int compareTo(Question o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", name='" + name + '\'' +
                ", ref_position='" + ref_position + '\'' +
                '}';
    }
}

public class createSheet {
    public static void main(String[] args) throws IOException {
        /**
         *  用来遍历文件夹,自动生成刷题表格
         */
        ArrayList<Question> container = new ArrayList<>();

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


                String file_name = file.getFileName().toString();
                String folder = file.getParent().getFileName().toString();
                if (file_name.endsWith("java") && !folder.equals("src")) {
                    Question question = new Question(file_name, folder);
                    container.add(question);
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
        Collections.sort(container);


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

        result.append(String.format("Java已刷题目 :<font color=red>%s</font>\n\n", container.size()));


        //插入表格表格
        result.append("| 题号 | Title |java|类别|\n" +
                "| ------------- | ------------- |---|---|\n");
        for (Question q : container) {
            result.append(String.format("| %d | %s | [答案链接](%s) | %s |\n", q.id, q.name, q.ref_position, q.kind));
        }

        //写入README.md
        FileWriter fw = new FileWriter(new File("README.md"), false);
        fw.write(result.toString());
        fw.close();
    }

}
