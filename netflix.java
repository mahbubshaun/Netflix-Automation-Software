import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.DefaultCaret;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.JProgressBar;
import javax.swing.JButton;
import com.google.common.net.InetAddresses;
import com.google.common.net.InternetDomainName;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.text.MessageFormat;

public class netflix {

	private JFrame frame;
	protected static ChromeDriver driver2;
	protected static ChromeOptions options2;
    public static JTextArea text;
    public static String path;
    
    public static ChromeOptions options;
    
    public static WebDriver driver;
    
  
    
    public static String l;
    
    public static String ip;
    //static SheetsQuickstart sp = new SheetsQuickstart();
    public static String port;
    
    public static String user;
    
    public static String passw;
    public static ArrayList<String> ar = new ArrayList<String>();
    
    public static ArrayList<String> ar2 = new ArrayList<String>();
    public static int off;
    
    public static String addr;
    public static String l_cat;
    public static String country;
    public static boolean ex;
	public static String city;
	public static String state;
	protected static int p;
    
    public static String page_n;
    public static boolean re_p;
    
    public static JProgressBar progressBar;
    
    public static int j;
    
    public static int i;
    
    public static int available;
    private static JTextField textField_4;
    private static JTextField txtInfopaymonnetwordup;
    private static JTextField textField_1;
 
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					
					
					 
					 try{
							Connection myConn =null;
							
					        Statement myStmt=null;
					        ResultSet myRs=null;
					  
					        String dburl="jdbc:mysql://database-1.cuzswbxyyf4l.us-east-2.rds.amazonaws.com:3306/bots";
					        String user="root";
					        String pass="Hacershaun1";
						 myConn = (Connection) DriverManager.getConnection(dburl, user, pass);
				           myStmt=(Statement) myConn.createStatement();
				           String sql ="Select license from bot_v where bot_name='Paymongeeks'";
				           myRs= myStmt.executeQuery(sql);
				           
				           if((myRs.next()))
				           {
				        	   String li = myRs.getString("license");
				        	   if(li.equals("true")){
				        		   netflix window = new netflix();
									window.frame.setVisible(true);
									j=500;
								
									 available=0;
				        	   }
				        	   else{
				        		   JOptionPane.showMessageDialog(null, "NO internet connection or something is not right..");
				        	   }
				           }
				           
				           myConn.close();
				           myStmt.close();
				           
				           myRs.close();
				           
						}catch(Exception b)
						{
						 b.printStackTrace();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public netflix() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 665, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NETFLIX SCRAPING BOT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(145, 17, 371, 27);
		frame.getContentPane().add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("images/button (38).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("images/button (38).png")));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				/*
				 String value1 = comboBox.getSelectedItem().toString();
				 
				 if ((value1.equals("SELECT HOUR"))  || txtztmxpgkxfbvlvyaccbqmnueswaspmsvw.getText().equals("") )
				 {
					 JOptionPane.showMessageDialog(null,"PLEASE SELECT REPEAT HOUR / INSERT SPREADSHEET ID");
					 
				 }
				 else{
					 
					JOptionPane.showMessageDialog(null,"Bot started");
					lblNewLabel_1.setEnabled(false);
					
				String id =	txtztmxpgkxfbvlvyaccbqmnueswaspmsvw.getText();
				
			//	sp.assing4(id);
				//	rebeet();
				 
				 
				 }*/
				
				path=txtInfopaymonnetwordup.getText();
				if(path.isEmpty() || textField_1.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null,"Please insert netlfix account login / Import excel sheet containing show link");	
					
				}
				else{
					
					
					  String fileName = path;
			            File file = new File(fileName);

			            // try to rename the file with the same name
			            File sameFileName = new File(fileName);

			            if(file.renameTo(sameFileName)){
			                // if the file is renamed
			                System.out.println("file is closed");    
			            }else{
			                // if the file didnt accept the renaming operation
			                System.out.println("file is opened");
			                try {
			                	String processName = "EXCEL.EXE";
			                    Runtime rt = Runtime.getRuntime();
			                    // For Windows OS...
			                    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			                        rt.exec("taskkill /T /F /IM " + processName);
			                        //rt.exec("taskkill /T /F /PID " + Long.parseLong(processName)); // Supply the PID value as string
			                        //rt.exec("taskkill /F /FI \"WINDOWTITLE eq " + processName + "\" /T"); // Supply the window title bar text.
			                        // If you want to kill only a single instance of the 
			                        // named process then get its PID value and use:
			                        // "taskkill /T /F /PID PID_Value"  OR you can provide
			                        // the window title and use:
			                        // "taskkill /F /FI \"WINDOWTITLE eq " + processName + "\" /T"
			                    }
			                    // For OSX And Linux OS's...
			                    else {
			                        rt.exec("sudo killall -9 '" + processName + "'");
			                        //rt.exec("kill -9 " + Long.parseLong(processName)); // Supply the PID value as string
			                        // If you want to kill only a single instance of the 
			                        // named process then get its PID value and use:
			                        // "kill -9 PID_Value"
			                    }
			                    rt.freeMemory();
			               
			                } 
			                catch (IOException | SecurityException | IllegalArgumentException ex) {
			                    ex.printStackTrace();
			                }
			               
			            }
			            
			           
			            event_top3();
			            JOptionPane.showMessageDialog(null,"Bot started");
				} 
				
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("images/button (38).png")));
		lblNewLabel_1.setBounds(145, 291, 371, 47);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 374, 639, 138);
		frame.getContentPane().add(scrollPane);
		 text = new JTextArea();
		 DefaultCaret caret = (DefaultCaret) text.getCaret();
		 caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		 text.setBackground(Color.LIGHT_GRAY);
		 text.setEditable(false);
			text.setLineWrap(true);
		       text.setWrapStyleWord(true);
		       text.setFont(new Font("Times New Roman", Font.BOLD, 15));
		       scrollPane.setViewportView(text);
		
		JLabel lblRealTimeLog = new JLabel("REALTIME LOG");
		lblRealTimeLog.setForeground(Color.WHITE);
		lblRealTimeLog.setBackground(Color.YELLOW);
		lblRealTimeLog.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblRealTimeLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealTimeLog.setBounds(145, 349, 371, 14);
		frame.getContentPane().add(lblRealTimeLog);
		
		JLabel lblV = new JLabel("V 2");
		lblV.setForeground(Color.WHITE);
		lblV.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblV.setBounds(10, 19, 60, 19);
		frame.getContentPane().add(lblV);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					 
					 
					 Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"taskkill.exe /F /IM chromedriver.exe /T");
				 }catch(Exception rr)
				 {
					 
				 }
				 System.exit(0);
				
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 61, 123, 47);
		
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("images/button (29).png")));
		
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(lblNewLabel_2);
		
		 progressBar = new JProgressBar();
		 progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.BLACK);
		progressBar.setBounds(10, 523, 639, 25);
		frame.getContentPane().add(progressBar);
		
		JLabel lblNewLabel_6 = new JLabel("PROXY");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 139, 123, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_4.setForeground(Color.YELLOW);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBackground(Color.GRAY);
		textField_4.setBounds(10, 177, 123, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NETFLIX LOGIN");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(145, 235, 371, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtInfopaymonnetwordup = new JTextField();
		txtInfopaymonnetwordup.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtInfopaymonnetwordup.setForeground(Color.YELLOW);
		txtInfopaymonnetwordup.setText("info@paymon.net:WordUp1001");
		txtInfopaymonnetwordup.setBackground(Color.GRAY);
		txtInfopaymonnetwordup.setBounds(186, 260, 289, 20);
		frame.getContentPane().add(txtInfopaymonnetwordup);
		txtInfopaymonnetwordup.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("IMPORT EXCEL SHEET");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(145, 55, 373, 27);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.YELLOW);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(186, 88, 289, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SampleJFileChooser();
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(145, 128, 361, 47);
		frame.getContentPane().add(label_1);
		label_1.setIcon(new ImageIcon(getClass().getResource("images/button (46).png")));
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setBounds(0, -13, 617, 592);
	//	frame.getContentPane().add(label);
		
		 ImageIcon img =new ImageIcon(getClass().getResource("images/n.png"));
	        
	       
	        
	        frame.setIconImage(img.getImage());
	        
	        label.setIcon(new ImageIcon(getClass().getResource("images/ps.jpg")));
	}
	  
	  public static void event_top3(){
			SwingWorker<Void,Void> email = new SwingWorker<Void,Void>()
					{

						public Workbook wb;
						public InputStream inp;
						public String st;
						public InputStream is;
						private FileInputStream inp2;
						private Workbook wb2;

						@Override
						protected Void doInBackground() throws Exception {
							 JFileChooser fr = new JFileChooser();
						     FileSystemView fw = fr.getFileSystemView();
						     
						     File direc = fw.getDefaultDirectory();
						     System.out.println(fw.getDefaultDirectory());
						     
						     System.out.println(fw.getDefaultDirectory());
							
							 inp = new FileInputStream(textField_1.getText());
							 wb = WorkbookFactory.create(inp);
							 Sheet sheet = wb.getSheetAt(0);
							
							 
							 Row row = null;
							 
							 
							 
							 Cell cell = null;
									 
							Cell cell2 = null;
							 
							 Cell cell3= null;
							 
							 Cell cell4 = null;
							 
							 
							 
							 for(int i=0;i<=sheet.getLastRowNum();i++)
							 {
								 
								 row= sheet.getRow(i);
								 
								 if(row== null)
								 {
									 
								 }else{
									 cell = row.getCell(0);
									 if(cell == null)
									 {
										 cell = row.createCell(0);
										 
									 }
									 
									 ar.add(cell.toString());
									 
									 
									 
									 
									 
									 
									 
								 }
								 
							
								 
							 }
							 
							 
							 
								DateTime dt = new DateTime();
								
							    // gets the current month
							int hours = dt.getHourOfDay(); // gets hour of day
							
							int min = dt.getMinuteOfHour();
							
							int seconds = dt.getSecondOfMinute();
							
							int YEAR = dt.getYear();
							
							int month = dt.getMonthOfYear(); 
							
							int day = dt.getDayOfMonth();
							 try {
						            String filename = fw.getDefaultDirectory()+"\\Out-"+"netflix"+"("+YEAR+"-"+month+"-"+day+"-"+hours+"-"+min+"-"+seconds+").xls ";
						            HSSFWorkbook workbook = new HSSFWorkbook();
						            HSSFSheet sheet2 = workbook.createSheet("FirstSheet"); 

						           
						            FileOutputStream fileOut = new FileOutputStream(filename);
						            workbook.write(fileOut);
						            fileOut.close();
						            workbook.close();
						            System.out.println("Your excel file has been generated!");

						        } catch ( Exception ex ) {
						            System.out.println(ex);
						        }
							 
							 String save = fw.getDefaultDirectory()+"\\Out-"+"netflix"+"("+YEAR+"-"+month+"-"+day+"-"+hours+"-"+min+"-"+seconds+").xls ";
							 inp2 = new FileInputStream(save);
							 wb2 = WorkbookFactory.create(inp2);
							 Sheet sheet2 = wb2.getSheetAt(0);
							 
							
							
							 
							 
							 
							 
							 
							 
							 
							 
							Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			                 //   System.out.println(timestamp);
			                    String t = String.valueOf(timestamp);
	                            st= "["+t+"] Opening browser";
						    	
						    	update(st);
						    	
						    	String text =txtInfopaymonnetwordup.getText();
								String[] time = text.split ( ":" );
							String u=time[0].trim();
							
							String p=time[1].trim();
							
							
							try{
							String proxy_u =textField_4.getText();
							String[] p1 = proxy_u.split (":");
						 ip=p1[0].trim();
						
						 port=p1[1].trim();
						
						 user=p1[2].trim();
						
						 passw=p1[3].trim();
						
							}catch(Exception ds)
							{
								
							}
							
							try{
								Proxy proxy = new Proxy();
								proxy.setHttpProxy(ip+":"+port);
								proxy.setSslProxy(ip+":"+port);
								
								DesiredCapabilities capabilities = DesiredCapabilities.chrome();
								capabilities.setCapability("proxy", proxy);
									String path = new File(".").getCanonicalPath();
									
							//		System.out.println("Application path is: "+path);
									System.setProperty("webdriver.chrome.driver",""+path+"\\chromedriver\\chromedriver.exe");
						//			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
									
									ChromeOptions options2 = new ChromeOptions();
									options2.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
									options2.setExperimentalOption("useAutomationExtension", false);
								//	options2.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36");
				                    options2.addArguments("--disable-blink-features=AutomationControlled");
				                    options2.setCapability("requireWindowFocus", true);
				                    options2.addArguments("--ignore-certificate-errors");
				                  
									options2.addArguments("start-maximized");
									capabilities.setCapability(ChromeOptions.CAPABILITY, options2);
									driver =  new ChromeDriver(capabilities);
									
									WebDriverWait wait = new WebDriverWait(driver,30);
									
									 timestamp = new Timestamp(System.currentTimeMillis());
					                 //   System.out.println(timestamp);
					                    t = String.valueOf(timestamp);
			                            st= "["+t+"] Going to netflix";
								    	
								    	update(st);
								    	
									
									driver.get("https://www.netflix.com/us/login");
									
									 timestamp = new Timestamp(System.currentTimeMillis());
					                 //   System.out.println(timestamp);
					                    t = String.valueOf(timestamp);
			                            st= "["+t+"] Entering login details";
								    	
								    	update(st);
									
									WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='id_userLoginId']")));
									           
									element1.clear();
									
									element1.sendKeys(u);
									
									Random r = new Random();
									 int low = 5000;
									 int high = 10000;
									 
								int	waits   = r.nextInt(high-low) + low;
								
								Thread.sleep(waits);
								
								WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='id_password']")));
						           
								element2.clear();
								
								element2.sendKeys(p);
								
								
								
								
								//*[@id="appMountPoint"]/div/div[3]/div/div/div[1]/form/button
								
								
								WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-uia='login-submit-button']")));
						           
								element3.click();
								
								
								
								
								
								JavascriptExecutor js23 = (JavascriptExecutor) driver;
								
								

								
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div/ul/li[1]//a"))).click();

						
								
									
						  progressBar.setMaximum(ar.size());
					      progressBar.update(progressBar.getGraphics());
								
								for(int j=0;j<=ar.size();j++)
								{
									try{
										
										 timestamp = new Timestamp(System.currentTimeMillis());
						                 //   System.out.println(timestamp);
						                    t = String.valueOf(timestamp);
				                            st= "["+t+"] Going to show "+(j+1);
									    	
									    	update(st); 
									    	
										driver.get(ar.get(j));
										
										
										timestamp = new Timestamp(System.currentTimeMillis());
						                 //   System.out.println(timestamp);
						                    t = String.valueOf(timestamp);
				                            st= "["+t+"] Getting total season number for show "+(j+1);
									    	
									    	update(st); 
									    	
										WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tab-Episodes']/a")));
								           
										element4.click();
										
										
										
										
										WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pane-Episodes']/div/div/div/div[1]/div[1]")));
								           
								//		element5.click();
										
										
										 for(int e=0;e<10;e++)
										  {
											  try{
											 // WebElement element17 = driver.findElement((By.xpath("//*[@id='root']/div/div/div/div[1]/div[1]/div/main/div/div[2]/div/nav/div/button")));
												
												  js23.executeScript("document.querySelector('#pane-Episodes > div > div > div > div.nfDropDown.widthRestricted.theme-lakira > div').click();");
												e=100;
												
												System.out.println("button is gone");
											  }catch(Exception gh)
											  {
												 e=0; 
											  }
										  }	
										
										wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pane-Episodes']/div/div/div/div[1]/div[2]/ul")));
										
										
										List<WebElement> season = driver.findElements(By.xpath("//*[@id='pane-Episodes']/div/div/div/div[1]/div[2]/ul//li"));	
										
										System.out.println("number of season found: "+season.size());
										timestamp = new Timestamp(System.currentTimeMillis());
						                 //   System.out.println(timestamp);
						                    t = String.valueOf(timestamp);
				                            st= "["+t+"] Total season found for show "+(j+1)+" "+season.size();
									    	
									    	update(st); 
										
										for(int s=0;s<season.size();s++)
										{
											
											timestamp = new Timestamp(System.currentTimeMillis());
							                 //   System.out.println(timestamp);
							                    t = String.valueOf(timestamp);
					                            st= "["+t+"] Getting season "+(s+1)+"  episodes for show "+(j+1);
										    	
										    	update(st); 
											
											driver.get(ar.get(j));
											
											
											
											 element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tab-Episodes']/a")));
									           
											element4.click();
											
											
											
											
											element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pane-Episodes']/div/div/div/div[1]/div[1]")));
									           
										//	element5.click();
											
											 for(int e=0;e<10;e++)
											  {
												  try{
												 // WebElement element17 = driver.findElement((By.xpath("//*[@id='root']/div/div/div/div[1]/div[1]/div/main/div/div[2]/div/nav/div/button")));
													
													  js23.executeScript("document.querySelector('#pane-Episodes > div > div > div > div.nfDropDown.widthRestricted.theme-lakira > div').click();");
													e=100;
													
													System.out.println("button is gone");
												  }catch(Exception gh)
												  {
													 e=0; 
												  }
											  }	
											 
											 
											wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pane-Episodes']/div/div/div/div[1]/div[2]/ul")));
											
											driver.findElement(By.xpath("//*[@id='pane-Episodes']/div/div/div/div[1]/div[2]/ul/li["+(s+1)+"]/a")).click();
											
											System.out.println("clicked season : "+(s+1));
											
											
											
											
											
											
											
											
										 for (int i=0; i<40; i++){ 
											   try {
											    Thread.sleep(1000);
											    }catch (InterruptedException e) {} 
											   //To check page ready state.
											   if (js23.executeScript("return document.readyState").toString().equals("complete")){ 
												 
											    break; 
											   }   
											  }
										 
										
									
										 low = 10000;
										  high = 15000;
										 
										waits   = r.nextInt(high-low) + low;
									
									Thread.sleep(waits);
										 for(int e=0;e<10;e++)
										  {
											  try{
											 // WebElement element17 = driver.findElement((By.xpath("//*[@id='root']/div/div/div/div[1]/div[1]/div/main/div/div[2]/div/nav/div/button")));
												
												  driver.findElement((By.xpath("(//a[@data-uia='play-button'])[1]"))).getAttribute("href");
												e=100;
												
												System.out.println("button is gone");
											  }catch(Exception gh)
											  {
												 e=0; 
											  }
										  }	
										
										
										/*
										
												
											*/
										 
									//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-uia='play-button'])[1]")));
										 
										for(int uu=0;uu<10;uu++)
										{
											try{
											WebElement  nex =	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/div/span[@class='handle handleNext active']/b"));
											
										List<WebElement> episode_l = driver.findElements(By.xpath("//a[@data-uia='play-button']"));	
                              	timestamp = new Timestamp(System.currentTimeMillis());
				                 //   System.out.println(timestamp);
				                    t = String.valueOf(timestamp);
		                            st= "["+t+"] saving episodes in excel!";
							    	
							    	update(st); 
										System.out.println("number of episode found: "+episode_l.size());
										for(int e=0;e<episode_l.size();e++)
										{
											int w=1;
										int cj = sheet2.getLastRowNum();

										while (cj > 0) {

											Row row2 = sheet2.getRow(w);
											if (row2 == null) {
												row2 = sheet2.createRow(w);

											}

											Cell c = null;
											Cell c2 = null;
											c = row2.getCell(0);
											if (c == null) {
												c = row2.createCell(0);
											}

											// c2=row2.getCell(0);
											String em = c.toString();
											if ((em.isEmpty()))

											{
												// System.out.println("lego will start updating
												// from row: "+row_int);

											//	st = "bot will start saving accounts details from row: " + w;
												//update(st);
											//	Thread.sleep(5000);

												break;
											} else {

												w++;

											}
										}
										
										
									Row	row2=sheet2.getRow(w);
									
									if(row2 == null)
									{
										row2 = sheet2.createRow(w);
									}
									Cell cell_2_1 = row2.getCell(0);
									if(cell_2_1 == null)
									{
										cell_2_1 = row2.createCell(0);
										
									}
										
									Cell cell_2_2 = row2.getCell(1);
									if(cell_2_2 == null)
									{
										cell_2_2 = row2.createCell(1);
										
									}
									
									Cell cell_2_3 = row2.getCell(2);
									if(cell_2_3 == null)
									{
										cell_2_3 = row2.createCell(2);
										
									}
									
									String season_t = driver.findElement(By.xpath("//*[@id='pane-Episodes']/div/div/div/div[1]/div")).getText();
									String show_name = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/h1/a/div/img")).getAttribute("alt");
									
									String episode =  driver.findElement(By.xpath("(//a[@data-uia='play-button'])["+(e+1)+"]")).getAttribute("aria-label");
									
									episode = episode.replace("Play", "");
									
									
									String link = driver.findElement(By.xpath("(//a[@data-uia='play-button'])["+(e+1)+"]")).getAttribute("href");
									
									if(ar2.contains(season_t+show_name+episode+link))
									{
										
									}
									else{
									ar2.add(season_t+show_name+episode+link);
									cell_2_1.setCellValue(show_name+" "+season_t);
									
									
									cell_2_2.setCellValue(episode);
									
									cell_2_3.setCellValue(link);
									 
									FileOutputStream	  savee2 = new FileOutputStream(save);
						            wb2.write(savee2);
						            savee2.flush();
						            savee2.close();
						        	timestamp = new Timestamp(System.currentTimeMillis());
					                 //   System.out.println(timestamp);
					                    t = String.valueOf(timestamp);
			                       //     st= "["+t+"] Episode "+(e+1)+" saved for season "+(s+1);
								    	
								    	update(st); 
						            
						            
										}
										}
										nex.click();
										uu=0;
											}catch(Exception df)
											{
												break;
											}
										}
										
										timestamp = new Timestamp(System.currentTimeMillis());
						                 //   System.out.println(timestamp);
						                    t = String.valueOf(timestamp);
				                            st= "["+t+"] All the Episodes have been saved for season "+(s+1);
									    	
									    	update(st); 
									    	ar2.clear();
										
										}
										
										 progressBar.setValue(j+1);
									      progressBar.update(progressBar.getGraphics());
										
										
									}catch(Exception h)
									{
									 h.printStackTrace();	
									}
									
									
									 inp2.close();
									
								}
								

							     
								
							}catch(Exception fg)
							{
								fg.printStackTrace();
								
								
								driver.close();
								driver.quit();
								
								Thread.sleep(4000);
								
								event_top3();
								
								 StringWriter sw = new StringWriter();
								 fg.printStackTrace(new PrintWriter(sw));
						            String exceptionAsString = sw.toString();
						            System.out.println(exceptionAsString);
							 JOptionPane.showMessageDialog(null, ""+exceptionAsString+"",
								      "ERROR!", JOptionPane.ERROR_MESSAGE);
								      
								
							}
							
							   inp.close();
							      wb.close();
							
								return null;
						}
				
					};
					email.execute();
					
		}
	  
		private static void update(String st) {
			
			text.append("\n"+st);

			text.update(text.getGraphics());
			
	}
		
		
		public static boolean isValidDomain(String str) 
	    { 
	        // Regex to check valid domain name. 
	        String regex = "^((?!-)[A-Za-z0-9-]"
	                       + "{1,63}(?<!-)\\.)"
	                       + "+[A-Za-z]{2,6}"; 
	  
	        // Compile the ReGex 
	        Pattern p 
	            = Pattern.compile(regex); 
	  
	        // If the string is empty 
	        // return false 
	      
	  
	        // Pattern class contains matcher() 
	        // method to find the matching 
	        // between the given string and 
	        // regular expression. 
	        Matcher m = p.matcher(str); 
	  
	        // Return if the string 
	        // matched the ReGex 
	        return m.matches(); 
	    } 
		
		  public void SampleJFileChooser(){
		         
		        JFileChooser jFileChooser = new JFileChooser();
		        jFileChooser.setCurrentDirectory(new File("/User/alvinreyes"));
		         
		        int result = jFileChooser.showOpenDialog(new JFrame());
		     
		     
		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = jFileChooser.getSelectedFile();
		           // path=selectedFile.getAbsolutePath();
		            textField_1.setText(selectedFile.getAbsolutePath());
		            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		        }
		    }
}
