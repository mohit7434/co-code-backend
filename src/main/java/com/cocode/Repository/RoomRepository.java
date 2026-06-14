package com.cocode.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cocode.model.RoomEntity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, String> {

}
