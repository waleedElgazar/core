package com.waleedreda.core.repo;


import com.waleedreda.core.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo<E extends BaseEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {
}
