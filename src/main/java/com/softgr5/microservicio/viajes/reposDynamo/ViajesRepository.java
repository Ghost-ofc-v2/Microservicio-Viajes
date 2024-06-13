package com.softgr5.microservicio.viajes.reposDynamo;

import com.softgr5.microservicio.viajes.entity.Viajes;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajesRepository extends DynamoDBCrudRepository<Viajes, String> {
}
