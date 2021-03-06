package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.patterns.PatternPassportSeries;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

/**
 *Класс ValidatorPassportSeries проверяет параметр клиента {@link Client#passportSeries}
 * @author Roman Mihalsky
 */
public class ValidatorPassportSeries implements Validator {
  /**
   *Функция проверяет passportSeries
   * @param contract - контракт
   * @return PatternError - данные об ошибке
   */
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("PassportSeries OK");
    try {
      if(!((""+contract.getClient().getPassportSeries()).matches(PatternPassportSeries.passportSeriesPattern))){
        throw new DiscrepancyPatternException("PassportSeries doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());
    }
    return error;
  }
}
