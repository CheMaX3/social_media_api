package org.chemax.repository;

import org.chemax.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

    Friend findByRequesterIdAndRequestedId(Long requesterId, Long requestedId);

    List<Friend> findByRequesterId(Long requesterId);
}
