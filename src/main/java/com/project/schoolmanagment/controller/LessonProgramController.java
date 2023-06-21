package com.project.schoolmanagment.controller;

import com.project.schoolmanagment.payload.request.LessonProgramRequest;
import com.project.schoolmanagment.payload.response.LessonProgramResponse;
import com.project.schoolmanagment.payload.response.ResponseMessage;
import com.project.schoolmanagment.service.LessonProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/lessonPrograms")
@RequiredArgsConstructor
public class LessonProgramController {


    private final LessonProgramService lessonProgramService;


    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
    @PostMapping("/save")
    public ResponseMessage<LessonProgramResponse>saveLessonProgram(@RequestBody @Valid LessonProgramRequest lessonProgramRequest){
        return lessonProgramService.saveLessonProgram(lessonProgramRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER','TEACHER','STUDENT')")
    @GetMapping ("/getAll")
    public List<LessonProgramResponse> getAllLessonProgramByList(){
        return lessonProgramService.getAllLessonProgramList() ;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
    @GetMapping ("/getById/{id}")
    public LessonProgramResponse getLessonProgramById(@PathVariable Long id){
        return lessonProgramService.getLessonProgramById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER','TEACHER','STUDENT')")
    @GetMapping ("/getAllUnassigned")
    public List<LessonProgramResponse>getAllUnassigned(){
        return lessonProgramService.getAllLessonProgramUnassigned();
    }


    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER','TEACHER','STUDENT')")
    @GetMapping ("/getAllAssigned")
    public List<LessonProgramResponse> getAllAssigned(){
        return lessonProgramService.getAllAssigned();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER')")
    public ResponseMessage deleteLessonProgramById(@PathVariable Long id){
        return lessonProgramService.deleteLessonProgramById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER','TEACHER','STUDENT')")
    @GetMapping ("/search")
    public Page<LessonProgramResponse> search(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")int size,
            @RequestParam(value = "sort")String sort,
            @RequestParam(value = "type")String type ){
        return lessonProgramService.getAllLessonProgramByPage(page,size,sort,type);

    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER','TEACHER')")
    @GetMapping ("/getAllLessonProgramByTeacher")
    public Set<LessonProgramResponse> getAllLessonProgramByTeacherUserName(HttpServletRequest httpServletRequest){
        String userName = (String) httpServletRequest.getAttribute("username");
        return lessonProgramService.getLessonProgramByTeacher(userName);
    }

}












