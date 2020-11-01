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

public class FactoryContract implements Factory{
  private GeneratorID generatorID;
  private Logger logger = Logger.getLogger("Logger");

  public FactoryContract (){
    generatorID = new GeneratorID();
  }

  public InternetContract createInternetContract(){
    InternetContract internetContract = new InternetContract();
    internetContract.setId(generatorID.generate());
    logger.info("Create default InternetContract with id " + internetContract.getId());
    return internetContract;
  }

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

  public MobileContract createMobileContract(){
    MobileContract mobileContract = new MobileContract();
    mobileContract.setId(generatorID.generate());
    logger.info("Create default MobileContract with id " + mobileContract.getId());
    return mobileContract;
  }

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

  public TvContract createTvContract(){
    TvContract tvContract = new TvContract();
    tvContract.setId(generatorID.generate());
    logger.info("Create default TvContract with id " + tvContract.getId());
    return tvContract;
  }

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
