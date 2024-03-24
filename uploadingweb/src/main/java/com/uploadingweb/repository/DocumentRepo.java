package com.uploadingweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uploadingweb.entity.Document;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Integer>{

}
