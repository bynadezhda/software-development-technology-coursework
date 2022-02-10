package com.example.kursach.config.converter;

import com.example.kursach.model.Resume;
import com.example.kursach.model.dto.ResumeDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ResumeConverterConfig {
    @Bean("summaryModelMapper")
    public ModelMapper getSummaryModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<ResumeDto, Resume>() {
            @Override
            protected void configure() {
                skip(destination.getUser());
            }
        });

        return modelMapper;
    }
}