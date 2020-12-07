package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.patterns.PatternName;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

/**
 *Класс ValidatorName проверяет параметр клиента {@link Client#name}
 * @author Roman Mihalsky
 */
public class ValidatorName implements Validator {
  /**
   *Функция проверяет name
   * @param contract - контракт
   * @return PatternError - данные об ошибке
   */
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("Name OK");
    try {
      if(!((contract.getClient().getName()).matches(PatternName.namePattern))){
        throw new DiscrepancyPatternException("Name doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());
    }
    return error;
  }
}
