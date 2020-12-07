package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.patterns.PatternPatronymic;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

/**
 *Класс ValidatorPatronymic проверяет параметр клиента {@link Client#patronymic}
 * @author Roman Mihalsky
 */
public class ValidatorPatronymic implements Validator {
  /**
   *Функция проверяет patronymic
   * @param contract - контракт
   * @return PatternError - данные об ошибке
   */
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("Patronymic OK");
    try {
      if(!((contract.getClient().getPatronymic()).matches(PatternPatronymic.patronymicPattern))){
        throw new DiscrepancyPatternException("Patronymic doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());
    }
    return error;
  }
}
