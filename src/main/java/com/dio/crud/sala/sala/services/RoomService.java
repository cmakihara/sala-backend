package com.dio.crud.sala.sala.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dio.crud.sala.sala.exceptions.ResourceNotFoundException;
import com.dio.crud.sala.sala.models.Room;
import com.dio.crud.sala.sala.repositories.RoomRepository;

@Service
public class RoomService {

	
	@Autowired
	private RoomRepository roomRepository;

	public List<Room> getAll() {		
		return roomRepository.findAll();
	}
	
	public ResponseEntity<Room> getById(Long roomId) throws ResourceNotFoundException {
		Room room = roomRepository.findById(roomId)
			.orElseThrow(()-> new ResourceNotFoundException("Room not found:: " + roomId));
		return ResponseEntity.ok().body(room);
	}

	public Room saveRoom(Room room) {		
		return roomRepository.save(room);
	}
	
	public ResponseEntity<Room> deleteRoom(Long roomId) {
		roomRepository.deleteById(roomId);
		return null;
	}
//	public ResponseEntity<Room> deleteRoom(Long roomId) throws ResourceNotFoundException {
//		Room room = roomRepository.findById(roomId)
//				.orElseThrow(()-> new ResourceNotFoundException("Room not found:: " + roomId));
//		roomRepository.deleteById(roomId);
//		return null;
//	}
	
	public Room updateRoom(Long roomId, Room room) throws ResourceNotFoundException {
		
		ResponseEntity<Room> newRoom = getById(room.getId());
		return room;
		
	}
	
	public boolean existeById(Long roomId) {
		return roomRepository.existsById(roomId);
	}
	
}
