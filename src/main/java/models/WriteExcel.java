package models;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import jxl.*;
import jxl.write.*;
import jxl.write.Boolean;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;
 
public class WriteExcel {
 
    public  WriteExcel(Map<Integer, HashMap<String,String>> HMap) {
 
        try {
            File exlFile = new File("C:\\Users\\Paul\\Documents\\workspace-sts-3.7.0.RELEASE\\ifntung\\src\\main\\webapp\\resources\\theme1\\writeHumans.xls");
            WritableWorkbook writableWorkbook = Workbook
                    .createWorkbook(exlFile);
 
            WritableSheet writableSheet = writableWorkbook.createSheet(
                    "Sheet1", 0);
 
            Label label = new Label(0, 0, "NAME");
            writableSheet.addCell(label);
            label = new Label(1, 0, "Last Name");
            writableSheet.addCell(label);
            label = new Label(2, 0, "Country");
            writableSheet.addCell(label);
            label = new Label(3, 0, "City");
            writableSheet.addCell(label);
            label = new Label(4, 0, "Phone");
            writableSheet.addCell(label);
            label = new Label(5, 0, "Email");
            writableSheet.addCell(label);
            
            
            for (Integer key : HMap.keySet()) {
                System.out.println("Key: " + key + ", Value: " + HMap.get(key).get("CUST_ID"));
                label = new Label(0, key+1, HMap.get(key).get("NAME"));
                writableSheet.addCell(label);
                label = new Label(1, key+1, HMap.get(key).get("LastName"));
                writableSheet.addCell(label);
                label = new Label(2, key+1, HMap.get(key).get("Country"));
                writableSheet.addCell(label);
                label = new Label(3, key+1, HMap.get(key).get("City"));
                writableSheet.addCell(label);
                label = new Label(4, key+1, HMap.get(key).get("Phone"));
                writableSheet.addCell(label);
                label = new Label(5, key+1, HMap.get(key).get("Email"));
                writableSheet.addCell(label);
            }
            
            //Write and close the workbook
            writableWorkbook.write();
            writableWorkbook.close();
            
            File generatedfile = new File("C:\\Users\\Paul\\Documents\\workspace-sts-3.7.0.RELEASE\\ifntung\\src\\main\\webapp\\resources\\theme1\\writeHumans.xls");
            if(generatedfile.exists())
            {
                if(Desktop.isDesktopSupported())
                {
                    Desktop.getDesktop().open(generatedfile);
                }
                else
                {
                    System.out.println("Not Supported by your desktop");
                }
            }
            else
            {
                System.out.println("File does not Exists");
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
 
}