package com.softgr5.microservicio.viajes.reposDynamo;

import com.softgr5.microservicio.viajes.entity.ViajeDestino;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajeDestinoRepository extends DynamoDBCrudRepository<ViajeDestino, String> {
}