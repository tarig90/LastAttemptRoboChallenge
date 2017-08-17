package lastfourthattemptrobo.demo.ControllerLayer;

import lastfourthattemptrobo.demo.ModelLayer.EducationalAchievements;
import lastfourthattemptrobo.demo.ModelLayer.Experience;
import lastfourthattemptrobo.demo.ModelLayer.Resume;
import lastfourthattemptrobo.demo.ModelLayer.Skills;
import lastfourthattemptrobo.demo.Repository.EducationalRepository;
import lastfourthattemptrobo.demo.Repository.ExperienceRepository;
import lastfourthattemptrobo.demo.Repository.ResumeRepository;
import lastfourthattemptrobo.demo.Repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    ResumeRepository resumeRepository;
    @Autowired
    EducationalRepository educationalRepository;
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    ExperienceRepository experienceRepository;


    @RequestMapping("/")
    public String listCourses(Model model){
        model.addAttribute("resumes", resumeRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String courseForm(Model model){
        model.addAttribute("resume", new Resume());
        return "courseform";
    }

    @PostMapping("/process")
    public String processForm(Resume resumem){
//        if (result.hasErrors()){
//            return "courseform";
//        }
        resumeRepository.save(resumem);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepository.findOne(id));
        return "show";
    }


    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepository.findOne(id));
        return "courseform";
    }



    // Educational Section in the Resume
    @GetMapping("/entereducation")
    public String EnterEducation(Model model)
    {
        model.addAttribute("neweduc", new EducationalAchievements());

        return "entereducation";
    }

    @RequestMapping("/updateEdu/{id}")
    public String updateEducation(@PathVariable("id") long id, Model model){
        model.addAttribute("neweduc", educationalRepository.findOne(id));
        return "entereducation";
    }

    @RequestMapping("/delete/{id}")
    public String delEducation(@PathVariable("id") long id)
    {
        educationalRepository.delete(id);
        return "redirect:/";
    }

    //
    @PostMapping("/entereducation")
    public String postEnterEDucation(@Valid @ModelAttribute("neweduc") EducationalAchievements eduction, BindingResult bindingResult)
    {
        educationalRepository.save(eduction);

        return "confirmeducation";
    }

    @GetMapping("/displayeducation")
    public String displayEDucation(Model model)
    {
        Iterable<EducationalAchievements> educalista = educationalRepository.findAll();
        model.addAttribute("educalistas",educalista );
        return "displayeducation";
    }

    //Skills section

    @GetMapping("/entersetofskills")
    public String enterSkills(Model model)
    {
       model.addAttribute("newskill" , new Skills());
        return  "entersetofskills";
   }


   @PostMapping("/entersetofskills")
   public String postSkills(@Valid @ModelAttribute("newskill") Skills skills, BindingResult bindingResult)
   {
       skillsRepository.save(skills);
       return "skillsconfirmed";
    }

    @RequestMapping("/delSkill/{id}")
    public String delSkills(@PathVariable("id") long id)
    {
        educationalRepository.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/updateSkl/{id}")
    public String updateSkill(@PathVariable("id") long id, Model model){
        model.addAttribute("newskill", skillsRepository.findOne(id));
        return "entersetofskills";
    }


    @GetMapping("/displayskills")
     public String displayskills(Model model)
    {
    Iterable<Skills> skllista = skillsRepository.findAll();
     model.addAttribute("skillistas", skllista);
     return "displayskills";
    }

  // Experience section
        @GetMapping("/enterexperience")
       public String enterExperience(Model model)
      {
      model.addAttribute("newexp", new Experience());

      return "enterexperience";
     }


   @PostMapping("/enterexperience")
   public String postEnterEXperience(@Valid @ModelAttribute("newexp") Experience experience , BindingResult bindingResult)
    {
       experienceRepository.save(experience);
       return  "experienceconfirmed";
    }

    @RequestMapping("/delExpr/{id}")
    public String delExperience(@PathVariable("id") long id)
    {
        educationalRepository.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/updateExp/{id}")
    public String updateExperience(@PathVariable("id") long id, Model model){
        model.addAttribute("newexp", experienceRepository.findOne(id));
        return "enterexperience";
    }


    @GetMapping("/displayexperience")
    public String displayExperience(Model model)
    {
        Iterable<Experience> exprList = experienceRepository.findAll();
        model.addAttribute("experienceLista",exprList);

        return "displayexperience";
     }

    @GetMapping("/displayresume")
    public String displayResume(Model model)
    {



        Resume resumeOBject= resumeRepository.findOne(new Long(1));

        ArrayList<EducationalAchievements> educationlist=((ArrayList<EducationalAchievements>) educationalRepository.findAll());
        resumeOBject.setEducation(educationlist);

        ArrayList<Experience> worklist=((ArrayList<Experience>)experienceRepository.findAll());
        resumeOBject.setExperience(worklist);

        ArrayList<Skills> skilllist=((ArrayList<Skills>)skillsRepository.findAll());
        resumeOBject.setSkillSet(skilllist);

        model.addAttribute("resumeObjects", resumeOBject );


        return "displayresume";//


     }


}

//
//    @GetMapping("/entereducation")
//    public String EnterEducation(Model model)
//    {
//        model.addAttribute("neweduc", new EducationalAchievements());
//
//        return "entereducation";
//    }
//
//    @PostMapping("/entereducation")
//    public String postEnterEDucation(@Valid @ModelAttribute("neweduc") EducationalAchievements eduction, BindingResult bindingResult)
//    {
//        educationRepository.save(eduction);
//
//        return "confirmeducation";
//    }
//
//    @GetMapping("/enterexperience")
//    public String enterExperience(Model model)
//    {
//        model.addAttribute("newexp", new Experience());
//
//        return "enterexperience";
//    }
//
//
//    @PostMapping("/enterexperience")
//    public String postEnterEXperience(@Valid @ModelAttribute("newexp") Experience experience , BindingResult bindingResult)
//    {
//        experienceRepository.save(experience);
//        return  "experienceconfirmed";
//    }
//
//    @GetMapping("/entersetofskills")
//    public String enterSkills(Model model)
//    {
//        model.addAttribute("newskill" , new Skills());
//        return  "entersetofskills";
//    }
//
//
//    @PostMapping("/entersetofskills")
//    public String postSkills(@Valid @ModelAttribute("newskill") Skills skills, BindingResult bindingResult)
//    {
//        skillRepository.save(skills);
//        return "skillsconfirmed";
//    }
//
//    @GetMapping("/enterresume")
//    public String getResume(Model model)
//    {
//
//        model.addAttribute("newres", new Resume());
//        return "enterresume";
//    }
//
//    @PostMapping("/enterresume")
//    public String postResume(@Valid @ModelAttribute("newres") Resume resume, BindingResult bindingResult)
//    {
//        resumeRepository.save(resume);
//        return "confirmresume";
//    }
//
//    @GetMapping("/displayresume")
//    public String displayResume(Model model)
//    {
//
//
//
//        Resume resumeOBject= resumeRepository.findOne(new Long(1));
//
//        ArrayList<EducationalAchievements> educationlist=((ArrayList<EducationalAchievements>) educationRepository.findAll());
//        resumeOBject.setEducation(educationlist);
//
//        ArrayList<Experience> worklist=((ArrayList<Experience>)experienceRepository.findAll());
//        resumeOBject.setExperience(worklist);
//
//        ArrayList<Skills> skilllist=((ArrayList<Skills>)skillRepository.findAll());
//        resumeOBject.setSkillSet(skilllist);
//
//        model.addAttribute("resumeObjects", resumeOBject );
//
////
//        return "displayresume";//
//
//
//    }
//
//    @GetMapping("/displayexperience")
//    public String displayExperience(Model model)
//    {
//        Iterable<Experience> exprList = experienceRepository.findAll();
//        model.addAttribute("experienceLista",exprList);
//
//        return "displayexperience";
//    }
//
//    @GetMapping("/displayskills")
//    public String displayskills(Model model)
//    {
//        Iterable<Skills> skllista = skillRepository.findAll();
//        model.addAttribute("skillistas", skllista);
//        return "displayskills";
//    }
//
//    @GetMapping("/displayeducation")
//    public String displayEDucation(Model model)
//    {
//        Iterable<EducationalAchievements> educalista = educationRepository.findAll();
//        model.addAttribute("educalistas",educalista );
//        return "displayeducation";
//    }
//
//    @RequestMapping("/update/{id}")
//    public String updateEducation(@PathVariable("id") long id, Model model){
//        model.addAttribute("neweduc", educationRepository.findOne(id));
//        return "entereducation";
//    }
//
//
//    @RequestMapping("/update/{id}")
//    public String updateSkills(@PathVariable("id") long id, Model model){
//        model.addAttribute("newskill", skillRepository.findOne(id));
//        return "entersetofskills";
//    }
//
//    @RequestMapping("/update/{id}")
//    public String updateResume(@PathVariable("id") long id, Model model){
//        model.addAttribute("newres", resumeRepository.findOne(id));
//        return "enterresume";
//    }
//
//    @RequestMapping("/update/{id}")
//    public String updateExperience(@PathVariable("id") long id, Model model){
//        model.addAttribute("newexp", experienceRepository.findOne(id));
//        return "enterexperience";
//    }
