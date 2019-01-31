import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@XmlRootElement
public class Course {
    private Integer id;
    private String name;




    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
