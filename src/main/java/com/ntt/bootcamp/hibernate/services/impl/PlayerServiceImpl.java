package com.ntt.bootcamp.hibernate.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.bootcamp.hibernate.bbdd.Player;
import com.ntt.bootcamp.hibernate.bbdd.dao.PlayerDao;
import com.ntt.bootcamp.hibernate.services.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerDao;
	
	@Override
	@Transactional
	public void insertNewPlayer(Player player) {
		if (player != null) {
			playerDao.insert(player);
		}			
	}

	@Override
	@Transactional
	public Player searchPlayerByID(Long id) {
		Player player = null;
		if (null != id) {
			player = playerDao.searchId(id);
		}
		return player;
	}

}
