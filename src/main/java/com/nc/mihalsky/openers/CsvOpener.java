package com.nc.mihalsky.openers;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.creators.CreatorClientFromCsv;
import com.nc.mihalsky.openers.creators.CreatorContractFromCsv;
import com.nc.mihalsky.openers.patterns.*;
import com.nc.mihalsky.openers.validators.*;
import com.nc.mihalsky.simple.SimpleArrayContract;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

/**
 *Класс CsvOpener для преобразования данных из CSV в Contracts
 * @author Roman Mihalsky
 */
public class CsvOpener implements Opener{
  /**Поле позиция поля имя в csv*/
  public static final String CSV_FILE_PATH = "src\\main\\resources\\csvFile.csv";
  /**Поле список данных из csv файла*/
  private static List<String[]> allData;
  /**Поле массив patterns*/
  private final TitlePattern[] patterns;
  /**Поле Map, где ключ(название поля в csv) и значение(соответствующий pattern)*/
  private HashMap<String,TitlePattern> mapPatterns;

  private Validator[] validators;

  /**Default constructor заполняет массив patterns новыми значениемя
   * и создает новую Map
   */
  public CsvOpener(){
    patterns = new TitlePattern[]{
            new PatternCondition1(), new PatternCondition2(), new PatternDateStartOfUse(),
            new PatternDateEndOfUse(), new PatternDateOfBirthDay(), new PatternGender(),
            new PatternName(), new PatternPassportNumber(), new PatternPassportSeries(),
            new PatternPatronymic(), new PatternPhoneNumber(), new PatternSurname(),
            new PatternTariff()
    };
    this.mapPatterns = new HashMap<>();

    validators = new Validator[]{
            new ValidatorDateEndOfUse(),new ValidatorDateOfBirthDay(),new ValidatorDateStartOfUse(),
            new ValidatorGender(),new ValidatorName(),new ValidatorPatronymic(),
            new ValidatorPhoneNumber(),new ValidatorPassportNumber(),new ValidatorPassportSeries(),
            new ValidatorSurname()
    };
  }

  /**Функция возвращает заполненный SimpleArrayContract<Contract> контрактами из csv файла
   * @param fileName - путь к csv файлу
   * @return SimpleArrayContract<Contract> - список контрактов
   */
  @Override
  public SimpleArrayContract<Contract> readFileToSimpleList(String fileName) {
    readData(fileName);
    findPositions();
    SimpleArrayContract<Contract> contracts = fillUp();

    return contracts;
  }

  /**Функция заполняет новый SimpleArrayContract<Contract> контрактами из csv файла и
   * передает в {@link CsvOpener#readFileToSimpleList(String)}
   * @return SimpleArrayContract<Contract> - список контрактов
   */
  private SimpleArrayContract<Contract> fillUp() {
    String [][] csvValues = getArrayOfValues();
    CreatorClientFromCsv creator = new CreatorClientFromCsv(mapPatterns);
    CreatorContractFromCsv creatorContract = new CreatorContractFromCsv(mapPatterns);
    SimpleArrayContract<Contract> list = new SimpleArrayContract<>();
    for(int i = 1;i < csvValues.length;i++){
      Client client = creator.create(csvValues[i]);
      Contract contract = creatorContract.create(csvValues[i],client);
      checkContract(contract);
      list.add(contract);
    }
    return list;
  }

  /**Функция поиска позиций заголовков*/
  private void findPositions() {
    String [][] csvValues = getArrayOfValues();
    String [] titles = csvValues[0];

    for(int i = 0; i < titles.length;i ++){
      for (int j = 0;j < patterns.length;j++){
        if (titles[i].matches(patterns[j].getTitle())){
          patterns[j].setIndexOfTitle(i);
          mapPatterns.put(patterns[j].getTitle(),patterns[j]);
        }
      }
    }
  }

  /**Функция считывает данные csv файла в список {@link CsvOpener#allData}
   * @param fileName - путь к csv файлу
   */
  private void readData(String fileName) {
    try {
      FileReader fileReader = new FileReader(fileName);

      CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();

      CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).build();

      allData = csvReader.readAll();

    }catch (Exception e){
      e.printStackTrace();
    }
  }

/**Функция преобразует список {@link CsvOpener#allData} к массиву
 * @return String[][] - иассив данных из csv файла
 */
  private static String[][] getArrayOfValues(){
    String [][] csvValues = new String[allData.size()][];
    allData.toArray(csvValues);
    return csvValues;
  }

  private void checkContract(Contract contract){
    for (Validator v : validators) {
      v.validate(contract);
    }
  }
}
