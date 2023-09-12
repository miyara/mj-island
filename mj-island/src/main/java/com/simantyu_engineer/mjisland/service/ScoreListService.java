package com.simantyu_engineer.mjisland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simantyu_engineer.mjisland.domain.model.gameSetting;
import com.simantyu_engineer.mjisland.domain.model.memberMst;
import com.simantyu_engineer.mjisland.domain.model.PlayerList;
import com.simantyu_engineer.mjisland.repository.MemberMstRepository;
import com.simantyu_engineer.mjisland.repository.PlayerListRepository;
import com.simantyu_engineer.mjisland.repository.GameSettingRepository;

@Service
@Transactional
public class ScoreListService {
    @Autowired
    private MemberMstRepository mmRepo;
    @Autowired
    private PlayerListRepository plRepo;
    @Autowired
    private GameSettingRepository gsRepo;

    /**
     * 会員マスタ - レコードを全件取得
     */
    public List<memberMst> findAllMemberMst(){
        return mmRepo.findAll();
    }

    /**
     * プレイヤー一覧 - レコードを全件取得
     */
    public List<PlayerList> findAllPlayerList(){
        return plRepo.findAll();
    }

    /**
     * ゲーム設定 - レコード全件取得
     */
    public List<gameSetting> findAllScoreList(){
        return gsRepo.findAll();
    }
}
