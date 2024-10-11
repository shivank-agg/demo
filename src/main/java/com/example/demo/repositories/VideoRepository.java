package com.example.demo.repositories;

import com.example.demo.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,  Integer> {
}
