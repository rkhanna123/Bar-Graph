package account.bar.graph;

/**
 *
 * @author  Rohan Khanna
 * @date    1/4/2021
 */
import java.io.*;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class BellGraph extends Application{
        static long maxAmount = 6000000;
        static String[] name = new String[8];
        static double[] balance = new double[8];
        public static void main(String[] args) throws IOException
	{
            int i=0;
            String filename = "Put CSV File path here including the filename.csv";
            try (Scanner accounts = new Scanner(new FileReader(filename))) {
                while (accounts.hasNextLine()) {
                    String line = accounts.nextLine();
                    while (line != null) {
                        if (i>0){
                            String[] cells = line.split(",");
                            name[i-1] = cells[0];
                            balance[i-1] = Integer.parseInt(cells[2]);
                            if(!accounts.hasNextLine()) {
                                break;
                            }
                        }
                        i++;
                        line = accounts.nextLine();
                        
                    }
                }
            }     
		Application.launch(args);
	}
        
        @Override
	public void start(Stage primaryStage) throws IOException {
            
                Pane pane = new Pane();
		double height = 1800; 
		double paneHeight = 1011;
                int a=110;
                Color[] myColors = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.BLUE,Color.PURPLE,Color.CYAN,Color.WHITE};
                for (int j=0; j<balance.length; j++) {
                    Rectangle rect = new Rectangle(20+(a*j), paneHeight - (height * ((balance[j])/(maxAmount))), 100, height * ((balance[j])/(maxAmount)));
                    rect.setFill(myColors[j]);
                    Text text1 = new Text(10+(a*j), paneHeight - (height * ((balance[j])/(maxAmount))) - 10, name[j]+": "+balance[j]);             
                    text1.setFill(Color.WHITE);
                    pane.getChildren().addAll(rect, text1);
                }
		//Create new scene, place in the stage, set title and display
		Scene scene = new Scene(pane, 1919, paneHeight);
                scene.setFill(Color.BLACK);
		primaryStage.setTitle("Accounts Bar Graph");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
        
	
	
}
