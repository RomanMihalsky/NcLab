package com.nc.mihalsky.factories;

import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;

import java.util.logging.Logger;

/**
 *Класс FactoryClient со свойствами <b>generatorID</b>,<b>logger</b>
 * @author Roman Mihalsky
 */
public class FactoryClient {
  /**Статическое поле генератор id*/
  private static GeneratorID generatorID = new GeneratorID();
  /**Статическое поле logger для вывода информации в консоль*/
  private static Logger logger = Logger.getLogger("Logger");

  /**
   * Статическая функция создания клиента @link Client} с default значениями
   * и генерацией id.
   * @return новый объект типа {@link Client}
   */
  public static Client createClient(){
    Client client = new Client();
    client.setId(generatorID.generate());
    logger.info("Created default client with id " + client.getId());
    return client;
  }

  /**
   * Статическая функция создания клиента {@link Client} с параметрами и генерацией id
   * @param name - имя клиента
   * @param surname - фамилия клиента
   * @param patronymic - отчество клиента
   * @param gender - пол клиента
   * @param phoneNumber - номер телефона клиента
   * @param passportSeries - серия паспорта клиента
   * @param passportNumber - номер паспорта клиента
   * @param dateOfBirthDay - дата рождения клиента клиента
   * @return новый объект типа {@link Client}
   */
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
