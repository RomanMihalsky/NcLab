package com.nc.mihalsky.openers.creators;

import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.factories.FactoryClient;
import com.nc.mihalsky.openers.CsvOpener;
import com.nc.mihalsky.openers.patterns.*;
import com.nc.mihalsky.simple.SimpleArray;
import com.nc.mihalsky.simple.SimpleList;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.util.HashMap;

/**
 *Класс CreatorClientFromCsv для создания клиента из csv данных
 * @author Roman Mihalsky
 */
public class CreatorClientFromCsv implements CreatorClientFromCsvI<Client> {
  /**Поле Map, где ключ(название поля в csv) и значение(соответствующий pattern)*/
  private HashMap<String,TitlePattern> mapPatterns;
  /**Список клиентов*/
  private SimpleList<Client> clients;

  /**Constructor заполняет  mapPatterns
   * и создает новый список клиентов
   */
  public CreatorClientFromCsv(HashMap<String,TitlePattern> mapPatterns){
    this.mapPatterns = mapPatterns;
    this.clients = new SimpleArray<>();
  }

  /**Функция возвращает нового клиента, созданного из csv
   * @param  values - данные из csv
   * @return Client - новый клиент
   */
  @Override
  public Client create(String[] values) {
    String name = values[mapPatterns.get(PatternName.nameTitle).getIndexOfTitle()];
    String surname = values[mapPatterns.get(PatternSurname.surnameTitle).getIndexOfTitle()];
    String patronymic = values[mapPatterns.get(PatternPatronymic.patronymicTitle).getIndexOfTitle()];
    String gender = values[mapPatterns.get(PatternGender.genderTitle).getIndexOfTitle()];
    long phoneNumber = Long.parseLong(values[mapPatterns.get(PatternPhoneNumber.phoneNumberTitle).getIndexOfTitle()]);
    int passportNumber = Integer.parseInt(values[mapPatterns.get(PatternPassportNumber.passportNumberTitle).getIndexOfTitle()]);
    int passportSeries = Integer.parseInt(values[mapPatterns.get(PatternPassportSeries.passportSeriesTitle).getIndexOfTitle()]);
    LocalDate dateOfBirthDay = LocalDate.parse(values[mapPatterns.get(PatternDateOfBirthDay.dateOfBirthDayTitle).getIndexOfTitle()],
            DateTimeFormat.forPattern("dd.MM.yyyy"));

    if(clients.size()!=0) {
      for (Client c : clients) {
        if (c.getPassportSeries() + c.getPassportNumber()==passportSeries + passportNumber) {
          return c;
        }
      }
    }

    Client client = FactoryClient.createClient(name,
            surname,
            patronymic,
            gender,
            phoneNumber,
            passportSeries,
            passportNumber,
            dateOfBirthDay);
    clients.add(client);
    return client;
  }

}
