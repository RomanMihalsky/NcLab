package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.patterns.PatternGender;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

/**
 *Класс ValidatorGender проверяет параметр клиента {@link Client#gender}
 * @author Roman Mihalsky
 */
public class ValidatorGender implements Validator {
  /**
   *Функция проверяет gender
   * @param contract - контракт
   * @return PatternError - данные об ошибке
   */
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("Gender OK");
    try {
      if(!((contract.getClient().getGender()).matches(PatternGender.genderPattern))){
        throw new DiscrepancyPatternException("Gender doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.WARNING);
      error.setTimeStamp(System.currentTimeMillis());
    }
    return error;
  }
}
