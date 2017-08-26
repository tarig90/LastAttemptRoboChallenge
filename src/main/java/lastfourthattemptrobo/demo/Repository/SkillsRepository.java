package lastfourthattemptrobo.demo.Repository;

import lastfourthattemptrobo.demo.ModelLayer.Resume;
import lastfourthattemptrobo.demo.ModelLayer.Skills;
import org.springframework.data.repository.CrudRepository;

public interface SkillsRepository extends CrudRepository<Skills,Long>
{
    //Long CountBySkillsId(Long id);
}
