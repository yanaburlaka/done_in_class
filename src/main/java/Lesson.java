import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.io.IOUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.Charset;

public class Lesson {

    public static void main(String[] args) throws IOException, JAXBException {
        FileInputStream in = new FileInputStream("some.txt");
        FileOutputStream out = new FileOutputStream("some_copy.txt");
        IOUtils.copy(IOUtils.buffer(in), out);
        String someText1 = "some";
        InputStream someText2 = IOUtils.toInputStream(someText1, Charset.defaultCharset());
        IOUtils.copy(someText2, new FileOutputStream("someSome.txt"));
        out.flush();
        jaxb();
        jacksonXml();
        jacksonJson();
    }

    private static void jacksonJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        Course course = new Course(3, "dfsdf");
        objectMapper.writeValue(new File("course_json.json"), course);
        Course course1 = objectMapper.readValue(new File("course_json.json"), Course.class);
        System.out.println(course1);
    }

    private static void jacksonXml() throws IOException{
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        Course course = new Course(3, "dfsdf");
        xmlMapper.writeValue(new File("course_2.xml"), course);
        Course course1 = xmlMapper.readValue(new File("course_2.xml"), Course.class);
        System.out.println(course1);



    }

    private static void jaxb() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        Course course = new Course(2, "sddsd");
        System.out.println(course);
        System.out.println(course.getId());
        marshaller.marshal(course, new File("course.xml"));

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object obj = unmarshaller.unmarshal(new File("course.xml"));
        System.out.println(obj);


    }
}

