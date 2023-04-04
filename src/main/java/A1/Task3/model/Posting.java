package A1.Task3.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posting")
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "matDoc")
    private String matDoc;

    @Column(name = "name")
    private String name;

    @Column(name = "autowiredPost")
    private boolean autowiredPost;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pstngDate")
    private Date pstngDate;

    public Posting() {
    }

    public Posting(String matDoc, String name, Date pstngDate) {
        this.matDoc = matDoc;
        this.name = name;
        this.pstngDate = pstngDate;
    }

    public Posting(String matDoc, String name, Date pstngDate, boolean autowiredPost) {
        this.matDoc = matDoc;
        this.name = name;
        this.pstngDate = pstngDate;
        this.autowiredPost = autowiredPost;
    }

    public Date getPstngDate() {
        return pstngDate;
    }

    public void setPstngDate(Date pstngDate) {
        this.pstngDate = pstngDate;
    }

    public long getId() {
        return id;
    }

    public String getMatDoc() {
        return matDoc;
    }

    public void setMatDoc(String matDoc) {
        this.matDoc = matDoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAutowiredPost() {
        return autowiredPost;
    }

    public void setAutowiredPost(boolean autowiredPost) {
        this.autowiredPost = autowiredPost;
    }

    @Override
    public String toString() {
        return "Posting{" +
                "id=" + id +
                ", matDoc='" + matDoc + '\'' +
                ", name='" + name + '\'' +
                ", autowiredPost=" + autowiredPost +
                ", pstngDate='" + pstngDate + '\'' +
                '}';
    }
}
