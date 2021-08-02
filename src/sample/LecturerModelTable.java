package sample;

public class LecturerModelTable {
    String id,name,faculty,course;

    public LecturerModelTable(String id, String name, String faculty, String course) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.course = course;
    }

    public LecturerModelTable(String name, String faculty, String course) {
        this.name = name;
        this.faculty = faculty;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
