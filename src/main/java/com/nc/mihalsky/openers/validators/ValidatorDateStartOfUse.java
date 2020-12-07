package com.nc.mihalsky.openers.validators;


import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.patterns.PatternDateStartOfUse;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

/**
 *Класс ValidatorDateStartOfUse проверяет параметр контракта {@link Contract#dateStartOfUse}
 * @author Roman Mihalsky
 */
public class ValidatorDateStartOfUse implements Validator {
  /**
   *Функция проверяет dateStartOfUse
   * @param contract - контракт
   * @return PatternError - данные об ошибке
   */
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("DateStartOfUse OK");
    try {
      if(!((contract.getDateStartOfUse().toString()).matches(PatternDateStartOfUse.dateStartOfUsePattern))){
        throw new DiscrepancyPatternException("DateStartOfUse doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());

    }
    return error;
  }
}
