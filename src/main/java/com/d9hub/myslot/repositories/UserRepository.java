/**
 * 
 */
package com.d9hub.myslot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.d9hub.myslot.models.Slot;
import com.d9hub.myslot.models.User;

/**
 * @author lruhunage
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

}
