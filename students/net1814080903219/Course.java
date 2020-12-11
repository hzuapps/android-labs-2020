package edu.hzuapps.androidlabs.net1814080903219;

public class Course {
    private String name;
    private int credit;
    private String category;
    private int score;

    public Course() {
    }

    public Course(String name, int credit, String category, int score) {
        this.name = name;
        this.credit = credit;
        this.category = category;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", credit=" + credit +
                ", category='" + category + '\'' +
                ", score=" + score +
                '}';
    }
}
