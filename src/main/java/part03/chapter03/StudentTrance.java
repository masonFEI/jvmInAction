/**
 * LY.com Inc.
 * Copyright (c) 2004-2026 All Rights Reserved.
 */
package part03.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * StudentTrance
 *
 * -XX:+HeapDumpBeforeFullGC -XX:HeapDumpPath=d:\student.hprof
 * @author feixuanyu
 * @version 1.0.0
 * @since 2026-03-22 22:16
 */
public class StudentTrance {
    static List<WebPage> webPages = new ArrayList<WebPage>();

    public static void createWebPage() {
        for (int i = 1; i < 100; i++) {
            WebPage wp = new WebPage();
            wp.setUrl("http://www." + Integer.toString(i) + ".com");
            wp.setContent(Integer.toString(i));
            webPages.add(wp);
        }
    }

    public static void main(String[] args) {
        createWebPage();// 创建了100个网页
        // 创建3个学生对象
        Student st3 = new Student(3, "Tom");
        Student st5 = new Student(5, "Jerry");
        Student st7 = new Student(7, "Lily");

        for (int i = 0; i < webPages.size(); i++) {
            if (i % st3.getId() == 0) {
                st3.visit(webPages.get(i));
            }

            if (i % st5.getId() == 0) {
                st5.visit(webPages.get(i));
            }

            if (i % st7.getId() == 0) {
                st7.visit(webPages.get(i));
            }
        }

        webPages.clear();
        System.gc();
    }

}

class WebPage {
    private String url;

    private String content;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }
}

class Student {
    private int           id;

    private String        name;

    private List<WebPage> history = new ArrayList<WebPage>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<WebPage> getHistory() {
        return history;
    }

    public void setHistory(List<WebPage> history) {
        this.history = history;
    }

    public void visit(WebPage wp) {
        if (Objects.nonNull(wp)) {
            history.add(wp);
        }
    }

}
