package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.patterns.PatternSurname;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

/**
 *Класс ValidatorSurname проверяет параметр клиента {@link Client#surname}
 * @author Roman Mihalsky
 */
public class ValidatorSurname implements Validator {
  /**
   *Функция проверяет surname
   * @param contract - контракт
   * @return PatternError - данные об ошибке
   */
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("Surname OK");
    try {
      if(!(contract.getClient().getSurname().matches(PatternSurname.surnamePattern))){
        throw new DiscrepancyPatternException("Surname doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());
    }
    return error;
  }
}
