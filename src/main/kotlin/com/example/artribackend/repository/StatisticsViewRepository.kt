package com.example.artribackend.repository

import com.example.artribackend.model.StatisticsView
import org.springframework.data.jpa.repository.JpaRepository

interface StatisticsViewRepository:JpaRepository<StatisticsView, Long> {
    fun findById(id: Long?):StatisticsView?
}