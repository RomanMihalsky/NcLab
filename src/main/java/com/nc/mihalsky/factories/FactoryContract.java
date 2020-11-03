package com.nc.mihalsky.factories;

import com.nc.mihalsky.entities.contracts.InternetContract;
import com.nc.mihalsky.entities.contracts.MobileContract;
import com.nc.mihalsky.entities.contracts.TvContract;
import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import com.nc.mihalsky.entities.contracts.enums.MobileTariff;
import com.nc.mihalsky.entities.contracts.enums.TvTariff;
import com.nc.mihalsky.entities.persons.Client;
import org.joda.time.LocalDate;

import java.util.logging.Logger;

/**
 *Класс FactoryContract со свойствами <b>generatorID</b>,<b>logger</b>
 * @author Roman Mihalsky
 */
public class FactoryContract implements Factory{
  /**Статическое поле генератор id*/
  private GeneratorID generatorID;
  /**Статическое поле logger для вывода информации в консоль*/
  private Logger logger = Logger.getLogger("Logger");

  /**Конструктор для создания FactoryContract с созданием нового генератора id*/
  public FactoryContract (){
    generatorID = new GeneratorID();
  }

  /**
   * Функция создания интернет контракта {@link InternetContract} с default значениями
   * и генерацией id.
   * @return новый объект типа {@link InternetContract}
   */
  public InternetContract createInternetContract(){
    InternetContract internetContract = new InternetContract();
    internetContract.setId(generatorID.generate());
    logger.info("Create default InternetContract with id " + internetContract.getId());
    return internetContract;
  }

  /**
   * Функция создания интернет контракта {@link InternetContract} с параметрами и генерацией id
   * @param dateStartOfUse - дата создания контракта
   * @param dateEndOfUse - дата заершения контракта
   * @param client - клиент
   * @param tariff - тариф на интернет
   * @return новый объект типа {@link InternetContract}
   */
  public InternetContract createInternetContract(LocalDate dateStartOfUse,
                                                 LocalDate dateEndOfUse,
                                                 Client client,
                                                 InternetTariff tariff){
    InternetContract internetContract = new InternetContract(
            generatorID.generate(),
            dateStartOfUse,
            dateEndOfUse,
            client,
            tariff);

    logger.info("Create InternetContract with id " + internetContract.getId());
    return internetContract;
  }

  /**
   * Функция создания контракта на мобильнкю связь {@link MobileContract} с default значениями
   * и генерацией id.
   * @return новый объект типа {@link MobileContract}
   */
  public MobileContract createMobileContract(){
    MobileContract mobileContract = new MobileContract();
    mobileContract.setId(generatorID.generate());
    logger.info("Create default MobileContract with id " + mobileContract.getId());
    return mobileContract;
  }

  /**
   * Функция создания контракта на мобильнкю связь{@link MobileContract} с параметрами и генерацией id
   * @param dateStartOfUse - дата создания контракта
   * @param dateEndOfUse - дата заершения контракта
   * @param client - клиент
   * @param tariff - тариф на мобильную связь
   * @return новый объект типа {@link MobileContract}
   */
  public MobileContract createMobileContract(LocalDate dateStartOfUse,
                                             LocalDate dateEndOfUse,
                                             Client client,
                                             MobileTariff tariff){
    MobileContract mobileContract = new MobileContract(
            generatorID.generate(),
            dateStartOfUse,
            dateEndOfUse,
            client,
            tariff);

    logger.info("Create MobileContract with id " + mobileContract.getId());
    return mobileContract;
  }

  /**
   * Функция создания контракта на телевидение {@link TvContract} с default значениями
   * и генерацией id.
   * @return новый объект типа {@link TvContract}
   */
  public TvContract createTvContract(){
    TvContract tvContract = new TvContract();
    tvContract.setId(generatorID.generate());
    logger.info("Create default TvContract with id " + tvContract.getId());
    return tvContract;
  }

  /**
   * Функция создания контракта на телевидение{@link TvContract} с параметрами и генерацией id
   * @param dateStartOfUse - дата создания контракта
   * @param dateEndOfUse - дата заершения контракта
   * @param client - клиент
   * @param tariff - тариф на телевидение
   * @return новый объект типа {@link TvContract}
   */
  public TvContract createTvContract(LocalDate dateStartOfUse,
                                     LocalDate dateEndOfUse,
                                     Client client,
                                     TvTariff tariff){
    TvContract tvContract = new TvContract(
            generatorID.generate(),
            dateStartOfUse,
            dateEndOfUse,
            client,
            tariff);

    logger.info("Create TvContract with id " + tvContract.getId());
    return tvContract;
  }
}
