package com.nc.mihalsky.openers.creators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.contracts.InternetContract;
import com.nc.mihalsky.entities.contracts.MobileContract;
import com.nc.mihalsky.entities.contracts.TvContract;
import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import com.nc.mihalsky.entities.contracts.enums.MobileTariff;
import com.nc.mihalsky.entities.contracts.enums.TvTariff;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.factories.FactoryContract;
import com.nc.mihalsky.openers.patterns.PatternDateEndOfUse;
import com.nc.mihalsky.openers.patterns.PatternDateStartOfUse;
import com.nc.mihalsky.openers.patterns.PatternTariff;
import com.nc.mihalsky.openers.patterns.TitlePattern;
import com.nc.mihalsky.simple.SimpleArrayContract;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.util.HashMap;

/**
 *Класс CreatorContractFromCsv для создания контракта из csv данных
 * @author Roman Mihalsky
 */
public class CreatorContractFromCsv implements CreatorContractFromCsvI<Contract>{
  /**Поле Map, где ключ(название поля в csv) и значение(соответствующий pattern)*/
  private HashMap<String, TitlePattern> mapPatterns;
  /**Список контрактов*/
  private SimpleArrayContract<Contract> contracts;
  /**Фабрика контрактов*/
  FactoryContract factoryContract;

  /**Constructor заполняет  mapPatterns
   * и создает новый список контрактов с фабрикой
   */
  public CreatorContractFromCsv(HashMap<String,TitlePattern> mapPatterns){
    this.mapPatterns = mapPatterns;
    this.contracts = new SimpleArrayContract<>();
    this.factoryContract = new FactoryContract();
  }

  /**Функция возвращает контракт, созданный из csv
   * @param  values - данные из csv
   * @param client - клиент
   * @return Contract - контракт
   */
  @Override
  public Contract create(String[] values, Client client) {
    LocalDate dateStartOfUse = LocalDate.parse(values[mapPatterns.get(PatternDateStartOfUse.dateStartOfUseTitle).getIndexOfTitle()],
            DateTimeFormat.forPattern("dd.MM.yyyy"));
    LocalDate dateEndOfUse = LocalDate.parse(values[mapPatterns.get(PatternDateEndOfUse.dateEndOfUseTitle).getIndexOfTitle()],
            DateTimeFormat.forPattern("dd.MM.yyyy"));
    Contract contract = createFull(values,dateStartOfUse,dateEndOfUse,client);
    return contract;
  }

  /**Функция создает новый контракт и возвращает его
   * @param  values - данные из csv
   * @param dateEndOfUse - дата заершения контракта
   * @param dateStartOfUse - дата создания контракта
   * @param client - клиент
   * @return Contract - контракт
   */
  private Contract createFull(String[] values,LocalDate dateStartOfUse,LocalDate dateEndOfUse,Client client){
    switch (values[mapPatterns.get("tariff").getIndexOfTitle()]){

      case  PatternTariff.internetTariffPattern: {
            InternetTariff tariff = ChooserTariff.chooseInternetTariff(values,mapPatterns);
            InternetContract contract = factoryContract.createInternetContract(dateStartOfUse,dateEndOfUse,client,tariff);
            return contract;
      }

      case PatternTariff.mobileTariffPattern: {
            MobileTariff tariff = ChooserTariff.chooseMobileTariff(values,mapPatterns);
            MobileContract contract = factoryContract.createMobileContract(dateStartOfUse,dateEndOfUse,client,tariff);
            return contract;
      }

      case  PatternTariff.tvTariffPattern: {
            TvTariff tariff = ChooserTariff.chooseTvTariff(values,mapPatterns);
            TvContract contract = factoryContract.createTvContract(dateStartOfUse,dateEndOfUse,client,tariff);
            return contract;
      }
    }

    return null;
  }

}
