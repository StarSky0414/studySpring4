package bean;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.springframework.stereotype.Repository;


@Repository
@JacksonXmlRootElement
public class PeopleXML {

    @JacksonXmlProperty(localName = "gradeId",isAttribute = true)
    public String Name = "Tom";

    @JacksonXmlProperty
    public int age = 25;


}
