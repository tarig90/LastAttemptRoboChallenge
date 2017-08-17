package lastfourthattemptrobo.demo.ModelLayer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
public class Resume
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String firstName;
    private String lastName;
    private String name;
    @NotNull
    private String emailAddress;

    private ArrayList<Experience> experience;
    private ArrayList<EducationalAchievements> education;
    private ArrayList<Skills> skillSet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }



    public ArrayList<Skills> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(ArrayList<Skills> skillSet) {
        this.skillSet = skillSet;
    }

    public ArrayList<Experience> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<Experience> experience) {
        this.experience = experience;
    }

    public ArrayList<EducationalAchievements> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<EducationalAchievements> education) {
        this.education = education;
    }

}
