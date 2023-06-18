package com.project.virtualktapp.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.virtualktapp.team.model.TeamModel;

@Repository
public interface TeamRepo extends JpaRepository<TeamModel, Integer>{

}
