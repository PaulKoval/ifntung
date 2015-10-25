package models;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

public class SimpleReportExample {

  public SimpleReportExample() {
	Connection connection = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/contactdb","root", "");
	} catch (SQLException e) {
		e.printStackTrace();
		return;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return;
	}

	JasperReportBuilder report = DynamicReports.report();//a new report
	report
	  .columns(
	      Columns.column("First Name", "NAME", DataTypes.stringType()),
	      Columns.column("Last Name", "LastName", DataTypes.stringType()),
	      Columns.column("Country", "Country", DataTypes.stringType()),
	      Columns.column("City", "City", DataTypes.stringType()),
	      Columns.column("Phone", "Phone", DataTypes.stringType()),
	      Columns.column("Email", "Email", DataTypes.stringType()))
	  .title(//title of the report
	      Components.text("SimpleReportExample")
		  .setHorizontalAlignment(HorizontalAlignment.CENTER))
		  .pageFooter(Components.pageXofY())//show page number on the page footer
		  .setDataSource("SELECT NAME, LastName, Country, City, Phone, Email FROM customer", 
                                  connection);

	try {
                //show the report
		report.show(false);

                //export the report to a pdf file
		report.toPdf(new FileOutputStream("C:\\Users\\Paul\\Documents\\workspace-sts-3.7.0.RELEASE\\ifntung\\src\\main\\webapp\\resources\\theme1\\report.pdf"));
	} catch (DRException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
  }
}