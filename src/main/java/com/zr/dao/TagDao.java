package com.zr.dao;


import com.zr.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDao extends JpaRepository<Tag,Long> {
}