package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.contracts.MobileContract;
import com.nc.mihalsky.entities.contracts.enums.MobileTariff;

import java.util.function.Predicate;

/**
 *Класс PredicateConditionMobileTariff со свойствами <b>mobileTariff</b>,<b>mobileTariffPredicate</b>
 * @author Roman Mihalsky
 */
public class PredicateConditionMobileTariff {
  /**Поле тариф на мобильную связь*/
  private MobileTariff mobileTariff;

  /**Конструкто для создания PredicateConditionMobileTariff с параметрами.
   * @param mobileTariff - тариф на мобильную связь
   */
  public PredicateConditionMobileTariff(MobileTariff mobileTariff){
    this.mobileTariff = mobileTariff;
  }

  /**
   * Predicate для сравнения по критерию - тариф на мобильную связь
   */
  public Predicate<Contract> mobileTariffPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      if(contract instanceof MobileContract){
        MobileContract mobileContract = (MobileContract)contract;
        return mobileContract.getTariff().equals(mobileTariff);
      }
      return false;
    }
  };

  /**
   * Функция определения клиента {@link PredicateConditionMobileTariff#mobileTariff}
   * @param mobileTariff - тариф на мобильную связь
   */
  public void setMobileTariff(MobileTariff mobileTariff) {
    this.mobileTariff = mobileTariff;
  }
}
