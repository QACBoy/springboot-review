package com.qacboy.girl.repository;

import com.qacboy.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/8/23 下午8:21
 *
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
}
