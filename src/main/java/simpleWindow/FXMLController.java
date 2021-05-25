package simpleWindow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.api.services.sheets.v4.model.ValueRange;


public class FXMLController {

	@FXML  private ListView<String> sheetData;


    public void initialize()  throws IOException, GeneralSecurityException{
    	ObservableList<String> languageList = FXCollections.<String>observableArrayList();
    	GoogleConnect gc = new GoogleConnect("1M9i413v2Ql_eprKqwS-aPfWt6nIvma8OminqhlXN7Ak");
    	List<List<Object>> values = gc.getData("Sheet1!A1:D1"); // Get the heading
    	languageList.add(values.get(0).get(1).toString());
    	values = gc.getData("Sheet1!A2:D"); // get the body
        for (List<Object> row : values) {
        	languageList.add(row.get(1) + ", " + row.get(2));
        }
        sheetData.setItems(languageList);
        
        ValueRange data = new ValueRange()
      	      .setValues(Arrays.asList(
      	        Arrays.asList("Expenses January"), 
      	        Arrays.asList("books", "30"), 
      	        Arrays.asList("pens", "10"),
      	        Arrays.asList("Expenses February"), 
      	        Arrays.asList("clothes", "20"),
      	        Arrays.asList("shoes", "5")));

        gc.setData("Sheet2!A1",data);
    }
}
