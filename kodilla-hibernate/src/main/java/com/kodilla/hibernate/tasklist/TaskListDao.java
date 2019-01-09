package com.kodilla.hibernate.tasklist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TaskListDao extends CrudRepository<TaskList, Integer> {

    List<TaskList> findByListName(String listname);
}
