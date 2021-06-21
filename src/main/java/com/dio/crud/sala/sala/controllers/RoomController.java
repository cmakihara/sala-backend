package com.dio.crud.sala.sala.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.crud.sala.sala.exceptions.ResourceNotFoundException;
import com.dio.crud.sala.sala.models.Room;
import com.dio.crud.sala.sala.services.RoomService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@GetMapping("/rooms")
	public List<Room> getAllRooms() {
		
		return roomService.getAll();
	}
	
	@GetMapping("/rooms/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable(value = "id")  Long roomId) throws ResourceNotFoundException{

		return roomService.getById(roomId);
		
	}
	
	@PostMapping("/rooms")
	public Room createRoom(@Valid @RequestBody Room room) {
		return roomService.saveRoom(room);		
	}
	
	
	
	@PutMapping("/rooms/{id}")
	public ResponseEntity<Room> editar(@PathVariable(value = "id") Long roomId, @Valid @RequestBody Room room) {
		
		if(!roomService.existeById(roomId)) {
			return ResponseEntity.notFound().build();
		}
		
		room.setId(roomId);
		room = roomService.saveRoom(room);
		
		return ResponseEntity.ok().body(room);
		
	}
	
	@DeleteMapping("rooms/{id}")
	public ResponseEntity<Room> delete(@PathVariable(value = "id") Long roomId, Room room) throws ResourceNotFoundException {
		
		if(!roomService.existeById(roomId)) {
			return ResponseEntity.notFound().build();
		}
				
		return roomService.deleteRoom(roomId);
	}
	
	
	
}
