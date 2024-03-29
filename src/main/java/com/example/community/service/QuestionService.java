package com.example.community.service;

import com.example.community.dto.PageinationDTO;
import com.example.community.dto.QuestionDTO;
import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;



    public PageinationDTO list(Integer page, Integer size) {

        PageinationDTO pageinationDTO = new PageinationDTO();
        Integer totalCount=questionMapper.count();
        pageinationDTO.setPagination(totalCount,page,size);

        if(page<1){
            page=1;
        }
        if(page>pageinationDTO.getTotalPage()){
            page=pageinationDTO.getTotalPage();
        }
        Integer offset=size*(page-1);
        List<Question> questions=questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();

        for(Question question:questions){
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        pageinationDTO.setQuestions(questionDTOList);
        return pageinationDTO;
    }
}
