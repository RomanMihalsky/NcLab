package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.patterns.PatternDateOfBirthDay;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

/**
 *Класс ValidatorDateOfBirthDay проверяет параметр клиента {@link Client#dateOfBirthDay}
 * @author Roman Mihalsky
 */
public class ValidatorDateOfBirthDay implements Validator {
  /**
   *Функция проверяет dateOfBirthDay
   * @param contract - контракт
   * @return PatternError - данные об ошибке
   */
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("DateOfBirthDay OK");
    try {
      if(!((contract.getClient().getDateOfBirthDay().toString()).matches(PatternDateOfBirthDay.dateOfBirthDayPattern))){
        throw new DiscrepancyPatternException("DateOfBirthDay doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());

    }
    return error;
  }
}
