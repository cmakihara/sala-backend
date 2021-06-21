package com.dio.crud.sala.sala.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.crud.sala.sala.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
