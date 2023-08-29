package com.simantyu_engineer.mjisland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simantyu_engineer.mjisland.domain.model.memberMst;
import com.simantyu_engineer.mjisland.repository.ScoreListRepository;

@Service
@Transactional
public class ScoreListService {
    @Autowired
    private ScoreListRepository repository;

    /**
     * レコードを全件取得
     */
    // public List<memberMst> findAllMemberMst(){
    //     return repository.findAll();
    // }
}
