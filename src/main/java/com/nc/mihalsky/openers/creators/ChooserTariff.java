package com.nc.mihalsky.openers.creators;

import com.nc.mihalsky.entities.contracts.enums.InternetTariff;
import com.nc.mihalsky.entities.contracts.enums.MobileTariff;
import com.nc.mihalsky.entities.contracts.enums.TvTariff;
import com.nc.mihalsky.openers.patterns.PatternCondition1;
import com.nc.mihalsky.openers.patterns.PatternCondition2;
import com.nc.mihalsky.openers.patterns.TitlePattern;
import org.apache.commons.lang3.EnumUtils;

import java.util.HashMap;
import java.util.List;
/**
 *Класс ChooserTariff для выбора тарифа
 * @author Roman Mihalsky
 */
public class ChooserTariff {

  /**Функция возвращает интернет тариф
   * @param  values - данные из csv
   * @param  mapPatterns - Поле Map, где ключ(название поля в csv) и значение(соответствующий pattern)
   * @return InternetTariff - интернет тариф
   */
  public static InternetTariff chooseInternetTariff(String[] values, HashMap<String, TitlePattern> mapPatterns) {
   List<InternetTariff> tariffsList = EnumUtils.getEnumList(InternetTariff.class);
   InternetTariff[] tariffs = new InternetTariff[tariffsList.size()];
   tariffsList.toArray(tariffs);

   int condition1 = Integer.parseInt(values[mapPatterns.get(PatternCondition1.condition1Title).getIndexOfTitle()]);
   for(int i = 0;i < tariffs.length;i++){
     if(tariffs[i].getInternetSpeed() == condition1){
       return tariffs[i];
     }
   }
   return InternetTariff.MEGAS;
  }

  /**Функция возвращает тариф на мобильную связь
   * @param  values - данные из csv
   * @param  mapPatterns - Поле Map, где ключ(название поля в csv) и значение(соответствующий pattern)
   * @return MobileTariff - тариф на мобильную связь
   */
  public static MobileTariff chooseMobileTariff(String[] values, HashMap<String, TitlePattern> mapPatterns) {
    List<MobileTariff> tariffsList = EnumUtils.getEnumList(MobileTariff.class);
    MobileTariff[] tariffs = new MobileTariff[tariffsList.size()];
    tariffsList.toArray(tariffs);

   int condition1 = Integer.parseInt(values[mapPatterns.get(PatternCondition1.condition1Title).getIndexOfTitle()]);
   int condition2 = Integer.parseInt(values[mapPatterns.get(PatternCondition2.condition2Title).getIndexOfTitle()]);
   for(int i = 0;i < tariffs.length;i++){
     if((tariffs[i].getGigabytes() == condition1 && (tariffs[i]).getSmsAmount() == condition2)){
       return tariffs[i];
     }
   }
   return MobileTariff.CHEAP;
  }

  /**Функция возвращает тариф на телевидение
   * @param  values - данные из csv
   * @param  mapPatterns - Поле Map, где ключ(название поля в csv) и значение(соответствующий pattern)
   * @return TvTariff - тариф на телевидение
   */
  public static TvTariff chooseTvTariff(String[] values, HashMap<String, TitlePattern> mapPatterns) {
    List<TvTariff> tariffsList = EnumUtils.getEnumList(TvTariff.class);
    TvTariff[] tariffs = new TvTariff[tariffsList.size()];
    tariffsList.toArray(tariffs);

    int condition1 = Integer.parseInt(values[mapPatterns.get(PatternCondition1.condition1Title).getIndexOfTitle()]);
    for(int i = 0;i < tariffs.length;i++){
      if(tariffs[i].getChannelsAmount() == condition1){
        return tariffs[i];
      }
    }
    return TvTariff.SMALL;
  }
}
