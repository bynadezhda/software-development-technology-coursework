package com.example.kursach.config.converter;

import com.example.kursach.model.Resume;
import com.example.kursach.model.dto.ResumeDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResumeConverter {
    @Qualifier("summaryModelMapper")
    private final ModelMapper modelMapper;


    public ResumeDto toDto(Resume resume) {
        ResumeDto resumeDto = modelMapper.map(resume, ResumeDto.class);
        resumeDto.setImageUserId("/image/" + resume.getUser().getId());
        return resumeDto;
    }

    public Resume toEntity(ResumeDto resumeDto) {
        Resume resume = modelMapper.map(resumeDto, Resume.class);
        resume.setFirstName(resumeDto.getFirstName());
        resume.setLastName(resumeDto.getLastName());
        return resume;
    }
}