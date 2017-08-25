package lastfourthattemptrobo.demo.ModelLayer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skills
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=4,max=40)
    private String skillOne;
    @NotNull
    @Size(min=4,max=40)
    private String skillTwo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkillOne() {
        return skillOne;
    }

    public void setSkillOne(String skillOne) {
        this.skillOne = skillOne;
    }

    public String getSkillTwo() {
        return skillTwo;
    }

    public void setSkillTwo(String skillTwo) {
        this.skillTwo = skillTwo;
    }

}
