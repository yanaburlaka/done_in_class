import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Course {
    private Integer id;
    private String name;
    private Date date;

    public Course(Integer id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Date getDate() {
        return date;

    }

    public String getName() {
        return name;
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course() {
    }

    public Integer getId() {
        return id;


    }
}
