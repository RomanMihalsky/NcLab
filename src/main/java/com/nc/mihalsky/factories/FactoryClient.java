package com.nc.mihalsky.factories;

import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;

import java.util.logging.Logger;

public class FactoryClient {
  private static GeneratorID generatorID = new GeneratorID();
  private static Logger logger = Logger.getLogger("Logger");

  public static Client createClient(){
    Client client = new Client();
    client.setId(generatorID.generate());
    logger.info("Created default client with id " + client.getId());
    return client;
  }

  public static  Client createClient(String name,
                                     String surname,
                                     String patronymic,
                                     String gender,
                                     long phoneNumber,
                                     int passportSeries,
                                     int passportNumber,
                                     LocalDate dateOfBirthDay){
    Client client = new Client(generatorID.generate(),
            name,
            surname,
            patronymic,
            gender,phoneNumber,
            passportSeries,
            passportNumber,
            dateOfBirthDay);

    logger.info("Create client with id " + client.getId());
    return client;
  }
}
