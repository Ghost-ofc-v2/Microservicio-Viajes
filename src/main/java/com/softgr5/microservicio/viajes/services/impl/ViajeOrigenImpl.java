package com.softgr5.microservicio.viajes.services.impl;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.softgr5.microservicio.viajes.DTO.BuscarViajeOrigen;
import com.softgr5.microservicio.viajes.entity.ViajeDestino;
import com.softgr5.microservicio.viajes.entity.ViajeOrigen;
import com.softgr5.microservicio.viajes.entity.Viajes;
import com.softgr5.microservicio.viajes.reposDynamo.ViajeOrigenRepository;
import com.softgr5.microservicio.viajes.services.ViajeOrigenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ViajeOrigenImpl implements ViajeOrigenService {


    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    @Override
    public List<Viajes> buscarViajeOrigen(BuscarViajeOrigen buscarViajeOrigen) {

        try {

            // Obtener todas las entradas de ViajeOrigen
            List<ViajeOrigen> origenes = dynamoDBMapper.scan(ViajeOrigen.class, new DynamoDBScanExpression()
                    .withFilterExpression("ciudadorigen = :ciudadOrigen")
                    .withExpressionAttributeValues(Map.of(":ciudadOrigen", new AttributeValue().withS(buscarViajeOrigen.getCiudadorigen()))));

            // Obtener todas las entradas de ViajeDestino
            List<ViajeDestino> destinos = dynamoDBMapper.scan(ViajeDestino.class, new DynamoDBScanExpression()
                    .withFilterExpression("ciudaddestino = :ciudadDestino")
                    .withExpressionAttributeValues(Map.of(":ciudadDestino", new AttributeValue().withS(buscarViajeOrigen.getCiudaddestino()))));

            // Filtrar las entradas de ViajeOrigen y ViajeDestino
            Map<String, ViajeOrigen> origenMap = new HashMap<>();
            Map<String, ViajeDestino> destinoMap = new HashMap<>();
            for (ViajeOrigen origen : origenes) {
                origenMap.put(origen.getIdviajeorigen(), origen);
            }
            for (ViajeDestino destino : destinos) {
                destinoMap.put(destino.getIdviajedestino(), destino);
            }

            // Obtener todos los viajes
            List<Viajes> viajes = dynamoDBMapper.scan(Viajes.class, new DynamoDBScanExpression()
                    .withFilterExpression("fecha_hora_salida = :fechaorigen")
                    .withExpressionAttributeValues(Map.of(":fechaorigen", new AttributeValue().withS(buscarViajeOrigen.getFechaorigen()))));

            // Filtrar los viajes por origen y destino
            viajes.removeIf(v -> !origenMap.containsKey(v.getViajeOrigen()) || !destinoMap.containsKey(v.getViajeDestino()));

            return viajes;
        }catch (Exception e) {
            throw new RuntimeException("Error al actualizar el viaje: " + e.getMessage());
        }
    }

}
