package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.patterns.PatternPassportNumber;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

/**
 *Класс ValidatorPassportNumber проверяет параметр клиента {@link Client#passportNumber}
 * @author Roman Mihalsky
 */
public class ValidatorPassportNumber implements Validator {
  /**
   *Функция проверяет passportNumber
   * @param contract - контракт
   * @return PatternError - данные об ошибке
   */
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("PassportNumber OK");
    try {
      if(!((""+contract.getClient().getPassportNumber()).matches(PatternPassportNumber.passportNumberPattern))){
        throw new DiscrepancyPatternException("PassportNumber doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());
    }
    return error;
  }
}
