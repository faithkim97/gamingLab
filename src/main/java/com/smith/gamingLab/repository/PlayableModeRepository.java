package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.PlayableMode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlayableModeRepository extends CrudRepository<PlayableMode, Integer> {

    @Query(value = "select * from playable_mode where mode = ?1", nativeQuery = true)
    PlayableMode getMode(String mode);

}
