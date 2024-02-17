import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.List;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.filechooser.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetflixScraper {
    private static WebDriver driver;
    private static List<String> ar = new ArrayList<>();
    private static List<String> ar2 = new ArrayList<>();
    private static String ip;
    private static String port;
    private static String user;
    private static String passw;
    private static JTextArea text;
    private static JTextField textField_1;
    private static JTextField textField_4;
    private static JProgressBar progressBar;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Netflix Scraper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(text);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        progressBar = new JProgressBar();
        frame.getContentPane().add(progressBar, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private static void SampleJFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("/User/alvinreyes"));

        int result = fileChooser.showOpenDialog(new JFrame());

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            textField_1.setText(selectedFile.getAbsolutePath());
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }

    public static void scrapeNetflixData() {
        SwingWorker<Void, Void> email = new SwingWorker<Void, Void>() {
            public Workbook wb;
            public FileInputStream inp;
            public String st;
            public FileInputStream inp2;
            public Workbook wb2;

            @Override
            protected Void doInBackground() throws Exception {
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    FileSystemView fileSystemView = fileChooser.getFileSystemView();
                    File defaultDirectory = fileSystemView.getDefaultDirectory();

                    inp = new FileInputStream(textField_1.getText());
                    wb = WorkbookFactory.create(inp);
                    Sheet sheet = wb.getSheetAt(0);

                    for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                        Row row = sheet.getRow(i);
                        if (row != null) {
                            Cell cell = row.getCell(0);
                            if (cell == null) {
                                cell = row.createCell(0);
                            }
                            ar.add(cell.toString());
                        }
                    }

                    DateTime dt = new DateTime();
                    int hours = dt.getHourOfDay();
                    int min = dt.getMinuteOfHour();
                    int seconds = dt.getSecondOfMinute();
                    int YEAR = dt.getYear();
                    int month = dt.getMonthOfYear();
                    int day = dt.getDayOfMonth();

                    String filename = fileSystemView.getDefaultDirectory() + "\\Out-" + "netflix" + "(" + YEAR + "-" + month + "-" + day + "-" + hours + "-" + min + "-" + seconds + ").xls ";
                    HSSFWorkbook workbook = new HSSFWorkbook();
                    HSSFSheet sheet2 = workbook.createSheet("FirstSheet");
                    FileOutputStream fileOut = new FileOutputStream(filename);
                    workbook.write(fileOut);
                    fileOut.close();
                    workbook.close();
                    System.out.println("Your excel file has been generated!");

                    String save = fileSystemView.getDefaultDirectory() + "\\Out-" + "netflix" + "(" + YEAR + "-" + month + "-" + day + "-" + hours + "-" + min + "-" + seconds + ").xls ";
                    inp2 = new FileInputStream(save);
                    wb2 = WorkbookFactory.create(inp2);
                    Sheet sheet2 = wb2.getSheetAt(0);

                    WebDriverWait wait = new WebDriverWait(driver, 30);
                    for (int j = 0; j <= ar.size(); j++) {
                        try {
                            driver = initializeDriver();
                            progressBar.setMaximum(ar.size());
                            progressBar.update(progressBar.getGraphics());
                            timestampUpdate("[" + getCurrentTimestamp() + "] Going to show " + (j + 1));

                            driver.get(ar.get(j));
                            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tab-Episodes']/a")));
                            element.click();
                            for (int s = 0; s < 10; s++) {
                                try {
                                    JavascriptExecutor js = (JavascriptExecutor) driver;
                                    js.executeScript("document.querySelector('#pane-Episodes > div > div > div > div.nfDropDown.widthRestricted.theme-lakira > div').click();");
                                    break;
                                } catch (Exception ex) {
                                    continue;
                                }
                            }
                            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pane-Episodes']/div/div/div/div[1]/div[2]/ul")));

                            List<WebElement> seasons = driver.findElements(By.xpath("//*[@id='pane-Episodes']/div/div/div/div[1]/div[2]/ul//li"));
                            for (int seasonIndex = 0; seasonIndex < seasons.size(); seasonIndex++) {
                                WebElement seasonElement = seasons.get(seasonIndex);
                                WebElement seasonLink = seasonElement.findElement(By.tagName("a"));
                                seasonLink.click();
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pane-Episodes']/div/div/div/div[1]/div[2]/ul")));
                                for (int episodeIndex = 0; episodeIndex < 10; episodeIndex++) {
                                    try {
                                        WebElement episodeElement = driver.findElement(By.xpath("(//a[@data-uia='play-button'])[" + (episodeIndex + 1) + "]"));
                                        String episodeTitle = episodeElement.getAttribute("aria-label").replace("Play", "");
                                        String episodeLink = episodeElement.getAttribute("href");
                                        if (!ar2.contains(episodeTitle + episodeLink)) {
                                            ar2.add(episodeTitle + episodeLink);
                                            Row row2 = sheet2.createRow(sheet2.getLastRowNum() + 1);
                                            Cell cell_2_1 = row2.createCell(0);
                                            Cell cell_2_2 = row2.createCell(1);
                                            Cell cell_2_3 = row2.createCell(2);
                                            cell_2_1.setCellValue(episodeTitle);
                                            cell_2_2.setCellValue(episodeLink);
                                            FileOutputStream saveStream = new FileOutputStream(save);
                                            wb2.write(saveStream);
                                            saveStream.flush();
                                            saveStream.close();
                                            timestampUpdate("[" + getCurrentTimestamp() + "] Episode " + (episodeIndex + 1) + " saved for season " + (seasonIndex + 1));
                                        }
                                    } catch (Exception e) {
                                        break;
                                    }
                                }
                            }
                            progressBar.setValue(j + 1);
                            progressBar.update(progressBar.getGraphics());
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (driver != null) {
                                driver.quit();
                            }
                        }
                    }
                    inp2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (inp != null) {
                        inp.close();
                    }
                    if (wb != null) {
                        wb.close();
                    }
                    if (wb2 != null) {
                        wb2.close();
                    }
                }
                return null;
            }

            private WebDriver initializeDriver() {
                try {
                    Proxy proxy = new Proxy();
                    proxy.setHttpProxy(ip + ":" + port);
                    proxy.setSslProxy(ip + ":" + port);

                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    capabilities.setCapability("proxy", proxy);
                    String path = new File(".").getCanonicalPath();
                    System.setProperty("webdriver.chrome.driver", path + "\\chromedriver\\chromedriver.exe");

                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.setCapability("requireWindowFocus", true);
                    options.addArguments("--ignore-certificate-errors");
                    options.addArguments("start-maximized");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);

                    return new ChromeDriver(capabilities);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            private String getCurrentTimestamp() {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                return String.valueOf(timestamp);
            }

            private void timestampUpdate(String message) {
                st = "[" + getCurrentTimestamp() + "] " + message;
                text.append("\n" + st);
                text.update(text.getGraphics());
            }
        };
        email.execute();
    }

    public static boolean isValidDomain(String str) {
        String regex = "^((?!-)[A-Za-z0-9-]" + "{1,63}(?<!-)\\.)" + "+[A-Za-z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
