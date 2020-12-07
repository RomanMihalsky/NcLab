import com.nc.mihalsky.openers.CsvOpener;

public class Test {
  public static void main(String[] args) {
    CsvOpener csvOpener = new CsvOpener();
    csvOpener.readFileToSimpleList(CsvOpener.CSV_FILE_PATH);
  }
}
